package com.example.demo.model;

import javax.persistence.*;
@Entity
@Table(name = "Album")
public class Album {
    @Id
    @Column(name = "lid", nullable = false)
    private int lid;

    @Column(name = "tag")
    private String tag;

    @Column(name = "hot_metric")
    private int hot_metric;

    @Column(name = "refer_tid",nullable = false)
    private int refer_tid;

    public int getLid() {
        return lid;
    }

    public int getHot_metric() {
        return hot_metric;
    }

    public String getTag() {
        return tag;
    }
    public int getRefer_tid() {
        return refer_tid;
    }

    public void setLid(int lid_num) {
        lid = lid_num;
    }

    public void setRefer_tid(int num) {
        refer_tid = num;
    }
    public void setTag(String atag) {
        tag = atag;
    }
    public void setHot_metric(int metric) {
        hot_metric = metric;
    }
}
