package cn.itcast.gjp.domain;
//������
public class ZhangWu {
	
	private int zwid;//id
	
	private String flname;//��������
	
	private String zhangWu;//�˻�����
	
	private double money;//���
	
	private String createtime;//����ʱ��
	
	private String description;//˵��
	
	public String getFlname(){
		return flname;
	}
	
	public void setFlname(String flname){
		this.flname = flname;
	}
	
	public String getZhangWu(){
		return zhangWu;
	}
	
	public void setZhangWu(String zhangWu){
		this.zhangWu = zhangWu;
	}
	
	public int getZwid(){
		return zwid;
	}
	
	public void setZwid(int zwid){
		this.zwid = zwid;
	}
	
	public double getMoney(){
		return money;
	}
	
	public void setMoney(double money){
		this.money = money;
	}
	
	public String getCreatetime(){
		return createtime;
	}
	
	public void setCreatetime(String createtime){
		this.createtime = createtime;
	}
	
	public String getDescription(){
		return description;
	}
	
	public void setDescription(String description){
		this.description = description;
	}
	
}
