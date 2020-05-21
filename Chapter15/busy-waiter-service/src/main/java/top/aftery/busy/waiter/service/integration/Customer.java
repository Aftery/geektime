package top.aftery.busy.waiter.service.integration;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

/**
 * @classname: Customer
 * @Auther: aftery
 * @Date: 2020/5/20 22:41
 * @Description:
 */
public interface Customer {
    String NOTIFY_ORDERS = "notifyOrders";

    @Output(NOTIFY_ORDERS)
    MessageChannel notification();
}
