package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;

@Entity
@Table(name = "ResponseTweet")
public class ResponseTweet {
    @Id
    @Column(name = "tid", nullable = false)
    private int tid;


    @Column(name = "uid",nullable = false)
    private int uid;

    @Column(name = "time",nullable = false)
    private Date time;

    @Column(name = "refer_tid")
    private int refer_tid;

    @Column(name = "likescount")
    private int likes_count;

    @Column(name = "dislikescount")
    private int dislikes_count;


    public int getTid() {
        return tid;
    }

    public void setTid(int num) {
        tid = num;
    }

    public int getUid() {
        return uid;
    }
    public void setUid(int num) {
        uid = num;
    }
    public Date getTime() {
        return time;
    }
    public void setTime(Date adate) {
        time = adate;
    }

    public int getRefer_tid() {
        return refer_tid;
    }
    public void setRefer_tid(int num) {
        refer_tid = num;
    }

    public int getLikes_count() {
        return likes_count;
    }
    public void setLikes_count(int count) {
        likes_count = count;
    }

    public int getDislikes_count() {
        return dislikes_count;
    }
    public void setDislikes_count(int count) {
        dislikes_count = count;
    }

    @Override
    public String toString() {
        return "This post is published by " + uid + "with unique tid " + tid;
    }
}
