package com.example.orderservice;

import com.example.orderservice.dao.OrderDao;
import com.example.orderservice.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableFeignClients
@EnableEurekaClient
@EnableHystrix
@EnableSwagger2
public class OrderServiceApplication implements CommandLineRunner {

    private OrderDao orderDao;

    @Autowired
    public OrderServiceApplication(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    public static void main(String[] args) {
        SpringApplication.run(OrderServiceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        orderDao.save(new Order("Item-A","Customer-A"));
        orderDao.save(new Order("Item-B","Customer-B"));
        orderDao.save(new Order("Item-C","Customer-C"));
        orderDao.save(new Order("Item-D","Customer-D"));

    }

    @Bean
    public Docket swaggerDocker()
    {
        return new Docket(DocumentationType.SWAGGER_2);
    }
}
