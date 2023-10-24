package dao;

import entities.User;

import java.util.List;

public interface UserDAO {

	public void addUser(User user);
	public List<User> getAllUsers();
}
