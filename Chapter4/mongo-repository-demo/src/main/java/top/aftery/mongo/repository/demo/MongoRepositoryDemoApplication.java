package top.aftery.mongo.repository.demo;

import lombok.extern.slf4j.Slf4j;
import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.convert.MongoCustomConversions;
import top.aftery.mongo.repository.demo.converter.MoneyReadConverter;
import top.aftery.mongo.repository.demo.entity.Coffee;
import top.aftery.mongo.repository.demo.repository.CoffeeRepository;

import java.util.Arrays;
import java.util.Date;

@Slf4j
@SpringBootApplication
public class MongoRepositoryDemoApplication implements CommandLineRunner {

    @Autowired
    private CoffeeRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(MongoRepositoryDemoApplication.class, args);
    }


    @Bean
    public MongoCustomConversions mongoCustomConversions() {
        return new MongoCustomConversions(Arrays.asList(new MoneyReadConverter()));
    }

    @Override
    public void run(String... args) throws Exception {
        Coffee espresso = Coffee.builder()
                .name("espresso")
                .price(Money.of(CurrencyUnit.of("CNY"), 20.0))
                .createTime(new Date())
                .updateTime(new Date()).build();
        Coffee latte = Coffee.builder()
                .name("latte")
                .price(Money.of(CurrencyUnit.of("CNY"), 30.0))
                .createTime(new Date())
                .updateTime(new Date()).build();
        repository.insert(Arrays.asList(espresso, latte));
        repository.findAll(Sort.by("name")).forEach(
                row -> log.info("save coffee:{}", row)
        );
        log.error("===================================");
        Thread.sleep(3000);
        latte.setPrice(Money.of(CurrencyUnit.of("CNY"),35.0));
        latte.setUpdateTime(new Date());

        repository.save(latte);

        repository.findByName("latte").forEach(row -> log.info("coffee:{}", row));
        repository.deleteAll();
    }
}
