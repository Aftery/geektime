package top.aftery.springbucks6.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import top.aftery.springbucks6.entity.CoffeeOrder;


/**
 * @classname: CoffeeOrderRepository
 * @Auther: aftery
 * @Date: 2020-04-05 17:38
 * @Description:
 */
@Repository
public interface CoffeeOrderRepository extends JpaRepository<CoffeeOrder,Long> {
}
