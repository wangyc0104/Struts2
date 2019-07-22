package wyc.core;

import java.util.HashMap;
import java.util.Map;

/**
 * Action对象
 * @author Yicheng Wang
 */
public class Action {
	
	private String name;
	
	private String classes;
	
	private String method = "execute";
	
	/**
	 * Action的结果集
	 */
	private Map<String, Result> resultMap = new HashMap<String, Result>();

	public Action() { }

	public Action(String name, String classes, String method) {
		super();
		this.name = name;
		this.classes = classes;
		this.method = method;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getClasses() {
		return classes;
	}

	public void setClasses(String classes) {
		this.classes = classes;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public Map<String, Result> getResultMap() {
		return resultMap;
	}

	public void setResultMap(Map<String, Result> resultMap) {
		this.resultMap = resultMap;
	}

}
