package selenium4newfeatures;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TakesElementScreenshot {

	public static void main(String[] args) throws IOException {
	  
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://app.hubspot.com/login");
		
		WebElement email=driver.findElement(By.id("username"));
		WebElement password=driver.findElement(By.id("password"));
		WebElement loginbttun=driver.findElement(By.id("loginBtn"));
		WebElement forgotpwd=driver.findElement(By.linkText("Forgot my password"));
		email.sendKeys("ariyan@yahoo.com");
		password.sendKeys("jain1232345");
		
		drawBorder(email,driver);
		takeElementScreenshot(email, "emailelement");
		drawBorder(password,driver);
		takeElementScreenshot(password, "passwordelement");
		drawBorder(loginbttun,driver);
		takeElementScreenshot(loginbttun, "loginelement");
		drawBorder(forgotpwd,driver);
		takeElementScreenshot(forgotpwd, "forgotpwdlink");
		
		driver.quit();

	}
	
	public static void takeElementScreenshot(WebElement element, String filename) {
		File file=element.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(file, new File("./target/Screenshots/"+filename+".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void drawBorder(WebElement element, WebDriver driver){
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].style.border='3px solid red'", element);
	}

}
