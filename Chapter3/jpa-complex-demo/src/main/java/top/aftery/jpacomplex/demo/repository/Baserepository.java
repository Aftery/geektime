package top.aftery.jpacomplex.demo.repository;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/**
 * @program: Baserepository
 * @description:
 * @author: aftery
 * @create: 2020-03-31 14:43
 **/
@NoRepositoryBean
public interface Baserepository<T,Long> extends PagingAndSortingRepository<T,Long> {

    List<T> findTop3ByOrderByUpdateTimeDescIdAsc();

}
