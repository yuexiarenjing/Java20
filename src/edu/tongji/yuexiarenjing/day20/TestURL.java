package edu.tongji.yuexiarenjing.day20;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

/*
 * URL:ͳһ��Դ��λ����һ��URL���󣬶�Ӧ��һ����������Դ
 * �ҿ���ͨ��URL�Ķ��󣬵�������Ӧ�ķ���������Դ��ȡ�������ء���
 */
public class TestURL {
	public static void main(String[] args) throws Exception{
		URL url = new URL("http://www.baidu.com");//FIle file = new FIle(���ļ���·����)��
		System.out.println(url.getProtocol());
		System.out.println(url.getHost());
		System.out.println(url.getPort());
		System.out.println(url.getFile());
		System.out.println(url.getRef());
		System.out.println(url.getQuery());
		//��ν�����˵���Դ�������:openStream()
		InputStream is = url.openStream();
		byte[] b = new byte[1024];
		int len;
		while((len = is.read(b)) != -1){
			String str = new String(b,0,len);
			System.out.println(str );
		}
		is.close();
		//����������ݵ������������ݵ���������Կ���ʹ��URLConnection
		URLConnection urlConn = url.openConnection();
		InputStream is1 = urlConn.getInputStream();
		FileOutputStream fos = new FileOutputStream(new File("abc.txt"));
		byte[] b1 = new byte[1024];
		int len1;
		while((len1 = is1.read(b1)) != -1){
			fos.write(b1,0, len1);
		}
		fos.close();
		is1.close();
		
	}
}
