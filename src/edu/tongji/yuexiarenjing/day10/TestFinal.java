package edu.tongji.yuexiarenjing.day10;

/*
 * final:���յģ��������������ࡢ���ԡ�����
 * 
 * 1.final�����ࣺ����಻�ܱ��̳У��磺String��StringBuffer��System��
 * 
 * 2.final���η����������ٱ���д,�磺Object��getClass()��
 * 
 * 3.final�������ԣ������Ծ���һ������,��ʼ���󲻿��ٱ���ֵ��ϰ���ϣ��ô�д�ַ���ʾ��
 * �˳��������︴�ƣ�1.����ʹ��Ĭ�ϳ�ʼ��2.������ʽ���ơ�����顢������
 * 
 * ������ static final���Σ�ȫ�ֳ���
 * 
 * >��finally finaliz()���ֿ�
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
