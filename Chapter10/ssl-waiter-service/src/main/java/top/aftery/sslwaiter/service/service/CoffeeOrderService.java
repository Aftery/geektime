package top.aftery.sslwaiter.service.service;


import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.binder.MeterBinder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.aftery.sslwaiter.service.entity.Coffee;
import top.aftery.sslwaiter.service.entity.CoffeeOrder;
import top.aftery.sslwaiter.service.entity.OrderState;
import top.aftery.sslwaiter.service.repository.CoffeeOrderRepository;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @classname: CoffeeService
 * @Auther: aftery
 * @Date: 2020-04-05 17:39
 * @Description:
 */
@Slf4j
@Service
@Transactional
public class CoffeeOrderService implements MeterBinder {

    @Autowired
    private CoffeeOrderRepository orderRepository;

    private Counter orderCount=null;

    public CoffeeOrder createOrder(String customer, Coffee... coffee) {
        CoffeeOrder order = CoffeeOrder.builder()
                .customer(customer)
                .items(new ArrayList<>(Arrays.asList(coffee)))
                .state(OrderState.INIT)
                .build();
        CoffeeOrder saved = orderRepository.save(order);
        log.info("New Order: {}", saved);
        orderCount.increment();
        return saved;
    }

    public boolean updateState(CoffeeOrder order, OrderState state) {
        if (state.compareTo(order.getState()) <= 0) {
            log.warn("Wrong State order: {}, {}", state, order.getState());
            return false;
        }
        order.setState(state);
        orderRepository.save(order);
        log.info("Updated Order: {}", order);
        return true;
    }

    public CoffeeOrder get(Long id) {
        return orderRepository.getOne(id);
    }

    @Override
    public void bindTo(MeterRegistry meterRegistry) {
        this.orderCount=meterRegistry.counter("order.count");
    }
}
