package top.aftery.ribbon.customer.service.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @classname: NewOrderRequest
 * @Auther: aftery
 * @Date: 2020/4/29 21:54
 * @Description:
 */
@Builder
@Getter
@Setter
public class NewOrderRequest {
    private String customer;
    private List<String> items;
}
