package top.aftery.spring.bucks.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.aftery.spring.bucks.entity.Coffee;
import top.aftery.spring.bucks.repository.CoffeeRepository;

import java.util.Optional;

import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.exact;

/**
 * @classname: CoffeeService
 * @Auther: aftery
 * @Date: 2020-04-05 14:35
 * @Description:
 */
@Slf4j
@Service
@Transactional
public class CoffeeService {

    @Autowired
    private CoffeeRepository relocation;

    public Optional<Coffee> findOneCoffee(String name) {

        ExampleMatcher matcher = ExampleMatcher.matching()
                .withMatcher("name", exact().ignoreCase());
        Optional<Coffee> coffee = relocation.findOne(
                Example.of(Coffee.builder().name(name).build(), matcher));
        log.info("coffee found:{}", coffee);
        return coffee;
    }

}
