package edu.tongji.yuexiarenjing.day20;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

/*
 * URL:统一资源定位符，一个URL对象，对应着一个互联网资源
 * 我可以通过URL的对象，调用其相应的方法将此资源读取（“下载”）
 */
public class TestURL {
	public static void main(String[] args) throws Exception{
		URL url = new URL("http://www.baidu.com");//FIle file = new FIle(“文件的路径”)；
		System.out.println(url.getProtocol());
		System.out.println(url.getHost());
		System.out.println(url.getPort());
		System.out.println(url.getFile());
		System.out.println(url.getRef());
		System.out.println(url.getQuery());
		//如何将服务端的资源保存进来:openStream()
		InputStream is = url.openStream();
		byte[] b = new byte[1024];
		int len;
		while((len = is.read(b)) != -1){
			String str = new String(b,0,len);
			System.out.println(str );
		}
		is.close();
		//如果又有数据的输入又有数据的输出，可以考虑使用URLConnection
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
