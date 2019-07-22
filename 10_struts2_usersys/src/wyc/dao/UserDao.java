package wyc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import wyc.entity.User;
import wyc.util.BaseDao;

/**
 * 用户数据访问对象
 * 
 * @author Yicheng Wang
 * 
 */
public class UserDao extends BaseDao {

	/**
	 * 用户登录：根据用户名和密码查找用户
	 * 
	 * @param u 用户对象
	 * @return 如果查找到用户则返回该用户完整对象，否则返回null
	 */
	public User login(User u) {
		String sql = "select * from t_user where name=? and pwd=?";
		ResultSet rs = this.executeQuery(sql, u.getName(), u.getPwd());
		try {
			if (rs.next()) {
				return new User(rs.getInt(1), rs.getString(2), rs.getString(3));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.close();
		}
		return null;
	}

	/**
	 * 获取用户列表
	 * 
	 * @return 用户列表List
	 */
	public List<User> getList() {
		String sql = "select * from t_user";
		List<User> list = new ArrayList<User>();
		ResultSet rs = this.executeQuery(sql);
		try {
			while (rs.next()) {
				list.add(new User(rs.getInt(1), rs.getString(2), rs.getString(3)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.close();
		}
		return list.size() > 0 ? list : null;
	}

	/**
	 * 更新用户
	 * 
	 * @param u 传入的用户对象
	 * @return 修改的行数
	 */
	public int update(User u) {
		String sql = "update t_user set name=?,pwd=? where id=?";
		return this.executeUpdate(sql, u.getName(), u.getPwd(), u.getId());
	}

	/**
	 * 根据传入的id获取用户
	 * 
	 * @param id 传入的id
	 * @return 如果搜索到用户则返回用户对象，否则返回null
	 */
	public User getById(int id) {
		String sql = "select * from t_user where id=?";
		ResultSet rs = this.executeQuery(sql, id);
		try {
			if (rs.next()) {
				return new User(rs.getInt(1), rs.getString(2), rs.getString(3));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.close();
		}
		return null;
	}

}
