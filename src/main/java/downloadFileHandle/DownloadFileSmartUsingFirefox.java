package downloadFileHandle;

import java.io.File;
import java.util.UUID;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DownloadFileSmartUsingFirefox {
	
	WebDriver driver;
	File folder;
	
	@BeforeMethod
	public void setUp() {
		//88889-99898-909090-989888-099908 (UUID like this)
		folder = new File(UUID.randomUUID().toString());
		folder.mkdir();
		//Firefox:
		FirefoxProfile profile=new FirefoxProfile();
		profile.setPreference("browser.download.dir", folder.getAbsolutePath());
		profile.setPreference("browser.download.folderList", 2);
		profile.setPreference("browser.helperApps.neverAsk.saveToDisk",
				               "image/jpeg,application/octet-stream");
		profile.setPreference("pdfjs.disabled", true);//Only for pdf file
		
		FirefoxOptions option=new FirefoxOptions();
		option.setProfile(profile);
		
		System.setProperty("webdriver.gecko.driver","C:\\Program Files\\Java\\geckodriver.exe");
	    driver=new FirefoxDriver(option);
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
