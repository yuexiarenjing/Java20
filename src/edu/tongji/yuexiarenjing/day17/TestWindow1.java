package edu.tongji.yuexiarenjing.day17;

/*
 * ʹ��ʵ��Runnable�ӿڵķ�ʽ����Ʊ
 * 
 * �˳�������̵߳İ�ȫ���⣬��ӡ��Ʊʱ���������Ʊ����Ʊ
 */

class Window1 implements Runnable{
	int ticket = 100;
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true) {
			if (ticket > 0) {
				System.out.println(Thread.currentThread().getName() + "��Ʊ��Ʊ��Ϊ��" + ticket--);
			} else {
				break;
			}
		}
	}
}

public class TestWindow1 {
	public static void main(String[] args) {
		Window1 w = new Window1();
		Thread t1 = new Thread(w);
		Thread t2 = new Thread(w);
		Thread t3 = new Thread(w);
		
		t1.setName("����1");
		t2.setName("����2");
		t3.setName("����3");
		
		t1.start();
		t2.start();
		t3.start();
	}
}