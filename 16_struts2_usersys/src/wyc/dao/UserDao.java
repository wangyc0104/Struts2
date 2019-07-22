package wyc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import wyc.entity.User;
import wyc.util.BaseDao;

/**
 * �û����ݿ���ʶ���
 * @author Yicheng Wang
 */
public class UserDao extends BaseDao {
	/**
	 * ��¼
	 * @param u
	 * @return
	 */
	public User login(User u) {
		String sql = "select * from t_user where name=? and pwd=?";
		ResultSet rs = this.executeQuery(sql, u.getName(), u.getPwd());
		try {
			if (rs.next()) {
				return new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.close();
		}
		return null;
	}

	/**
	 * ��ȡ�û��б�
	 * @return
	 */
	public List<User> getList() {
		String sql = "select * from t_user";
		List<User> list = new ArrayList<User>();
		ResultSet rs = this.executeQuery(sql);
		try {
			while (rs.next()) {
				list.add(new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			this.close();
		}
		return list.size() > 0 ? list : null;
	}

	/**
	 * �����û���Ϣ
	 * @param u
	 * @return
	 */
	public int update(User u) {
		String sql = "update t_user set name=?,pwd=? where id=?";
		return this.executeUpdate(sql, u.getName(), u.getPwd(), u.getId());
	}

	/**
	 * �����û�id��ȡ�û�
	 * @param id
	 * @return
	 */
	public User getById(int id) {
		String sql = "select * from t_user where id=?";
		ResultSet rs = this.executeQuery(sql, id);
		try {
			if (rs.next()) {
				return new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.close();
		}
		return null;
	}

}
