package top.aftery.mongo.repository.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import top.aftery.mongo.repository.demo.entity.Coffee;

import java.util.List;

/**
 * @classname: CoffeeRepository
 * @Auther: aftery
 * @Date: 2020-04-05 17:15
 * @Description:
 */
public interface CoffeeRepository extends MongoRepository<Coffee, String> {

    List<Coffee> findByName(String name);
}
