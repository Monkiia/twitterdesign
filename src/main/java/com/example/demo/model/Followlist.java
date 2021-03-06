package com.example.demo.model;

import javax.persistence.*;

@Entity
@Table(name = "Followlist")
public class Followlist {
    @Id
    @GeneratedValue
    private int fid;

    @Column(name = "uid", nullable = false)
    private int uid;

    @Column(name = "followid", nullable = false)
    private int follows;

}
