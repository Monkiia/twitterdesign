package com.example.demo.repository;

import com.example.demo.model.ResponseTweet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;


@Repository
public interface ResponseTweetRepository extends JpaRepository<ResponseTweet,Integer> {
    List<ResponseTweet> findResponseTweetByUid(int uid);
    List<ResponseTweet> findResponseTweetByTime(Date time);
}

