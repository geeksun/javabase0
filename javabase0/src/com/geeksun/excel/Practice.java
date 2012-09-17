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
	 * 一个Excel文件的层次：Excel文件->工作表->行->单元格 
	 * 对应到POI中，为：workbook->sheet->row->cell 
	 */ 
	
	public static String outputFile = "e:\\test.xls"; 				//  输出文件
	public static String fileToBeRead = "e:\\test.xls"; 
	
	/**
	 *  生成 Excel 表格
	 */
	public void createExcel() 
	{ 
	        try 
	        { 
	            // 创建新的Excel 工作簿 
	            HSSFWorkbook workbook = new HSSFWorkbook(); 
	            // 在Excel工作簿中建一工作表，其名为缺省值 
	            // 如要新建一名为"效益指标"的工作表，其语句为： 
	            HSSFSheet sheet = workbook.createSheet("效益指标"); 
	            
	            HSSFRow row = sheet.createRow((short)0); 
	            //在索引 0 的位置创建单元格（左上端） 
	            HSSFCell cell = row.createCell((short)0); 
	            
	            // 定义单元格为字符串类型 
	            cell.setCellType(HSSFCell.CELL_TYPE_STRING); 
	            
	            // 在单元格中输入一些内容 
	            cell.setCellValue("POI Excel Model"); 
	            
	            //  指针指向下一列
	            row = sheet.createRow((short)0);
	            cell = row.createCell((short)4);
	            
	            //  设置要写入的单元格数
	            //cell.setCellNum((short) 5);
	            cell.setCellValue("姜志强");
	            
	            //  指向表格的下一行 
	            row=sheet.createRow((short)1); 
	            cell=row.createCell((short)0); 

	            //设置单元格内容 
	            cell.setCellValue("Powered by 夏天"); 

	            // 新建一输出文件流,用来向文件写入字节数据(图像数据)的字节流 
	            FileOutputStream fOut = new FileOutputStream(outputFile); 

	            // 把相应的Excel 工作簿存盘 
	            workbook.write(fOut); 
	            // 刷新输出流文件,强制写入缓冲的字节
	            fOut.flush(); 
	            // 操作结束，关闭文件 
	            fOut.close(); 
	            System.out.println("文件生成..."); 
	        } 
	        catch(Exception e) 
	        { 
	            System.out.println("已运行 createExcel() : " + e); 
	        } 
	    } 
	
	    /**
	     *  读取 Excel 文件的内容, Read Handle
	     */
	
	    public void readExcel() 
	    { 
	        try 
	        { 
	            // 创建对 Excel 工作簿文件的引用 
	            HSSFWorkbook workbook = new HSSFWorkbook(new FileInputStream(fileToBeRead)); 
	            System.out.println("===SheetsNum===" + workbook.getNumberOfSheets());
	            //  获取 sheet 工作表的数量 
	            for(int numSheets = 0; numSheets < workbook.getNumberOfSheets(); numSheets++) 
	            { 
	                if(null != workbook.getSheetAt(numSheets)) 
	                { 
	                	//  获得一个 sheet 工作表对象
	                    HSSFSheet aSheet = workbook.getSheetAt(numSheets); 
	                    //  判断工作表中的行数
	                    for(int rowNumOfSheet = 0; rowNumOfSheet <= aSheet.getLastRowNum(); rowNumOfSheet++) 
	                    { 
	                        if(null != aSheet.getRow(rowNumOfSheet)) 
	                        { 
	                        	//  获得工作表中的一行
	                            HSSFRow aRow = aSheet.getRow(rowNumOfSheet); 
	                            
	                            for(short cellNumOfRow = 0; cellNumOfRow <= aRow.getLastCellNum(); cellNumOfRow++) 
	                            { 
	                                if(null != aRow.getCell(cellNumOfRow)) 
	                                { 
	                                	//  获得一行中的一个单元
	                                    HSSFCell aCell = aRow.getCell(cellNumOfRow); 
	                                    //  输出单元中的内容,读取顺序:先左右,后上下
	                                    String temp = aCell.getStringCellValue();
	                                    if(temp.equals("姜志强")){
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
	        //  调出对话框，它显示使用由 messageType(1) 参数确定的默认图标的 message
	        JOptionPane.showMessageDialog(null,"文件写入成功","POI",1); 
	        
	        poi.readExcel(); 
	        JOptionPane.showMessageDialog(null,"文件读取成功","POI",1); 
	    } 
	} 

