package com.example.demo.repository;
import java.util.*;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

public interface FollowlistRepository {
    List<User> findfollowsByUid(int uid);
    List<User> findfollowersByFollows(int follows);
}
