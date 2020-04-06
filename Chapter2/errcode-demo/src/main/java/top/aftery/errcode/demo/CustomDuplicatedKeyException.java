package top.aftery.errcode.demo;

import org.springframework.dao.DuplicateKeyException;

/**
 * @classname: CustomDuplicatedKeyException
 * @Auther: aftery
 * @Date: 2020-03-29 15:31
 * @Description:
 */
public class CustomDuplicatedKeyException extends DuplicateKeyException {


    public CustomDuplicatedKeyException(String msg) {
        super(msg);
    }

    public CustomDuplicatedKeyException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
