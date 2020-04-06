package top.aftery.redis.repository.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import top.aftery.redis.repository.demo.entity.CoffeeCache;

import java.util.Optional;

/**
 * @classname: CoffeeCacheRepository
 * @Auther: aftery
 * @Date: 2020-04-06 11:24
 * @Description:
 */
@Repository
public interface CoffeeCacheRepository extends CrudRepository<CoffeeCache, Long> {

    Optional<CoffeeCache> findOneByName(String name);
}
