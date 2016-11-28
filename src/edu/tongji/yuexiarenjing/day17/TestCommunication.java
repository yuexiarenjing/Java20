package edu.tongji.yuexiarenjing.day17;
/*
 * �߳�ͨ�š����µ������ؼ��֣�ʹ�õĻ���������ͬ��������ͬ�������С�
 * wait()��һ��һ���߳�ִ�е�wait()�����ͷŵ�ǰ������
 * notify() notifyAll()������wait��һ�������е��̡߳�
 * ʹ�������̴߳�ӡ1-100���߳�1���߳�2�����ӡ
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
		
		t1.setName("��");
		t2.setName("��");
		
		t1.start();
		t2.start();
		
	}
}
