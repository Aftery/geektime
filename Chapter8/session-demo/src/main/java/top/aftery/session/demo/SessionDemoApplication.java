package top.aftery.session.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@SpringBootApplication
@EnableRedisHttpSession
public class SessionDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SessionDemoApplication.class, args);
    }

    @RequestMapping("/hello")
    public String printSession(HttpSession session, String name) {
        String storedName = (String) session.getAttribute("name");
        if (storedName == null) {
            session.setAttribute("name", name);
            storedName = name;
        }
        return storedName;
    }
}
