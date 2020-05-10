package top.aftery.nacos.waiter.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableCaching
@EnableDiscoveryClient
@EnableJpaRepositories
public class NacosWaiterServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(NacosWaiterServiceApplication.class, args);
    }

}
