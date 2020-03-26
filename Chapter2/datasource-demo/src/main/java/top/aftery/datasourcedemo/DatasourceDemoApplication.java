package top.aftery.datasourcedemo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @classname: DatasourceDemoApplication
 * @Auther: aftery
 * @Date: 2020-03-26 22:41
 * @Description: CommandLineRunner:实现此接口可以在程序启动之后运行run方法
 */
@Slf4j
@SpringBootApplication
public class DatasourceDemoApplication implements CommandLineRunner {

	@Autowired
	private DataSource dataSource;

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public static void main(String[] args) {
		SpringApplication.run(DatasourceDemoApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		showConnection();
		showData();
	}

	private void showData() {
		jdbcTemplate.queryForList("select  * from  foo").forEach(row->log.info(row.toString()));
	}

	private void showConnection() throws SQLException {
		log.info(dataSource.toString());
		Connection conn = dataSource.getConnection();
		log.info(String.valueOf(conn));
		conn.close();

	}
}
