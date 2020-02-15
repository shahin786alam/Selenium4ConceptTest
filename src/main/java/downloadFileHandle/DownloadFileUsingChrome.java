package downloadFileHandle;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DownloadFileUsingChrome {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","C:\\Program Files"
				      + "\\Java\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
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
