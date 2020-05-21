package top.aftery.lazy.customer.service.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @classname: NewOrderRequest
 * @Auther: aftery
 * @Date: 2020/5/6 21:14
 * @Description:
 */
@Builder
@Getter
@Setter
public class NewOrderRequest {
    private String customer;
    private List<String> items;
}
