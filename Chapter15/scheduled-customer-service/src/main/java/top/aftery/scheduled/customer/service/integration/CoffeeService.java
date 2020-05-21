package top.aftery.scheduled.customer.service.integration;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import top.aftery.scheduled.customer.service.entity.Coffee;

import java.util.List;

/**
 * @classname: CoffeeServiceImpl
 * @Auther: aftery
 * @Date: 2020/5/20 21:51
 * @Description:
 */
@FeignClient(name = "waiter-service", contextId = "coffee", path = "/coffee")
public interface CoffeeService {
    @GetMapping(path = "/", params = "!name")
    List<Coffee> getAll();

    @GetMapping("/{id}")
    Coffee getById(@PathVariable Long id);

    @GetMapping(path = "/", params = "name")
    Coffee getByName(@RequestParam String name);
}
