package fa.training.common;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtils {

	public static Connection getConnection() {
		try {

			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

			String connectionUrl = "jdbc:sqlserver://localhost:1433;"
					+ "user = sa;password=12345678;databaseName=SMS;encrypt=false";

			Connection conn = DriverManager.getConnection(connectionUrl);

			return conn;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}
}
