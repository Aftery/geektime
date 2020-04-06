package top.aftery.jpacomplex.demo.repository;

import top.aftery.jpacomplex.demo.entity.CoffeeOrder;

import java.util.List;

/**
 * @program: CoffeeOrderRepository
 * @description:
 * @author: aftery
 * @create: 2020-03-31 14:46
 **/
public interface CoffeeOrderRepository extends Baserepository<CoffeeOrder, Long> {

    List<CoffeeOrder> findByCustomerOrderById(String customer);

    List<CoffeeOrder> findByItems_Name(String name);

}
