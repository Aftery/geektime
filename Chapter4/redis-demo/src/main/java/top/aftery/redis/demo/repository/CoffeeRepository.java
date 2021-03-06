package top.aftery.redis.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import top.aftery.redis.demo.entity.Coffee;

/**
 * @classname: CoffeeRepository
 * @Auther: aftery
 * @Date: 2020-04-05 17:38
 * @Description:
 */
@Repository
public interface CoffeeRepository extends JpaRepository<Coffee,Long> {
}
