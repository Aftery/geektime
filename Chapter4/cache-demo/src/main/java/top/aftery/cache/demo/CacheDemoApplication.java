package top.aftery.cache.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import top.aftery.cache.demo.service.CoffeeService;

@Slf4j
@SpringBootApplication
@EnableCaching
public class CacheDemoApplication implements CommandLineRunner {

    @Autowired
    private CoffeeService coffeeService;

    public static void main(String[] args) {
        SpringApplication.run(CacheDemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("count:{}",coffeeService.findAllCoffees().size());
        for (int i = 0; i <10 ; i++) {
            log.info("reading from cache");
            coffeeService.findAllCoffees();
        }

        coffeeService.reloadCoffee();
        log.info("Reading after refresh.");
        coffeeService.findAllCoffees().forEach(c -> log.info("Coffee {}", c.getName()));
    }
}
