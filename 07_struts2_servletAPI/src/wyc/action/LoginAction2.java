package wyc.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionContext;

/**
 * 实现ServletRequestAware接口，直接可使用HttpServletRequest对象 <br>
 * 这种方法不能实现解耦 <br>
 * 
 * @author Yicheng Wang
 * 
 */
public class LoginAction2 implements ServletRequestAware {

	private String name;
	private String pwd;
	HttpServletRequest request;

	// 处理方法
	public String execute() {
		System.out.println(name + "：" + pwd);
		if ("wyc".equals(name) && "123".equals(pwd)) {
			request.getSession().setAttribute("user", name);
			System.out.println("name：" + request.getParameter("name"));
			return "success";
		} else {
			return "login";
		}
	}

	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
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
