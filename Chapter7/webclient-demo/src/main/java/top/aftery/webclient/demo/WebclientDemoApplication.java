package top.aftery.webclient.demo;

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
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;
import top.aftery.webclient.demo.model.Coffee;

import java.util.concurrent.CountDownLatch;

@Slf4j
@SpringBootApplication
public class WebclientDemoApplication implements ApplicationRunner {

    @Autowired
    private WebClient webClient;

    public static void main(String[] args) {
        //SpringApplication.run(WebclientDemoApplication.class, args);
        new SpringApplicationBuilder(WebclientDemoApplication.class)
                .web(WebApplicationType.NONE)
                .bannerMode(Banner.Mode.OFF)
                .run(args);
    }

    @Bean
    public WebClient webClient(WebClient.Builder builder) {
        return builder.baseUrl("http://localhost:8080").build();
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

        CountDownLatch latch = new CountDownLatch(2);

        webClient.get()
                .uri("/coffee/{id}", 1)
                .retrieve()
                .bodyToMono(Coffee.class)
                .doOnError(t -> log.error("ERROR:", t))
                .doFinally(s -> latch.countDown())
                .subscribeOn(Schedulers.single())
                .subscribe(c -> log.info("coffee 1:{}", c));
        Mono<Coffee> americano = Mono.just(
                Coffee.builder()
                        .name("americano")
                        .price(Money.of(CurrencyUnit.of("CNY"), 25.00))
                        .build()
        );
        log.error("===================================================");
        webClient.post()
                .uri("/coffee/")
                .body(americano, Coffee.class)
                .retrieve()
                .bodyToMono(Coffee.class)
                .doFinally(s -> latch.countDown())
                .subscribeOn(Schedulers.single())
                .subscribe(c -> log.info("Coffee Created: {}", c));

        latch.await();
        log.error("===================================================");
        webClient.get()
                .uri("/coffee/")
                .retrieve()
                .bodyToFlux(Coffee.class)
                .toStream()
                .forEach(c -> log.info("Coffee in List: {}", c));
    }
}
