package edu.tongji.yuexiarenjing.day17;

import java.lang.Thread;

/*
 * 模拟火车站售票窗口，开启三个窗口售票，总票数为100张
 * 
 * 存在线程的安全问题--->使用同步代码块处理。
 * 
 * 此程序为错误的示范不能完成同步机制
 */

class Window5 extends Thread {
	static int ticket = 100;
	static Object obj = new Object();

	public void run() {
		while (true) {	
			show();
		}
	}
	
	public synchronized void show(){//this充当锁
		if (ticket > 0) {
//			try {
//				Thread.currentThread().sleep(10);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
			System.out.println(Thread.currentThread().getName() 
					+ "售票，票号为：" + ticket--);
		}		
	}
}

public class TestWindow5 {
	public static void main(String[] args) {
		Window5 w1 = new Window5();
		Window5 w2 = new Window5();
		Window5 w3 = new Window5();

		w1.setName("窗口1");
		w2.setName("窗口2");
		w3.setName("窗口3");

		w1.start();
		w2.start();
		w3.start();
	}
}
