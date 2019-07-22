package wyc.action;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

/**
 * AjaxAction
 * @author Yicheng Wang
 */
public class AjaxAction {
	
	public String execute() throws IOException {
		HttpServletResponse resp = ServletActionContext.getResponse();
		resp.setCharacterEncoding("utf-8");
		resp.getWriter().print("struts ajax");
		return null;
	}
	
}
