package edu.tongji.yuexiarenjing.day17;
/*
 * 银行有一个账户
 * 有两个储户分别向同一账户存3000元，每次存1000，存3次，每次存完打印账户余额
 * 
 * 1.是否涉及多线程？是！有两个储户（两种方式创建多线程）
 * 2.是否共享数据？有！是同一个账户
 * 3.得考虑线程的同步。（两种方法处理线程的安全）
 */

class Account{
	double balance;//余额
	public Account(){
		
	}
	//存钱
	public synchronized void deposit(double amt){//this是Account唯一
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
		
		c1.setName("甲");
		c2.setName("乙");
		
		c1.start();
		c2.start();
	}
}
