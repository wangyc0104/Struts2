package wyc.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

/**
 * ����������
 * @author Yicheng Wang
 */
@SuppressWarnings("serial")
public class ListInterceptor extends MethodFilterInterceptor {
	
	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		System.out.println("������������ִ��");
		return invocation.invoke();
	}
	
}
