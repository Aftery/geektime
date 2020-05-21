package top.aftery.lazy.customer.service.integration;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import top.aftery.lazy.customer.service.model.CoffeeOrder;
import top.aftery.lazy.customer.service.model.NewOrderRequest;
import top.aftery.lazy.customer.service.model.OrderStateRequest;


/**
 * @classname: CoffeeOrderService
 * @Auther: aftery
 * @Date: 2020/5/8 21:32
 * @Description:
 */
@FeignClient(name = "consul-waiter-service", contextId = "coffeeOrder")
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
