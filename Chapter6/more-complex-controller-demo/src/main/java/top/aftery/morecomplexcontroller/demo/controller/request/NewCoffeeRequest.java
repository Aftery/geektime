package top.aftery.morecomplexcontroller.demo.controller.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.joda.money.Money;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @classname: NewCoffeeRequest
 * @Auther: aftery
 * @Date: 2020-04-12 10:54
 * @Description:
 */
@Getter
@Setter
@ToString
public class NewCoffeeRequest {

    @NotEmpty
    private String name;

    @NotNull
    private Money price;
}
