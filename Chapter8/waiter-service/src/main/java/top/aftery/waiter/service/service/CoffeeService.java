package top.aftery.waiter.service.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import top.aftery.waiter.service.entity.Coffee;
import top.aftery.waiter.service.repository.CoffeeRepository;

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

    public Mono<Coffee> findById(Long id) {
        return coffeeRepository.findById(id);
    }

    public Flux<Coffee> findAll() {
        return coffeeRepository.findAll();
    }

    public Mono<Coffee> findByName(String name) {
        return coffeeRepository.findByName(name);
    }

}
