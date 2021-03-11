package utilities;


public class CheckingRunmodes {

	public static void main(String[] args) {


		String suiteName = "MeveroAppSuite";
		
		boolean suiteRunmode = DataUtil.isSuiteRunnable(suiteName);
		System.out.println(suiteRunmode);
		
		
		/*
		 * String testCaseName = "OpenAccountTest";
		 * 
		 * boolean testRunmode = DataUtil.isTestRunnable(testCaseName, new
		 * ExcelReader(System.getProperty("user.dir")+
		 * "\\src\\test\\resources\\testdata\\"+suiteName+".xlsx"));
		 * System.out.println(testRunmode);
		 */
		
	}

}
