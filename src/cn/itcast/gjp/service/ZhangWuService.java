package cn.itcast.gjp.service;

import java.util.List;

import cn.itcast.gjp.dao.ZhangWuDao;
import cn.itcast.gjp.domain.ZhangWu;

//账务业务层类
public class ZhangWuService {
	
	private ZhangWuDao zhangWuDao = new ZhangWuDao();
	
	//查询所有
	
	public List<ZhangWu> selectAll(){
		
		return zhangWuDao.selectAll();
		
	}
	
	/**
	 * 按条件查询账务方法
	 * 
	 * @param start
	 * 
	 * @param end
	 * 
	 * @return
	 * 
	 */		
	public List<ZhangWu> select(String start, String end){
		
		return zhangWuDao.select(start, end);
		
	}
	
	/**
	 * 添加账务
	 * @param zw
	 */
	public void addZhangWu(ZhangWu zw){
		
		zhangWuDao.addZhangWu(zw);
		
	}
	
	/**
	 * 编辑账务
	 * @param zw
	 */
	public void editZhangWu(ZhangWu zw) {
		
		zhangWuDao.editZhangWu(zw);
		
	}
	
	/**
	 * 删除账务
	 * @param zwid
	 */
	public void deleteZhangWu(int zwid) {
		
		zhangWuDao.deleteZhangWu(zwid);
		
	}
	
	
}
