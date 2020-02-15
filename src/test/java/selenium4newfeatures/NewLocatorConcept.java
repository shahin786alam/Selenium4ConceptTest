package selenium4newfeatures;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.openqa.selenium.support.locators.RelativeLocator.*;
import java.util.List;
import io.github.bonigarcia.wdm.WebDriverManager;
/*
if i want to use all the time (RelativeLocator.withTagName)like below this line
WebElement loginbtn=driver.findElement(RelativeLocator.withTagName("input").below(By.id("txtPassword")));
Then it's okay to use. But
if i don't want to use all the time (RelativeLocator.) Then i have to import below this line->
import static org.openqa.selenium.support.locators.RelativeLocator.*;
then inside the script i have to write like this->
WebElement loginbtn=driver.findElement(withTagName("input").below(By.id("txtPassword")));
*/
public class NewLocatorConcept {

	public static void main(String[] args) {
	
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		
//		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
//		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
//		WebElement loginbtn=driver.findElement(RelativeLocator.withTagName("input").below(By.id("txtPassword")));
//		loginbtn.click();
		
		List<WebElement> accout=driver.findElements(withTagName("img").below(By.xpath("//a[text()='OrangeHRM, Inc']")));
		System.out.println("Total count is: "+accout.size());
		
		for(WebElement ele:accout) {
			System.out.println(ele.getAttribute("alt"));
		}
		driver.quit();
	}
//this is for webpage console command:
//document.getElementById("txtUsername")
//document.getElementById("txtUsername").getBoundingClientRect()
}
