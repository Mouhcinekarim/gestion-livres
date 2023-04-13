package database;

import domains.Role;
import domains.User;

 public final class SECURIRY {
	private static String USER_NAME="admin@gmail.com";
	private static String PASSWORD="admin";
    private static User user;
	
	public static User getAdmin(){
		if(user==null) {user=new User();
		user.setLogin(USER_NAME);
		user.setPassword(PASSWORD);
		user.setRole(Role.ADMIN);
		return user;} 
		return null;
	}
}
