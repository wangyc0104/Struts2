package wyc.action;

import java.util.ArrayList;
import java.util.List;

import wyc.entity.User;
import net.sf.json.JSONArray;

/**
 * JsonAction
 * @author Yicheng Wang
 */
public class JsonAction {
	
	private JSONArray root;

	public String execute() {
		List<User> list = new ArrayList<User>();
		list.add(new User("wyc", 23));
		list.add(new User("dacheng", 22));
		list.add(new User("xiaocheng", 21));
		root = JSONArray.fromObject(list);
		System.out.println("json=" + root.toString());
		return "success";
	}

	public JSONArray getRoot() {
		System.out.println("getRoot");
		return root;
	}

	public void setRoot(JSONArray root) {
		this.root = root;
	}

}
