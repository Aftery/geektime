package top.aftery.simple.jdbc.demo.dao;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import top.aftery.simple.jdbc.demo.entity.Foo;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @classname: BatchFooDoo
 * @Auther: aftery
 * @Date: 2020-03-28 17:28
 * @Description:
 */
@Slf4j
@Repository
@Transactional
public class BatchFooDoo {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private NamedParameterJdbcTemplate nameJdbc;

    public void batchInster(){
        int[] ints = jdbcTemplate.batchUpdate("insert into foo (bar) value (?)", new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement preparedStatement, int i) throws SQLException {
                preparedStatement.setString(1, "b-" + i);
            }

            @Override
            public int getBatchSize() {
                return 2;
            }
        });

        List<Foo> list=new ArrayList<>();
        list.add(Foo.builder().id(100L).bar("b-100").build());
        list.add(Foo.builder().id(101L).bar("b-101").build());
        nameJdbc.batchUpdate("insert into foo values(:id,:bar)", SqlParameterSourceUtils.createBatch(list));
    }








}
