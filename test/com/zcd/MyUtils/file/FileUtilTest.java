package com.zcd.MyUtils.file;

import java.io.IOException;

import org.junit.Test;


public class FileUtilTest{

	@Test
	public void testReadFile() throws IOException {
		String url = "E:/workspace/CheckTableInfo/src/com/better517na/TableInfoCheck/business/impl/BaseBusinessImpl.java";
		String string =  FileUtil.readFile(url);
		System.out.println(string);
	}

}
