package test;

import org.junit.jupiter.api.Test;

import login.service.UserService;

public class InsertUser {
	
	@Test
	public void add() {
		String userName = "admin";
		String password = "1234";
		String email = "admin@gmail.com";
		
		UserService userService = UserService.getInstance();
		boolean addResult = userService.insertUser(userName, password, email);
		System.out.printf("測試結果 addResult: %s%n", addResult);
		
	}
	
}
