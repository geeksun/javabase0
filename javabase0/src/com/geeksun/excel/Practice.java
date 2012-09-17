package com.geeksun.excel;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import javax.swing.JOptionPane;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

/**@category : User POI Class warehouse
 * @author Administrator
 * @explain : Java operate Excel
 */

public class Practice {
	
	/** 
	 * һ��Excel�ļ��Ĳ�Σ�Excel�ļ�->������->��->��Ԫ�� 
	 * ��Ӧ��POI�У�Ϊ��workbook->sheet->row->cell 
	 */ 
	
	public static String outputFile = "e:\\test.xls"; 				//  ����ļ�
	public static String fileToBeRead = "e:\\test.xls"; 
	
	/**
	 *  ���� Excel ���
	 */
	public void createExcel() 
	{ 
	        try 
	        { 
	            // �����µ�Excel ������ 
	            HSSFWorkbook workbook = new HSSFWorkbook(); 
	            // ��Excel�������н�һ����������Ϊȱʡֵ 
	            // ��Ҫ�½�һ��Ϊ"Ч��ָ��"�Ĺ����������Ϊ�� 
	            HSSFSheet sheet = workbook.createSheet("Ч��ָ��"); 
	            
	            HSSFRow row = sheet.createRow((short)0); 
	            //������ 0 ��λ�ô�����Ԫ�����϶ˣ� 
	            HSSFCell cell = row.createCell((short)0); 
	            
	            // ���嵥Ԫ��Ϊ�ַ������� 
	            cell.setCellType(HSSFCell.CELL_TYPE_STRING); 
	            
	            // �ڵ�Ԫ��������һЩ���� 
	            cell.setCellValue("POI Excel Model"); 
	            
	            //  ָ��ָ����һ��
	            row = sheet.createRow((short)0);
	            cell = row.createCell((short)4);
	            
	            //  ����Ҫд��ĵ�Ԫ����
	            //cell.setCellNum((short) 5);
	            cell.setCellValue("��־ǿ");
	            
	            //  ָ�������һ�� 
	            row=sheet.createRow((short)1); 
	            cell=row.createCell((short)0); 

	            //���õ�Ԫ������ 
	            cell.setCellValue("Powered by ����"); 

	            // �½�һ����ļ���,�������ļ�д���ֽ�����(ͼ������)���ֽ��� 
	            FileOutputStream fOut = new FileOutputStream(outputFile); 

	            // ����Ӧ��Excel ���������� 
	            workbook.write(fOut); 
	            // ˢ��������ļ�,ǿ��д�뻺����ֽ�
	            fOut.flush(); 
	            // �����������ر��ļ� 
	            fOut.close(); 
	            System.out.println("�ļ�����..."); 
	        } 
	        catch(Exception e) 
	        { 
	            System.out.println("������ createExcel() : " + e); 
	        } 
	    } 
	
	    /**
	     *  ��ȡ Excel �ļ�������, Read Handle
	     */
	
	    public void readExcel() 
	    { 
	        try 
	        { 
	            // ������ Excel �������ļ������� 
	            HSSFWorkbook workbook = new HSSFWorkbook(new FileInputStream(fileToBeRead)); 
	            System.out.println("===SheetsNum===" + workbook.getNumberOfSheets());
	            //  ��ȡ sheet ����������� 
	            for(int numSheets = 0; numSheets < workbook.getNumberOfSheets(); numSheets++) 
	            { 
	                if(null != workbook.getSheetAt(numSheets)) 
	                { 
	                	//  ���һ�� sheet ���������
	                    HSSFSheet aSheet = workbook.getSheetAt(numSheets); 
	                    //  �жϹ������е�����
	                    for(int rowNumOfSheet = 0; rowNumOfSheet <= aSheet.getLastRowNum(); rowNumOfSheet++) 
	                    { 
	                        if(null != aSheet.getRow(rowNumOfSheet)) 
	                        { 
	                        	//  ��ù������е�һ��
	                            HSSFRow aRow = aSheet.getRow(rowNumOfSheet); 
	                            
	                            for(short cellNumOfRow = 0; cellNumOfRow <= aRow.getLastCellNum(); cellNumOfRow++) 
	                            { 
	                                if(null != aRow.getCell(cellNumOfRow)) 
	                                { 
	                                	//  ���һ���е�һ����Ԫ
	                                    HSSFCell aCell = aRow.getCell(cellNumOfRow); 
	                                    //  �����Ԫ�е�����,��ȡ˳��:������,������
	                                    String temp = aCell.getStringCellValue();
	                                    if(temp.equals("��־ǿ")){
	                                    	System.out.println("user exits");
	                                    }else{
	                                    	System.out.println("search go");
	                                    }
	                                    
	                                } 
	                            } 
	                        } 
	                    } 
	                } 
	            } 
	        } 
	        catch(Exception e) 
	        { 
	            System.out.println("ReadExcelError" + e); 
	        } 
	    } 
	    
	    public static void main(String[] args) 
	    { 
	    	Practice poi = new Practice(); 
	        poi.createExcel(); 
	        //  �����Ի�������ʾʹ���� messageType(1) ����ȷ����Ĭ��ͼ��� message
	        JOptionPane.showMessageDialog(null,"�ļ�д��ɹ�","POI",1); 
	        
	        poi.readExcel(); 
	        JOptionPane.showMessageDialog(null,"�ļ���ȡ�ɹ�","POI",1); 
	    } 
	} 

