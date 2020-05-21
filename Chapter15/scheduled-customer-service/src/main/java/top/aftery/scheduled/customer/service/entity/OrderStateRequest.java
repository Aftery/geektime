package top.aftery.scheduled.customer.service.entity;

import lombok.Builder;
import lombok.Data;

/**
 * @classname: OrderStateRequest
 * @Auther: aftery
 * @Date: 2020/5/20 21:45
 * @Description:
 */
@Data
@Builder
public class OrderStateRequest {
    private OrderState state;
}
