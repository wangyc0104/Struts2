package wyc.action;

import com.opensymphony.xwork2.ActionContext;

/**
 * 模拟登录Action
 * @author Yicheng Wang
 */
public class LoginAction {
	
	private String name;
	private String pwd;

	// 处理方法
	public String execute() {
		System.out.println(name + ": " + pwd);
		if ("wyc".equals(name) && "123".equals(pwd)) {
			ActionContext.getContext().getSession().put("user", name);
			return "success";
		} else {
			return "login";
		}
	}

	public String logout() {
		System.out.println("退出");
		return "success";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

}
