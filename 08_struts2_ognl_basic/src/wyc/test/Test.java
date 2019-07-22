package wyc.test;

import java.util.HashMap;
import java.util.Map;

import ognl.Ognl;
import ognl.OgnlException;
import wyc.entity.User;

/**
 * OGNL基本原则
 * 
 * @author Yicheng Wang
 */
public class Test {
	public static void main(String[] args) throws OgnlException {
		// 数据分为2类：常用的和不常用的。常用的一般是小数据，不常用的一般是大数据；
		// OGNL表达式：常用的数据直接取，不常用的数据加#取。
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("name", "大诚");
		map.put("age", 25);
		User user = new User();
		user.setName("小诚");
		Object obj = Ognl.getValue("#name", map, user);
		System.out.println(obj);
	}
}
