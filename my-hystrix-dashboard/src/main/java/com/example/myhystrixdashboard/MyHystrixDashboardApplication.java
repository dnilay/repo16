package com.example.myhystrixdashboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrixDashboard
public class MyHystrixDashboardApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyHystrixDashboardApplication.class, args);
    }

}
