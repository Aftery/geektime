package top.aftery.errcode.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ErrcodeDemoApplicationTests {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Test()
	public void contextLoads() {
		jdbcTemplate.execute("insert  into  foo values (182,'a')");
		jdbcTemplate.execute("insert  into  foo values (182,'a')");

	}

}
