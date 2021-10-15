package com.example.demo.repository;
import java.util.*;

import com.example.demo.model.Followlist;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface FollowlistRepository extends CrudRepository<Followlist,Integer> {
    @Query("select f.follows from Followlist f where f.uid = ?1")
    List<Integer> findfollowsByUid(int uid);

    @Query("select f.uid from Followlist f where f.follows = ?1")
    List<Integer> findUidByfollows(int follows);

    List<Followlist> findAll();
}
