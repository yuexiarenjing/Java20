package edu.tongji.yuexiarenjing.day15;

import java.io.File;
import java.util.Date;

import org.junit.Test;

/*
 * java.io.File��
 * 1.���������������ص��ࡢ�ӿڵȶ�������java.io����
 * 2.File��һ���࣬�����й�������������󡣴˶����Ӧ��һ���ļ���txt avi doc ppt MP3 jpg�����ļ�Ŀ¼
 * 3.File�������ƽ̨�޹�
 * 4.File�еķ������漰����δ�����ɾ�����������ȵȡ�ֻҪ�漰�ļ����ݵģ�File������Ϊ���ģ�������IO������ɡ�
 * 5.File��Ķ�����Ϊop���ľ�����Ĺ��������βΡ�
 */
public class TestFile {
	/*
	 * ·����
	 * ����·���������̷����ڵ��������ļ�·��
	 * ���·�����ڵ�ǰ�ļ�Ŀ¼�µ��ļ���·��
	 * 
	 * �����ļ���
	 * getName()
	 * getPath()
	 * getAbsoluteFile() 
	 * getAbsolutePath ()
	 * getParent ()
	 * reNameTo(File newName) //���ļ�ת�Ʋ���������newName����ļ����벻����
	 * 
	 * �ļ����/��ȡ�ļ���Ϣ
	 * exists()
	 * canWrite()
	 * canRead()
	 * isFile
	 * isDirectory()
	 * lastModified()
	 * length()
	 * 
	 * �ļ��������/Ŀ¼�������
	 * createNewFile()
	 * delete()
	 * mkDir()
	 * mkDirs()//�ϲ��ļ�Ŀ¼�����ڵ��������
	 * list()
	 * listFiles()
	 */
	@Test
	public void test1(){
		File file1 = new File("io");
//		File file2 = new File("io1");
		
		System.out.println(file1.getName());
		System.out.println(file1.getPath());
		System.out.println(file1.getAbsoluteFile());
		System.out.println(file1.getAbsolutePath());
		System.out.println(file1.getParent());
		
		System.out.println(file1.exists());
		System.out.println(file1.canWrite());
		System.out.println(file1.canRead());
		System.out.println(file1.isFile());
		System.out.println(file1.isDirectory());
		System.out.println(new Date(file1.lastModified()));
		System.out.println(file1.length());
		
		File file3 = new File("D:\\BaiduYunDownload");
		String[] strs = file3.list();
		for (int i = 0; i < strs.length; i++) {
			System.out.println(strs[i]);
		}
		
		File[] files = file3.listFiles();
		for (int i = 0; i < files.length; i++) {
			System.out.println(files[i].getName());
		}
		//renameTo(File newName):������
		//Ҫ��file1�ļ�һ������file2�ļ�һ�������ڣ�file1������ļ�Ŀ¼��file2Ҳ�������ļ�Ŀ¼
		//file1.renameTo(file2);
	}
}
