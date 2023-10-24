import services.UserService;

public class Main {

	public static void main(String[] args) {
		UserService form = new UserService();
		form.registerUser();
		form.showAllUsers();
	}

}
