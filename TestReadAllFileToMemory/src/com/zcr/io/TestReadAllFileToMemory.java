package com.zcr.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * 将文件一次行读取到内存
 * 
 * @author zcr
 * 
 */
public class TestReadAllFileToMemory
{
	public static void main(String[] args)
	{
		/*File file = new File("C:\\soft\\java\\tomcat\\apache-tomcat-7.0.40\\webapps\\appDataGenerate\\log4j\\lepai_recognize_cache.log"); // 我的文件在C盘下
		// String content=readToString(file);
		System.out.println(readToString(file));*/
		
		List<String> stringList = readTxtFileIntoStringArrList("C:\\soft\\java\\tomcat\\apache-tomcat-7.0.40\\webapps\\appDataGenerate\\log4j\\lepai_recognize_cache.log");
		
		System.out.println("-------使用BufferedReader读取-----------");
		for(String str : stringList)
		{
			System.out.println(str);
		}
		
		System.out.println("\n---------使用byte直接缓存整个文件到内存----------------");
		
		String[] stringArr = readToString("C:\\soft\\java\\tomcat\\apache-tomcat-7.0.40\\webapps\\appDataGenerate\\log4j\\lepai_recognize_cache.log");
		for(int i = 0 ; i < stringArr.length ; i ++)
		{
			System.out.println(stringArr[i]);
		}
		
		
	}

	/**
	 * 读取filePath的文件，将文件中的数据按照行读取到String数组中
	 * @param filePath	文件的路径
	 * @return			文件中一行一行的数据
	 */
	public static String[] readToString(String filePath)
	{
		File file = new File(filePath);
		Long filelength = file.length(); // 获取文件长度
		byte[] filecontent = new byte[filelength.intValue()];
		try
		{
			FileInputStream in = new FileInputStream(file);
			in.read(filecontent);
			in.close();
		} catch (FileNotFoundException e)
		{
			e.printStackTrace();
		} catch (IOException e)
		{
			e.printStackTrace();
		}
		
		String[] fileContentArr = new String(filecontent).split("\r\n");
		
		return fileContentArr;// 返回文件内容,默认编码
	}
	
	
	
	
	
	/**
	 * 功能：Java读取txt文件的内容 步骤：1：先获得文件句柄 2：获得文件句柄当做是输入一个字节码流，需要对这个输入流进行读取
	 * 3：读取到输入流后，需要读取生成字节流 4：一行一行的输出。readline()。 备注：需要考虑的是异常情况
	 * 
	 * @param filePath
	 *            文件路径[到达文件:如： D:\aa.txt]
	 * @return 将这个文件按照每一行切割成数组存放到list中。
	 */
	public static List<String> readTxtFileIntoStringArrList(String filePath)
	{
		List<String> list = new ArrayList<String>();
		try
		{
			String encoding = "GBK";
			File file = new File(filePath);
			if (file.isFile() && file.exists())
			{ // 判断文件是否存在
				InputStreamReader read = new InputStreamReader(
						new FileInputStream(file), encoding);// 考虑到编码格式
				BufferedReader bufferedReader = new BufferedReader(read);
				String lineTxt = null;

				while ((lineTxt = bufferedReader.readLine()) != null)
				{
					list.add(lineTxt);
				}
				bufferedReader.close();
				read.close();
			}
			else
			{
				System.out.println("找不到指定的文件");
			}
		}
		catch (Exception e)
		{
			System.out.println("读取文件内容出错");
			e.printStackTrace();
		}

		return list;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
