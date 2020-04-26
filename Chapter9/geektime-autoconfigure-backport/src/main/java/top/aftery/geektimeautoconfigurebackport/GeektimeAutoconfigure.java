package top.aftery.geektimeautoconfigurebackport;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @classname: GeektimeAutoconfigure
 * @Auther: aftery
 * @Date: 2020/4/19 16:50
 * @Description:
 */
@Configuration
public class GeektimeAutoconfigure {
    @Bean
    public static GeektimeAutoconfigureBackportApplication geektimeAutoconfigureBackportApplication() {
        return new GeektimeAutoconfigureBackportApplication();
    }
}
