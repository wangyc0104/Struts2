package wyc.converter;

import java.util.Map;

import org.apache.struts2.util.StrutsTypeConverter;

import wyc.entity.Point;

/**
 * 坐标点转换器
 * @author Yicheng Wang
 */
public class PointConverter extends StrutsTypeConverter {
	
	/**
	 * 将表单提交的字符串数据 转换为 指定自定义类型 <br>
	 * @param context 是ActionContext
	 * @param values 要进行类型转换的字符串数组
	 * @param toClass 被转换的类型
	 * @return 转换后的坐标点对象
	 */
	@Override
	public Object convertFromString(Map context, String[] values, Class toClass) {
		String value = values[0];
		Point point = new Point();
		String x = value.substring(1, value.indexOf(","));
		String y = value.substring(value.indexOf(",") + 1, value.length() - 1);
		System.out.println("x=" + x);
		System.out.println("y=" + y);
		point.setX(Integer.parseInt(x));
		point.setY(Integer.parseInt(y));
		return point;
	}

	/**
	 * 将定义类型 转换为字符串在前台页面显示（通过ognl表达式将会使用该方法进行转换）<br>
	 * @param context 是ActionContext 
	 * @param o 要转换的对象
	 */
	@Override
	public String convertToString(Map context, Object o) {
		Point point = (Point) o;
		return "(" + point.getX() + "," + point.getY() + ")";
	}
	
}
