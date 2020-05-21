package top.aftery.scheduled.customer.service.integration;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import top.aftery.scheduled.customer.service.entity.CoffeeOrder;
import top.aftery.scheduled.customer.service.entity.NewOrderRequest;
import top.aftery.scheduled.customer.service.entity.OrderStateRequest;

/**
 * @classname: CoffeeOrderService
 * @Auther: aftery
 * @Date: 2020/5/20 21:49
 * @Description:
 */
@FeignClient(name = "waiter-service", contextId = "coffeeOrder")
public interface CoffeeOrderService {
    @GetMapping("/order/{id}")
    CoffeeOrder getOrder(@PathVariable("id") Long id);

    @PostMapping(path = "/order/", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    CoffeeOrder create(@RequestBody NewOrderRequest newOrder);

    @PutMapping("/order/{id}")
    CoffeeOrder updateState(@PathVariable("id") Long id,
                            @RequestBody OrderStateRequest orderState);
}
