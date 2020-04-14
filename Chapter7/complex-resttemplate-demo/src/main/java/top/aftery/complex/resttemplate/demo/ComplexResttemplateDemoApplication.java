package top.aftery.complex.resttemplate.demo;

import lombok.extern.slf4j.Slf4j;
import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.Banner;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import top.aftery.complex.resttemplate.demo.model.Coffee;

import java.net.URI;
import java.util.List;

@Slf4j
@SpringBootApplication
public class ComplexResttemplateDemoApplication implements ApplicationRunner {

    @Autowired
    private RestTemplate restTemplate;

    public static void main(String[] args) {
        //SpringApplication.run(ComplexResttemplateDemoApplication.class, args);
        new SpringApplicationBuilder()
                .sources(ComplexResttemplateDemoApplication.class)
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

        URI uri = UriComponentsBuilder.fromUriString("http://localhost:8080/coffee/?name={name}")
                .build("mocha");

        RequestEntity<Void> request = RequestEntity.get(uri).accept(MediaType.APPLICATION_XML)
                .build();
        ResponseEntity<String> resp = restTemplate.exchange(request, String.class);
        log.info("Response Status: {}, Response Headers: {}", resp.getStatusCode(), resp.getHeaders().toString());
        log.info("Coffee: {}", resp.getBody());

        log.error("===========================================================");

        String coffeeUrl = "http://localhost:8080/coffee/";
        Coffee build = Coffee.builder()
                .name("Americano")
                .price(Money.of(CurrencyUnit.of("CNY"), 25.00))
                .build();
        Coffee response = restTemplate.postForObject(coffeeUrl, build, Coffee.class);
        log.info("New Coffee: {}", response);
        log.error("===========================================================");

        ParameterizedTypeReference<List<Coffee>> ptr = new ParameterizedTypeReference<List<Coffee>>() {
        };
        ResponseEntity<List<Coffee>> list = restTemplate.exchange(coffeeUrl, HttpMethod.GET, null, ptr);
        list.getBody().forEach(c -> log.info("coffee:{}", c));

    }
}
