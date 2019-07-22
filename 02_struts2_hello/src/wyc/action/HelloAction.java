package wyc.action;

/**
 * 我的第一个Struts2程序
 * 
 * @author Yicheng Wang
 * 
 */
public class HelloAction {

	public HelloAction() {
		System.out.println("Constructor method");
	}

	public String execute() {
		System.out.println("Hello Action!");
		return "success";
	}

	public String good() {
		System.out.println("GOOD");
		return "good";
	}

	public String bad() {
		System.out.println("BAD");
		return "bad";
	}

}
