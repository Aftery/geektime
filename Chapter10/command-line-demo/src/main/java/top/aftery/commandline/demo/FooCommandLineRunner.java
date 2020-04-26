package top.aftery.commandline.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @classname: FooCommandLineRunner
 * @Auther: aftery
 * @Date: 2020/4/25 18:12
 * @Description:
 */
@Slf4j
@Order(1)
@Component
public class FooCommandLineRunner implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        log.info("Foo");
    }
}
