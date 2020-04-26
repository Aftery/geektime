package top.aftery.customer.service.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @classname: NewOrderRequest
 * @Auther: aftery
 * @Date: 2020/4/16 20:56
 * @Description:
 */
@Builder
@Getter
@Setter
public class NewOrderRequest {
    private String customer;
    private List<String> items;
}

