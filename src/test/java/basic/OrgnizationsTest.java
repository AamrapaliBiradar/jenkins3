package basic;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import commonUtils.PropertyFileUtil;
import commonUtils.WebDriverUtil;

public class OrgnizationsTest {

	@Test
	public void CreateOrganizationsTest() throws IOException {
		PropertyFileUtil putil = new PropertyFileUtil();
		WebDriverUtil wutil = new WebDriverUtil();

		WebDriver driver = new ChromeDriver();
		// To read the data from property file(i.e. LoginCredencials.properties)
		String URL = putil.getDataFromPropertyFile("Url");
		String USERNAME = putil.getDataFromPropertyFile("Username");
		String PASSWORD = putil.getDataFromPropertyFile("Password");

		
		driver.get(URL);
		// To maximize the window
		wutil.maximize(driver);
		// To apply wait for findElement()
		wutil.implicitwait(driver);

		
		// Login to application
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();

	}

}
