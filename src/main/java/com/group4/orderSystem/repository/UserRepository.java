package com.group4.orderSystem.repository;

import com.group4.orderSystem.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<User, Long>{
    Optional<User> findByEmail(String email);
}
