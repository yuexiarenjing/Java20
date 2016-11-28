package edu.tongji.yuexiarenjing.day20;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

import org.junit.Test;

/*
 * 客户端给服务端发送文本，服务端会将文本转化为大写再返回给客户端。
 * 如下程序为了保证相应的流及socket的关闭（即使在关闭之前出现异常，也一定要保证相应资源的关闭），要求用try-catch-finally进行操作。
 * 要求关闭信息在finally里进行。
 */
public class TCP4 {

	// 发送
	@Test
	public void client() {
		Socket socket = null;
		OutputStream os = null;
		Scanner scanner = null;
		InputStream is = null;
		try {
			socket = new Socket(InetAddress.getByName("127.0.0.1"), 9090);
			os = socket.getOutputStream();
			// os.write("abc".getBytes());
			System.out.println("请输入多个字符：");
			scanner = new Scanner(System.in);
			String str = scanner.next();
			os.write(str.getBytes());
			socket.shutdownOutput();
			is = socket.getInputStream();
			byte[] b = new byte[1024];
			int len;
			while ((len = is.read(b)) != -1) {
				String str1 = new String(b, 0, len);
				System.out.println(str1);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (is != null) {
				try {
					is.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (os != null) {
				try {
					os.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (scanner != null) {
				try {
					scanner.close();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (socket != null) {
				try {
					socket.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	// 接收
	@Test
	public void server() {
		ServerSocket ss = null;
		Socket s = null;
		InputStream is = null;
		OutputStream os = null;
		try {
			ss = new ServerSocket(9090);
			s = ss.accept();
			is = s.getInputStream();
			byte[] b = new byte[1024];
			int len;
			String str = new String();
			while ((len = is.read(b)) != -1) {
				String str1 = new String(b, 0, len);
				str += str1;
			}
			String strUpperCase = str.toUpperCase();
			os = s.getOutputStream();
			os.write(strUpperCase.getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (os != null) {
				try {
					os.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (is != null) {
				try {
					is.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (s != null) {
				try {
					s.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (ss != null) {
				try {
					ss.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}
}
