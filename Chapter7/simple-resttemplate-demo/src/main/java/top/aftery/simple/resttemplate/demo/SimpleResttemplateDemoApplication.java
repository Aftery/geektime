package top.aftery.simple.resttemplate.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.Banner;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import top.aftery.simple.resttemplate.demo.model.Coffee;

import java.math.BigDecimal;
import java.net.URI;

@Slf4j
@SpringBootApplication
public class SimpleResttemplateDemoApplication implements ApplicationRunner {

    @Autowired
    private RestTemplate restTemplate;


    public static void main(String[] args) {
//        SpringApplication.run(SimpleResttemplateDemoApplication.class, args);
        new SpringApplicationBuilder()
                .sources(SimpleResttemplateDemoApplication.class)
                .bannerMode(Banner.Mode.OFF)
                .web(WebApplicationType.NONE)
                .run(args);
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder restTemplateBuilder) {
        return restTemplateBuilder.build();
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {


        URI uri = UriComponentsBuilder
                .fromUriString("http://localhost:8080/coffee/{id}")
                .build(1);
        log.info("msg:{}", uri);
        ResponseEntity<Coffee> coffee = restTemplate.getForEntity(uri, Coffee.class);
        log.info("response status:{},response headers:{}", coffee.getStatusCode(), coffee.getHeaders().toString());
        log.info("coffee:{}", coffee.getBody());
        log.error("============================================");

        String coffeeUrl = "http://localhost:8080/coffee/";
        Coffee request = Coffee.builder()
                .name("Americano")
                .price(BigDecimal.valueOf(25.00))
                .build();
        String forObject = restTemplate.getForObject(coffeeUrl, String.class);
        log.info("string:{}", forObject);

    }
}
