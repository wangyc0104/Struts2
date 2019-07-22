package wyc.action;

import java.util.List;

import wyc.entity.User;
import wyc.service.UserService;

import com.opensymphony.xwork2.Action;

/**
 * 用户相关Action
 * @author Yicheng Wang
 *
 */
public class UserAction {
	
	private User user;
	private List<User> list;
	private UserService userService = new UserService();

	// 用户登录
	public String login() {
		User temp = userService.login(user);
		if (temp != null) {
			// list = userService.getList();
			return Action.SUCCESS;
		}
		return Action.LOGIN;
	}

	// 获取用户列表
	public String list() {
		list = userService.getList();
		return Action.SUCCESS;
	}

	// 跳转到用户更新页面update.jsp
	public String toUpdate() {
		user = userService.getById(user.getId());
		return Action.SUCCESS;
	}

	// 进行用户更新，如果更新成功则跳转到成功页面
	public String update() {
		int result = userService.update(user);
		if (result > 0) {
			return Action.SUCCESS;
		}
		return Action.ERROR;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<User> getList() {
		return list;
	}

	public void setList(List<User> list) {
		this.list = list;
	}

}
