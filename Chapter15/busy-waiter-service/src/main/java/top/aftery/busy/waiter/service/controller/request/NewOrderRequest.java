package top.aftery.busy.waiter.service.controller.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * @classname: NewOrderRequest
 * @Auther: aftery
 * @Date: 2020-04-11 16:58
 * @Description:
 */
@Getter
@Setter
@ToString
public class NewOrderRequest {

    private String customer;
    private List<String> items;

}
