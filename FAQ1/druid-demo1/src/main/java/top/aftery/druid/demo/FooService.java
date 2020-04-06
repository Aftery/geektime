package top.aftery.druid.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @classname: FooService
 * @Auther: aftery
 * @Date: 2020-03-29 16:35
 * @Description:
 */
@Repository
public class FooService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Transactional
    public void selectForUpdate() {
        jdbcTemplate.queryForObject("select id from foo where id = 191 for update", Long.class);
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
        }
    }
}
