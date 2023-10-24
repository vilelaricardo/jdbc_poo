package services;

import dao.postgres.UserDAOImpl;
import entities.User;

import javax.swing.*;
import java.util.List;

public class UserService {

	public void registerUser() {
		String name = JOptionPane.showInputDialog("Informe o nome do Usuário");
		int age  = Integer.parseInt(JOptionPane.showInputDialog("Informe o nome do Usuário"));
		User user = new User(name,age);
		new UserDAOImpl().addUser(user);
	}

	public void showAllUsers() {
		UserDAOImpl userDAO = new UserDAOImpl();
		List<User> userList = userDAO.getAllUsers();
		StringBuilder sb = new StringBuilder();

		for (User user : userList) {
			sb.append("Name: ")
				.append(user.getName())
				.append(" Age: ")
				.append(user.getAge())
				.append("\n");
		}
		JOptionPane.showMessageDialog(null, sb);
	}

}
