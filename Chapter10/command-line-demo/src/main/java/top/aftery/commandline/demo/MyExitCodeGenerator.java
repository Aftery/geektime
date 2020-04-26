package top.aftery.commandline.demo;

import org.springframework.boot.ExitCodeGenerator;
import org.springframework.stereotype.Component;

/**
 * @classname: MyExitCodeGenerator
 * @Auther: aftery
 * @Date: 2020/4/25 18:12
 * @Description:
 */
@Component
public class MyExitCodeGenerator implements ExitCodeGenerator {
    @Override
    public int getExitCode() {
        return 1;
    }
}
