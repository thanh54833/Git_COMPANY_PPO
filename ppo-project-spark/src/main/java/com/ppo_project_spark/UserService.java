package com.ppo_project_spark;
import java.util.*;

public class UserService {

	private Map<String, User> users = new HashMap<String, User>();

	public List<User> getAllUsers() {
		return new ArrayList<User>(users.values());
	}

	public User getUser(String id) {
		return users.get(id);
	}

	public User createUser(String name, String email,int age) {
		failIfInvalid(name, email);
		User user = new User(name, email,age);
		users.put(user.getId(), user);
		return user;
	}
	public User updateUser(String id, String name, String email,int age) {
		User user = users.get(id);
		if (user == null) {
			throw new IllegalArgumentException("No user with id '" + id + "' found");
		}
		failIfInvalid(name, email);
		user.setName(name);
		user.setEmail(email);
		user.setAge(age);
		
		return user;
	}

	private void failIfInvalid(String name, String email) {
		if (name == null || name.isEmpty()) {
			throw new IllegalArgumentException("Parameter 'name' cannot be empty");
		}
		if (email == null || email.isEmpty()) {
			throw new IllegalArgumentException("Parameter 'email' cannot be empty");
		}
	}
}