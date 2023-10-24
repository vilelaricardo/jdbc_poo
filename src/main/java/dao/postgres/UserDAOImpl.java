package dao.postgres;

import dao.UserDAO;
import entities.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAOImpl implements UserDAO {

	Connection connection;


	public UserDAOImpl()  {
		connection = PostgresConnectionDAO.getConnection();
	}

	public void addUser(User user) {
		String query = "INSERT INTO users (name, age) VALUES (?, ?)";
		PreparedStatement preparedStatement = null;

		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, user.getName());
			preparedStatement.setInt(2, user.getAge());
			preparedStatement.execute();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if (preparedStatement != null) {
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					throw new RuntimeException(e);
				}
			}
		}
	}

	@Override
	public List<User> getAllUsers() {
		String query = "SELECT name, age FROM users";
		List<User> users = new ArrayList<>();
		PreparedStatement preparedStatement = null;
		ResultSet result = null;

		try {
			preparedStatement = connection.prepareStatement(query);
			result = preparedStatement.executeQuery();
			while (result.next()) {
				users.add(new User(result.getString("name"), result.getInt("age")));
			}
			return users;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
