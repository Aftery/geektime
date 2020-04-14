package top.aftery.thymeleafview.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import top.aftery.thymeleafview.demo.controller.request.NewOrderRequest;
import top.aftery.thymeleafview.demo.entity.Coffee;
import top.aftery.thymeleafview.demo.entity.CoffeeOrder;
import top.aftery.thymeleafview.demo.service.CoffeeOrderService;
import top.aftery.thymeleafview.demo.service.CoffeeService;

import javax.validation.Valid;
import java.util.List;

/**
 * @classname: CoffeeOrderController
 * @Auther: aftery
 * @Date: 2020-04-11 17:09
 * @Description:
 */
@Slf4j
@Controller
@RequestMapping("/order")
public class CoffeeOrderController {

    @Autowired
    private CoffeeOrderService orderService;

    @Autowired
    private CoffeeService coffeeService;

    @GetMapping("/{id}")
    @ResponseBody
    public CoffeeOrder getOrder(@PathVariable Long id) {
        return orderService.get(id);
    }

    @PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public CoffeeOrder create(@RequestBody NewOrderRequest newOrder) {
        log.info("Receive new Order {}", newOrder);
        Coffee[] coffeeList = coffeeService.getCoffeeByName(newOrder.getItems())
                .toArray(new Coffee[]{});
        return orderService.createOrder(newOrder.getCustomer(), coffeeList);
    }

    @ModelAttribute
    public List<Coffee> coffeeList() {
        return coffeeService.findAllCoffee();
    }

    @GetMapping("/")
    public ModelAndView showCreateForm() {
        return new ModelAndView("create-order-from");
    }

    @PostMapping(path = "/", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String createOrder(@Valid NewOrderRequest newOrder, BindingResult result, ModelMap map) {
        if (result.hasErrors()) {
            log.warn("binding result:{}", result);
            map.addAttribute("message", result.toString());
            return "create-order-from";
        }
        log.info("Receive new Order {}", newOrder);
        Coffee[] coffeeList = coffeeService.getCoffeeByName(newOrder.getItems())
                .toArray(new Coffee[]{});
        CoffeeOrder order = orderService.createOrder(newOrder.getCustomer(), coffeeList);
        return "redirect:/order/" + order.getId();
    }

}
