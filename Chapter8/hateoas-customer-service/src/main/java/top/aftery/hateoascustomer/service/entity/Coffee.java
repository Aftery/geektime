package top.aftery.hateoascustomer.service.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.joda.money.Money;

import java.io.Serializable;
import java.util.Date;

/**
 * @program: Coffee
 * @description:
 * @author: aftery
 * @create: 2020-03-31 14:31
 **/
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Coffee implements Serializable {
    private String name;
    private Money price;
    private Date createTime;
    private Date updateTime;
}
