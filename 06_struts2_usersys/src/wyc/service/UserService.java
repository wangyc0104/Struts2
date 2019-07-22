package wyc.service;

import java.util.List;

import wyc.dao.UserDao;
import wyc.entity.User;

/**
 * 用户Service
 * @author Yicheng Wang
 *
 */
public class UserService {
	private UserDao userDao = new UserDao();
	public User login(User u){
		return userDao.login(u);
	}
	public List<User> getList(){
		return userDao.getList();
	}
	public int update(User u){
		return userDao.update(u);
	}
	public User getById(int id){
		return userDao.getById(id);
	}
}
