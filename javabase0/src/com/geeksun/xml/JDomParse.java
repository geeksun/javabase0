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

/**
 * @author geeksun
 *  jdom parse xml file
 */
public class JDomParse {
	public JDomParse() {
		String xmlpath = "library.xml";
		//JDOM����Ҫָ��ʹ��ʲô������-->Ĭ�ϵĽ����� 
		SAXBuilder builder = new SAXBuilder(false);
		try {
			//�õ�Document�������Ժ�Ҫ���е����в������Ƕ����Document�����ģ�
			Document doc = builder.build(xmlpath);
			//�õ���Ԫ�أ�
			Element books = doc.getRootElement();
			//�õ�Ԫ�أ��ڵ㣩�ļ��ϣ� 
			List booklist = books.getChildren("book");
			//��ѭList���� 
			for (Iterator iter = booklist.iterator(); iter.hasNext();) {
				Element book = (Element) iter.next();
				//ȡ��Ԫ�ص�����
				String email = book.getAttributeValue("email");
				System.out.println(email);
				//ȡ��Ԫ�ص���Ԫ�أ�Ϊ��Ͳ�Ԫ�أ���ֵ�� 
				String name = book.getChildTextTrim("name");
				System.out.println(name);
				//�ı�Ԫ�أ�Ϊ��Ͳ�Ԫ�أ���ֵ�� 
				book.getChild("name").setText("alterrjzjh");
			}
			//����Document���޸ĵ�XML�ļ��У� 
			XMLOutputter outputter = new XMLOutputter();
			outputter.output(doc, new FileOutputStream(xmlpath));
		} catch (JDOMException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new JDomParse();
	}
}
