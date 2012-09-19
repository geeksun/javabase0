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
	 * ��ȡXML�ļ�������Ϣ
	 */
	public static Vector LoadXML(String path) throws Exception {
		Vector xmlVector = null;
		FileInputStream fi = null;
		try {
			fi = new FileInputStream(path);
			xmlVector = new Vector();
			SAXBuilder sb = new SAXBuilder();
			Document doc = sb.build(fi);
			Element root = doc.getRootElement(); // �õ���Ԫ��
			List books = root.getChildren(); // �õ���Ԫ��������Ԫ�صļ���
			Element book = null;
			XmlOperate xml = null;
			for (int i = 0; i < books.size(); i++) {
				xml = new XmlOperate();
				book = (Element) books.get(i); // �õ���һ����Ԫ��
				xml.setbookname(book.getChild("����").getText());
				xml.setauthor(book.getChild("����").getText());
				xml.setpub(book.getChild("������").getText());
				xml.setprice(book.getChild("�۸�").getText());
				xml.setpubdate(book.getChild("��������").getText());
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
	 * ɾ��XML�ļ�ָ����Ϣ
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
			Element root = doc.getRootElement(); // �õ���Ԫ��
			List books = root.getChildren(); // �õ���Ԫ��������Ԫ�صļ���
			books.remove(xmlid);// ɾ��ָ��λ�õ���Ԫ��
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
	 * ���XML�ļ�ָ����Ϣ
	 */
	public static void AddXML(HttpServletRequest request) throws Exception {
		FileInputStream fi = null;
		FileOutputStream fo = null;
		try {
			String path = request.getParameter("path");
			fi = new FileInputStream(path);
			SAXBuilder sb = new SAXBuilder();
			Document doc = sb.build(fi);
			Element root = doc.getRootElement(); // �õ���Ԫ��
			List books = root.getChildren(); // �õ���Ԫ��������Ԫ�صļ���
			String bookname = request.getParameter("bookname");
			String author = request.getParameter("author");
			String price = request.getParameter("price");
			String pub = request.getParameter("pub");
			String pubdate = request.getParameter("pubdate");
			Text newtext;
			Element newbook = new Element("��");
			Element newname = new Element("����");
			newname.setText(bookname);
			newbook.addContent(newname);
			Element newauthor = new Element("����");
			newauthor.setText(author);
			newbook.addContent(newauthor);
			Element newpub = new Element("������");
			newpub.setText(pub);
			newbook.addContent(newpub);
			Element newprice = new Element("�۸�");
			newprice.setText(price);
			newbook.addContent(newprice);
			Element newdate = new Element("��������");
			newdate.setText(pubdate);
			newbook.addContent(newdate);
			books.add(newbook);// ������Ԫ��
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
	 * �޸�XML�ļ�ָ����Ϣ
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
			Element root = doc.getRootElement(); // �õ���Ԫ��
			List books = root.getChildren(); // �õ���Ԫ��������Ԫ�صļ���
			Element book = (Element) books.get(xmlid);
			String bookname = request.getParameter("bookname");
			String author = request.getParameter("author");
			String price = request.getParameter("price");
			String pub = request.getParameter("pub");
			String pubdate = request.getParameter("pubdate");
			Text newtext;
			Element newname = book.getChild("����");
			newname.setText(bookname);// �޸�����Ϊ�µ�����
			Element newauthor = book.getChild("����");
			newauthor.setText(author);
			Element newpub = book.getChild("������");
			newpub.setText(pub);
			Element newprice = book.getChild("�۸�");
			newprice.setText(price);
			Element newdate = book.getChild("��������");
			newdate.setText(pubdate);
			//	books.set(xmlid,book);//�޸���Ԫ��
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
