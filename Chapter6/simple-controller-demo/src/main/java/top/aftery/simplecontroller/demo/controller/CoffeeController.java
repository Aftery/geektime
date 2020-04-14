package top.aftery.simplecontroller.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.aftery.simplecontroller.demo.entity.Coffee;
import top.aftery.simplecontroller.demo.service.CoffeeService;

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

    @GetMapping("/")
    @ResponseBody
    public List<Coffee> getAll() {
        return coffeeService.findAllCoffee();
    }
}
