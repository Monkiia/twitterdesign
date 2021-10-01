package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootTest
@EnableJpaRepositories(basePackages = {"com.example.demp/repository"})
class DemoApplicationTests {

    @Test
    void contextLoads() {
    }

}
