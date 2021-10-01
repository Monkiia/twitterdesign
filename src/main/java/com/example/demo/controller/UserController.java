package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@RestController
@ComponentScan(basePackages = { "com.example.demo" })
public class UserController {
    @Autowired
    UserRepository userrepos;
    @GetMapping("/user")
    public ResponseEntity<List<User>> user() {
        List<User> users = new ArrayList<User>();
        userrepos.findAll().forEach(users::add);
        return new ResponseEntity<>(users, HttpStatus.OK);
    }


    @GetMapping("/user/register")
    public String user_register(@RequestParam(value = "Email_register", defaultValue = "XX@gmail.com") String email_address, @RequestParam(value = "password_register", defaultValue = "123456") String password) {
        return String.format("This is the user register with email address %s password %s", email_address, password);
    }

    @GetMapping("/user/register_demo")

    public String user_register_demo(@RequestParam(value = "Email_register", defaultValue = "XX@gmail.com") String email_address, @RequestParam(value = "password_register", defaultValue = "123456") String password) {
        return "";
    }

    @GetMapping("/user/login")
    public String user_login(@RequestParam(value = "Email_login", defaultValue = "XX@gmail.com") String email_address, @RequestParam(value = "password_login", defaultValue = "123456") String password) {
        return String.format("This is the user login with email address %s password %s",email_address,password);
    }

    @GetMapping("/user/thirdpartyauth")
    public String thirdpartyauth(@RequestParam(value = "external", defaultValue = "GoogleValidations1Firstname=ShenshengLastname=Chen") String authreturnresult) {
        int firstnameindexend = authreturnresult.lastIndexOf("Firstname=") + "Firstname=".length();
        int lastnameindexstart = authreturnresult.indexOf("Lastname=");
        String firstname = authreturnresult.substring(firstnameindexend,lastnameindexstart);
        return String.format("This is to authorize %s via third party app",firstname);
    }

    @GetMapping("/user/peopleyoumayknow")
    public String peopleyoumayknow(@RequestParam(value = "uid",defaultValue = "000000000") int user_id) {
        return "This is the function that gives you recommended other users for user " + user_id;
    }


    @GetMapping("/user/follows")
    public String follows(@RequestParam(value = "uid",defaultValue = "000000000") int user_id) {
        return "This is the function that shows who you follows for user " + user_id;
    }

    @GetMapping("/user/followers")
    public String followers(@RequestParam(value = "uid",defaultValue = "000000000") int user_id) {
        return "This is the function that shows your followers for user " + user_id;
    }
}
