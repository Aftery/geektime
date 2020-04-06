package top.aftery.declarative.transaction.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @classname: FooServiceImpl
 * @Auther: aftery
 * @Date: 2020-03-29 14:40
 * @Description:
 */
@Slf4j
@Service
public class FooServiceImpl implements FooService{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private FooService fooService;


    @Override
    @Transactional
    public void insertRecord() {
            jdbcTemplate.execute("insert into  foo (bar) value ('aaaa')");
    }

    @Override
    @Transactional(rollbackFor = RollbackException.class)
    public void insertThenRollback() throws RollbackException {
        jdbcTemplate.execute("INSERT INTO FOO (BAR) VALUES ('bbbb')");
        throw new RollbackException();
    }

    /**
     * Spring事物是通过aop代理实现的，目标本身并没有事物管理功能，所以事物直接调用目标方法，事物是不会生效的
     * @throws RollbackException
     */
    @Override
    public void invokeInsertThenRollback() throws RollbackException {
//        fooService.insertThenRollback();;
        insertThenRollback();
    }
}
