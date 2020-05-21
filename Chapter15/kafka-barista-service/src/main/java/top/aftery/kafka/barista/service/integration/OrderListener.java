package top.aftery.kafka.barista.service.integration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;
import top.aftery.kafka.barista.service.entity.CoffeeOrder;
import top.aftery.kafka.barista.service.entity.OrderState;
import top.aftery.kafka.barista.service.repository.CoffeeOrderRepository;

import javax.transaction.Transactional;

/**
 * @classname: OrderListener
 * @Auther: aftery
 * @Date: 2020/5/19 20:37
 * @Description:
 */
@Component
@Slf4j
@Transactional
public class OrderListener {

    @Autowired
    private CoffeeOrderRepository orderRepository;
    @Autowired
    @Qualifier(Waiter.FINISHED_ORDERS)
    private MessageChannel finishedOrdersMessageChannel;
    @Value("${order.barista-prefix}${random.uuid}")
    private String barista;

    @StreamListener(Waiter.NEW_ORDERS)
    @SendTo(Waiter.FINISHED_ORDERS)
    public Long processNewOrder(Long id) {
        CoffeeOrder o = orderRepository.getOne(id);
        if (o == null) {
            log.warn("Order id {} is NOT valid.", id);
            throw new IllegalArgumentException("Order ID is INVAILD!");
        }
        log.info("Receive a new Order {}. Waiter: {}. Customer: {}",
                id, o.getWaiter(), o.getCustomer());
        o.setState(OrderState.BREWED);
        o.setBarista(barista);
        orderRepository.save(o);
        log.info("Order {} is READY.", id);
        return id;
    }

}
