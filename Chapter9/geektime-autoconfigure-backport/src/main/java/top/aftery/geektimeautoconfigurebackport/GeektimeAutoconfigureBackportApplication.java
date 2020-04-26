package top.aftery.geektimeautoconfigurebackport;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.util.ClassUtils;
import top.aftery.greeting.GreetingApplication;

@Slf4j
public class GeektimeAutoconfigureBackportApplication implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        boolean hasClass = ClassUtils.isPresent("top.aftery.greeting.GreetingApplication",
                GeektimeAutoconfigureBackportApplication.class.getClassLoader());
        if (!hasClass) {
            log.info("GreetingApplicationRunner is NOT present in CLASSPATH.");
            return;
        }

        if (beanFactory.containsBeanDefinition("GreetingApplication")) {
            log.info("We already have a greetingApplicationRunner bean registered.");
            return;
        }

        register(beanFactory);
    }

    private void register(ConfigurableListableBeanFactory beanFactory) {
        if (beanFactory instanceof BeanDefinitionRegistry) {
            GenericBeanDefinition beanDefinition = new GenericBeanDefinition();
            beanDefinition.setBeanClass(GreetingApplication.class);

            ((BeanDefinitionRegistry) beanFactory)
                    .registerBeanDefinition("GreetingApplication",
                            beanDefinition);
        } else {
            beanFactory.registerSingleton("GreetingApplication",
                    new GreetingApplication());
        }
    }
}
