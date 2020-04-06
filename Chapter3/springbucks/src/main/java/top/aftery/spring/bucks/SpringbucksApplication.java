package top.aftery.spring.bucks;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import top.aftery.spring.bucks.entity.Coffee;
import top.aftery.spring.bucks.entity.CoffeeOrder;
import top.aftery.spring.bucks.entity.OrderState;
import top.aftery.spring.bucks.repository.CoffeeRepository;
import top.aftery.spring.bucks.service.CoffeeOrderService;
import top.aftery.spring.bucks.service.CoffeeService;

import java.util.Optional;

@Slf4j
@SpringBootApplication
public class SpringbucksApplication implements CommandLineRunner {

    @Autowired
    private CoffeeRepository coffeeRepository;
    @Autowired
    private CoffeeService coffeeService;
    @Autowired
    private CoffeeOrderService orderService;

    public static void main(String[] args) {
        SpringApplication.run(SpringbucksApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
      log.info("all coffee:{}",coffeeRepository.findAll());

        Optional<Coffee> latte = coffeeService.findOneCoffee("latte");
        if(latte.isPresent()){
            CoffeeOrder order = orderService.createOrder("li lei", latte.get());
            log.info("updte init to paid:{}",orderService.updateState(order, OrderState.PAID));
            log.info("updte init to init:{}",orderService.updateState(order, OrderState.INIT));
        }
    }
}
