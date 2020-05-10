package top.aftery.resilience4j.circuitbreaker.demo.model;

/**
 * @classname: OrderState
 * @Auther: aftery
 * @Date: 2020/5/6 21:14
 * @Description:
 */
public enum OrderState {
    INIT, PAID, BREWING, BREWED, TAKEN, CANCELLED
}
