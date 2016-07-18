package com.zcd.MyUtils.elseclass;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

import com.zcd.MyUtils.file.FileUtil;

public class TestAnalysisSourceCode {

	/**
	 * 测试提前 import 语句
	 * @throws IOException 
	 */
	@Test
	public void testAnalysisImport() throws IOException{
		String url = "E:/a.txt";
		String string =  FileUtil.readFile(url);
		System.out.println(string);
		Pattern p = Pattern.compile("(\\().*(\\))"); // 正则表达式
		// \{(.|\s)+\}
		Matcher matcher = p.matcher(string);
		List<String> results = new ArrayList<String>();
		while(matcher.find()){
			results.add(matcher.group());
			System.out.println(matcher.group());
		}
		System.out.println(results);
		String temp = string.replaceAll("	", "$2");
		System.out.println(temp);
	}
	
	@Test
	public void testRege(){
//		String a = "单a人房B";
//		System.out.println(a.replaceAll("[a-z]|[A-B]", ""));
//		String a = "豪华套房(一套一) 海景套一房一厅";
//		System.out.println(a.replaceAll("(\\()(.*)(套一)(.*)(\\))", "$2$3$4"));
		
//		String a = "豪华套房(一套687m) 海景套一房一厅(dsfa)";
//		System.out.println(a.replaceAll("(\\()(.*)([0-9]*)(m|M|米)(.*)(\\))", "$2$3$4"));
		
//		String a = "豪华套房(一套一) 复式榻榻米大床房(带2332阳台)";
//		System.out.println(a.replaceAll("(\\()(([\u4e00-\u9fa5]|[a-z]|[0-9]|[A-B])*)(露台|阳台)(\\))", ""));
//		String a = "豪华套房(一套一) 商务房A(大床) jdaslfkj";
//		System.out.println(a.replaceAll("(\\()([^(大床)])(\\))", ""));
	
//		String a = "豪华套房(一套一) 商务房A(大床) jdaslfkj";
//		System.out.println(a.replaceAll("(\\()([^(大床)])(\\))", ""));
		
//		String a = "豪华套房(早餐故事) 商务房A(早) jdas(餐0)lfkj";
//		System.out.println(a.replaceAll("(\\()(.*?)(早|餐)(\\))", ""));
//		
//		String b = "(ab)(baadasf)(c)(d)(E)";
//		System.out.println(b.replaceAll("\\((.*?)\\)", "O"));
//		
//		String c = "alaskfjl我(asdf) 大海(asdfasd) 阿斯顿发送到";
//		System.out.println(c.replaceAll("\\((.*?)\\)", "O"));
		
		String d = "豪华套房(一房一厅) 商务房A(早) jdas(餐0)lfkj";
		System.out.println(d.replaceAll("(\\()(.*?)((.*?)(房|居|室|卧|)(.*?)厅|卧室|地下室|套一|套二)(.*?)(\\))", "O"));
	}
}
