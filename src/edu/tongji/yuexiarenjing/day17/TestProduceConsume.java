package edu.tongji.yuexiarenjing.day17;

/*
 * ������/����������
 * ����
 * 1.�Ƿ��漰�����̵߳����⣿�ǣ������ߡ�������
 * 2.�Ƿ��漰���������ݣ��ǣ���Ʒ�������������̰߳�ȫ
 * 3.�Ƿ��漰���̵߳�ͨ�ţ��������������������ߵ�ͨ��
 */

class Clerk {// ��Ա
	int product;

	public synchronized void addProduct() {// ������Ʒ
		if(product >= 20){
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			product++;
			System.out.println(Thread.currentThread().getName() + ":�����˵�" + product + "����Ʒ");
			notifyAll();
		}
	}
	
	public synchronized void consumeProduct() {// ������Ʒ
		if(product <= 0){
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			System.out.println(Thread.currentThread().getName() + ":�����˵�" + product + "����Ʒ");
			product--;
			notifyAll();
		}
	}
}

class Producer implements Runnable {// ������
	Clerk clerk;

	public Producer(Clerk clerk) {
		// TODO Auto-generated constructor stub
		this.clerk = clerk;
	}

	public void run() {
		System.out.println("�����߿�ʼ������Ʒ");
		while (true) {
//			try {
//				Thread.currentThread().sleep(10);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
			clerk.addProduct();
		}
	}
}

class Consumer implements Runnable {//������
	Clerk clerk;
	public Consumer(Clerk clerk) {
		// TODO Auto-generated constructor stub
		this.clerk = clerk;
	}
	public void run() {
		System.out.println("�����߿����Ѳ�Ʒ");
		while (true) {
//			try {
//				Thread.currentThread().sleep(10);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
			clerk.consumeProduct();
		}
	}
}

public class TestProduceConsume {
	public static void main(String[] args) {
		Clerk clerk = new Clerk();
		Producer p1 = new Producer(clerk);
		Consumer c1 = new Consumer(clerk);
		
		Thread t1 = new Thread(p1);//һ���������߳�
		Thread t3 = new Thread(p1);//һ���������߳�
		Thread t2 = new Thread(c1);//һ���������߳�
		
		t1.setName("������1");
		t3.setName("������2");
		t2.setName("������1");
		
		t1.start();
		t2.start();
		t3.start();
	}
}
