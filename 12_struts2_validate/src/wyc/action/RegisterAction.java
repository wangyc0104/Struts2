package wyc.action;

import java.util.Date;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 用户注册Action
 * @author Yicheng Wang
 */
@SuppressWarnings("serial")
public class RegisterAction extends ActionSupport {
	private String name;
	private String pwd;
	private int age;
	private Date birthday;

	/**
	 * 默认执行
	 */
	@Override
	public String execute() throws Exception {
		System.out.println("execute");
		return Action.SUCCESS;
	}

	/**
	 * 注册
	 */
	public String register() {
		System.out.println("register");
		return Action.SUCCESS;
	}

	/**
	 * 注册验证
	 */
	public void validateRegister() {
		System.out.println("validate age");
		if (age > 150 || age < 1) {
			this.addActionError("年龄不合法");
		}
	}

	/**
	 * 验证操作
	 */
	public void validate() {
		System.out.println("validate");
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	
}
