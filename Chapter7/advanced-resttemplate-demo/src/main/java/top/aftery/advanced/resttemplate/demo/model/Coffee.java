package top.aftery.advanced.resttemplate.demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.joda.money.Money;

import java.io.Serializable;
import java.util.Date;

/**
 * @classname: Coffee
 * @Auther: aftery
 * @Date: 2020/4/16 20:35
 * @Description:
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Coffee implements Serializable {

    private Long id;
    private String name;
    private Money price;
    private Date createTime;
    private Date updateTime;
}
