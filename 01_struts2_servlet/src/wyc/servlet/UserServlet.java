package wyc.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 使用Servlet进行Web访问
 * 
 * @author Yicheng Wang
 * 
 */
@SuppressWarnings("serial")
public class UserServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String strName = req.getParameter("name");
		String strPwd = req.getParameter("pwd");
		String strAge = req.getParameter("age");
		if (strName != null && strPwd != null && strAge != null) {
			System.out.println("添加成功！");
			resp.getWriter().print("success");
		} else {
			System.out.println("添加失败！");
			resp.getWriter().print("failed");
		}
	}

}
