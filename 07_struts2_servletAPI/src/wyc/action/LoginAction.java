package wyc.action;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;

/**
 * ActionContext获取作用域的方法
 * 
 * @author Yicheng Wang
 * 
 */
public class LoginAction {
	private String name;
	private String pwd;

	// 处理方法
	@SuppressWarnings("unchecked")
	public String execute() {
		System.out.println(name + "：" + pwd);
		if ("wyc".equals(name) && "123".equals(pwd)) {
			// 获取session
			ActionContext.getContext().getSession().put("user", name);
			// 获取request（HttpServletRequest）对象的attributes
			Map<String, Object> request = (Map<String, Object>) ActionContext.getContext().get("request");
			System.out.println(request);
			// 获取application
			Map<String, Object> application = ActionContext.getContext().getApplication();
			System.out.println(application);
			// 获取parameters
			Map<String, Object> parameters = ActionContext.getContext().getParameters();
			// 相当于request.getParameter("name");
			System.out.println("name：" + ((String[]) parameters.get("name"))[0]);
			return "success";
		} else {
			return "login";
		}
	}

	public String logout() {
		ActionContext.getContext().getSession().remove("user");
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
