package top.aftery.propertysourcedemo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.env.EnvironmentPostProcessor;
import org.springframework.boot.env.PropertiesPropertySourceLoader;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 * @classname: YapfEnvironmentPostProcessor
 * @Auther: aftery
 * @Date: 2020/4/19 17:14
 * @Description:
 */
@Slf4j
public class YapfEnvironmentPostProcessor implements EnvironmentPostProcessor {
    private PropertiesPropertySourceLoader loader = new PropertiesPropertySourceLoader();

    @Override
    public void postProcessEnvironment(ConfigurableEnvironment environment, SpringApplication application) {
        MutablePropertySources propertySources = environment.getPropertySources();
        Resource resource = new ClassPathResource("yapf.properties");
        try {
            PropertySource ps = loader.load("YetAnotherPropertiesFile", resource)
                    .get(0);
            propertySources.addFirst(ps);
        } catch (Exception e) {
            log.error("Exception!", e);
        }
    }
}
