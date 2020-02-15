package selenium4newfeatures;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class GetRectMethodConcept {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		//driver.manage().window().fullscreen();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://app.hubspot.com/login");
		
		WebElement loginbutton=driver.findElement(By.id("loginBtn"));
		//selenium 3:
		Dimension loginbuttonDim=loginbutton.getSize();
		System.out.println(loginbuttonDim.getHeight());
		System.out.println(loginbuttonDim.getWidth());
		
		Point p=loginbutton.getLocation();
		System.out.println(p.getX());
		System.out.println(p.getY());
		
		//selenium 4:
		Rectangle loginbuttonRect=loginbutton.getRect();
		System.out.println(loginbuttonRect.getHeight());
		System.out.println(loginbuttonRect.getWidth());
		
		System.out.println(loginbuttonRect.getX());
		System.out.println(loginbuttonRect.getY());
		//document.getElementById("loginBtn").getBoundingClienRect();
		//search in webpage console 
		driver.quit();

	}

}
