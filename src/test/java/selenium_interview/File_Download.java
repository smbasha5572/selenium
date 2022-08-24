package selenium_interview;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class File_Download {

	@Test
	public void main() throws InterruptedException {
		
		String fileType="DOC, DOCX";
		
		WebDriverManager.chromedriver().setup();
		
		 
		 ChromeOptions options=new ChromeOptions();
		 
		 HashMap<String,Object> prefs=new HashMap<>();
		 prefs.put("plugins.always_open_pdf_externally", true);
		 prefs.put("download.default_directory", "C:\\workspace\\test_downloads");
		 
		 options.setExperimentalOption("prefs", prefs);
		 
		 WebDriver driver=new ChromeDriver(options);
		 
		 driver.get("https://file-examples.com/index.php/sample-documents-download/");
		 Thread.sleep(3000);
	
	     driver.findElement(By.xpath("//td[text()='"+fileType+"']/following-sibling::td[2]/a")).click();
	     Thread.sleep(3000);
//	     driver.findElement(By.xpath("//td[text()=\"150 kB\"]/following-sibling::td[4]/a")).click();
	      
	     driver.findElement(By.xpath("//a[starts-with(text(),'Download sample')]")).click();
	
	}

}
