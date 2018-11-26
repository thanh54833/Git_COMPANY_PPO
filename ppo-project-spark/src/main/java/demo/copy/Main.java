package demo.copy;

public class Main {
	public static void main(String[] args) {

		System.out.println("start project ...");
		
		new UserController(new UserService());
	}
}
