package edu.tongji.yuexiarenjing.day15;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.junit.Test;

/**
 * 1.IO的体系
 * 按照流向的不同：输入流	输出流
 * 按照处理数据单位的不同：字节流  字符流  （处理的文本文件）
 * 按照角色的不同：节点流（直接作用于文件）  处理流
 * 抽象基类			节点流（文件流）				缓冲流
 * InputStream		FileInputStream			BufferedInputStream
 * OutputStream		FileOutpuStream			BufferedOutputStream
 * Reader			FileReader				BufferedReader
 * Writer			FileWriter				BufferedWriter
 */
public class TestFileInputOutputStream {
	// 从硬盘读取一个文化。使用FileInputStream
	// 要读取的文件一定要存在，否则抛FileNotFoundException
	@Test
	public void TestFileInputStream1() throws Exception {
		// TODO Auto-generated constructor stub
		// 1.创建一个File类
		File file = new File("io");
		// 2.创建一个FileInputStream类的对象
		FileInputStream fis = new FileInputStream(file);
		// 3.调用FileInputStream的方法实现file文件的读取
		/*
		 * read()读取文件的一个字节。当执行到文件结尾时返回-1
		 */
		// int b = fis.read();
		// while(b != -1){
		// System.out.print((char)b);
		// b = fis.read();
		// }
		int b;
		while ((b = fis.read()) != -1) {
			System.out.print((char) b);
		}
		// 4.关闭相应的流
		fis.close();
	}

	// 使用try-catch的方式处理以下的异常更合理！保证流的关闭操作一定可以执行
	@Test
	public void TestFileInputStream2() {
		// 1.创建一个File类
		File file = new File("io");
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(file);
			// 3.调用FileInputStream的方法实现file文件的读取
			/*
			 * read()读取文件的一个字节。当执行到文件结尾时返回-1
			 */
			int b;
			while ((b = fis.read()) != -1) {
				System.out.print((char) b);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (fis != null) {
				try {
					// 4.关闭相应的流
					fis.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	@Test
	public void TestFileInputStream3() {
		File file = new File("io");
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(file);
			byte[] b = new byte[5];// 读取到的数据存入数组
			int len;// 每次读入到byte中的字节的长度
			while ((len = fis.read(b)) != -1) {
				// for (int i = 0; i < len; i++) {
				// System.out.print((char) b[i]);
				// }
				String str = new String(b, 0, len);
				System.out.print(str);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	@Test
	public void TestFileOutputStream() {
		File file = new File("io2");
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(file);
			fos.write(new String("I love China I love the World!").getBytes());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (fos != null) {
				try {
					fos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

	@Test
	public void TestFileInputOutputStream1() {
		File file1 = new File("io");
		File file2 = new File("io3");
		FileInputStream fis = null;
		FileOutputStream fos = null;
		try {
			fis = new FileInputStream(file1);
			fos = new FileOutputStream(file2);
			byte[] b = new byte[20];
			int len;
			while ((len = fis.read(b)) != -1) {
				fos.write(b, 0, len);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			if (fos != null) {
				try {
					fos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	//实现复制文件的方法
	public static void copyFile(String src, String dest){
		File file1 = new File(src);
		File file2 = new File(dest);
		FileInputStream fis = null;
		FileOutputStream fos = null;
		try {
			fis = new FileInputStream(file1);
			fos = new FileOutputStream(file2);
			byte[] b = new byte[20];
			int len;
			while ((len = fis.read(b)) != -1) {
				fos.write(b, 0, len);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			if (fos != null) {
				try {
					fos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	@Test
	public void testCopyFile(){
		long start = System.currentTimeMillis();
		String src = "io";
		String dest = "io5";
		copyFile(src,dest);
		long end = System.currentTimeMillis();
		System.out.println("花费的时间为：" + (end - start));
	}
}
