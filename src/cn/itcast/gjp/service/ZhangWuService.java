package cn.itcast.gjp.service;

import java.util.List;

import cn.itcast.gjp.dao.ZhangWuDao;
import cn.itcast.gjp.domain.ZhangWu;

//����ҵ�����
public class ZhangWuService {
	
	private ZhangWuDao zhangWuDao = new ZhangWuDao();
	
	//��ѯ����
	
	public List<ZhangWu> selectAll(){
		
		return zhangWuDao.selectAll();
		
	}
	
	/**
	 * ��������ѯ���񷽷�
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
	 * �������
	 * @param zw
	 */
	public void addZhangWu(ZhangWu zw){
		
		zhangWuDao.addZhangWu(zw);
		
	}
	
	/**
	 * �༭����
	 * @param zw
	 */
	public void editZhangWu(ZhangWu zw) {
		
		zhangWuDao.editZhangWu(zw);
		
	}
	
	/**
	 * ɾ������
	 * @param zwid
	 */
	public void deleteZhangWu(int zwid) {
		
		zhangWuDao.deleteZhangWu(zwid);
		
	}
	
	
}
