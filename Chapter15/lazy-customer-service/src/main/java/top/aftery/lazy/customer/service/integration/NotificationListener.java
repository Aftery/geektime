package top.aftery.lazy.customer.service.integration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;
import top.aftery.lazy.customer.service.model.CoffeeOrder;
import top.aftery.lazy.customer.service.model.OrderState;
import top.aftery.lazy.customer.service.model.OrderStateRequest;

/**
 * @classname: NotificationListener
 * @Auther: aftery
 * @Date: 2020/5/20 22:25
 * @Description:
 */
@Component
@Slf4j
public class NotificationListener {
    @Autowired
    private CoffeeOrderService orderService;
    @Value("${customer.name}")
    private String customer;

    @StreamListener(Waiter.NOTIFY_ORDERS)
    public void takeOrder(@Payload Long id) {
        CoffeeOrder order = orderService.getOrder(id);
        if (OrderState.BREWED == order.getState()) {
            log.info("Order {} is READY, I'll take it.", id);
            orderService.updateState(id,
                    OrderStateRequest.builder().state(OrderState.TAKEN).build());
        } else {
            log.warn("Order {} is NOT READY. Why are you notify me?", id);
        }
    }

}
