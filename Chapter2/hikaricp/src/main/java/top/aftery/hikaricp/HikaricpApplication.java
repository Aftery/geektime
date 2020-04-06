package top.aftery.hikaricp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;


import javax.sql.DataSource;


@SpringBootApplication
public class HikaricpApplication implements CommandLineRunner {


    @Qualifier("dataSource")
    @Autowired
    private  DataSource dataSource;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public static void main(String[] args) {
        SpringApplication.run(HikaricpApplication.class, args);

    }



    @Override
    public void run(String... args) throws Exception {
        System.out.println(dataSource);
        System.out.println(dataSource.getConnection().toString());
        jdbcTemplate.queryForList("select * from foo").forEach(row-> System.out.println(row.toString()));
    }
}
