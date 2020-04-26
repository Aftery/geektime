package top.aftery.geektime.springboot.autoconfigure;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import top.aftery.greeting.GreetingApplication;

@Configuration
@ConditionalOnClass(GreetingApplication.class)
public class GeektimeSpringBootAutoconfigureApplication {

    @Bean
    @ConditionalOnMissingBean(GreetingApplication.class)
    @ConditionalOnProperty(name = "greeting.enabled", havingValue = "true", matchIfMissing = true)
    public GreetingApplication greetingApplicationRunner() {
        return new GreetingApplication();
    }

}
