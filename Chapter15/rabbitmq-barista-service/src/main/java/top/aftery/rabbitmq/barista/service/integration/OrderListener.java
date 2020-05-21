package top.aftery.rabbitmq.barista.service.integration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;
import org.springframework.stereotype.Component;
import top.aftery.rabbitmq.barista.service.entity.CoffeeOrder;
import top.aftery.rabbitmq.barista.service.entity.OrderState;
import top.aftery.rabbitmq.barista.service.repository.CoffeeOrderRepository;

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
    public void processNewOrder(Long id) {
        CoffeeOrder o = orderRepository.getOne(id);
        if (o == null) {
            log.warn("Order id {} is NOT valid.", id);
            return;
        }
        log.info("Receive a new Order {}. Waiter: {}. Customer: {}",
                id, o.getWaiter(), o.getCustomer());
        o.setState(OrderState.BREWED);
        o.setBarista(barista);
        orderRepository.save(o);
        log.info("Order {} is READY.", id);
        log.error("我接受到mq的消息了："+id);
        finishedOrdersMessageChannel.send(MessageBuilder.withPayload(id).build());
    }

}
