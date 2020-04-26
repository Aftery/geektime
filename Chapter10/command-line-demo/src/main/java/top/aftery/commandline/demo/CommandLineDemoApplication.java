package top.aftery.commandline.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CommandLineDemoApplication {

    public static void main(String[] args) {
        // 根据 application.properties 里的配置来决定 WebApplicationType
        SpringApplication.run(CommandLineDemoApplication.class, args);
//        new SpringApplicationBuilder(CommandLineDemoApplication.class)
//                .web(WebApplicationType.NONE)
//                .run(args);

    }

}
