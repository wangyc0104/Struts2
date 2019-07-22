package wyc.action;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;

/**
 * ActionContext��ȡ������ķ���
 * 
 * @author Yicheng Wang
 * 
 */
public class LoginAction {
	private String name;
	private String pwd;

	// ������
	@SuppressWarnings("unchecked")
	public String execute() {
		System.out.println(name + "��" + pwd);
		if ("wyc".equals(name) && "123".equals(pwd)) {
			// ��ȡsession
			ActionContext.getContext().getSession().put("user", name);
			// ��ȡrequest��HttpServletRequest�������attributes
			Map<String, Object> request = (Map<String, Object>) ActionContext.getContext().get("request");
			System.out.println(request);
			// ��ȡapplication
			Map<String, Object> application = ActionContext.getContext().getApplication();
			System.out.println(application);
			// ��ȡparameters
			Map<String, Object> parameters = ActionContext.getContext().getParameters();
			// �൱��request.getParameter("name");
			System.out.println("name��" + ((String[]) parameters.get("name"))[0]);
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
