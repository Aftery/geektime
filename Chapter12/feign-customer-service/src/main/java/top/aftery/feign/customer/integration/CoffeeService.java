package top.aftery.feign.customer.integration;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import top.aftery.feign.customer.model.Coffee;

import java.util.List;

/**
 * @classname: CoffeeService
 * @Auther: aftery
 * @Date: 2020/4/29 22:22
 * @Description:
 */
@FeignClient(name = "eureka-waiter-service",contextId = "coffee",path = "/coffee")
public interface CoffeeService {

    @GetMapping(path = "/", params = "!name")
    List<Coffee> getAll();

    @GetMapping("/{id}")
    Coffee getById(@PathVariable Long id);

    @GetMapping(path = "/", params = "name")
    Coffee getByName(@RequestParam String name);

}
