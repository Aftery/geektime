package top.aftery.indicator.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import top.aftery.indicator.demo.controller.request.NewOrderRequest;
import top.aftery.indicator.demo.entity.Coffee;
import top.aftery.indicator.demo.entity.CoffeeOrder;
import top.aftery.indicator.demo.service.CoffeeOrderService;
import top.aftery.indicator.demo.service.CoffeeService;


/**
 * @classname: CoffeeOrderController
 * @Auther: aftery
 * @Date: 2020-04-11 17:09
 * @Description:
 */
@Slf4j
@Controller
@RequestMapping("/order")
public class CoffeeOrderController {

    @Autowired
    private CoffeeOrderService orderService;

    @Autowired
    private CoffeeService coffeeService;

    @GetMapping("/{id}")
    @ResponseBody
    public CoffeeOrder getOrder(@PathVariable Long id) {
        return orderService.get(id);
    }

    @PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE
            , produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public CoffeeOrder create(@RequestBody NewOrderRequest newOrder) {
        log.info("Receive new Order {}", newOrder);
        Coffee[] coffeeList = coffeeService.getCoffeeByName(newOrder.getItems())
                .toArray(new Coffee[]{});
        return orderService.createOrder(newOrder.getCustomer(), coffeeList);
    }

}
