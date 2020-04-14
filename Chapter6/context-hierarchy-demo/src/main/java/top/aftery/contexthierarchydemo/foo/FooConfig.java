package top.aftery.contexthierarchydemo.foo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import top.aftery.contexthierarchydemo.context.TestBean;

/**
 * @classname: FooConfig
 * @Auther: aftery
 * @Date: 2020-04-11 17:58
 * @Description:
 */
@Configuration
@EnableAspectJAutoProxy
public class FooConfig {

    @Bean
    public TestBean testBeanX() {
        return new TestBean("foo");
    }

    @Bean
    public TestBean testBeanY() {
        return new TestBean("foo");
    }

    @Bean
    public FooAspect fooAspect(){
        return new FooAspect();
    }

}
