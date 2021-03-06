package top.aftery.thymeleafview.demo.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.aftery.thymeleafview.demo.entity.Coffee;
import top.aftery.thymeleafview.demo.repository.CoffeeRepository;


import java.util.List;

/**
 * @classname: CoffeeService
 * @Auther: aftery
 * @Date: 2020-04-05 17:39
 * @Description:
 */
@Slf4j
@Service
@Transactional
@CacheConfig(cacheNames = "CoffeeCache")
public class CoffeeService {


    @Autowired
    private CoffeeRepository coffeeRepository;

    @Cacheable
    public List<Coffee> findAllCoffee() {
        return coffeeRepository.findAll();
    }

    public List<Coffee> getCoffeeByName(List<String> names){
        return coffeeRepository.findByNameInOrderById(names);
    }


}
