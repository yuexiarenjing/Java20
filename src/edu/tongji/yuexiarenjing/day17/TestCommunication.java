package edu.tongji.yuexiarenjing.day17;
/*
 * 线程通信。如下的三个关键字，使用的话，都得在同步代码块或同步方法中。
 * wait()：一旦一个线程执行到wait()，就释放当前的锁。
 * notify() notifyAll()：唤醒wait的一个或所有的线程。
 * 使用两个线程打印1-100，线程1，线程2交替打印
 * 
 */

class PrintNum implements Runnable{
	int num = 1;
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true){
			synchronized (this) {
				notify(); 
				if (num <= 100) {
//					try {
//						Thread.currentThread().sleep(10);
//					} catch (InterruptedException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
					System.out.println(Thread.currentThread().getName() + ":" + num++);
				} else {
					break;
				}
				try {
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}


public class TestCommunication {
	public static void main(String[] args) {
		PrintNum p = new PrintNum();
		Thread t1 = new Thread(p);
		Thread t2 = new Thread(p);
		
		t1.setName("甲");
		t2.setName("乙");
		
		t1.start();
		t2.start();
		
	}
}
