package com.group4.orderSystem.services;

import com.group4.orderSystem.models.Item;
import com.group4.orderSystem.models.User;
import com.group4.orderSystem.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@AllArgsConstructor
@Transactional
public class UserService implements UserDetailsService {

    private static final String USER_NOT_FOUND_MSG = "User with email %s not found";
    private final PasswordEncoder encoder;

    UserRepository repo;
    //Find all users from database
    public List<User> listAllUsers() { return repo.findAll(); };

    // Get a user by Id
    public User getUserById(Long id) { return repo.findById(id).get(); };

    public User save(User user) {
        repo.save(user);
        return user;
    }

    public String registerUser(User user){
        boolean userExist = repo
                .findByEmail(user.getEmail())
                .isPresent();
        if (userExist){
            throw new IllegalStateException("Email already taken");
        }
        String encodedPassword = encoder.encode(user.getPassword());
        user.setPassword(encodedPassword);

        repo.save(user);
        return "Ok";
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return repo.findByEmail(email)
                .orElseThrow(()->new UsernameNotFoundException(String.format(USER_NOT_FOUND_MSG, email)));
    }
}
