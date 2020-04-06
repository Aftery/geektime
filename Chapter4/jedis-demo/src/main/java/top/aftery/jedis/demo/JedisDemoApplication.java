package top.aftery.jedis.demo;


import lombok.extern.slf4j.Slf4j;
import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import top.aftery.jedis.demo.service.CoffeeService;

import java.util.Map;

@Slf4j
@SpringBootApplication
public class JedisDemoApplication implements CommandLineRunner {

    @Autowired
    private CoffeeService coffeeService;

    @Autowired
    private JedisPool jedisPool;

    @Autowired
    private JedisPoolConfig jedisPoolConfig;


    public static void main(String[] args) {
        SpringApplication.run(JedisDemoApplication.class, args);
    }

    @Bean
    @ConfigurationProperties("redis")
    public JedisPoolConfig jedisPoolConfig() {
        return new JedisPoolConfig();
    }

    @Bean(destroyMethod = "close")
    public JedisPool jedisPool(@Value("${redis.host}") String host) {
        return new JedisPool(jedisPoolConfig(), host);
    }

    @Override
    public void run(String... args) throws Exception {
        log.info(jedisPoolConfig.toString());
        try (Jedis jedis = jedisPool.getResource()) {
            coffeeService.findAllCoffee().forEach(c ->
                    jedis.hset("springbucks-menu", c.getName(), Long.toString(c.getPrice().getAmountMajorLong()))
            );
            Map<String, String> menu = jedis.hgetAll("springbucks-menu");
            log.info("Menu: {}", menu);

            String price = jedis.hget("springbucks-menu", "espresso");
            log.info("espresso - {}",
                    Money.ofMinor(CurrencyUnit.of("CNY"), Long.parseLong(price)));
        }


    }
}
