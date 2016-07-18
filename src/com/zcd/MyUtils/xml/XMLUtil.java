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
			System.out.println(tab+"鑷繁锛�"+element2.getPath());
			System.out.println(tab+"鑷繁锛�"+element2.getName());
			System.out.println(tab+"鐖朵翰锛�"+element2.getParent().getName());
			System.out.println(tab+"鐖朵翰锛�"+element2.getParent().getPath());
			if(!element2.isTextOnly()){
//				System.out.println("textOnly");
				treeWalk(element2, tab+"   ");
			}
		}
//		for (int i = 0, size = element.nodeCount(); i < size; i++) {
//			Node node = element.node(i);
//			if (node instanceof Element) {
//				treeWalk((Element) node);
//			} else {
//				System.out.println(":"+node.getText());
//				// do something....
//			}
//		}
	}

	// public static void main(String[] args) {
	// // TODO Auto-generated method stub
	// String source = "鎴愰兘姝︿警鍖轰竴鐜矾鍗楀洓娈�14鍙峰浼嶅ぇ鍘︿簩妤�";
	// String target = "鎴愰兘甯備竴鐜矾鍗楀洓娈�14鍙峰浼嶅ぇ鍘︿簩妤�(瑗垮崡姘戞棌澶у姝ｉ棬鏃�)";
	// int i = 0;
	//
	// // i= EditDistanceChange(source,target);
	// i = EditDistance(source, target);
	// System.out.println("闇�瑕�" + i + "娆�");
	// }

	public static void main(String[] args) {
		String s1 = "鎴愰兘姝︿警鍖轰竴鐜矾鍗楀洓娈�14鍙峰浼嶅ぇ鍘︿簩妤�";
		String s2 = "鎴愰兘甯備竴鐜矾鍗楀洓娈�14鍙峰浼嶅ぇ鍘︿簩妤�(瑗垮崡姘戞棌澶у姝ｉ棬鏃�)";
		String sub = Maxsubstring(s1, s2);
		System.out.println("Maxsubstring:" + sub);
	}

	public static String Maxsubstring(String s1, String s2) {
		String max = (s1.length() > s2.length()) ? s1 : s2;
		String min = max.equals(s1) ? s2 : s1;
		for (int i = 0; i < min.length(); i++) {
			for (int m = 0, n = min.length() - i; n != min.length() + 1; m++, n++) {
				// System.out.println(min.substring(m, n));
				String sub = min.substring(m, n);
				if (max.contains(sub)) {
					return sub;
				}
			}
		}
		return null;
	}

	// 鍔ㄦ�佽鍒掓硶
	private static int EditDistance(String source, String target) {
		char[] s = source.toCharArray();
		char[] t = target.toCharArray();
		int slen = source.length();
		int tlen = target.length();
		int d[][] = new int[slen + 1][tlen + 1];
		for (int i = 0; i <= slen; i++) {
			d[i][0] = i;
		}
		for (int i = 0; i <= tlen; i++) {
			d[0][i] = i;
		}
		for (int i = 1; i <= slen; i++) {
			for (int j = 1; j <= tlen; j++) {
				if (s[i - 1] == t[j - 1]) {
					d[i][j] = d[i - 1][j - 1];
				} else {
					int insert = d[i][j - 1] + 1;
					int del = d[i - 1][j] + 1;
					int update = d[i - 1][j - 1] + 1;
					d[i][j] = Math.min(insert, del) > Math.min(del, update) ? Math.min(del, update)
							: Math.min(insert, del);
				}
			}
		}
		return d[slen][tlen];
	}

	// 閫掑綊瀹炵幇 --- 绌蜂妇娉曪紙鏋氫妇娉曪級
	private static int EditDistanceChange(String source, String target) {
		if (target.length() != 0 && source.length() == 0) {
			return EditDistanceChange(source, target.substring(1)) + 1;
		} else if (target.length() == 0 && source.length() != 0) {
			return EditDistanceChange(source.substring(1), target) + 1;
		} else if (target.length() != 0 && source.length() != 0) {
			// 褰撴簮瀛楃绗竴涓�煎拰鐩爣瀛楃绗竴涓�肩浉鍚屾椂
			if (source.charAt(0) == target.charAt(0)) {
				return EditDistanceChange(source.substring(1), target.substring(1));
			} else {
				int insert = EditDistanceChange(source.substring(1), target) + 1;
				int del = EditDistanceChange(source, target.substring(1)) + 1;
				int update = EditDistanceChange(source.substring(1), target.substring(1)) + 1;
				return Math.min(insert, del) > Math.min(del, update) ? Math.min(del, update) : Math.min(insert, del);
			}
		} else {
			return 0;
		}
	}

}
