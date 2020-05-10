package top.aftery.hystrix.stream.customer.service.model;

/**
 * @classname: OrderState
 * @Auther: aftery
 * @Date: 2020/5/6 21:14
 * @Description:
 */
public enum OrderState {
    INIT, PAID, BREWING, BREWED, TAKEN, CANCELLED
}
