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
		//JDOM����Ҫָ��ʹ��ʲô������-->Ĭ�ϵĽ����� 
		SAXBuilder builder = new SAXBuilder(false);
		try {
			//�õ�Document�������Ժ�Ҫ���е����в������Ƕ����Document�����ģ�
			Document doc = builder.build(xmlpath);
			//�õ���Ԫ�أ�
			Element pps = doc.getRootElement();
			String id = pps.getAttributeValue("id");
			
			//�õ�Ԫ�أ��ڵ㣩�ļ��ϣ� 
			List ppslist = pps.getChildren("pp");
			System.out.println("ppslist=="+ppslist.size());
			//��ѭList����  //for (int i=0;i<pplist.size();i++) {
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
				//ȡ��Ԫ�ص�����
				/*String email = book.getAttributeValue("email");
				System.out.println(email);
				//ȡ��Ԫ�ص���Ԫ�أ�Ϊ��Ͳ�Ԫ�أ���ֵ�� 
				String name = book.getChildTextTrim("name");
				System.out.println(name);
				//�ı�Ԫ�أ�Ϊ��Ͳ�Ԫ�أ���ֵ�� 
				book.getChild("name").setText("alterrjzjh");
			}*/
			//����Document���޸ĵ�XML�ļ��У� 
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
