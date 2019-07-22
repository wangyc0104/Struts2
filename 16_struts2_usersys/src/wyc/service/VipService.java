package wyc.service;

import java.util.List;
import java.util.Map;

import wyc.dao.VipDao;
import wyc.entity.Vip;

/**
 * VIP Service
 * @author Yicheng Wang
 */
public class VipService {
	
	private VipDao vipDao = new VipDao();

	public List<Vip> getList() {
		return vipDao.getList();
	}

	public Map<Integer, String> getMap() {
		return vipDao.getMap();
	}
	
}
