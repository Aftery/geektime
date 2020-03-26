package top.aftery.hellospring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 * @classname: HelloSpringApplication
 * @Auther: aftery
 * @Date: 2020-03-26 22:41
 * @Description:
 */

@SpringBootApplication
@RestController
public class HelloSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(HelloSpringApplication.class, args);
    }

    @GetMapping("/hello")
    public String hello(){
        return "hello spring";
    }
}
