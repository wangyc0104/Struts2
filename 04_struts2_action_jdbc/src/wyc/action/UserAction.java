package wyc.action;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;

import wyc.pojo.User;
import wyc.service.UserService;
import wyc.service.impl.UserServiceImpl;

public class UserAction {

	List<User> userList;
	UserService userServiceImpl = new UserServiceImpl();

	public String execute() {
		userList = userServiceImpl.show();
		ActionContext.getContext().getSession().put("userList", userList);
		return "success";
	}
}
