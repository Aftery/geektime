package top.aftery.waiter.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import top.aftery.waiter.service.service.CoffeeService;

@SpringBootTest
public class WaiterServiceApplicationTests {

    @Autowired
    private CoffeeService coffeeService;


}
