package top.aftery.waiter.service.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.io.Serializable;
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
@Table("t_order")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CoffeeOrder implements Serializable {
    @Id
    private Long id;
    private String customer;
    private OrderState state;
    private List<Coffee> items;
    private Date createTime;
    private Date updateTime;
}
