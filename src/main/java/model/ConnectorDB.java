package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectorDB {

	public static Connection getConnection()
	{
		try {
			return DriverManager.getConnection("jdbc:mysql://10.5.2.2:3306/storage?useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "javauser", "321321");
		} catch (SQLException e) {
			//e.printStackTrace();
			return null;
		}
	}
}
