package top.aftery.busy.waiter.service.integration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;
import top.aftery.busy.waiter.service.entity.CoffeeOrder;
import top.aftery.busy.waiter.service.service.CoffeeOrderService;

/**
 * @classname: OrderListener
 * @Auther: aftery
 * @Date: 2020/5/18 22:15
 * @Description:
 */
@Component
@Slf4j
public class OrderListener {

    @Autowired
    private Customer customer;
    @Autowired
    private CoffeeOrderService orderService;

    @StreamListener(Barista.FINISHED_ORDERS)
    public void listenFinishedOrders(Long id) {
        log.info("We've finished an order [{}].", id);
        CoffeeOrder order = orderService.get(id);
        Message<Long> message = MessageBuilder.withPayload(id)
                .setHeader("customer", order.getCustomer())
                .build();
        log.info("Notify the customer: {}", order.getCustomer());
        customer.notification().send(message);
    }

}
