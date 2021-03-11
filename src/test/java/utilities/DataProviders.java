package utilities;

import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;

public class DataProviders {

	@DataProvider(name = "meveroApp")
	public static Object[][] getDataSuite1(Method m) {
		System.out.println("test.......");
		System.out.println(m.getName());
		
		ExcelReader excel = new ExcelReader(Constants.SUITE2_XL_PATH);
		String testcase = m.getName();
		System.out.println(testcase);
		return DataUtil.getData(testcase, excel);

	}

}
