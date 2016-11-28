package edu.tongji.yuexiarenjing.day15;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.junit.Test;

/**
 * 1.IO����ϵ
 * ��������Ĳ�ͬ��������	�����
 * ���մ������ݵ�λ�Ĳ�ͬ���ֽ���  �ַ���  ��������ı��ļ���
 * ���ս�ɫ�Ĳ�ͬ���ڵ�����ֱ���������ļ���  ������
 * �������			�ڵ������ļ�����				������
 * InputStream		FileInputStream			BufferedInputStream
 * OutputStream		FileOutpuStream			BufferedOutputStream
 * Reader			FileReader				BufferedReader
 * Writer			FileWriter				BufferedWriter
 */
public class TestFileInputOutputStream {
	// ��Ӳ�̶�ȡһ���Ļ���ʹ��FileInputStream
	// Ҫ��ȡ���ļ�һ��Ҫ���ڣ�������FileNotFoundException
	@Test
	public void TestFileInputStream1() throws Exception {
		// TODO Auto-generated constructor stub
		// 1.����һ��File��
		File file = new File("io");
		// 2.����һ��FileInputStream��Ķ���
		FileInputStream fis = new FileInputStream(file);
		// 3.����FileInputStream�ķ���ʵ��file�ļ��Ķ�ȡ
		/*
		 * read()��ȡ�ļ���һ���ֽڡ���ִ�е��ļ���βʱ����-1
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
		// 4.�ر���Ӧ����
		fis.close();
	}

	// ʹ��try-catch�ķ�ʽ�������µ��쳣��������֤���Ĺرղ���һ������ִ��
	@Test
	public void TestFileInputStream2() {
		// 1.����һ��File��
		File file = new File("io");
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(file);
			// 3.����FileInputStream�ķ���ʵ��file�ļ��Ķ�ȡ
			/*
			 * read()��ȡ�ļ���һ���ֽڡ���ִ�е��ļ���βʱ����-1
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
					// 4.�ر���Ӧ����
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
			byte[] b = new byte[5];// ��ȡ�������ݴ�������
			int len;// ÿ�ζ��뵽byte�е��ֽڵĳ���
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
	
	//ʵ�ָ����ļ��ķ���
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
		System.out.println("���ѵ�ʱ��Ϊ��" + (end - start));
	}
}
