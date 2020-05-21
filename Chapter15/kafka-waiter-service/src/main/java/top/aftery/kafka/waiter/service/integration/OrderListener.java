package top.aftery.kafka.waiter.service.integration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;

/**
 * @classname: OrderListener
 * @Auther: aftery
 * @Date: 2020/5/18 22:15
 * @Description:
 */
@Component
@Slf4j
public class OrderListener {

    @StreamListener(Barista.FINISHED_ORDERS)
    public void listenFinishedOrders(Long id) {
        log.info("We've finished an order [{}].", id);
    }

}
