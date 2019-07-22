package wyc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import wyc.pojo.User;

public class UserDao extends BaseDao {
	
	// 增加某个用户
	
	// 删除某个用户
	
	// 修改某个用户
	
	// 查询某个用户
	
	// 查询所有用户
	public List<User> selectAllUsers() {
		List<User> userList = null;
		String sql = "select * from user";
		ResultSet rs = null;
		try {
			userList = new ArrayList<User>();
			rs = this.executeQuery(sql, new Object[]{});
			while(rs.next()){
				User user = new User();
				user.setId(rs.getInt(1));
				user.setUsername(rs.getString(2));
				user.setPassword(rs.getString(3));
				user.setAge(rs.getInt(4));
				userList.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userList;
	}
}
