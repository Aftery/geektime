package top.aftery.mybatis.generator;

import lombok.extern.slf4j.Slf4j;
import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import top.aftery.mybatis.generator.mapper.CoffeeMapper;
import top.aftery.mybatis.generator.model.Coffee;
import top.aftery.mybatis.generator.model.CoffeeExample;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Slf4j
@SpringBootApplication
@MapperScan(value = "top.aftery.mybatis.generator.mapper")
public class MybatisGeneratorDemoApplication implements CommandLineRunner {

    @Autowired
    private CoffeeMapper coffeeMapper;

    public static void main(String[] args) {
        SpringApplication.run(MybatisGeneratorDemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        //生成的时候，注意generatorConfig.xml中targetProject，指定的位置
//        generateArtifacts();
        playWithArtifacts();
    }

    private void generateArtifacts() throws Exception {
        List<String> warnings = new ArrayList<>();
        ConfigurationParser cp = new ConfigurationParser(warnings);
        Configuration config = cp.parseConfiguration(
                this.getClass().getResourceAsStream("/generatorConfig.xml"));
        DefaultShellCallback callback = new DefaultShellCallback(true);
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
        myBatisGenerator.generate(null);


    }

    private void playWithArtifacts() {
        Coffee espresso = new Coffee()
                .withName("espresso")
                .withPrice(Money.of(CurrencyUnit.of("CNY"), 20.0))
                .withCreateTime(new Date())
                .withUpdateTime(new Date());
        coffeeMapper.insert(espresso);
        log.info("espresso:{}", espresso);

        Coffee latte = new Coffee()
                .withName("latte")
                .withPrice(Money.of(CurrencyUnit.of("CNY"), 30.0))
                .withCreateTime(new Date())
                .withUpdateTime(new Date());
        coffeeMapper.insert(latte);
        log.info("latte:{}", latte);

        Coffee coffee = coffeeMapper.selectByPrimaryKey(1L);
        log.info("byKey coffee:{}", coffee);

        CoffeeExample coffeeExample = new CoffeeExample();
        coffeeExample.createCriteria().andNameEqualTo("latte");

        List<Coffee> coffees = coffeeMapper.selectByExample(coffeeExample);
        coffees.forEach(row->log.info("coffees:{}",row));

    }
}
