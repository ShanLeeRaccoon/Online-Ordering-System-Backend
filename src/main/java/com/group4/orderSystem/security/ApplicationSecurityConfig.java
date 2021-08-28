package com.group4.orderSystem.security;

import com.group4.orderSystem.filters.CustomAuthenticationFilter;
import com.group4.orderSystem.filters.CustomAuthorizationFilter;
import com.group4.orderSystem.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import static com.group4.orderSystem.security.ApplicationUserRole.*;
import static org.springframework.http.HttpMethod.*;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(
        prePostEnabled = true,
        securedEnabled = true,
        jsr250Enabled = true
)
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {

    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public ApplicationSecurityConfig(BCryptPasswordEncoder passwordEncoder, UserService userService) {
        this.passwordEncoder = passwordEncoder;
        this.userService = userService;
    }

    private final UserService userService;
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        CustomAuthenticationFilter customAuthenticationFilter = new CustomAuthenticationFilter(authenticationManagerBean());
        customAuthenticationFilter.setFilterProcessesUrl("/auth/login");
        http
                .csrf().disable()
                .cors().and()
                .addFilter(customAuthenticationFilter)
                .addFilterBefore(new CustomAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class)
                .authorizeRequests()
                // ALL ACCESS
                .antMatchers("index", "/css/*", "/js/*", "/register",
                        "/login", "/auth/login", "/token/refresh/**", "/signup" ).permitAll()
                .antMatchers(GET, "/items/**").permitAll()

                // ADMIN ACCESS
                // Users
//                .antMatchers(GET, "/users/**").hasAnyAuthority("ADMIN")
                .antMatchers(GET, "/users").permitAll()
                .antMatchers(GET, "/user/**").hasAnyAuthority("ADMIN")
                .antMatchers(POST, "/users").hasAnyAuthority("ADMIN")
                .antMatchers(POST, "/register/admin").hasAnyAuthority("ADMIN")
                // Items
                .antMatchers(POST, "/items/**").hasAnyAuthority("ADMIN")
                .antMatchers(PUT, "/items/**").hasAnyAuthority("ADMIN")
                .antMatchers(DELETE, "/items/**").hasAnyAuthority("ADMIN")

                // Orders
                .antMatchers(GET, "/orders").hasAnyAuthority("ADMIN","BUYER")
                .antMatchers(GET, "/orders/*").hasAnyAuthority("ADMIN","BUYER")
                .antMatchers(GET, "/order/*").hasAnyAuthority("ADMIN","BUYER")

                .antMatchers(POST, "/order").hasAnyAuthority("ADMIN","BUYER")

                .antMatchers(PUT, "/order/*").hasAnyAuthority("ADMIN","BUYER")
                .antMatchers(DELETE, "/order/*").hasAnyAuthority("ADMIN","BUYER")

                // BUYER ACCESS
                // Users
                .antMatchers(GET, "/user/**").hasAnyAuthority("BUYER")
                // Orders
//                .antMatchers(GET, "/orders/**").hasAnyAuthority("BUYER")
//                .antMatchers(GET, "/order/**").hasAnyAuthority("BUYER")
//                .antMatchers(POST, "/order").hasAnyAuthority("BUYER")
//                .antMatchers(PUT, "/order/**").hasAnyAuthority("BUYER")
//                .antMatchers(DELETE, "/order/**").hasAnyAuthority("BUYER")

                .anyRequest()
                .authenticated();
    }
    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(daoAuthenticationProvider());
    }

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(passwordEncoder);
        provider.setUserDetailsService(userService);
        return provider;
    }

}
