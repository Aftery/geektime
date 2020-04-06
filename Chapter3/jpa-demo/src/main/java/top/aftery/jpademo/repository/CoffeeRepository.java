package top.aftery.jpademo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import top.aftery.jpademo.eneity.Coffee;

/**
 * @program: CoffeeRepository
 * @description:
 * @author: aftery
 * @create: 2020-03-31 10:55
 **/
public interface CoffeeRepository extends JpaRepository<Coffee,Long> {
}
