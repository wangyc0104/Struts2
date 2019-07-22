package wyc.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 使用注解来实现Struts2框架（显得很乱，极度不推荐使用）
 * @author Yicheng Wang
 */
@ParentPackage(value = "struts-default")
@Namespace("/")
public class HelloAction extends ActionSupport {
	@Action(value = "/hello", results = { @Result(name = "success", location = "/index.jsp"), @Result(name = "failed", type = "redirect", location = "/failed.jsp") })
	public String execute() {
		System.out.println("hello action");
		return "success";
	}
}
