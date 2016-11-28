package edu.tongji.yuexiarenjing.day15;

import java.io.File;
import java.util.Date;

import org.junit.Test;

/*
 * java.io.File类
 * 1.凡是与输入输出相关的类、接口等都定义在java.io包下
 * 2.File是一个类，可以有构造器创建其对象。此对象对应着一个文件（txt avi doc ppt MP3 jpg）或文件目录
 * 3.File类对象与平台无关
 * 4.File中的方法仅涉及到如何创建、删除、重命名等等。只要涉及文件内容的，File是无能为力的，必须由IO流来完成。
 * 5.File类的对象常作为op流的具体类的构造器的形参。
 */
public class TestFile {
	/*
	 * 路径：
	 * 绝对路径：包括盘符在内的完整的文件路径
	 * 相对路径：在当前文件目录下的文件的路径
	 * 
	 * 访问文件名
	 * getName()
	 * getPath()
	 * getAbsoluteFile() 
	 * getAbsolutePath ()
	 * getParent ()
	 * reNameTo(File newName) //将文件转移并重命名，newName这个文件必须不存在
	 * 
	 * 文件检测/获取文件信息
	 * exists()
	 * canWrite()
	 * canRead()
	 * isFile
	 * isDirectory()
	 * lastModified()
	 * length()
	 * 
	 * 文件操作相关/目录操作相关
	 * createNewFile()
	 * delete()
	 * mkDir()
	 * mkDirs()//上层文件目录不存在的情况下用
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
		//renameTo(File newName):重命名
		//要求file1文件一定存在file2文件一定不存在，file1如果是文件目录则file2也必须是文件目录
		//file1.renameTo(file2);
	}
}
