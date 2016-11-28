package edu.tongji.yuexiarenjing.day15;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

import org.junit.Test;

/**
 * 1.IO����ϵ
 * ��������Ĳ�ͬ��������	�����
 * ���մ������ݵ�λ�Ĳ�ͬ���ֽ���  �ַ���  ��������ı��ļ���
 * ���ս�ɫ�Ĳ�ͬ���ڵ�����ֱ���������ļ���  ������
 * �������			�ڵ������ļ�����				����������������һ��,���������ļ�������Ч�ʣ�
 * InputStream		FileInputStream			BufferedInputStream
 * OutputStream		FileOutpuStream			BufferedOutputStrea (flush())
 * Reader			FileReader				BufferedReader	(readLine())
 * Writer			FileWriter				BufferedWriter	(flush())
 */

public class TestBuffered {
	@Test
	public void testBufferedReader(){
		BufferedReader br = null;
		try {
			File file  = new File("io");
			FileReader fr = new FileReader(file);
			br = new BufferedReader(fr);
			
//			char[] c = new char[1024];
//			int len;
//			while((len = br.read(c)) != -1){
//				String str = new String(c, 0, len);
//				System.out.print(str);
//			}
			
			String str;
			while((str = br.readLine()) != null){
				System.out.println(str);
			}
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(br != null){
				try {
					br.close();
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
		String src = "E:\\Ѹ������\\[EMD][Jormungand][01-24][BIG5][X264_AAC][1280X720]\\[EMD][Jormungand][12][BIG5][X264_AAC][1280X720][27251A25].mp4";
		String dest = "1.mp4";
		copyFile(src,dest);
		long end = System.currentTimeMillis();
		System.out.println("���ѵ�ʱ�䣺" + (end - start));
	}
	//ʹ�û�����ʵ���ļ����Ƶķ���
	public void copyFile(String src, String dest){
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		try {
			File file1 = new File(src);
			File file2 = new File(dest);
			
			FileInputStream fis = new FileInputStream(file1);
			FileOutputStream fos = new FileOutputStream(file2);
			
			bis = new BufferedInputStream(fis);
			bos = new BufferedOutputStream(fos);
			
			byte[] b = new byte[1024];
			int len;
			while((len = bis.read(b)) != -1){
				bos.write(b, 0, len);
				bos.flush();
			}
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(bos != null){
				try {
					bos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}				
			}
			if(bis != null){
				try {
					bis.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}				
			}
		}
	}
	
	//ʹ��BufferedInputStream��BufferedOutputStreamʵ���ı��ĸ���
	@Test
	public void testBufferedInputOutputStream(){
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		try {
			File file1 = new File("io");
			File file2 = new File("io5");
			
			FileInputStream fis = new FileInputStream(file1);
			FileOutputStream fos = new FileOutputStream(file2);
			
			bis = new BufferedInputStream(fis);
			bos = new BufferedOutputStream(fos);
			
			byte[] b = new byte[1024];
			int len;
			while((len = bis.read(b)) != -1){
				bos.write(b, 0, len);
				bos.flush();
			}
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(bos != null){
				try {
					bos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}				
			}
			if(bis != null){
				try {
					bis.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}				
			}
		}		
	}
}
