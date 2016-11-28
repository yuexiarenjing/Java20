package edu.tongji.yuexiarenjing.day10;

/*
 * final:最终的，可以用来修饰类、属性、方法
 * 
 * 1.final修饰类：这个类不能被继承，如：String、StringBuffer、System。
 * 
 * 2.final修饰方法：不能再被重写,如：Object的getClass()。
 * 
 * 3.final修饰属性：此属性就是一个常量,初始化后不可再被赋值。习惯上，用大写字符表示。
 * 此常量在哪里复制：1.不能使用默认初始化2.可以显式复制、代码块、构造器
 * 
 * 变量用 static final修饰：全局常量
 * 
 * >与finally finaliz()区分开
 */

public class TestFinal {
	public static void main(String[] args) {
		C c = new C();
		System.out.println(c.getClass());
	}
}

class E{
	final int I = 12;
	final double PI; 
	final String NAME;
	public void m1(){
		System.out.println(I);
//		I = 10;
	}
	{
		PI = 3.14;
	}
	public E() {
		NAME = "EE";
	}
	public E(String name) {
		this();
		//NAME = name;
	}
}

//class SubString extends String{
//	
//}

final class A{
	
}

//class B extends A{
//	
//}

class C{
	public final void method1(){
		System.out.println("method1");
	}
}

class D extends C{
//	public void method1(){
//		System.out.println("method1...");
//	}
}
