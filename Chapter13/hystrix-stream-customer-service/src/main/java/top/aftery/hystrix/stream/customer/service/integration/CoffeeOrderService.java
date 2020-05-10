package top.aftery.hystrix.stream.customer.service.integration;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import top.aftery.hystrix.stream.customer.service.model.CoffeeOrder;
import top.aftery.hystrix.stream.customer.service.model.NewOrderRequest;


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
}
