package top.aftery.metrics.demo.support;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;
import top.aftery.metrics.demo.service.CoffeeService;

/**
 * @classname: CoffeeIndicator
 * @Auther: aftery
 * @Date: 2020/4/25 10:21
 * @Description:
 */
@Component
public class CoffeeIndicator implements HealthIndicator {

    @Autowired
    private CoffeeService coffeeService;

    @Override
    public Health health() {
        long count = coffeeService.getCoffeeCount();
        Health health;
        if (count > 0) {
            health = Health.up()
                    .withDetail("count", count)
                    .withDetail("message", "We have enough coffee.")
                    .build();
        } else {
            health = Health.down()
                    .withDetail("count", 0)
                    .withDetail("message", "We are out of coffee.")
                    .build();
        }
        return health;
    }
}
