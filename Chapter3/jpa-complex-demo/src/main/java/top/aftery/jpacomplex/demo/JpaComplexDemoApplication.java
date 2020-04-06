package top.aftery.jpacomplex.demo;

import lombok.extern.slf4j.Slf4j;
import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;
import top.aftery.jpacomplex.demo.entity.Coffee;
import top.aftery.jpacomplex.demo.entity.CoffeeOrder;
import top.aftery.jpacomplex.demo.entity.OrderState;
import top.aftery.jpacomplex.demo.repository.Baserepository;
import top.aftery.jpacomplex.demo.repository.CoffeeOrderRepository;
import top.aftery.jpacomplex.demo.repository.CoffeeRepository;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@SpringBootApplication
public class JpaComplexDemoApplication implements CommandLineRunner {

    @Autowired
    private CoffeeOrderRepository orderRepository;

    @Autowired
    private CoffeeRepository coffeeRepository;

    public static void main(String[] args) {
        SpringApplication.run(JpaComplexDemoApplication.class, args);
    }


    @Override
    @Transactional
    public void run(String... args) throws Exception {
        //添加数据
//        initOrders();
        //查询数据
        findOrders();
    }

    private void initOrders() {
        Coffee latte = Coffee.builder().name("latte")
                .price(Money.of(CurrencyUnit.of("CNY"), 30.0))
                .build();
        coffeeRepository.save(latte);
        log.info("Coffee: {}", latte);

        Coffee espresso = Coffee.builder().name("espresso")
                .price(Money.of(CurrencyUnit.of("CNY"), 20.0))
                .build();
        coffeeRepository.save(espresso);
        log.info("Coffee: {}", espresso);

        CoffeeOrder order = CoffeeOrder.builder()
                .customer("Li Lei")
                .items(Collections.singletonList(espresso))
                .state(OrderState.INIT)
                .build();
        orderRepository.save(order);
        log.info("Order: {}", order);

        order = CoffeeOrder.builder()
                .customer("Li Lei")
                .items(Arrays.asList(espresso, latte))
                .state(OrderState.INIT)
                .build();
        orderRepository.save(order);
        log.info("Order: {}", order);

    }

    private void findOrders() {
        coffeeRepository.findAll(Sort.by(Sort.Direction.DESC,"price"))
                .forEach(row->log.info(row.toString()));
        log.info("===========================================================================");

        /**
         * 查询coffee前3，按照更新时间降序，id升序
         */
        coffeeRepository.findTop3ByOrderByUpdateTimeDescIdAsc()
                .forEach(row->log.info(row.toString()));

        log.info("===========================================================================");

        List<CoffeeOrder> list = orderRepository.findByCustomerOrderById("Li Lei");
        list.forEach(row->log.info(row.toString()));

        log.info("===========================================================================");

        String latte = orderRepository.findByItems_Name("espresso").stream()
                .map(o -> o.getId().toString())
                .collect(Collectors.joining(","));
        System.out.println(latte);
    }


}
