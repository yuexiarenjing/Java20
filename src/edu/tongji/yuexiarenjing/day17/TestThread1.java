package edu.tongji.yuexiarenjing.day17;

import java.lang.Thread;

/*
 * �������̵߳ķ�ʽ����ͨ��ʵ�ֵķ�ʽ
 * 
 * �Ա�һ�¼̳� �ķ�ʽ��ʵ�ֵķ�ʽ
 * 1.��ϵ��public class Thread extends implements Runnable
 * 2.�ĸ���ʽ�ã�ʵ�ֵķ�ʽ���ڼ̳еķ�ʽ
 * 		why��	1.������java���̳еľ�����
 * 				2.�������߳�Ҫ����һ����Դ�����ݣ������ʺ�ʹ��ʵ�ֵķ�ʽ
 */

class PrintNum1 implements Runnable{
	@Override
	public void run() {
		// TODO Auto-generated method stub
		//���߳�ִ�еĴ���
		for (int i = 0; i < 100; i++) {
			if(i % 2 == 0){
				System.out.println(Thread.currentThread().getName() + ":" + i);
			}
		}
	}
}

public class TestThread1 {
	public static void main(String[] args) {
		PrintNum1 p = new PrintNum1();
		//Ҫ������һ�����̣߳��������start()����
		Thread t1 = new Thread(p);
		t1.start();	//�����̣߳�ִ��Thread��������ʱ�������βεĶ����run()������
		
		//�ٴ�����һ���߳�
		Thread t2 = new Thread(p);
		t2.start();
	}
}
