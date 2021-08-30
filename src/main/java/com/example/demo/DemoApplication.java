package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
        return String.format("Hello %s!", name);
    }

    @GetMapping("/user")
    public String user() {
        return String.format("This is the user page");
    }

    @GetMapping("/user/register")
    public String user_register(@RequestParam(value = "Email_register", defaultValue = "XX@gmail.com") String email_address, @RequestParam(value = "password_register", defaultValue = "123456") String password) {
        return String.format("This is the user register with email address %s password %s", email_address, password);
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

    @GetMapping("/twitter")
    public String twitter() {
        return "this is the info page for posts";
    }

    @GetMapping("/twitter/generatetid")
    public String generate_tid(@RequestParam(value = "uid", defaultValue = "000000000") int user_id) {
        return "This is the function that generate a unique post tid";
    }

    @GetMapping("/twitter/post")
    public String post(@RequestParam(value = "content", defaultValue = "yoyo") String content, @RequestParam(value = "tid_refer",defaultValue = "11111") String tid, @RequestParam(value = "timeline",defaultValue = "Jan 11") String time) {
        return String.format("content = %s, %n tid_refer = %s %n time_line = %s",content,tid, time);
    }

    @GetMapping("/twitter/retweet")
    public String retweet(@RequestParam(value = "tid_refer", defaultValue = "11111") String tid, @RequestParam(value = "timeline", defaultValue = "Jan 11") String timeline) {
        return String.format("This function is to generate a retweet with its refer tid %s and timeline %s", tid,timeline);
    }

    @GetMapping("/twitter/like")
    public String like(@RequestParam(value = "tid", defaultValue = "11111") String tid, @RequestParam(value = "status", defaultValue = "True") String status) {
        return String.format("This function is to like tid %s with status %s", tid, status);
    }

    @GetMapping("/twitter/dislike")
    public String dislike(@RequestParam(value = "tid", defaultValue = "11111") String tid, @RequestParam(value = "status", defaultValue = "True") String status) {
        return String.format("This function is to dislike tid %s with status %s", tid, status);
    }

    @GetMapping("/twitter/comment")
    public String comment(@RequestParam(value = "content", defaultValue = "awww") String content, @RequestParam(value = "tid_refer", defaultValue = "11111") String tid, @RequestParam(value = "timeline", defaultValue = "Jan 11") String time) {
        return String.format("This function is to leave a comment on a refered tid %s, with content = %s and time is %s",tid,content,time);
    }

    @GetMapping("/trending/currenthotfeed")
    public String getcurrenthotfeed() {
        return "This function is to get current hot feed for everyone (national wide)";
    }

    @GetMapping("/trending/personalize_recommend_feed")
    public String get_personalize_recommend_feed(@RequestParam(value = "uid" , defaultValue = "111111") String uid) {
        return String.format("This function is to get personalized feeding for uid %s",uid);
    }

    @GetMapping("/trending/related_feed")
    public String get_related_feed(@RequestParam(value = "tid", defaultValue = "11111") String tid) {
        return String.format("This function is to get related feed of tid %s",tid);
    }

}