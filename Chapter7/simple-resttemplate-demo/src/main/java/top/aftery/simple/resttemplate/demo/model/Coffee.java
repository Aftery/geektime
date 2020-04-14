package top.aftery.simple.resttemplate.demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @classname: Coffee
 * @Auther: aftery
 * @Date: 2020/4/14 20:54
 * @Description:
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Coffee implements Serializable {

    private Long id;
    private String name;
    private BigDecimal price;
    private Date createTime;
    private Date updateTime;

}
