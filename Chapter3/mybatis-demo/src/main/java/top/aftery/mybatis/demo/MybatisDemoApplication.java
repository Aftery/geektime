package top.aftery.mybatis.demo;

import lombok.extern.slf4j.Slf4j;
import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import top.aftery.mybatis.demo.entity.Coffee;
import top.aftery.mybatis.demo.mapper.CoffeeMapper;

@Slf4j
@SpringBootApplication
public class MybatisDemoApplication implements CommandLineRunner {


    @Autowired
    private CoffeeMapper coffeeMapper;

    public static void main(String[] args) {
        SpringApplication.run(MybatisDemoApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
//        save();
        findById(1L);
    }

    public void save() {
        Coffee c = Coffee.builder().name("espresso")
                .price(Money.of(CurrencyUnit.of("CNY"), 20.0)).build();
        int count = coffeeMapper.save(c);
        log.info("Save {} Coffee: {}", count, c);

        c = Coffee.builder().name("latte")
                .price(Money.of(CurrencyUnit.of("CNY"), 25.0)).build();
        count = coffeeMapper.save(c);
        log.info("Save {} Coffee: {}", count, c);
    }

    public void findById(Long id) {
        System.out.println(coffeeMapper.findById(id));
    }
}
