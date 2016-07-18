package com.zcd.MyUtils.xml;

import java.io.File;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;

public class XMLUtil {

	Document document = DocumentHelper.createDocument();

	@Test
	public void testParseXml() throws DocumentException {
		SAXReader reader = new SAXReader();
		Document document = reader.read(new File("D:/csdn.xml"));
		Element root = document.getRootElement();
//		for (Iterator it = root.attributeIterator(); it.hasNext();) {
//			Attribute attribute = (Attribute) it.next();
//			String text = attribute.getText();
//			System.out.println(text);
//		}
		treeWalk(root, "   ");
	}

	public void treeWalk(Document document) {
		treeWalk(document.getRootElement(), "   ");
	}

	public void treeWalk(Element element,String tab) {
		List<Element> elements = element.elements();
		for(Element element2:elements){
			if(!element2.isTextOnly()){
//				System.out.println("textOnly");
				treeWalk(element2, tab+"   ");
			}
		}
	}





}
