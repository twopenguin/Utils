package com.zcd.MyUtils.xml;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.TreeSet;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class ObjectFactory {

	private static Queue<Element> elementsQueue = new LinkedList<Element>();

	private static  TreeSet<Obj> objs = new TreeSet<Obj>();

	public static void treeWalk(Document document) {
		elementsQueue.add(document.getRootElement());
		while (!elementsQueue.isEmpty()) {
			TreeSet<Field> fields = new TreeSet<>();
			Element element = elementsQueue.poll();
			Obj obj = new Obj();
			obj.setObjName(element.getName());
			List<Element> elements = element.elements();
			for (Element element2 : elements) {
				Field field = new Field();
				field.setCurrentElement(element2);
				field.setParentElement(element);
				field.setFieldName(element2.getName());
				if (!element2.isTextOnly()) {
					elementsQueue.add(element2);
					field.setHasSon(true);
				} else {
					field.setHasSon(false);
				}
				fields.add(field);
			}
			obj.setFields(fields);
			objs.add(obj);
		}
		System.out.println(objs.size());
		System.out.println("finished!");
		System.out.println(objs);
	}
	
	public static void main(String[] args) throws DocumentException, IOException {
		SAXReader reader = new SAXReader();
		Document document = reader.read(new File("D:/csdn.xml"));
		treeWalk(document);
		writeToFile();
	}
	
	public static void writeToFile() throws IOException{
		String baseUrl ="D:/Objects/";
		String prifix = ".java";
		Obj[] objsArray = new Obj[objs.size()]; 
		objs.toArray(objsArray);
		for(int i=0;i<objsArray.length;i++){
			File file = new File(baseUrl+objsArray[i].getObjName()+prifix);
			file.createNewFile();
			Field[] fieldsArray = new Field[objsArray[i].getFields().size()];
			objsArray[i].getFields().toArray(fieldsArray);
			
			StringBuffer stringBuffer = new StringBuffer();
			stringBuffer.append("package com.zcd.model;").append("\n").append("\n").append("public class "+objsArray[i].getObjName() +" {\n");
			
			// 准备属性
			for(int j=0;j<fieldsArray.length ;j++){
				char[] nameArray = fieldsArray[j].getFieldName().toCharArray();
				nameArray[0] += 32;
				String lowerName = new String(nameArray);
				if(fieldsArray[j].getHasSon()==false){
					stringBuffer.append("private String "+lowerName +";\n");
				}else {
					stringBuffer.append("private "+fieldsArray[j].getFieldName()+" " +lowerName +";\n");
				}
				stringBuffer.append("\n");
			}
			
			// 准备getter and setter
			for(int j=0;j<fieldsArray.length ;j++){
				char[] nameArray = fieldsArray[j].getFieldName().toCharArray();
				nameArray[0] += 32;
				String lowerName = new String(nameArray);
				if(fieldsArray[j].getHasSon()==false){
					stringBuffer.append("public String get" +fieldsArray[j].getFieldName()+"(){\n");
					stringBuffer.append("return "+lowerName+";\n");
					stringBuffer.append("}\n");
					stringBuffer.append("\n");
					stringBuffer.append("public String set" +fieldsArray[j].getFieldName()+"(String "+lowerName+"){\n");
					stringBuffer.append("this."+lowerName+" = "+lowerName+";\n");
					stringBuffer.append("}\n");
					stringBuffer.append("\n");
				}else {
					
					stringBuffer.append("public "+fieldsArray[j].getFieldName()+" get" +fieldsArray[j].getFieldName()+"(){\n");
					stringBuffer.append("return "+lowerName+";\n");
					stringBuffer.append("}\n");
					stringBuffer.append("\n");
					stringBuffer.append("public "+fieldsArray[j].getFieldName()+" set" +fieldsArray[j].getFieldName()+"(String "+lowerName+"){\n");
					stringBuffer.append("this."+lowerName+" = "+lowerName+";\n");
					stringBuffer.append("}\n");
					stringBuffer.append("\n");
				}
			}
			stringBuffer.append("}\n");
			
			String text = stringBuffer.toString();
			
			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
			writer.write(text);
			writer.close();
		}
	}

}
