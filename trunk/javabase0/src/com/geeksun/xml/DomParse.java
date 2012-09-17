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
		   // 得到DOM解析器的工厂实例
		   DocumentBuilderFactory docfcty = DocumentBuilderFactory.newInstance();
		   // 从DOM工厂获得解析器
		   DocumentBuilder dombuilder = docfcty.newDocumentBuilder();
		   // 将文件转换为输入流
		   InputStream in = new FileInputStream("book.xml");
		   Document doc=dombuilder.parse(in);
		   
		   // 得到根元素
		   Element root=doc.getDocumentElement();
		   
		   // 获得所有子节点
		   NodeList books=root.getChildNodes();
		   
		   if(books != null)
		   {
		    System.out.println("books.length===========" + books.getLength());
		    List nodeList = new ArrayList();
		    
		    // 循环节点
		    //for(int i = 0; i < books.getLength(); i++)
		    //{
		     //get item No.2 attributes
		     Node book = books.item(1);
		     if(book.getNodeType() == Node.ELEMENT_NODE) // ELEMENT_NODE是节点类型
		     {
		      // 获得节点属性值
		      String email = book.getAttributes().getNamedItem("email").getNodeValue();
		      System.out.println("email=========" + email);
		      // 循环子节点
		      for(Node node = book.getFirstChild(); node != null; node = node.getNextSibling())
		      {
		       if(node.getNodeType() == Node.ELEMENT_NODE)
		       {
		        String name = "";
		        String price = "";
		        // 取得name节点的值
		        if(node.getNodeName().equals("name"))
		        {
		         name = node.getFirstChild().getNodeValue();
		         System.out.println("name=============" + name);
		        }
		        // 取得price节点的值
		        if(node.getNodeName().equals("price"))
		        {
		         price = node.getFirstChild().getNodeValue();
		         System.out.println("price==========" + price);
		        }
		        // 将取得子节点放入数组（作为一条记录存储）
		        String []strArr = {name, price};
		        // 将数组放入集合
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
