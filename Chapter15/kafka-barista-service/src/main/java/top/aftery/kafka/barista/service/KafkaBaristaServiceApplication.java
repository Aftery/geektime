package top.aftery.kafka.barista.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import top.aftery.kafka.barista.service.integration.Waiter;

@SpringBootApplication
@EnableJpaRepositories
@EnableBinding(Waiter.class)
public class KafkaBaristaServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(KafkaBaristaServiceApplication.class, args);
    }

}
