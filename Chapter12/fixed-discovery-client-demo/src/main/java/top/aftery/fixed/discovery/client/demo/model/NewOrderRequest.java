package top.aftery.fixed.discovery.client.demo.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @classname: NewOrderRequest
 * @Auther: aftery
 * @Date: 2020/5/7 20:50
 * @Description:
 */
@Builder
@Getter
@Setter
public class NewOrderRequest {
    private String customer;
    private List<String> items;
}
