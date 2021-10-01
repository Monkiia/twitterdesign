package com.example.demo.DAO;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserDAO {
    @Autowired
    UserRepository U;

    // 这里写逻辑
    //

    public UserRepository getU() {
        return U;
    }

    List<User> findUserByUsername(String username) {
        return U.findUserByUsername(username);
    }



}
