package wyc.test;

import wyc.dao.UserDao;

public class Test {
	public static void main(String[] args) {
		UserDao ud = new UserDao();
		System.out.println(ud.selectAllUsers());
	}
}
