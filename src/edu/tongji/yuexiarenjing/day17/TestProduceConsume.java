package edu.tongji.yuexiarenjing.day17;

/*
 * 生产者/消费者问题
 * 分析
 * 1.是否涉及到多线程的问题？是！生产者、消费者
 * 2.是否涉及到共享数据？是！产品的数量，考虑线程安全
 * 3.是否涉及到线程的通信？存在着生产者与消费者的通信
 */

class Clerk {// 店员
	int product;

	public synchronized void addProduct() {// 生产产品
		if(product >= 20){
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			product++;
			System.out.println(Thread.currentThread().getName() + ":生产了第" + product + "个产品");
			notifyAll();
		}
	}
	
	public synchronized void consumeProduct() {// 生产产品
		if(product <= 0){
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			System.out.println(Thread.currentThread().getName() + ":消费了第" + product + "个产品");
			product--;
			notifyAll();
		}
	}
}

class Producer implements Runnable {// 生产者
	Clerk clerk;

	public Producer(Clerk clerk) {
		// TODO Auto-generated constructor stub
		this.clerk = clerk;
	}

	public void run() {
		System.out.println("生产者开始生产产品");
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

class Consumer implements Runnable {//消费者
	Clerk clerk;
	public Consumer(Clerk clerk) {
		// TODO Auto-generated constructor stub
		this.clerk = clerk;
	}
	public void run() {
		System.out.println("消费者开消费产品");
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
		
		Thread t1 = new Thread(p1);//一个生产者线程
		Thread t3 = new Thread(p1);//一个生产者线程
		Thread t2 = new Thread(c1);//一个消费者线程
		
		t1.setName("生产者1");
		t3.setName("生产者2");
		t2.setName("消费者1");
		
		t1.start();
		t2.start();
		t3.start();
	}
}
