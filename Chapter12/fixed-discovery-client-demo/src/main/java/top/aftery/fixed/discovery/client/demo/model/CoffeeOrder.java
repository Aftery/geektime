package top.aftery.fixed.discovery.client.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

/**
 * @classname: CoffeeOrder
 * @Auther: aftery
 * @Date: 2020/5/7 20:49
 * @Description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CoffeeOrder {
    private Long id;
    private String customer;
    private List<Coffee> items;
    private OrderState state;
    private Date createTime;
    private Date updateTime;
}
