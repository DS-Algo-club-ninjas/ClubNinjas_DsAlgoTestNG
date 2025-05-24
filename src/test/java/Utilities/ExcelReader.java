package Utilities;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;

import java.io.*;
import java.util.*;


public class ExcelReader {
	
	 private XSSFSheet sheet;
	 private XSSFWorkbook workbook;
	 private FileInputStream fis;
	
	public ExcelReader(String sheetName) throws Exception {
		  String path = System.getProperty("user.dir") + "/src/test/resources/TestData/DsAlgo_TestData.xlsx";
	        fis = new FileInputStream(path);
	        workbook = new XSSFWorkbook(fis);
	        sheet = workbook.getSheet(sheetName);
	        if (sheet == null) throw new IllegalArgumentException("Sheet not found: " + sheetName);
	}
	
	// Returns credentials from a given row number
	public String[] excelDataRead(String sheetName, int rowNumber) {

		String[] credentials = new String[3];
		try {
		
		    Row row = sheet.getRow(rowNumber);
            credentials[0] = getCellValue(row, 0);
            credentials[1] = getCellValue(row, 1);
            credentials[2] = getCellValue(row, 2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return credentials;
		}
	
	//Helper: Safely gets string representation of a cell
	private String getCellValue(Row row, int cellIndex) {
		 if (row == null) return "";
	        Cell cell = row.getCell(cellIndex);
	        DataFormatter formatter = new DataFormatter();
	        return (cell != null) ? formatter.formatCellValue(cell).trim() : "";
	}
	
	//Retrieves specific row of data on value in first column
    public Map<String, String> getRowDataByRowName(String scenario) {
        Map<String, String> rowData = new HashMap<>();
        DataFormatter formatter = new DataFormatter();
        Row header = sheet.getRow(0);
        if (header == null) return rowData;

        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
            Row currentRow = sheet.getRow(i);
            if (currentRow != null) {
                String rowKey = formatter.formatCellValue(currentRow.getCell(0)).trim();
                if (scenario.equalsIgnoreCase(rowKey)) {
                    for (int j = 1; j < currentRow.getLastCellNum(); j++) {
                        String key = formatter.formatCellValue(header.getCell(j)).trim();
                        String value = formatter.formatCellValue(currentRow.getCell(j)).trim();
                        rowData.put(key, value);
                    }
                    break;
                }
            }
        }
        return rowData;
    }
    
    // Get all row names from the first column (for data-driven loops)
    public List<String> getAllRowNames() {
        List<String> names = new ArrayList<>();
        DataFormatter formatter = new DataFormatter();
        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
            Row row = sheet.getRow(i);
            if (row != null) {
                String name = formatter.formatCellValue(row.getCell(0)).trim();
                if (!name.isEmpty()) names.add(name);
            }
        }
        return names;
    }

    // Optional: Clean up workbook when done
    public void close() throws IOException {
        workbook.close();
        fis.close();
    }
    
    public List<Object[]> getDataByScenario(String scenario) {
        List<Object[]> data = new ArrayList<>();
        //int rows = sheet.getPhysicalNumberOfRows();
        int rows = sheet.getLastRowNum();
        Row headerRow = sheet.getRow(0);
        int cols = headerRow.getLastCellNum();
        for (int i = 1; i <= rows; i++) {
            Row row = sheet.getRow(i);
            Cell firstCell = row.getCell(0);
            if (firstCell != null && firstCell.getStringCellValue().equalsIgnoreCase(scenario)) {
            	Object[] rowData = new Object[cols - 1]; // exclude the scenario column
                for (int j = 1; j < cols; j++) {
                    Cell cell = row.getCell(j);
                    if (cell != null) {
                    	DataFormatter formatter = new DataFormatter();
            			rowData[j - 1] = formatter.formatCellValue(cell);
                        //rowData[j - 1] = cell.toString();
                    } else {
                        rowData[j - 1] = "";
                    }
                }
                data.add(rowData);
             }
        }	        
        return data;
    }
}
