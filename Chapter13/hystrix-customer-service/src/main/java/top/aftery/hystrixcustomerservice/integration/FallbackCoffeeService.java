package top.aftery.hystrixcustomerservice.integration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import top.aftery.hystrixcustomerservice.model.Coffee;

import java.util.List;

/**
 * @classname: FallbackCoffeeService
 * @Auther: aftery
 * @Date: 2020/5/10 14:35
 * @Description:
 */
@Slf4j
@Component
public class FallbackCoffeeService implements CoffeeService{


    @Override
    public List<Coffee> getAll() {
        log.warn("Fallback to EMPTY menu.");
        return null;
    }

    @Override
    public Coffee getById(Long id) {
        return null;
    }

    @Override
    public Coffee getByName(String name) {
        return null;
    }
}
