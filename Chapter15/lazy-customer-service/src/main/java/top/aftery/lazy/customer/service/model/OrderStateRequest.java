package top.aftery.lazy.customer.service.model;

import lombok.Builder;
import lombok.Data;

/**
 * @classname: OrderStateRequest
 * @Auther: aftery
 * @Date: 2020/5/20 22:27
 * @Description:
 */
@Data
@Builder
public class OrderStateRequest {
    private OrderState state;
}
