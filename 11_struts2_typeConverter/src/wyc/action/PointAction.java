package wyc.action;

import wyc.entity.Point;

import com.opensymphony.xwork2.Action;

/**
 * 坐标点Action
 * @author Yicheng Wang
 *
 */
public class PointAction {
	
	/**
	 * 坐标点对象
	 */
	private Point point;

	/**
	 * 执行转换并返回成功页面
	 * @return 成功页面
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
