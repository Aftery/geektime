package top.aftery.spring.bucks.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import top.aftery.spring.bucks.entity.Coffee;

/**
 * @classname: CoffeeRepository
 * @Auther: aftery
 * @Date: 2020-04-05 14:34
 * @Description:
 */
public interface CoffeeRepository extends JpaRepository<Coffee,Long> {

}
