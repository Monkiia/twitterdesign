package com.example.demo.DAO;
import java.util.*;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository

public interface UseriDAO extends JpaRepository<User,Integer> {

    List<User> findUserByUsername(String username);

}
