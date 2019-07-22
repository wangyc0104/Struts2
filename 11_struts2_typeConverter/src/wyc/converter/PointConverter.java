package wyc.converter;

import java.util.Map;

import org.apache.struts2.util.StrutsTypeConverter;

import wyc.entity.Point;

/**
 * �����ת����
 * @author Yicheng Wang
 */
public class PointConverter extends StrutsTypeConverter {
	
	/**
	 * �����ύ���ַ������� ת��Ϊ ָ���Զ������� <br>
	 * @param context ��ActionContext
	 * @param values Ҫ��������ת�����ַ�������
	 * @param toClass ��ת��������
	 * @return ת�������������
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
	 * ���������� ת��Ϊ�ַ�����ǰ̨ҳ����ʾ��ͨ��ognl���ʽ����ʹ�ø÷�������ת����<br>
	 * @param context ��ActionContext 
	 * @param o Ҫת���Ķ���
	 */
	@Override
	public String convertToString(Map context, Object o) {
		Point point = (Point) o;
		return "(" + point.getX() + "," + point.getY() + ")";
	}
	
}
