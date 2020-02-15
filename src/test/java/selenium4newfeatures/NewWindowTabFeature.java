package selenium4newfeatures;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NewWindowTabFeature {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		//driver.manage().window().fullscreen();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.google.com");
		System.out.println(driver.getTitle());
		
		//driver.switchTo().newWindow(WindowType.TAB);//open a new blank tab
		driver.switchTo().newWindow(WindowType.WINDOW);//open a new window
		
		Set<String> handles=driver.getWindowHandles();
		List<String> ls=new ArrayList<String>(handles);
		
		String parentwindowid=ls.get(0);
		String chieldwindowid=ls.get(1);
		System.out.println(parentwindowid);
		System.out.println(chieldwindowid);
		
		System.out.println("after switching title is: "+driver.getTitle());
		
		driver.get("https://www.facebook.com");
		System.out.println("after switching title is: "+driver.getTitle());
		driver.close();//close the tab
		
		driver.switchTo().window(parentwindowid);
		System.out.println("after switching title is: "+driver.getTitle());

	}

}
