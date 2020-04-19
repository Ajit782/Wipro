package core;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Reporter;

import com.google.common.io.Files;

public class Support extends BaseTestCase{
	File srcFiler=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	
	public static void takeScreenshot(String filename) {
		Reporter.log("Capturing the snapshot of the '"+ filename+"' page ");
		
		File srcFiler=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			Files.copy(srcFiler, new File("screenshots/"+filename+".jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Reporter.log("Snapshot Captured");
	}
	
	public static String getScreenshot(String filename) {
		takeScreenshot(filename);
		return System.getProperty("user.dir")+"/screenshots/"+filename+".jpg"; 
	}
	
	
	
}
