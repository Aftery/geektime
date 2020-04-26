package top.aftery.http2customerservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

/**
 * @program: CoffeeOrder
 * @description:
 * @author: aftery
 * @create: 2020-03-31 14:33
 * @Table(name = "T_ORDER") 可输出父类的属性
 * @ManyToMany ：多对多的关系
 * @JoinTable ：指定Coffee里面外键的名字
 * @OrderBy ：按照id排序
 **/
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
