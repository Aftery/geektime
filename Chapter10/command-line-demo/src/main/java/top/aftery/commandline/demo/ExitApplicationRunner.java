package top.aftery.commandline.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @classname: ExitApplicationRunner
 * @Auther: aftery
 * @Date: 2020/4/25 18:13
 * @Description:
 */
@Slf4j
@Order(3)
@Component
public class ExitApplicationRunner implements ApplicationRunner, ApplicationContextAware {


    private ApplicationContext applicationContext;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        int code = SpringApplication.exit(applicationContext);
        log.info("Exit with {}.", code);
        System.exit(code);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
