package wyc.action;

import wyc.entity.User;

import com.opensymphony.xwork2.Action;

/**
 * ��������ע������ݴ���
 * 
 * @author Yicheng Wang
 * 
 */
public class UserAction {
	private User user;

	// ע��
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
