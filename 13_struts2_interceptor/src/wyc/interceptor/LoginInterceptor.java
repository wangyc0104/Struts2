package wyc.interceptor;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * ��¼���������̳�AbstractInterceptor��
 * @author Yicheng Wang
 */
public class LoginInterceptor extends AbstractInterceptor {
	
	/**
	 * ��������Ĭ��ʵ�ַ���
	 */
	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		// �ж��Ƿ���login.action �������ֱ�����У�ִ����һ��������
		// ����������ж��Ƿ��¼�������¼ִ����һ��������
		// ���û���򷵻ص�¼ҳ��
		// actionNameû����չ��
		String actionName = invocation.getProxy().getActionName();
		if ("login".equals(actionName)) {
			return invocation.invoke();
		}
		Object obj = invocation.getInvocationContext().getSession().get("user");
		if (obj == null) {// û�е�¼
			return Action.LOGIN;
		}
		return invocation.invoke();
	}

}
