package top.aftery.mybatis.pagehelper.demo.entity;

import lombok.*;
import org.joda.money.Money;

import java.util.Date;

/**
 * @classname: Coffee
 * @Auther: aftery
 * @Date: 2020-04-05 11:32
 * @Description:
 */
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Coffee {

    private Long id;
    private String name;
    private Money price;
    private Date createTime;
    private Date updateTime;
}
