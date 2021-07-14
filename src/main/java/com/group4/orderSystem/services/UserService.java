package com.group4.orderSystem.services;

import com.group4.orderSystem.models.Item;
import com.group4.orderSystem.models.User;
import com.group4.orderSystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserService {

    @Autowired
    UserRepository repo;
    //Find all items from database
    public List<User> listAllUsers() { return repo.findAll(); };

}
