package com.example.demo.repository;
import java.util.*;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.Post;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface PostRepository extends JpaRepository<Post,Integer> {
    List<Post> findPostByUid(int uid);
    List<Post> findPostByTime(Date time);
}

