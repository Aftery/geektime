package top.aftery.indicator.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.util.Date;

/**
 * @program: BaseEntity
 * @description:
 * @author: aftery
 * @create: 2020-03-31 14:27
 * @MappedSuperclass 通过这个注解，我们可以将该实体类当成基类实体，它不会映射到数据库表，但继承它的子类实体在映射时会自动扫描该基类实体的映射属性
 **/

@MappedSuperclass
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BaseEntity implements Serializable {


    @Id
    @GeneratedValue
    private Long id;

    @Column(updatable = false)
    @CreationTimestamp
    private Date createTime;

    @UpdateTimestamp
    private Date updateTime;


}
