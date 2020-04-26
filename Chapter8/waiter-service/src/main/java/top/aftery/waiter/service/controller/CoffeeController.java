package top.aftery.waiter.service.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import top.aftery.waiter.service.entity.Coffee;
import top.aftery.waiter.service.service.CoffeeService;

/**
 * @classname: CoffeeController
 * @Auther: aftery
 * @Date: 2020-04-11 17:03
 * @Description:
 */

@Controller
@RequestMapping("/coffee")
@Slf4j
public class CoffeeController {
    @Autowired
    private CoffeeService coffeeService;

    @GetMapping(path = "/", params = "!name")
    @ResponseBody
    public Flux<Coffee> getAll() {
        log.error("===============");
        return coffeeService.findAll();
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Mono<Coffee> getById(@PathVariable Long id) {
        return coffeeService.findById(id);
    }

    @GetMapping(path = "/", params = "name")
    @ResponseBody
    public Mono<Coffee> getByName(@RequestParam String name) {
        return coffeeService.findByName(name);
    }
}
