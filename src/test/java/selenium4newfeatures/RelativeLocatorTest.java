package selenium4newfeatures;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class RelativeLocatorTest {
	WebDriver driver;
	@BeforeClass
	public void setup() {
		WebDriverManager.chromedriver().setup();
	    driver= new ChromeDriver();
		driver.manage().window().fullscreen();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://automationbookstore.dev/");	
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
	@Test(description="Test Book5 is left of Book6 & below Book1")
	public void tset1() {
		WebElement Book5=driver.findElement(RelativeLocator.withTagName("li").toLeftOf(By.id("pid6")).below(By.id("pid1")));
		String id=Book5.getAttribute("id");
		System.out.println(id);
		Assert.assertEquals(id, "pid5");
	}
	
	//@Test(description="Test Book2 is above Book6 & right of Book1")
	public void tset2() {
		WebElement Book2=driver.findElement(RelativeLocator.withTagName("li").toRightOf(By.id("pid1")).above(By.id("pid6")));
		String id=Book2.getAttribute("id");
		System.out.println(id);
		Assert.assertEquals(id, "pid2");
	}

}
