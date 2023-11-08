package genericLibraries;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryImplementation implements IRetryAnalyzer {
	int maxRetries=3;
	int Count=0;
	@Override
	public boolean retry(ITestResult result) {
		if(Count<maxRetries) {
			Count++;
			return true;
		}
		return false;
	}

}
