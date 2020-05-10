package top.aftery.feign.customer.integration;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import top.aftery.feign.customer.model.CoffeeOrder;
import top.aftery.feign.customer.model.NewOrderRequest;

/**
 * @classname: CoffeeOrderService
 * @Auther: aftery
 * @Date: 2020/4/29 22:23
 * @Description:
 */
@FeignClient(name = "eureka-waiter-service", contextId = "coffeeOrder", path = "/order")
public interface CoffeeOrderService {

    @GetMapping("/{id}")
    CoffeeOrder getOrder(@PathVariable("id") Long id);

    @PostMapping(path = "/", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    CoffeeOrder create(@RequestBody NewOrderRequest newOrder);

}
