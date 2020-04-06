package top.aftery.cache.withredsi.demo.service;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.aftery.cache.withredsi.demo.entity.Coffee;
import top.aftery.cache.withredsi.demo.repository.CoffeeRepository;

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
@CacheConfig(cacheNames = "coffee")
public class CoffeeService {

    @Autowired
    private CoffeeRepository coffeeRepository;


    @Cacheable
    public List<Coffee> findAllCoffee() {
        log.info("findAllCoffee");
        return coffeeRepository.findAll();
    }

    @CacheEvict
    public void reloadCoffee() {
    }


}
