package siva;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Hyr {
	public static WebDriver driver;

	@Test
	public  void main() throws Throwable {
		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.hyrtutorials.com/p/html-dropdown-elements-practice.html");
		Thread.sleep(2000);
		WebElement courseElement = driver.findElement(By.id("course"));
		Select courseNameDropdown = new Select(courseElement);
		List<WebElement> courseNameDropdownOptions = courseNameDropdown.getOptions();
		for (WebElement option : courseNameDropdownOptions) {
			System.out.println(option.getText());
		}
		courseNameDropdown.selectByIndex(1);
		Thread.sleep(3000);
		courseNameDropdown.selectByValue("net");
		Thread.sleep(3000);
		courseNameDropdown.selectByVisibleText("Javascript");
		Thread.sleep(2000);
		String selectedText = courseNameDropdown.getFirstSelectedOption().getText();
		System.out.println("Selected visible text-" + selectedText);

	}

}
