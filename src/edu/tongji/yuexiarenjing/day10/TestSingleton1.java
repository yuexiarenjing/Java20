package edu.tongji.yuexiarenjing.day10;

//懒汉式单例模式，存在多线程安全问题
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
