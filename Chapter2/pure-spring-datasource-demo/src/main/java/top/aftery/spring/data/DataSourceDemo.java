package top.aftery.spring.data;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.commons.dbcp2.BasicDataSourceFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Properties;

/**
 * @program: DataSourceDemo
 * @description:  Spring
 * @author: aftery
 * @create: 2020-03-27 13:46
 **/
@Configuration
@EnableTransactionManagement
public class DataSourceDemo {

    @Autowired
    private DataSource dataSource;

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("Application.xml");
        showBeans(applicationContext);
        dataSourceDemo(applicationContext);
    }


    @Bean(destroyMethod = "close")
    public DataSource dataSource() throws Exception {
        Properties properties = new Properties();
        properties.setProperty("driverClassName", "com.mysql.jdbc.Driver");
        properties.setProperty("url", "jdbc:mysql://localhost:3306/test");
        properties.setProperty("username", "root");
        properties.setProperty("password", "12345678");
        BasicDataSource dataSource = BasicDataSourceFactory.createDataSource(properties);
        System.out.println(dataSource);
        return dataSource;

    }

    @Bean
    public PlatformTransactionManager transactionManager() {
        return new DataSourceTransactionManager(dataSource);
    }


    public static void dataSourceDemo(ApplicationContext applicationContext) {
        DataSourceDemo demo = applicationContext.getBean("dataSourceDemo", DataSourceDemo.class);
        demo.showDatasource();
    }

    public void showDatasource() {
        try {
            System.out.println(dataSource.toString());
            Connection connection = dataSource.getConnection();
            System.out.println(connection.toString());
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    public static void showBeans(ApplicationContext applicationContext) {
        System.out.println(Arrays.toString(applicationContext.getBeanDefinitionNames()));
    }


}
