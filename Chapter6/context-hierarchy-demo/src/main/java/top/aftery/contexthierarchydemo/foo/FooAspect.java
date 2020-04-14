package top.aftery.contexthierarchydemo.foo;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;

/**
 * @classname: FooAspect
 * @Auther: aftery
 * @Date: 2020-04-11 17:57
 * @Description:
 */
@Aspect
@Slf4j
public class FooAspect {
    @AfterReturning("bean(testBean*)")
    public void printAfter(){
        log.info("after hello()");
    }
}
