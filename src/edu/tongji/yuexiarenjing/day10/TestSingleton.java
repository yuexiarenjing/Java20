package edu.tongji.yuexiarenjing.day10;

//饿汉式单例模式
public class TestSingleton {
	public static void main(String[] args) {
		Singleton s1 = Singleton.getInstance();
		Singleton s2 = Singleton.getInstance();
		System.out.println(s1 == s2);
	}
}

class Singleton {

	private Singleton() {

	}

	private static Singleton instance = new Singleton();

	public static Singleton getInstance() {
		return instance;
	}
}
