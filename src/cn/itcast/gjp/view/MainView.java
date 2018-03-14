package cn.itcast.gjp.view;

import java.util.List;
import java.util.Scanner;

import cn.itcast.gjp.domain.ZhangWu;
import cn.itcast.gjp.service.ZhangWuService;

@SuppressWarnings("resource")
public class MainView {
	
	//����Ŀ��view����service
	private ZhangWuService zhangWuService = new ZhangWuService();
	
	//���з���
	public void run(){
		
		//1.��ӡ�˵�  2����ȡ�û�����  3.���ö�Ӧ����
		boolean flag = true;
		
		Scanner in = new Scanner(System.in);
		
		while(flag){
			
			System.out.println("-------------�ܼ��ż�ͥ�������-------------");
			
			System.out.println("1.�������  2.�༭����  3.ɾ������  4.��ѯ����  5.�˳�ϵͳ");
			
			System.out.println("������Ҫ�����Ĺ������[1-5]:");
			
			int op = in.nextInt();
			
			switch(op){
			
				case 1: 
					addZhangWu();
					break;
					
				case 2:
					editZhangWu();
					break;
					
				case 3:
					deleteZhangWu();
					break;
					
				case 4:
					selectZhangWu();
					break;
					
				case 5:
					System.out.println("�ټ���");
					flag = false;
					break;
					
				default:
					System.out.println("�������");
			
			}
		}
	}
	
	
	public void selectZhangWu(){
		
		System.out.println("1.��ѯ����   2.��������ѯ");
		
		Scanner in = new Scanner(System.in);
		
		int op = in.nextInt();
		
		switch(op){
		
			case 1:
				selectAll();
				break;
				
			case 2:
				select();
				break;
				
			default:
				System.out.println("�������");
				
		}
	}
	
	//��ѯ�������񷽷�
	public void selectAll(){
		
		List<ZhangWu> zhangWuList = zhangWuService.selectAll();
		
		print(zhangWuList);
	}
	
	//������񷽷�
	private void print(List<ZhangWu> zhangWuList){
		
		System.out.println("ID\t���\t\t�˻�\t\t���\t\tʱ��\t\t˵��");
		
		for(ZhangWu zw:zhangWuList){
			
			System.out.println(zw.getZwid() + "\t" + zw.getFlname() + "\t\t"
					
					+ zw.getZhangWu() + "\t\t" + zw.getMoney() + "\t\t"
					
					+ zw.getCreatetime() + "\t" + zw.getDescription());
			
		}
	}
	
	public void select(){
		//1.��ȡ�û������ѯ���ڷ�Χ
		//2.����service��select�����������������ѯ����
		
		Scanner in = new Scanner(System.in);
		
		System.out.print("�������ѯ��ʼʱ�䣺");
		
		String start = in.next();
		
		System.out.print("�������ѯ����ʱ�䣺");
		
		String end = in.next();
		
		List<ZhangWu> zhangWuList = zhangWuService.select(start, end);
		
		print(zhangWuList);
	}
	
	/**
	 * ������񷽷�
	 */
	public void addZhangWu(){
		/**
		 * 1.��ȡ�û����룬��װ��bean�С�
		 * 2.����service��addZhangWu()���������ӹ���
		 */
		Scanner in = new Scanner(System.in);
		
		ZhangWu zw = new ZhangWu();
		
		System.out.print("���������");
		
		zw.setFlname(in.next());
		
		System.out.print("�������˻���");
		
		zw.setZhangWu(in.next());
		
		System.out.print("�������");
		
		zw.setMoney(in.nextDouble());
		
		System.out.print("������ʱ�䣺");
		
		zw.setCreatetime(in.next());
		
		System.out.print("������˵����");
		
		zw.setDescription(in.next());
		
		zhangWuService.addZhangWu(zw);
		
		System.out.println("�������ɹ���");
		
	}
	
	/**
	 * �༭���񷽷�
	 */
	public void editZhangWu(){
		/**
		 * 1.��ȡ�û����룬��װ��bean�С�
		 * 2.����service��editZhangWu()���������ӹ���
		 */
		Scanner in = new Scanner(System.in);
		
		ZhangWu zw = new ZhangWu();
		
		System.out.print("������ID��");
		
		zw.setZwid(in.nextInt());
		
		System.out.print("�����������");
		
		zw.setFlname(in.next());
		
		System.out.print("���������˻���");
		
		zw.setZhangWu(in.next());
		
		System.out.print("�������½�");
		
		zw.setMoney(in.nextDouble());
		
		System.out.print("��������ʱ�䣺");
		
		zw.setCreatetime(in.next());
		
		System.out.print("��������˵����");
		
		zw.setDescription(in.next());
		
		zhangWuService.editZhangWu(zw);
		
		System.out.println("�༭����ɹ���");
		
	}
	
	/**
	 * ɾ�����񷽷�
	 */
	public void deleteZhangWu(){
		
		/**
		 * 1.��ȡ�û����룬��װ��bean�С�
		 * 2.����service��deleteZhangWu()���������ӹ���
		 */
		Scanner in = new Scanner(System.in);
		
		System.out.print("������ID��");
		
		zhangWuService.deleteZhangWu(in.nextInt());
		
		System.out.println("ɾ������ɹ���");
		
	}
}
