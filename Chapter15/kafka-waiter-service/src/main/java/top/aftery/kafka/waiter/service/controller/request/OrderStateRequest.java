package top.aftery.kafka.waiter.service.controller.request;

import lombok.Data;
import top.aftery.kafka.waiter.service.entity.OrderState;

/**
 * @classname: OrderStateRequest
 * @Auther: aftery
 * @Date: 2020/5/19 20:53
 * @Description:
 */
@Data
public class OrderStateRequest {
    private OrderState state;
}
