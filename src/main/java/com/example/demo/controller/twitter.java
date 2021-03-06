package com.example.demo.controller;

import com.example.demo.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.DAO.postDAO;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

@SpringBootApplication

@RestController

public class twitter {
    @Autowired
    postDAO DAO;
    // ****** Single Rest Controller *******


    @GetMapping("/twitter")
    public String twitter() throws ParseException {
        DAO.writePost(1,"YoYo", 4);
        return "successful write";
    }



    @GetMapping("/twitter/generatetid")
    public String generate_tid(@RequestParam(value = "uid", defaultValue = "000000000") int user_id) {
        return "This is the function that generate a unique post tid";
    }

    @GetMapping("/twitter/post")
    public String post(@RequestParam(value = "content", defaultValue = "yoyo") String content,
                       @RequestParam(value = "tid_refer",defaultValue = "11111") String tid,
                       @RequestParam(value = "timeline",defaultValue = "Jan 11") String time) {
        return String.format("content = %s, %n tid_refer = %s %n time_line = %s",content,tid, time);
    }

    @GetMapping("/twitter/retweet")
    public String retweet(@RequestParam(value = "tid_refer", defaultValue = "11111") String tid,
                          @RequestParam(value = "timeline", defaultValue = "Jan 11") String timeline) {
        return String.format("This function is to generate a retweet with its refer tid %s and timeline %s", tid,timeline);
    }

    @GetMapping("/twitter/like")
    public String like(@RequestParam(value = "tid", defaultValue = "11111") String tid,
                       @RequestParam(value = "status", defaultValue = "True") String status) {
        return String.format("This function is to like tid %s with status %s", tid, status);
    }

    @GetMapping("/twitter/dislike")
    public String dislike(@RequestParam(value = "tid", defaultValue = "11111") String tid,
                          @RequestParam(value = "status", defaultValue = "True") String status) {
        return String.format("This function is to dislike tid %s with status %s", tid, status);
    }

    @GetMapping("/twitter/comment")
    public String comment(@RequestParam(value = "content", defaultValue = "awww") String content,
                          @RequestParam(value = "tid_refer", defaultValue = "11111") String tid,
                          @RequestParam(value = "timeline", defaultValue = "Jan 11") String time) {
        return String.format("This function is to leave a comment on a refered tid %s, with content = %s and time is %s",tid,content,time);
    }
}
