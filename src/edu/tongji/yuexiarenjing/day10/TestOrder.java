package edu.tongji.yuexiarenjing.day10;

/*
 * 类的第四个成员：初始化块（代码块）
 * 1.如果有修饰的话，那么只能使用static。
 * 2.分类：
 * 静态代码块：
 * 	1.可以有输出语句。
 * 	2.随着类的加载而加载，而且只加载一次。
 * 	3.多个静态代码块之间按照顺序执行。
 * 	4.静态代码块的执行要早于非静态代码块。
 * 	5.静态代码块中只能执行静态属性的结构（类属性，类方法）。
 * 非静态代码块：
 * 	1.可以对类的属性进行初始化操作，同时也可以调用本类声明 的方法。
 * 	2.可以有输出语句。
 * 	3.一个类中可以有多个非静态代码块，多个代码块之间按顺序执行。
 * 	4.每创建一个类的对象，非静态代码块就加载一次。
 * 	5.非静态代码块的执行要早于构造器。
 * 
 * 关于属性赋值的操作：1.默认初始化2.显示初始化或代码块初始化（此处2个结构按照出现的先后顺序执行）3.构造器4.通过方法对对象属性进行修改
 */

public class TestOrder {
	public static void main(String[] args) {
		Order o1 = new Order();
		System.out.println(o1);

		System.out.println();

		Order o2 = new Order();
		System.out.println(o2);
	}
}

class Order {
	private int orderId = 1001;
	private String orderName;
	@SuppressWarnings("unused")
	private static String orderDesc;

	// 静态代码块
	static {
		System.out.println("静态代码块2");
		orderDesc = "我是一个Order";
	}

	static {
		System.out.println("静态代码块1");
	}

	// 非静态初始化块
	{
		orderId = 1002;
		orderName = "AA";
		System.out.println("我是非静态代码块1");
	}

	{
		orderId = 1003;
		System.out.println("我是非静态代码块2");
	}

	public Order() {
		super();
		System.out.println("我是Order的空参的构造器");
	}

	public Order(int orderId, String orderName) {
		super();
		this.orderId = orderId;
		this.orderName = orderName;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getOrderName() {
		return orderName;
	}

	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", orderName=" + orderName + "]";
	}
}