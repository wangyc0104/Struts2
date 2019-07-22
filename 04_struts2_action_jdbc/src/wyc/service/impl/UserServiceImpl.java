package wyc.service.impl;

import java.util.List;

import wyc.dao.UserDao;
import wyc.pojo.User;
import wyc.service.UserService;

public class UserServiceImpl implements UserService {

	UserDao ud = new UserDao();

	@Override
	public List<User> show() {
		return ud.selectAllUsers();
	}

}
