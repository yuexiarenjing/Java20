package edu.tongji.yuexiarenjing.day20;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

import org.junit.Test;
/*
 * UDP��ʵ��
 */
public class UDP {
	//������
	@Test
	public void send(){
		DatagramSocket ds = null;
		try {
			ds = new DatagramSocket();
			byte[] b = "����Ҫ���͵�����".getBytes();
			//����һ�����ݱ���ÿ�����ݱ����ܴ���64k������¼�ŷ��Ͷ˵�ip�Ͷ˿ںţ��Լ����ն˵�ip���˿ں�
			DatagramPacket pack = new DatagramPacket(b,b.length,InetAddress.getByName("127.0.0.1"), 9090);
			ds.send(pack);			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(ds != null){
				ds.close();
			}
		}
	}
	
	//������
	@Test
	public void receive(){
		DatagramSocket ds = null;
		try {
			ds = new DatagramSocket(9090);
			byte[] b = new byte[1024];
			DatagramPacket pack = new DatagramPacket(b,0,b.length);
			ds.receive(pack);
			String str = new String(pack.getData(),0,pack.getLength());
			System.out.println(str);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(ds != null){
				ds.close();
			}
		}
	}
}
