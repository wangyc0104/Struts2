package wyc.interceptor;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * 登录拦截器（继承AbstractInterceptor）
 * @author Yicheng Wang
 */
public class LoginInterceptor extends AbstractInterceptor {
	
	/**
	 * 拦截器的默认实现方法
	 */
	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		// 判断是否是login.action 如果是则直接旅行，执行下一个拦截器
		// 如果不是则判断是否登录，如果登录执行下一个拦截器
		// 如果没有则返回登录页面
		// actionName没有扩展名
		String actionName = invocation.getProxy().getActionName();
		if ("login".equals(actionName)) {
			return invocation.invoke();
		}
		Object obj = invocation.getInvocationContext().getSession().get("user");
		if (obj == null) {// 没有登录
			return Action.LOGIN;
		}
		return invocation.invoke();
	}

}
