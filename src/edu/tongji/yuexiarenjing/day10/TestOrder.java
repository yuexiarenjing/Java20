package edu.tongji.yuexiarenjing.day10;

/*
 * ��ĵ��ĸ���Ա����ʼ���飨����飩
 * 1.��������εĻ�����ôֻ��ʹ��static��
 * 2.���ࣺ
 * ��̬����飺
 * 	1.�����������䡣
 * 	2.������ļ��ض����أ�����ֻ����һ�Ρ�
 * 	3.�����̬�����֮�䰴��˳��ִ�С�
 * 	4.��̬������ִ��Ҫ���ڷǾ�̬����顣
 * 	5.��̬�������ֻ��ִ�о�̬���ԵĽṹ�������ԣ��෽������
 * �Ǿ�̬����飺
 * 	1.���Զ�������Խ��г�ʼ��������ͬʱҲ���Ե��ñ������� �ķ�����
 * 	2.�����������䡣
 * 	3.һ�����п����ж���Ǿ�̬����飬��������֮�䰴˳��ִ�С�
 * 	4.ÿ����һ����Ķ��󣬷Ǿ�̬�����ͼ���һ�Ρ�
 * 	5.�Ǿ�̬������ִ��Ҫ���ڹ�������
 * 
 * �������Ը�ֵ�Ĳ�����1.Ĭ�ϳ�ʼ��2.��ʾ��ʼ���������ʼ�����˴�2���ṹ���ճ��ֵ��Ⱥ�˳��ִ�У�3.������4.ͨ�������Զ������Խ����޸�
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

	// ��̬�����
	static {
		System.out.println("��̬�����2");
		orderDesc = "����һ��Order";
	}

	static {
		System.out.println("��̬�����1");
	}

	// �Ǿ�̬��ʼ����
	{
		orderId = 1002;
		orderName = "AA";
		System.out.println("���ǷǾ�̬�����1");
	}

	{
		orderId = 1003;
		System.out.println("���ǷǾ�̬�����2");
	}

	public Order() {
		super();
		System.out.println("����Order�ĿղεĹ�����");
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