package top.aftery.scheduled.customer.service.support;

import lombok.Data;
import org.springframework.context.ApplicationEvent;
import top.aftery.scheduled.customer.service.entity.CoffeeOrder;

/**
 * @classname: OrderWaitingEvent
 * @Auther: aftery
 * @Date: 2020/5/20 21:45
 * @Description:
 */
@Data
public class OrderWaitingEvent extends ApplicationEvent {
    private CoffeeOrder order;

    public OrderWaitingEvent(CoffeeOrder order) {
        super(order);
        this.order = order;
    }
}
