package top.aftery.hystrixcustomerservice.integration;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import top.aftery.hystrixcustomerservice.model.Coffee;

import java.util.List;

/**
 * @classname: CoffeeService
 * @Auther: aftery
 * @Date: 2020/5/8 21:32
 * @Description:
 */
@FeignClient(name = "consul-waiter-service", contextId = "coffee",  qualifier = "",path = "/coffee",
        fallback = FallbackCoffeeService.class)
public interface CoffeeService {
    @GetMapping(path = "/", params = "!name")
    List<Coffee> getAll();

    @GetMapping("/{id}")
    Coffee getById(@PathVariable Long id);

    @GetMapping(path = "/", params = "name")
    Coffee getByName(@RequestParam String name);
}
