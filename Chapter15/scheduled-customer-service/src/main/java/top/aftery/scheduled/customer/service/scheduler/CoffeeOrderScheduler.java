package top.aftery.scheduled.customer.service.scheduler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import top.aftery.scheduled.customer.service.entity.CoffeeOrder;
import top.aftery.scheduled.customer.service.entity.OrderState;
import top.aftery.scheduled.customer.service.entity.OrderStateRequest;
import top.aftery.scheduled.customer.service.integration.CoffeeOrderService;
import top.aftery.scheduled.customer.service.support.OrderWaitingEvent;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @classname: CoffeeOrderScheduler
 * @Auther: aftery
 * @Date: 2020/5/20 21:48
 * @Description:
 */
@Component
@Slf4j
public class CoffeeOrderScheduler {

    @Autowired
    private CoffeeOrderService coffeeOrderService;
    private Map<Long, CoffeeOrder> orderMap = new ConcurrentHashMap<>();

    @EventListener
    public void acceptOrder(OrderWaitingEvent event) {
        orderMap.put(event.getOrder().getId(), event.getOrder());
    }

    @Scheduled(fixedRate = 1000)
    public void waitForCoffee() {
        if (orderMap.isEmpty()) {
            return;
        }
        log.info("I'm waiting for my coffee.");
        orderMap.values().stream()
                .map(o -> coffeeOrderService.getOrder(o.getId()))
                .filter(o -> OrderState.BREWED == o.getState())
                .forEach(o -> {
                    log.info("Order [{}] is READY, I'll take it.", o);
                    coffeeOrderService.updateState(o.getId(),
                            OrderStateRequest.builder()
                                    .state(OrderState.TAKEN).build());
                    orderMap.remove(o.getId());
                });
    }

}
