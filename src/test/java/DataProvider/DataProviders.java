package DataProvider;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import Utilities.ExcelReader;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	   @DataProvider(name = "ValidloginDetails")
	    public Object[][] getLoginData() throws Exception {
		   ExcelReader excel = new ExcelReader("valid_Login");

	        List<Object[]> data = new ArrayList<>();

	        String[] rowNames = {"validLoginId"}; // or dynamic based on row count

	        for (String rowName : rowNames) {
	            Map<String, String> rowData = excel.getRowDataByRowName(rowName);
	            if (!rowData.isEmpty()) {
	                data.add(new Object[]{rowName, rowData});
	            }
	        }
	        excel.close();
	        return data.toArray(new Object[0][0]);
	    }
	   
	   @DataProvider(name = "inValidloginDetails")
	    public Object[][] getInvalidLoginData() throws Exception {
		   ExcelReader excel = new ExcelReader("Login");

	        List<Object[]> data = new ArrayList<>();

	        String[] rowNames = {"EmptyField","invalidLogin","invalidLogin"}; // or dynamic based on row count

	        for (String rowName : rowNames) {
	            Map<String, String> rowData = excel.getRowDataByRowName(rowName);
	            if (!rowData.isEmpty()) {
	                data.add(new Object[]{rowName, rowData});
	            }
	        }
	        excel.close();
	        System.out.println("Print data from excel row" +data);
	        return data.toArray(new Object[0][0]);
	    }
	  }
