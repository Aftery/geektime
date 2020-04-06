package top.aftery.declarative.transaction.demo;

/**
 * @classname: FooService
 * @Auther: aftery
 * @Date: 2020-03-29 14:37
 * @Description:
 */
public interface FooService {

    void insertRecord();

    void insertThenRollback() throws RollbackException;

    void invokeInsertThenRollback() throws RollbackException;

}
