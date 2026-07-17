package com.learnautomation.playwright.utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtil {

	public static Object[][] getSheetData(String sheetName) {

		try {
			FileInputStream fis = new FileInputStream("src\\main\\resources\\testdata\\LoginData.xlsx");
			Workbook workbook = WorkbookFactory.create(fis);
			Sheet sheet = workbook.getSheet(sheetName);
			DataFormatter formatter = new DataFormatter();

			int rows = sheet.getPhysicalNumberOfRows();
			int cols = sheet.getRow(0).getLastCellNum()-1;

			Object[][] data = new Object[rows - 1][cols];

			for (int i = 1; i < rows; i++) {
				for (int j = 0; j < cols; j++) {

					Cell cell = sheet.getRow(i).getCell(j);
					data[i - 1][j] = cell == null ? "" : formatter.formatCellValue(cell);
				}
			}

			workbook.close();

			return data;

		} catch (Exception e) {
			throw new RuntimeException(e);

		}
	}

	public static void writeResult(String sheetName, int rowNum, int colNum, String result) {

		try {
			FileInputStream fis = new FileInputStream("src\\main\\resources\\testdata\\LoginData.xlsx");
			Workbook workbook = WorkbookFactory.create(fis);
			fis.close();

			Sheet sheet = workbook.getSheet(sheetName);
			Row row = sheet.getRow(rowNum);
			if (row == null) {
				row = sheet.createRow(rowNum);
			}

			Cell cell = row.getCell(colNum);
			if (cell == null) {
				cell = row.createCell(colNum);
			}

			cell.setCellValue(result);

			FileOutputStream fos = new FileOutputStream("src\\main\\resources\\testdata\\LoginData.xlsx");
			workbook.write(fos);
			fos.close();
			workbook.close();

		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
