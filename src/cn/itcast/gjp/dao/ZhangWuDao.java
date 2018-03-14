package cn.itcast.gjp.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.itcast.gjp.domain.ZhangWu;
import cn.itcast.gjp.tools.JDBCUtils;

public class ZhangWuDao {
	
	//��ȡ���ݿ����ӳأ��õ����������ݵĶ���QueryRunner
	QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
	
	//��ѯ��������
	public List<ZhangWu> selectAll(){
		
		String sql = "select * from gjp_zhangwu";
		
		try{
			
			return qr.query(sql, new BeanListHandler<ZhangWu>(ZhangWu.class));
			
		}catch(SQLException e){
			
			throw new RuntimeException(e);
			
		}
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
	public List<ZhangWu> select(String start, String end) {
		String sql = "select * from gjp_zhangwu where createtime between ? and ?";
		
		Object[] params = {start, end};
		
		try{
			
			return qr.query(sql, new BeanListHandler<ZhangWu> (ZhangWu.class),params);
			
		}catch(SQLException e){
			
			throw new RuntimeException(e);
			
		}
	}
	
	/**
	 * �������
	 * @param zw
	 */
	public void addZhangWu(ZhangWu zw) {
		
		String sql = "insert into gjp_zhangwu(flname,money,zhangwu,createtime,description) values(?,?,?,?,?)";
		
		try{
			
			Object[] params = {zw.getFlname(),zw.getMoney(),zw.getZhangWu(),zw.getCreatetime(),zw.getDescription()};
			
			qr.update(sql,params);
			
		}catch(SQLException e){
			
			throw new RuntimeException(e);
			
		}
	}
	
	
	public void editZhangWu(ZhangWu zw) {
		
		String sql = "update gjp_zhangwu set flname=?,money=?,zhangwu=?,createtime=?,description=? where zwid=?";
		
		try{
			
			Object[] params = {zw.getFlname(),zw.getMoney(),zw.getZhangWu(),zw.getCreatetime(),zw.getDescription()};
			
			qr.update(sql, params);
			
		}catch(SQLException e){
			
			throw new RuntimeException(e);
			
		}
	}
	
	/**
	 * ɾ������
	 * @param zwid
	 */
	public void deleteZhangWu(int zwid) {
		
		String sql = "delete from gjp_zhangwu where zwid=?";
		
		try{
			
			qr.update(sql, zwid);
			
		}catch(SQLException e){
			
			throw new RuntimeException(e);
			
		}
		
	}
	
}
