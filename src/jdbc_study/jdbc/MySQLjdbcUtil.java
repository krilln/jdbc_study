package jdbc_study.jdbc;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class MySQLjdbcUtil {
	
	
	public static Connection getConnection() {
		Connection conn = null;
		try (InputStream is = ClassLoader.getSystemResourceAsStream("db.properties")){
			Properties properties = new Properties();
			properties.load(is);
			
			System.out.println(properties.getProperty("user"));
			System.out.println(properties.getProperty("password"));
			System.out.println(properties.getProperty("driver"));
			System.out.println(properties.getProperty("url"));
			
			conn =DriverManager.getConnection(properties.getProperty("url"), properties);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
}
