package top.aftery.hystrix.stream.customer.service.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.aftery.hystrix.stream.customer.service.integration.CoffeeOrderService;
import top.aftery.hystrix.stream.customer.service.integration.CoffeeService;
import top.aftery.hystrix.stream.customer.service.model.Coffee;
import top.aftery.hystrix.stream.customer.service.model.CoffeeOrder;
import top.aftery.hystrix.stream.customer.service.model.NewOrderRequest;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @classname: CustomerController
 * @Auther: aftery
 * @Date: 2020/5/8 21:31
 * @Description:
 */
@RestController
@RequestMapping("/customer")
@Slf4j
public class CustomerController {

    @Autowired
    private CoffeeService coffeeService;

    @Autowired
    private CoffeeOrderService coffeeOrderService;

    @GetMapping("/menu")
    public List<Coffee> readMenu() {
        List<Coffee> list = coffeeService.getAll();
        return list == null ? Collections.emptyList() : list;
    }

    @PostMapping("/order")
    @HystrixCommand(fallbackMethod = "fallbackCreateOrder")
    public CoffeeOrder createOrder() {
        NewOrderRequest orderRequest = NewOrderRequest.builder()
                .customer("Li Lei")
                .items(Arrays.asList("capuccino"))
                .build();
        CoffeeOrder order = coffeeOrderService.create(orderRequest);
        log.info("Order ID: {}", order != null ? order.getId() : "-");
        return order;
    }

    public CoffeeOrder fallbackCreateOrder() {
        log.warn("Fallback to NULL order.");
        return null;
    }
}

