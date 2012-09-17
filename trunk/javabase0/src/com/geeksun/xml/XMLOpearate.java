package com.geeksun.xml;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.jdom.output.XMLOutputter;

public class XMLOpearate {
	/**
	 * @param xmlpath
	 * @parse XML file, return contain List
	 */
	public static List parseXml(String xmlpath){
		List list = null;
		//String xmlpath = "library.xml";
		//JDOM首先要指定使用什么解析器-->默认的解析器 
		SAXBuilder builder = new SAXBuilder(false);
		try {
			//得到Document，我们以后要进行的所有操作都是对这个Document操作的：
			Document doc = builder.build(xmlpath);
			//得到根元素：
			Element pps = doc.getRootElement();
			String id = pps.getAttributeValue("id");
			
			//得到元素（节点）的集合： 
			List ppslist = pps.getChildren("pp");
			System.out.println("ppslist=="+ppslist.size());
			//轮循List集合  //for (int i=0;i<pplist.size();i++) {
			for (Iterator iter = ppslist.iterator(); iter.hasNext();) {
				Element book = (Element) iter.next();
				List pplist = book.getChildren("pp");
				{
					for (Iterator it = pplist.iterator(); it.hasNext();){
						Element type = (Element) it.next();
						List typeList = type.getChildren("type");
						for (Iterator i = typeList.iterator(); i.hasNext();){
							Element pp = (Element) i.next();
							String name = pp.getAttributeValue("name");
							System.out.println("name=="+name);
						}
					}
				}
				//取得元素的属性
				/*String email = book.getAttributeValue("email");
				System.out.println(email);
				//取得元素的子元素（为最低层元素）的值： 
				String name = book.getChildTextTrim("name");
				System.out.println(name);
				//改变元素（为最低层元素）的值： 
				book.getChild("name").setText("alterrjzjh");
			}*/
			//保存Document的修改到XML文件中： 
			XMLOutputter outputter = new XMLOutputter();
			outputter.output(doc, new FileOutputStream(xmlpath));
		} 
		}catch (JDOMException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return list;
	}
	public static void main(String[] args) {
		parseXml("product_type.xml");
	}

}
