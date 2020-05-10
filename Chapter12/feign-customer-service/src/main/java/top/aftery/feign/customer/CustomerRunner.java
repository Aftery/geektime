package top.aftery.feign.customer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import top.aftery.feign.customer.integration.CoffeeOrderService;
import top.aftery.feign.customer.integration.CoffeeService;
import top.aftery.feign.customer.model.Coffee;
import top.aftery.feign.customer.model.CoffeeOrder;
import top.aftery.feign.customer.model.NewOrderRequest;

import java.util.Arrays;
import java.util.List;

/**
 * @classname: CustomerRunner
 * @Auther: aftery
 * @Date: 2020/4/29 22:02
 * @Description:
 */
@Slf4j
@Component
public class CustomerRunner implements ApplicationRunner {

    @Autowired
    private CoffeeService coffeeService;

    @Autowired
    private CoffeeOrderService coffeeOrderService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        readMenu();
        Long id = orderCoffee();
        queryOrder(id);
    }

    private void readMenu() {
        List<Coffee> coffees = coffeeService.getAll();
        coffees.forEach(c -> log.info("Coffee: {}", c));
    }

    private Long orderCoffee() {
        NewOrderRequest orderRequest = NewOrderRequest.builder()
                .customer("Li Lei")
                .items(Arrays.asList("capuccino"))
                .build();
        CoffeeOrder order = coffeeOrderService.create(orderRequest);
        log.info("Order ID: {}", order.getId());
        return order.getId();
    }

    private void queryOrder(Long id) {
        CoffeeOrder order = coffeeOrderService.getOrder(id);
        log.info("Order: {}", order);
    }
}
