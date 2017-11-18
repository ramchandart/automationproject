/**
 * 
 */
package com.testng.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import jxl.Sheet;
import jxl.Workbook;

/**
 * @author Raam
 *
 */
public class ExcelUtils {

	/**
	 * @param FileName
	 * @param SheetName
	 * @return
	 */
	public static String[][] readExcelData(String fileName, String sheetName) {
		String[][] testData = null;
		try {
			FileInputStream inputStream = new FileInputStream(fileName);
			Workbook wb = Workbook.getWorkbook(inputStream);
			Sheet sh = wb.getSheet(sheetName);

			int totalColumns = sh.getColumns();
			int totalRows = sh.getRows();

			testData = new String[totalRows - 1][totalColumns];

			for (int i = 1; i < totalRows; i++) {

				for (int j = 0; j < totalColumns; j++) {
					testData[i - 1][j] = sh.getCell(j, i).getContents();
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return testData;
	}
}
