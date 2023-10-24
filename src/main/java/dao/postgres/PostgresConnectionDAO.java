package dao.postgres;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PostgresConnectionDAO {

	private static final String jdbcUrl = "jdbc:postgresql://localhost:5432/poo_postgres";
	private static final String username = "vilela";
	private static final String password = "ads2023";
	public static Connection getConnection() {
		try {
			return DriverManager.getConnection(jdbcUrl, username, password);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
