package com.geeksun.excel;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import jxl.Workbook;
import jxl.format.UnderlineStyle;
import jxl.write.Boolean;
import jxl.write.Label;
import jxl.write.Number;
import jxl.write.NumberFormat;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class JxlExcelOperate {
	
	public static void main(String[] args) throws IOException, RowsExceededException, WriteException {
		//  new create one xls file
		OutputStream os=new FileOutputStream("D:\\excel2.xls");
		//  ���������ļ�
		WritableWorkbook wwb = Workbook.createWorkbook(os);  
		//  ����һ��sheet����ǰ�����ݷֿ�,����1Ϊsheet��,2Ϊsheet��
		WritableSheet ws = wwb.createSheet("Test Sheet 1", 0); 
		
		WritableFont wf = new jxl.write.WritableFont(WritableFont.TIMES, 18, WritableFont.BOLD, true); 
		WritableCellFormat wcfF =  new jxl.write.WritableCellFormat(wf); 
		Label labelC = new Label(0, 0, "This is a Label cell",wcfF); 
		ws.addCell(labelC); 
		
		NumberFormat nf = new jxl.write.NumberFormat("#.##"); 
		WritableCellFormat wcfN = new jxl.write.WritableCellFormat(nf); 	
		Number labelNF = new jxl.write.Number(1, 1, 3.1415926, wcfN); 
		ws.addCell(labelNF); 
		
		Boolean labelB = new jxl.write.Boolean(0, 2, false); 
		ws.addCell(labelB); 
		
		jxl.write.DateTime labelDT = new jxl.write.DateTime(0, 3, new java.util.Date()); 
		ws.addCell(labelDT); 
		
		jxl.write.DateFormat df = new jxl.write.DateFormat("dd MM yyyy hh:mm:ss"); 
		jxl.write.WritableCellFormat wcfDF = new jxl.write.WritableCellFormat(df); 
		jxl.write.DateTime labelDTF = new jxl.write.DateTime(1, 3, new java.util.Date(), wcfDF); 
		ws.addCell(labelDTF); 
		
		jxl.write.WritableFont wfc = new jxl.write.WritableFont(WritableFont.ARIAL, 10, WritableFont.NO_BOLD, 
				false,UnderlineStyle.NO_UNDERLINE, jxl.format.Colour.RED); 
		jxl.write.WritableCellFormat wcfFC = new jxl.write.WritableCellFormat(wfc); 

		jxl.write.WritableFont wfc1 = new jxl.write.WritableFont(WritableFont.ARIAL,20,WritableFont.BOLD,
				false,UnderlineStyle.NO_UNDERLINE,jxl.format.Colour.GREEN); 
		
		jxl.write.WritableCellFormat wcfFC1 = new jxl.write.WritableCellFormat(wfc); 
		wcfFC.setBackground(jxl.format.Colour.RED);//���õ�Ԫ�����ɫΪ��ɫ 
		labelC = new jxl.write.Label(6,0,"i love china",wcfFC); 
		   
	}

}
