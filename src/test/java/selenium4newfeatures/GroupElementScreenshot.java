package selenium4newfeatures;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class GroupElementScreenshot {

	public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		//driver.manage().window().fullscreen();
		driver.manage().window().maximize();
		//driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get("https://www.w3schools.com/html/html_tables.asp");
		WebElement webtable=driver.findElement(By.id("customers"));
		File file=webtable.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file, new File("./target/Screenshots/webtable.png"));
        
//		driver.get("https://register.freecrm.com/register/");
//      //  WebElement webtable=driver.findElement(By.className("ui form"));
//        //this line get exceptions: InvalidSelectorException 
//        WebElement webtable=driver.findElement(By.cssSelector(".ui.form"));
//        File file=webtable.getScreenshotAs(OutputType.FILE);
//		FileUtils.copyFile(file, new File("./target/Screenshots/register.png"));
	    
//		driver.get("https://app.hubspot.com/signup/crm/step/user-info");
//		WebElement ele=driver.findElement(By.xpath("//form"));
//		File file=ele.getScreenshotAs(OutputType.FILE);
//		FileUtils.copyFile(file, new File("./target/Screenshots/register_hub.png"));
		driver.quit();
	}
	
}
