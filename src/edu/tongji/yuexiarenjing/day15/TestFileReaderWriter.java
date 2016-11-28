package edu.tongji.yuexiarenjing.day15;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.junit.Test;

/*
 * ʹ��FileReader FileWriter����ʵ���ı��ĸ��ơ����ַ�����
 * ���ڷ��ı��ļ�����Ƶ�ļ�����Ƶ�ļ���ͼƬ����ֻ��ʹ���ֽ�����
 */

public class TestFileReaderWriter {
	@Test
	public void testFileReaderWriter(){
		FileReader fr = null;
		FileWriter fw = null;
		try{
			File src = new File("io");
			File dest = new File("io5");
			fr = new FileReader(src);
			fw = new FileWriter(dest);
			char[] c = new char[24];
			int len;
			while((len = fr.read(c)) != -1){
				fw.write(c, 0, len);
			}
		}catch(IOException e){
			e.printStackTrace();
		}finally{
			if(fr != null){
				try {
					fr.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(fw != null){
				try {
					fw.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	@Test
	public void testFileReader() {
		FileReader fr = null;
		try {
			File file = new File("io");
			fr = new FileReader(file);
			char[] c = new char[24];
			int len;
			while ((len = fr.read(c)) != -1) {
				String str = new String(c, 0, len);
				System.out.print(str);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (fr != null) {
				try {
					fr.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
