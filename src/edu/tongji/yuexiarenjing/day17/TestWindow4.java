package edu.tongji.yuexiarenjing.day17;

/*
 * 使用实现Runnable接口的方式，售票
 * 
 * 此程序存在线程的安全问题，打印车票时，会出现重票，错票
 * 1.线程安全问题存在的原因？
 * 		由于一个线程在操作共享数据的过程中，未执行完的情况下，另外的线程参与进来，导致共享数据存在安全问题。
 * 
 * 2.如何来解决线程的安全问题？
 * 		必须让一个线程操作共享数据完毕后，其他线程才有机会参与共享数据的操作。
 * 
 * 3.java如何实现线程的安全：线程同步机制
 * 		方式一；同步代码块
 * 		synchronized(同步监视器){
 * 			//需要被同步的代码块(即为操作共享数据的代码)
 * 		}
 * 		1.共享数据：多个线程共同操作的同一个数据（变量）
 * 		2.同步监视器：由任何一个对象来充当。哪个线程获取此监视器，谁就执行同步代码块。俗称：锁。
 * 		要求：所有进程必须公用一把锁！
 * 		注：在实现的方式中，考虑同步的话，可以使用this充当锁，但在继承方式中，慎用this
 * 
 * 		方法二：同步方法
 *		讲操作共享数据的方法声明为synchronized。即此方法为同步方法，能够保证当其中一个线程执行此方法时，
 *		其他线程在外等待，直至此线程执行完此方法。
 *		>同步方法的所：this
 *
 * 4.线程同步的弊端，同意时间只能一个线程访问共享数据，效率变低了。
 * 
 */

class Window4 implements Runnable {
	int ticket = 100;// 共享数据

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true) {
			show();			
		}
	}

	public synchronized void show() {
		if (ticket > 0) {
//			try {
//				Thread.currentThread().sleep(10);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
			System.out.println(Thread.currentThread().getName() + "售票，票号为：" + ticket--);
		}
	}
}

public class TestWindow4 {
	public static void main(String[] args) {
		Window4 w = new Window4();
		Thread t1 = new Thread(w);
		Thread t2 = new Thread(w);
		Thread t3 = new Thread(w);

		t1.setName("窗口1");
		t2.setName("窗口2");
		t3.setName("窗口3");

		t1.start();
		t2.start();
		t3.start();
	}
}
