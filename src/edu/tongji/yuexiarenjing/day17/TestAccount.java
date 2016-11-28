package edu.tongji.yuexiarenjing.day17;
/*
 * ������һ���˻�
 * �����������ֱ���ͬһ�˻���3000Ԫ��ÿ�δ�1000����3�Σ�ÿ�δ����ӡ�˻����
 * 
 * 1.�Ƿ��漰���̣߳��ǣ����������������ַ�ʽ�������̣߳�
 * 2.�Ƿ������ݣ��У���ͬһ���˻�
 * 3.�ÿ����̵߳�ͬ���������ַ��������̵߳İ�ȫ��
 */

class Account{
	double balance;//���
	public Account(){
		
	}
	//��Ǯ
	public synchronized void deposit(double amt){//this��AccountΨһ
		balance += amt;
//		try {
//			Thread.currentThread().sleep(10);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		System.out.println(Thread.currentThread().getName() + ":" + balance);
	}
}

class Customer extends Thread{
	Account account;
	
	public Customer(Account account) {
		// TODO Auto-generated constructor stub
		this.account = account;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 3; i++) {
			account.deposit(1000);
		}
	}
}

public class TestAccount {
	public static void main(String[] args) {
		Account acct = new Account();
		Customer c1 = new Customer(acct);
		Customer c2 = new Customer(acct);
		
		c1.setName("��");
		c2.setName("��");
		
		c1.start();
		c2.start();
	}
}
