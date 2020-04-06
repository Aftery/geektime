package top.aftery.redis.repository.demo;

import io.lettuce.core.ReadFrom;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.redis.LettuceClientConfigurationBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.redis.core.convert.RedisCustomConversions;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import top.aftery.redis.repository.demo.converter.BytesToMoneyConverter;
import top.aftery.redis.repository.demo.converter.MoneyToBytesConverter;
import top.aftery.redis.repository.demo.entity.Coffee;
import top.aftery.redis.repository.demo.service.CoffeeService;

import java.util.Arrays;
import java.util.Optional;

@Slf4j
@SpringBootApplication
@EnableTransactionManagement
@EnableRedisRepositories
@EnableJpaRepositories
public class RedisRepositoryDemoApplication implements CommandLineRunner {

    @Autowired
    private CoffeeService coffeeService;

    public static void main(String[] args) {
        SpringApplication.run(RedisRepositoryDemoApplication.class, args);
    }

    @Bean
    public LettuceClientConfigurationBuilderCustomizer customizer() {
        return builder -> builder.readFrom(ReadFrom.MASTER_PREFERRED);
    }

    @Bean
    public RedisCustomConversions redisCustomConversions() {
        return new RedisCustomConversions(
                Arrays.asList(new MoneyToBytesConverter(), new BytesToMoneyConverter()));
    }
    @Override
    public void run(String... args) throws Exception {
        Optional<Coffee> mocha = coffeeService.findSimpleCoffeeFromCache("mocha");
        log.info("coffee mocha:{}",mocha);

        log.error("===================================================");

        for (int i = 0; i <5 ; i++) {
           mocha = coffeeService.findSimpleCoffeeFromCache("mocha");
        }
        log.info("vlaue from redis:{}",mocha);

    }
}
