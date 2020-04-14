package top.aftery.complexcontroller.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import top.aftery.complexcontroller.demo.entity.Coffee;
import top.aftery.complexcontroller.demo.service.CoffeeService;

import java.util.List;


/**
 * @classname: CoffeeController
 * @Auther: aftery
 * @Date: 2020-04-11 17:03
 * @Description:
 */
@Controller
@RequestMapping("/coffee")
public class CoffeeController {

    @Autowired
    private CoffeeService coffeeService;

    @GetMapping(value = "/", params = "!name")
    @ResponseBody
    public List<Coffee> getAll() {
        return coffeeService.findAllCoffee();
    }

    @ResponseBody
    @RequestMapping(path = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Coffee getById(@PathVariable Long id) {
        Coffee coffee = coffeeService.getCoffee(id);
        return coffee;
    }

    @GetMapping(path = "/", params = "name")
    @ResponseBody
    public Coffee getByName(@RequestParam String name) {
        return coffeeService.getCoffee(name);
    }
}
