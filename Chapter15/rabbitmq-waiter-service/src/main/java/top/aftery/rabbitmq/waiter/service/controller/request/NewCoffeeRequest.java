package top.aftery.rabbitmq.waiter.service.controller.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.joda.money.Money;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @classname: NewCoffeeRequest
 * @Auther: aftery
 * @Date: 2020-04-12 11:44
 * @Description:
 */
@Getter
@Setter
@ToString
@Component
public class NewCoffeeRequest {

    @NotEmpty
    private String name;

    @NotNull
    private Money price;

}
