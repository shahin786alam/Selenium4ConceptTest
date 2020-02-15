package downloadFileHandle;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

public class DownloadFileUsingFirefox {

	public static void main(String[] args) {
		
		//Additional settings for firefox drowser
		//mime type url: https://www.sitepoint.com/mime-types-complete-list/
		FirefoxProfile profile=new FirefoxProfile();
		profile.setPreference("browser.helperApps.neverAsk.saveToDisk","Text/plain,application/pdf");//Mine type
		profile.setPreference("browser.download.manager.showWhenStarting", false);
		profile.setPreference("pdfjs.disabled", true);//Only for pdf file
		
		FirefoxOptions option=new FirefoxOptions();
		option.setProfile(profile);
		
		System.setProperty("webdriver.gecko.driver","C:\\Program Files\\Java\\geckodriver.exe");
        WebDriver driver=new FirefoxDriver(option);
        
        driver.get("http://demo.automationtesting.in/FileDownload.html");
		//download text file:
		driver.findElement(By.id("textbox")).sendKeys("Testing File");
		driver.findElement(By.id("createTxt")).click();//Generate file button
		driver.findElement(By.id("link-to-download")).click();//click on download link
		
		//Download pdf file:
		driver.findElement(By.id("pdfbox")).sendKeys("Testing pdf files");
		driver.findElement(By.id("createPdf")).click();//click on Generate PDF button
		driver.findElement(By.id("pdf-link-to-download")).click();//click on download link
	}

}
