package com.group4.orderSystem.models;

import com.group4.orderSystem.security.ApplicationUserRole;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Collections;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@Entity
@Table (name = "user")
public class User implements UserDetails {

    @Id
    @SequenceGenerator(
            name = "buyer_sequence",
            sequenceName = "buyer_sequence",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "buyer_generator")
    @Column(nullable = false, updatable = false)
    private Long id;

    @Column
    private String email;

    @Column
    private String name;

    @Column
    private String username;

    @Column
    private String password;

    @Column
    private boolean locked;

    @Column
    private boolean enabled = true;

    @Column
    @Enumerated(EnumType.STRING)
    private ApplicationUserRole appUserRole;

    public User(String email, String name, String username, String password, ApplicationUserRole appUserRole) {
        this.email = email;
        this.name = name;
        this.username = username;
        this.password = password;
        this.appUserRole = appUserRole;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(appUserRole.name());
        return Collections.singletonList(simpleGrantedAuthority);
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;

    }
}
