package DataProvider;

import java.lang.reflect.Method;
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

        String[] rowNames = {"EmptyField","EmptyField","invalidLogin","invalidLogin"}; // or dynamic based on row count

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
   
   @DataProvider(name = "DataStructureOptionsWithoutSignIn")
   public Object[][] homePageDrpDwnsOptions() throws Exception {
	   return new Object[][] { { "Arrays" }, { "Linked List" }, {"Stack"},{"Queue"},{"Tree"},{"Graph"} };
   }
   
   @DataProvider(name = "CodeTryEditorArray")
   public Object[][] validCodeTryEditor(Method m) throws Exception {
	   String methodName = m.getName();
	   String sheet = "";
	   String scenario="";
	   if(methodName.contains("inValidCodeTryEditor")) {
		   sheet = "TryCode";
		   scenario = "Invalid";
		   }
	   else if(methodName.contains("validCodeTryEditor")) {
		   sheet = "TryCode";
		   scenario = "Valid";
	   }
	   else if(methodName.contains("runInvalidCode")) {
		   sheet = "PracticeQns";
		   scenario = "InvalidRun";
	   }
	   else if(methodName.equals("runValidCodeSearchTheArray")) {
		   sheet = "PracticeQns";
		   scenario = "ValidRunSearch";
	   }
	   else if(methodName.contains("submitInvalidCode")) {
		   sheet = "PracticeQns";
		   scenario = "InvalidSubmit";
	   }
	   else if(methodName.equals("submitValidCodeSearchTheArray")) {
		   sheet = "PracticeQns";
		   scenario = "ValidSubmitSearch";
	   }
	   else if(methodName.equals("runValidCodeMaxConOnes")) {
		   sheet = "PracticeQns";
		   scenario = "ValidRunMax";
	   }
	   else if(methodName.equals("submitValidCodeMaxConOnes")) {
		   sheet = "PracticeQns";
		   scenario = "ValidSubmitMax";
	   }
	   else if(methodName.equals("runValidFindEvenNumber")) {
		   sheet = "PracticeQns";
		   scenario = "ValidRunFindEven";
	   }
	   else if(methodName.equals("submitValidCodeFindEvenNumber")) {
		   sheet = "PracticeQns";
		   scenario = "ValidSubmitFindEven";
	   }
	   else if(methodName.equals("runValidSqrsOfSortedArrayQtn")) {
		   sheet = "PracticeQns";
		   scenario = "RunValidSquare";
	   }
	   else if(methodName.equals("submitValidCodeSqrsOfSortedArrayQtn")) {
		   sheet = "PracticeQns";
		   scenario = "SubmitValidSquare";
	   }
	   else
	   {
		   throw new RuntimeException("Method Name not found");
	   }
	   
	   ExcelReader excel = new ExcelReader(sheet);
       List<Object[]> list = excel.getDataByScenario(scenario);
       excel.close();
       return list.toArray(new Object[0][0]);
   }
  }
