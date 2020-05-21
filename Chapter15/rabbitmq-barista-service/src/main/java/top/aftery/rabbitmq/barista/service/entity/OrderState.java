package top.aftery.rabbitmq.barista.service.entity;

/**
 * @classname: OrderState
 * @Auther: aftery
 * @Date: 2020/5/19 20:40
 * @Description:
 */
public enum OrderState {
    INIT, PAID, BREWING, BREWED, TAKEN, CANCELLED
}
