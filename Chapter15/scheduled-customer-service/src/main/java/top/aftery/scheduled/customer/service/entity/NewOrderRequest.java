package top.aftery.scheduled.customer.service.entity;

import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * @classname: NewOrderRequest
 * @Auther: aftery
 * @Date: 2020/5/20 21:44
 * @Description:
 */
@Builder
@Data
public class NewOrderRequest {
    private String customer;
    private List<String> items;
}
