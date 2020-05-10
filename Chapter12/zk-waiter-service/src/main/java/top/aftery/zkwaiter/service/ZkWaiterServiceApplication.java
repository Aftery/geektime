package top.aftery.zkwaiter.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableDiscoveryClient
@EnableCaching
@EnableJpaRepositories
public class ZkWaiterServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZkWaiterServiceApplication.class, args);
    }

}
