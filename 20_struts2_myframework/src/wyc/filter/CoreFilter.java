package wyc.filter;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dom4j.DocumentException;

import wyc.core.Action;
import wyc.core.ActionMapper;
import wyc.core.Result;

/**
 * ���Ĺ�����
 * @author Yicheng Wang
 */
public class CoreFilter implements Filter {
	
	public void destroy() { }

	/**
	 * ��ʼ��
	 */
	public void init(FilterConfig config) throws ServletException {
		try {
			// ���������� ���������ļ�
			ActionMapper.parser();
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}

	/**
	 * ������
	 */
	public void doFilter(ServletRequest rq, ServletResponse rp, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) rq;
		HttpServletResponse resp = (HttpServletResponse) rp;
		// ������ӳ�䵽action��
		Action targetAction = reqToAction(req);
		if (targetAction == null)
			chain.doFilter(rq, rp);
		// ����action����
		try {
			Object proxyAction = createProxyAction(targetAction.getClasses());
			// ���û��ύ���������õ�action��������
			setProperty(req, proxyAction);
			// ִ��action�ķ���
			String result = execute(proxyAction, targetAction.getMethod());
			// ������
			// ��ȡ�������
			Result r = targetAction.getResultMap().get(result);
			resultExecute(req, resp, r, proxyAction);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * ������ӳ�䵽action��
	 * @param req
	 * @return
	 */
	private Action reqToAction(HttpServletRequest req) {
		String path = req.getRequestURI();
		// ֻ������action��β������
		if (!path.endsWith(".action"))
			return null;
		// ���������
		String reqName = path.substring(path.lastIndexOf("/") + 1, path.lastIndexOf("."));
		return ActionMapper.actionMap.get(reqName);
	}

	/**
	 * ����action����
	 * @param className
	 * @return
	 * @throws Exception
	 */
	private Object createProxyAction(String className) throws Exception {
		Class<?> clzz = Class.forName(className);
		return clzz.newInstance();
	}

	/**
	 * ���û��ύ���������õ�action��������---�򻯺ܶ�
	 * @param req
	 * @param obj
	 * @throws SecurityException
	 * @throws NoSuchFieldException
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 */
	private void setProperty(HttpServletRequest req, Object obj) throws SecurityException, NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
		// ����Class
		Class<?> clzz = obj.getClass();
		Map<?, ?> map = req.getParameterMap();
		for (Iterator<?> iter = map.keySet().iterator(); iter.hasNext();) {
			Object key = iter.next();
			// �����ύ���� ȥ�� Field
			Field field = clzz.getDeclaredField(key.toString());
			if (field == null) {
				continue;
			}
			field.setAccessible(true);
			// Ҫ������Ӧ������ת��---ʡ����
			field.set(obj, req.getParameter(key.toString()));
			field.setAccessible(false);
		}
	}

	/**
	 * ִ��action�ķ���
	 * @param proxyAction
	 * @param method
	 * @return
	 * @throws SecurityException
	 * @throws NoSuchMethodException
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 */
	private String execute(Object proxyAction, String method) throws SecurityException, NoSuchMethodException, IllegalArgumentException, IllegalAccessException, InvocationTargetException {
		Class<?> clzz = proxyAction.getClass();
		Method m = clzz.getDeclaredMethod(method);
		return (String) m.invoke(proxyAction);
	}

	/**
	 * ������
	 * @param req
	 * @param resp
	 * @param r
	 * @param proxyAction
	 * @throws IOException
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 * @throws ServletException
	 */
	private void resultExecute(HttpServletRequest req, HttpServletResponse resp, Result r, Object proxyAction) throws IOException, IllegalArgumentException, IllegalAccessException, ServletException {
		if ("redirect".equals(r.getType())) {
			resp.sendRedirect(r.getLocation());
			return;
		}
		// ��action������ֵ ���õ�req��attribute��
		Class<?> clzz = proxyAction.getClass();
		Field[] fds = clzz.getDeclaredFields();
		for (Field fd : fds) {
			fd.setAccessible(true);
			req.setAttribute(fd.getName(), fd.get(proxyAction));
			fd.setAccessible(false);
		}
		req.getRequestDispatcher(r.getLocation()).forward(req, resp);
	}

}
