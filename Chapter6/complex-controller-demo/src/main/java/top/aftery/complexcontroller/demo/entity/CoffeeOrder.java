package top.aftery.complexcontroller.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
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
@Entity
@Table(name = "T_ORDER")
@Data
@ToString(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonIgnoreProperties(value = "hibernateLazyInitializer")
public class CoffeeOrder extends BaseEntity implements Serializable {

    private String customer;
    @ManyToMany
    @JoinTable(name = "T_ORDER_COFFEE")
    @OrderBy("id")
    private List<Coffee> items;
    @Enumerated
    @Column(nullable = false)
    private OrderState state;


}
