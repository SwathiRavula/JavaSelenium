package com.test.selenium;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class ApachePOIExample {
	public static void main(String[] args) throws FileNotFoundException {
		
		
		//obtaining input bytes from a file  
		FileInputStream fis=new FileInputStream(new File("C:\\demo\\student.xls"));  
		//creating workbook instance that refers to .xls file  
		try {
			HSSFWorkbook wb=new HSSFWorkbook(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}   
		
		
		
		
	}

}
