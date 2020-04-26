package top.aftery.commandline.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @classname: BarApplicationRunner
 * @Auther: aftery
 * @Date: 2020/4/25 18:11
 * @Description:
 */
@Component
@Slf4j
@Order(2)
public class BarApplicationRunner implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) throws Exception {
        log.info("Bar");
    }
}
