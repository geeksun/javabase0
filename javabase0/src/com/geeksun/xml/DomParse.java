package com.geeksun.xml;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * @author geeksun
 *  dom parse xml
 */
public class DomParse {
	public DomParse() {
		  try
		  {
		   // �õ�DOM�������Ĺ���ʵ��
		   DocumentBuilderFactory docfcty = DocumentBuilderFactory.newInstance();
		   // ��DOM������ý�����
		   DocumentBuilder dombuilder = docfcty.newDocumentBuilder();
		   // ���ļ�ת��Ϊ������
		   InputStream in = new FileInputStream("book.xml");
		   Document doc=dombuilder.parse(in);
		   
		   // �õ���Ԫ��
		   Element root=doc.getDocumentElement();
		   
		   // ��������ӽڵ�
		   NodeList books=root.getChildNodes();
		   
		   if(books != null)
		   {
		    System.out.println("books.length===========" + books.getLength());
		    List nodeList = new ArrayList();
		    
		    // ѭ���ڵ�
		    //for(int i = 0; i < books.getLength(); i++)
		    //{
		     //get item No.2 attributes
		     Node book = books.item(1);
		     if(book.getNodeType() == Node.ELEMENT_NODE) // ELEMENT_NODE�ǽڵ�����
		     {
		      // ��ýڵ�����ֵ
		      String email = book.getAttributes().getNamedItem("email").getNodeValue();
		      System.out.println("email=========" + email);
		      // ѭ���ӽڵ�
		      for(Node node = book.getFirstChild(); node != null; node = node.getNextSibling())
		      {
		       if(node.getNodeType() == Node.ELEMENT_NODE)
		       {
		        String name = "";
		        String price = "";
		        // ȡ��name�ڵ��ֵ
		        if(node.getNodeName().equals("name"))
		        {
		         name = node.getFirstChild().getNodeValue();
		         System.out.println("name=============" + name);
		        }
		        // ȡ��price�ڵ��ֵ
		        if(node.getNodeName().equals("price"))
		        {
		         price = node.getFirstChild().getNodeValue();
		         System.out.println("price==========" + price);
		        }
		        // ��ȡ���ӽڵ�������飨��Ϊһ����¼�洢��
		        String []strArr = {name, price};
		        // ��������뼯��
		        nodeList.add(strArr);
		       }
		      }
		      System.out.println("nodelist.size=========" + nodeList.size());
		     }
		    }
		   //}
		  }
		  catch(Exception e)
		  {
		   e.printStackTrace();
		  }
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new DomParse();
	}

}
