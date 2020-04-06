package top.aftery.mybatis.pagehelper.demo.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;
import top.aftery.mybatis.pagehelper.demo.entity.Coffee;

import java.util.List;

/**
 * @classname: CoffeeMapper
 * @Auther: aftery
 * @Date: 2020-04-05 11:31
 * @Description:
 */
@Mapper
@Repository
public interface CoffeeMapper {

    @Select("select * from t_coffee order by id")
    List<Coffee> findAllWithRowBounds(RowBounds rowBounds);

    @Select("select * from t_coffee order by id")
    List<Coffee> findAllWithParam(@Param("pageNum") int pageNum,
                                  @Param("pageSize") int pageSize);

}
