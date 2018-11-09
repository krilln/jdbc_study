package jdbc_study.jdbc;

import java.sql.Connection;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;


public class MySQLjdbcUtilTest {
	static final Logger LOG = LogManager.getLogger();
	@Test
	public void test() {
		try {
			Connection conn = MySQLjdbcUtil.getConnection();
			LOG.trace(String.format("Connected to DataVase $s successfully",conn.getCatalog()));
			Assert.assertNotNull(conn);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}

}
