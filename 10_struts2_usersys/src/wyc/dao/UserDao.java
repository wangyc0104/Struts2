package wyc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import wyc.entity.User;
import wyc.util.BaseDao;

/**
 * �û����ݷ��ʶ���
 * 
 * @author Yicheng Wang
 * 
 */
public class UserDao extends BaseDao {

	/**
	 * �û���¼�������û�������������û�
	 * 
	 * @param u �û�����
	 * @return ������ҵ��û��򷵻ظ��û��������󣬷��򷵻�null
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
	 * ��ȡ�û��б�
	 * 
	 * @return �û��б�List
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
	 * �����û�
	 * 
	 * @param u ������û�����
	 * @return �޸ĵ�����
	 */
	public int update(User u) {
		String sql = "update t_user set name=?,pwd=? where id=?";
		return this.executeUpdate(sql, u.getName(), u.getPwd(), u.getId());
	}

	/**
	 * ���ݴ����id��ȡ�û�
	 * 
	 * @param id �����id
	 * @return ����������û��򷵻��û����󣬷��򷵻�null
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
