package Utilities;

import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelReader {
	
	public String[] excelDataRead(String sheetName, int rowNumber) {
		String path = System.getProperty("user.dir") + "/src/test/resources/TestData/DsAlgo_TestData.xlsx";
		String[] credentials = new String[3];
		File excelFile = new File(path);
		try {
		FileInputStream Fis = new FileInputStream(excelFile);
		XSSFWorkbook workbook = new XSSFWorkbook(Fis);
		XSSFSheet sheet = workbook.getSheet(sheetName);

		Row row = sheet.getRow(rowNumber);

		String username = getCellValue(row, 0);
		String password = getCellValue(row, 1);
		String passwordConfirmation = getCellValue(row, 2);

		workbook.close();
		Fis.close();

		
		credentials[0] = username;
		credentials[1] = password;
		credentials[2] = passwordConfirmation;
		}
		catch (Exception e) {
		e.printStackTrace();
			}

		return credentials;
		}
	
	private String getCellValue(Row row, int cellIndex) {
		Cell cell = row.getCell(cellIndex);
		if (cell == null || cell.getCellType() == CellType.BLANK) {
			return "";
		}
		if (cell.getCellType() == CellType.NUMERIC) {
			DataFormatter formatter = new DataFormatter();
			String value = formatter.formatCellValue(cell);
			return value;
		}
		if (cell.getCellType() == CellType.STRING) {
			return cell.getStringCellValue();
		}
		return "";
	}

}
