package wyc.action;

import wyc.entity.User;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ModelDriven;

/**
 * 模型驱动的数据传递
 * 
 * @author Yicheng Wang
 * 
 */
public class ModelDrivenAction implements ModelDriven<User> {
	private User user = new User();

	// 注册
	public String register() {
		System.out.println(user);
		return Action.SUCCESS;
	}

	public User getModel() {
		return user;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
