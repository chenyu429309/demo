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
 * ���ļ�һ���ж�ȡ���ڴ�
 * 
 * @author zcr
 * 
 */
public class TestReadAllFileToMemory
{
	public static void main(String[] args)
	{
		/*File file = new File("C:\\soft\\java\\tomcat\\apache-tomcat-7.0.40\\webapps\\appDataGenerate\\log4j\\lepai_recognize_cache.log"); // �ҵ��ļ���C����
		// String content=readToString(file);
		System.out.println(readToString(file));*/
		
		List<String> stringList = readTxtFileIntoStringArrList("C:\\soft\\java\\tomcat\\apache-tomcat-7.0.40\\webapps\\appDataGenerate\\log4j\\lepai_recognize_cache.log");
		
		System.out.println("-------ʹ��BufferedReader��ȡ-----------");
		for(String str : stringList)
		{
			System.out.println(str);
		}
		
		System.out.println("\n---------ʹ��byteֱ�ӻ��������ļ����ڴ�----------------");
		
		String[] stringArr = readToString("C:\\soft\\java\\tomcat\\apache-tomcat-7.0.40\\webapps\\appDataGenerate\\log4j\\lepai_recognize_cache.log");
		for(int i = 0 ; i < stringArr.length ; i ++)
		{
			System.out.println(stringArr[i]);
		}
		
		
	}

	/**
	 * ��ȡfilePath���ļ������ļ��е����ݰ����ж�ȡ��String������
	 * @param filePath	�ļ���·��
	 * @return			�ļ���һ��һ�е�����
	 */
	public static String[] readToString(String filePath)
	{
		File file = new File(filePath);
		Long filelength = file.length(); // ��ȡ�ļ�����
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
		
		return fileContentArr;// �����ļ�����,Ĭ�ϱ���
	}
	
	
	
	
	
	/**
	 * ���ܣ�Java��ȡtxt�ļ������� ���裺1���Ȼ���ļ���� 2������ļ��������������һ���ֽ���������Ҫ��������������ж�ȡ
	 * 3����ȡ������������Ҫ��ȡ�����ֽ��� 4��һ��һ�е������readline()�� ��ע����Ҫ���ǵ����쳣���
	 * 
	 * @param filePath
	 *            �ļ�·��[�����ļ�:�磺 D:\aa.txt]
	 * @return ������ļ�����ÿһ���и�������ŵ�list�С�
	 */
	public static List<String> readTxtFileIntoStringArrList(String filePath)
	{
		List<String> list = new ArrayList<String>();
		try
		{
			String encoding = "GBK";
			File file = new File(filePath);
			if (file.isFile() && file.exists())
			{ // �ж��ļ��Ƿ����
				InputStreamReader read = new InputStreamReader(
						new FileInputStream(file), encoding);// ���ǵ������ʽ
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
				System.out.println("�Ҳ���ָ�����ļ�");
			}
		}
		catch (Exception e)
		{
			System.out.println("��ȡ�ļ����ݳ���");
			e.printStackTrace();
		}

		return list;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
