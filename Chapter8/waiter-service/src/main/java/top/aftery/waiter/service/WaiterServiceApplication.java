package top.aftery.waiter.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;

import java.util.TimeZone;

@SpringBootApplication
@EnableR2dbcRepositories
public class WaiterServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(WaiterServiceApplication.class, args);
    }



//    @Bean
//    public R2dbcCustomConversions r2dbcCustomConversions() {
//        Dialect dialect = getDialect(connectionFactory());
//        CustomConversions.StoreConversions storeConversions =
//                CustomConversions.StoreConversions.of(dialect.getSimpleTypeHolder());
//        return new R2dbcCustomConversions(storeConversions,
//                Arrays.asList(new MoneyReadConverter(), new MoneyWriteConverter()));
//    }


    @Bean
    public Jackson2ObjectMapperBuilderCustomizer jacksonBuilderCustomizer() {
        return builder -> builder.indentOutput(true)
                .timeZone(TimeZone.getTimeZone("Asia/Shanghai"));
    }

}
