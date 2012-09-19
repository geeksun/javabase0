package com.base.xml;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.Text;
import org.jdom.input.SAXBuilder;
import org.jdom.output.XMLOutputter;

public class XmlOperate {
	private String bookname, author, pub, price, pubdate;

	public String getbookname() {
		return bookname;
	}

	public String getauthor() {
		return author;
	}

	public String getpub() {
		return pub;
	}

	public String getprice() {
		return price;
	}

	public String getpubdate() {
		return pubdate;
	}

	public void setbookname(String bookname) {
		this.bookname = bookname;
	}

	public void setauthor(String author) {
		this.author = author;
	}

	public void setpub(String pub) {
		this.pub = pub;
	}

	public void setprice(String price) {
		this.price = price;
	}

	public void setpubdate(String pubdate) {
		this.pubdate = pubdate;
	}

	public XmlOperate() {
	}

	/**
	 * 读取XML文件所有信息
	 */
	public static Vector LoadXML(String path) throws Exception {
		Vector xmlVector = null;
		FileInputStream fi = null;
		try {
			fi = new FileInputStream(path);
			xmlVector = new Vector();
			SAXBuilder sb = new SAXBuilder();
			Document doc = sb.build(fi);
			Element root = doc.getRootElement(); // 得到根元素
			List books = root.getChildren(); // 得到根元素所有子元素的集合
			Element book = null;
			XmlOperate xml = null;
			for (int i = 0; i < books.size(); i++) {
				xml = new XmlOperate();
				book = (Element) books.get(i); // 得到第一本书元素
				xml.setbookname(book.getChild("书名").getText());
				xml.setauthor(book.getChild("作者").getText());
				xml.setpub(book.getChild("出版社").getText());
				xml.setprice(book.getChild("价格").getText());
				xml.setpubdate(book.getChild("出版日期").getText());
				xmlVector.add(xml);
			}
		} catch (Exception e) {
			System.err.println(e + "error");
		} finally {
			try {
				fi.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return xmlVector;
	}

	/**
	 * 删除XML文件指定信息
	 */
	public static void DelXML(HttpServletRequest request) throws Exception {
		FileInputStream fi = null;
		FileOutputStream fo = null;
		try {
			String path = request.getParameter("path");
			int xmlid = Integer.parseInt(request.getParameter("id"));
			fi = new FileInputStream(path);
			SAXBuilder sb = new SAXBuilder();
			Document doc = sb.build(fi);
			Element root = doc.getRootElement(); // 得到根元素
			List books = root.getChildren(); // 得到根元素所有子元素的集合
			books.remove(xmlid);// 删除指定位置的子元素
			String indent = " ";
			boolean newLines = true;
			XMLOutputter outp = new XMLOutputter(indent, newLines, "GBK");
			fo = new FileOutputStream(path);
			outp.output(doc, fo);
		} catch (Exception e) {
			System.err.println(e + "error");
		} finally {
			try {
				fi.close();
				fo.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 添加XML文件指定信息
	 */
	public static void AddXML(HttpServletRequest request) throws Exception {
		FileInputStream fi = null;
		FileOutputStream fo = null;
		try {
			String path = request.getParameter("path");
			fi = new FileInputStream(path);
			SAXBuilder sb = new SAXBuilder();
			Document doc = sb.build(fi);
			Element root = doc.getRootElement(); // 得到根元素
			List books = root.getChildren(); // 得到根元素所有子元素的集合
			String bookname = request.getParameter("bookname");
			String author = request.getParameter("author");
			String price = request.getParameter("price");
			String pub = request.getParameter("pub");
			String pubdate = request.getParameter("pubdate");
			Text newtext;
			Element newbook = new Element("书");
			Element newname = new Element("书名");
			newname.setText(bookname);
			newbook.addContent(newname);
			Element newauthor = new Element("作者");
			newauthor.setText(author);
			newbook.addContent(newauthor);
			Element newpub = new Element("出版社");
			newpub.setText(pub);
			newbook.addContent(newpub);
			Element newprice = new Element("价格");
			newprice.setText(price);
			newbook.addContent(newprice);
			Element newdate = new Element("出版日期");
			newdate.setText(pubdate);
			newbook.addContent(newdate);
			books.add(newbook);// 增加子元素
			String indent = " ";
			boolean newLines = true;
			XMLOutputter outp = new XMLOutputter(indent, newLines, "GBK");
			fo = new FileOutputStream(path);
			outp.output(doc, fo);
		} catch (Exception e) {
			System.err.println(e + "error");
		} finally {
			try {
				fi.close();
				fo.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 修改XML文件指定信息
	 */
	public static void EditXML(HttpServletRequest request) throws Exception {
		FileInputStream fi = null;
		FileOutputStream fo = null;
		try {
			String path = request.getParameter("path");
			int xmlid = Integer.parseInt(request.getParameter("id"));
			fi = new FileInputStream(path);
			SAXBuilder sb = new SAXBuilder();
			Document doc = sb.build(fi);
			Element root = doc.getRootElement(); // 得到根元素
			List books = root.getChildren(); // 得到根元素所有子元素的集合
			Element book = (Element) books.get(xmlid);
			String bookname = request.getParameter("bookname");
			String author = request.getParameter("author");
			String price = request.getParameter("price");
			String pub = request.getParameter("pub");
			String pubdate = request.getParameter("pubdate");
			Text newtext;
			Element newname = book.getChild("书名");
			newname.setText(bookname);// 修改书名为新的书名
			Element newauthor = book.getChild("作者");
			newauthor.setText(author);
			Element newpub = book.getChild("出版社");
			newpub.setText(pub);
			Element newprice = book.getChild("价格");
			newprice.setText(price);
			Element newdate = book.getChild("出版日期");
			newdate.setText(pubdate);
			//	books.set(xmlid,book);//修改子元素
			String indent = " ";
			boolean newLines = true;
			XMLOutputter outp = new XMLOutputter(indent, newLines, "GBK");
			fo = new FileOutputStream(path);
			outp.output(doc, fo);
		} catch (Exception e) {
			System.err.println(e + "error");
		} finally {
			try {
				fi.close();
				fo.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) throws Exception {
		Vector vec = LoadXML("D:\\workspace\\ms\\WebRoot\\xml\\book.xml");
		for(int i=0;i<vec.size();i++){
			System.out.println(vec.get(i)); 
		}
		
	}

}
