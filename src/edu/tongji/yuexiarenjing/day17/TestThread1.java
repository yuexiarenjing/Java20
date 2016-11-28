package edu.tongji.yuexiarenjing.day17;

import java.lang.Thread;

/*
 * 创建多线程的方式二：通过实现的方式
 * 
 * 对比一下继承 的方式和实现的方式
 * 1.联系：public class Thread extends implements Runnable
 * 2.哪个方式好？实现的方式优于继承的方式
 * 		why？	1.避免了java单继承的局限性
 * 				2.如果多个线程要操作一份资源（数据），更适合使用实现的方式
 */

class PrintNum1 implements Runnable{
	@Override
	public void run() {
		// TODO Auto-generated method stub
		//子线程执行的代码
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
		//要想启动一个多线程，必须调用start()方法
		Thread t1 = new Thread(p);
		t1.start();	//启动线程，执行Thread对象生成时构造器形参的对象的run()方法。
		
		//再窗创建一个线程
		Thread t2 = new Thread(p);
		t2.start();
	}
}
