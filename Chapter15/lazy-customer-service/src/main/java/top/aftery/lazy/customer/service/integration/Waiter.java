package top.aftery.lazy.customer.service.integration;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

/**
 * @classname: Waiter
 * @Auther: aftery
 * @Date: 2020/5/20 22:26
 * @Description:
 */
public interface Waiter {
    String NOTIFY_ORDERS = "notifyOrders";

    @Input(NOTIFY_ORDERS)
    SubscribableChannel notification();
}