package top.aftery.mybatis.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.joda.money.Money;

import java.util.Date;

/**
 * @program: Coffee
 * @description:
 * @author: aftery
 * @create: 2020-03-31 15:50
 **/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Coffee {

    private Long id;

    private String name;

    private Money price;

    private Date createTime;

    private Date updateTime;

}
