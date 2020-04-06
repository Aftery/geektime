package top.aftery.redis.repository.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.joda.money.Money;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

import javax.persistence.Id;
import java.io.Serializable;

/**
 * @classname: CoffeeCache
 * @Auther: aftery
 * @Date: 2020-04-06 11:15
 * @Description:
 */
@RedisHash(value = "springbucks-coffee",timeToLive = 60)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CoffeeCache implements Serializable {

    @Id
    private Long id;

    @Indexed
    private String name;

    private Money price;

}
