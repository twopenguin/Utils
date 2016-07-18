package com.zcd.MyUtils.xml;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import org.dom4j.Element;

public class ObjectFactory {

	private Queue<Element> elementsQueue = new LinkedList<Element>();
	
	private List<Obj> objs = new ArrayList<Obj>();
	

	
	public void treeWalk(Element element) {
		Obj obj = new Obj();
//		List<Field> fields
 		List<Element> elements = element.elements();
		for(Element element2:elements){
			if(!element2.isTextOnly()){
				treeWalk(element2);
//				elementsQueue.
			}
		}
	}
	
}
