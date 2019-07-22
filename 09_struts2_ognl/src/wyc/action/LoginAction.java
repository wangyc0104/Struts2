package wyc.action;

import wyc.entity.User;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.util.ValueStack;

/**
 * ��ֵջ�в�������
 * 
 * @author Yicheng Wang
 * 
 */
public class LoginAction {
	private String name;
	private String pwd;

	// ������
	public String execute() {
		System.out.println(name + "��" + pwd);
		if ("wyc".equals(name) && "123".equals(pwd)) {
			// ��ȡsession
			ActionContext.getContext().getSession().put("user", name);
			ValueStack vs = ActionContext.getContext().getValueStack();
			System.out.println("name��" + vs.findString("name"));
			User user = new User();
			user.setName("���");
			vs.push(user);
			return "success";
		} else {
			return "login";
		}
	}

	public String logout() {
		ActionContext.getContext().getSession().remove("user");
		System.out.println("�˳�");
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
