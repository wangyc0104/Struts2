package wyc.action;

import wyc.entity.Point;

import com.opensymphony.xwork2.Action;

/**
 * �����Action
 * @author Yicheng Wang
 *
 */
public class PointAction {
	
	/**
	 * ��������
	 */
	private Point point;

	/**
	 * ִ��ת�������سɹ�ҳ��
	 * @return �ɹ�ҳ��
	 */
	public String execute() {
		System.out.println("point - (" + point.getX() + "," + point.getY() + ")");
		return Action.SUCCESS;
	}

	public Point getPoint() {
		return point;
	}

	public void setPoint(Point point) {
		this.point = point;
	}

}
