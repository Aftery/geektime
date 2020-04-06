package top.aftery.simple.jdbc.demo.dao;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import top.aftery.simple.jdbc.demo.entity.Foo;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @classname: FooDao
 * @Auther: aftery
 * @Date: 2020-03-28 17:27
 * @Description:
 */
@Slf4j
@Repository
public class FooDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private SimpleJdbcInsert simpleJdbcInsert;


    public void  insertData(){
        Arrays.asList("a","b").forEach(bar->{
            jdbcTemplate.update("insert  into  foo (bar) value (?)",bar);
        });

        HashMap<String,String> row=new HashMap<>();
        row.put("bar","d");
        Number key = simpleJdbcInsert.executeAndReturnKey(row);
        log.info("id of d:{}",key);
    }

    public void listData(){
        log.info("count:{}",jdbcTemplate.queryForObject("select count(*) from foo",Long.class));

        log.info("=================================================================================");

        List<String> list = jdbcTemplate.queryForList("select bar from foo", String.class);
        list.forEach(s -> log.info("Bar: {}", s));

        log.info("=================================================================================");

//        List<Foo> query = jdbcTemplate.query("select * from foo", new RowMapper<Foo>() {
//            @Override
//            public Foo mapRow(ResultSet resultSet, int i) throws SQLException {
//                return Foo.builder().id(resultSet.getLong(1)).bar(resultSet.getString(2))
//                        .build();
//            }
//        });
        jdbcTemplate.query("select * from foo",(a,b)->Foo.builder().id(a.getLong(1)).bar(a.getString(2))
                .build()).forEach(row->log.info(row.toString()));


    }
}
