package wyc.action;

import wyc.entity.User;

import com.opensymphony.xwork2.Action;

/**
 * 对象属性注入的数据传递
 * 
 * @author Yicheng Wang
 * 
 */
public class UserAction {
	private User user;

	// 注册
	public String register() {
		System.out.println(user);
		return Action.SUCCESS;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
