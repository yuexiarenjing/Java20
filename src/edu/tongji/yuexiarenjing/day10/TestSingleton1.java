package edu.tongji.yuexiarenjing.day10;

//����ʽ����ģʽ�����ڶ��̰߳�ȫ����
public class TestSingleton1 {

}

class Singleton1 {

	private Singleton1() {

	}

	private static Singleton1 instance = null;

	public static Singleton1 getInstance() {
		if (instance == null) {
			instance = new Singleton1();
		}
		return instance;
	}
}