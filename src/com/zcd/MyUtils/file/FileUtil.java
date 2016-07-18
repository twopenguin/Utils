package com.zcd.MyUtils.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * 测试FileUtil这个工具类
 * @author duanji
 *
 */
public class FileUtil {

	/**
	 * 根据传入的文件地址，返回这个文件的String
	 * @param url
	 * @return 文件的字符串
	 * @throws IOException 
	 */
	public static String readFile(String url) throws IOException{
		File file = new File(url);
		FileReader reader = new FileReader(file);
		BufferedReader bufferedReader = new BufferedReader(reader);
		String str = null;
		StringBuffer sb = new StringBuffer();
		while((str=bufferedReader.readLine())!=null){
			sb.append(str).append("\n");
		}
		bufferedReader.close();
		reader.close();
		return sb.toString();
	}
	
	
	
}
