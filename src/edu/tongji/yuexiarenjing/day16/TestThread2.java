package edu.tongji.yuexiarenjing.day16;

import java.lang.Thread;

/*
 * �����������̣߳�������һ�����1-100֮���ż������һ�����������
 */

class SubThread2 extends Thread{
	public void run(){
		for(int i = 1; i <= 100; i++){
			if(i % 2 == 0){
				System.out.println(Thread.currentThread().getName() + ":" + i);
			}
		}
	}
}

class SubThread3 extends Thread{
	public void run(){
		for(int i = 1; i <= 100; i++){
			if(i % 2 != 0){
				System.out.println(Thread.currentThread().getName() + ":" + i);
			}
		}
	}
}

public class TestThread2 {
	public static void main(String[] args){
		SubThread2 st2 = new SubThread2();
		SubThread3 st3 = new SubThread3();
		st2.start();
		st3.start();
		
		//�̳���Thread���������Ķ���
//		new Thread(){
//			public void run(){
//				for(int i = 1; i <= 100; i++){
//					if(i % 2 == 0){
//						System.out.println(Thread.currentThread().getName() + ":" + i);
//					}
//				}
//			}
//		}.start();
//		
//		new Thread(){
//			public void run(){
//				for(int i = 1; i <= 100; i++){
//					if(i % 2 != 0){
//						System.out.println(Thread.currentThread().getName() + ":" + i);
//					}
//				}
//			}
//		}.start();
		
	}
}
