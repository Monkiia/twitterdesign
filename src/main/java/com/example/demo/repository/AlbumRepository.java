package com.example.demo.repository;

import com.example.demo.model.Album;
import com.example.demo.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;


@Repository
public interface AlbumRepository extends JpaRepository<Album,Integer> {
    int findLidByTag(String tag);
}

