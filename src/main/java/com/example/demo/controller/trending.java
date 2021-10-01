package com.example.demo.controller;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication

@RestController
public class trending{
        // Single Rest Controller
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
