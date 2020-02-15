package downloadFileHandle;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

//import static org.hamcrest.CoreMatchers.*;
//import static org.hamcrest.MatcherAssert.assertThat;

public class DownloadFileSmartUsingChrome {
 
	WebDriver driver;
	File folder;
	
	@BeforeMethod
	public void setUp() {
		//88889-99898-909090-989888-099908 (UUID like this)
		folder = new File(UUID.randomUUID().toString());
		folder.mkdir();
		//chrome:
		System.setProperty("webdriver.chrome.driver","C:\\Program Files\\Java\\chromedriver_win32\\chromedriver.exe");
	    ChromeOptions options=new ChromeOptions();
	    
	    Map<String, Object> perfs= new HashMap<String, Object>();
	    perfs.put("profile.default_content_settings.popups",0);//should be 0 popups
	    perfs.put("download.default_directory", folder.getAbsolutePath());
	    
	    options.setExperimentalOption("prefs", perfs);
	    DesiredCapabilities cap= new DesiredCapabilities();
	    cap.setCapability(ChromeOptions.CAPABILITY, options);
		driver=new ChromeDriver(cap);
	}
	
	@Test
	public void downloadFileTest() throws InterruptedException {
		driver.get("http://the-internet.herokuapp.com/download");
		//driver.findElement(By.cssSelector(".example a")).click();
		driver.findElement(By.linkText("some-file.txt")).click();
		
		//wait for 2 secs to download the file
		Thread.sleep(2000);
		File listoffile[]=folder.listFiles();
		//make sure the directory is not empty
		//Assert.assertEquals(listoffile.length, is(not(0)));
		Assert.assertTrue(listoffile.length>0);
		
		for(File file: listoffile) {
			//make sure the downloaded file is not empty
			//Assert.assertEquals(file.length(), is(not((long)0)));
			Assert.assertTrue(file.length()>0);
		}
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
		for(File file: folder.listFiles()) {
			file.delete();
		}
		folder.delete();
	}

	
	
}
