package top.aftery.mybatis.pagehelper.demo;

import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import top.aftery.mybatis.pagehelper.demo.entity.Coffee;
import top.aftery.mybatis.pagehelper.demo.mapper.CoffeeMapper;

import java.util.List;

@Slf4j
@SpringBootApplication
public class MybatisPagehelperDemoApplication implements CommandLineRunner {

    @Autowired
    private CoffeeMapper mapper;

    public static void main(String[] args) {
        SpringApplication.run(MybatisPagehelperDemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        mapper.findAllWithRowBounds(new RowBounds(1, 3))
                .forEach(row -> log.info("page1 coffee{}", row));
        mapper.findAllWithRowBounds(new RowBounds(2, 3))
                .forEach(row -> log.info("page2 coffee{}", row));

        log.info("==============================================");

        mapper.findAllWithRowBounds(new RowBounds(1, 0))
                .forEach(row -> log.info("page(1) coffee:{}", row));

        log.info("==============================================");

        mapper.findAllWithParam(1, 3)
                .forEach(row -> log.info("page{2} coffee:{}", row));
        List<Coffee> allWithParam = mapper.findAllWithParam(2, 3);
        PageInfo<Coffee> pageInfo = new PageInfo<>(allWithParam);
        log.info("pageInfo:{}", pageInfo);


    }
}
