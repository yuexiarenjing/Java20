package edu.tongji.yuexiarenjing.day17;

/*
 * ʹ��ʵ��Runnable�ӿڵķ�ʽ����Ʊ
 * 
 * �˳�������̵߳İ�ȫ���⣬��ӡ��Ʊʱ���������Ʊ����Ʊ
 * 1.�̰߳�ȫ������ڵ�ԭ��
 * 		����һ���߳��ڲ����������ݵĹ����У�δִ���������£�������̲߳�����������¹������ݴ��ڰ�ȫ���⡣
 * 
 * 2.���������̵߳İ�ȫ���⣿
 * 		������һ���̲߳�������������Ϻ������̲߳��л�����빲�����ݵĲ�����
 * 
 * 3.java���ʵ���̵߳İ�ȫ���߳�ͬ������
 * 		��ʽһ��ͬ�������
 * 		synchronized(ͬ��������){
 * 			//��Ҫ��ͬ���Ĵ����(��Ϊ�����������ݵĴ���)
 * 		}
 * 		1.�������ݣ�����̹߳�ͬ������ͬһ�����ݣ�������
 * 		2.ͬ�������������κ�һ���������䵱���ĸ��̻߳�ȡ�˼�������˭��ִ��ͬ������顣�׳ƣ�����
 * 		Ҫ�����н��̱��빫��һ������
 * 		ע����ʵ�ֵķ�ʽ�У�����ͬ���Ļ�������ʹ��this�䵱�������ڼ̳з�ʽ�У�����this
 * 
 * 		��������ͬ������
 *
 * 
 */

class Window2 implements Runnable {
	int ticket = 100;// ��������
//	Object obj = new Object();

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true) {
			synchronized (this) {//this��ʾ��ǰ���󣬴˴���Ϊw
				if (ticket > 0) {
//					try {
//						Thread.currentThread().sleep(10);
//					} catch (InterruptedException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
					System.out.println(Thread.currentThread().getName() + "��Ʊ��Ʊ��Ϊ��" + ticket--);
				} else {
					break;
				}
			}
		}
	}
}

public class TestWindow2 {
	public static void main(String[] args) {
		Window2 w = new Window2();
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
