package commonUtils;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class WebDriverUtil {

	// public WebDriver driver;

	// here we are passing parameter to method to resolve the NullPointerException
	// error.
	// we are getting NullPointerException bcoz driver is not initialized.
	public void maximize(WebDriver driver) {
		driver.manage().window().maximize();
	}

	public void implicitwait(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	public void handledropdown(WebElement element, String targetedElement) {
		Select s = new Select(element);
		s.selectByVisibleText(targetedElement);
	}

	public void mousehover(WebDriver driver, WebElement element) {
		Actions a = new Actions(driver);
		a.moveToElement(element);
		a.perform();
	}

	public void switchWindow(WebDriver driver, String expectedurl) {

		Set<String> ids = driver.getWindowHandles();
		for (String e : ids) {
			String actualurl = driver.switchTo().window(e).getCurrentUrl();

			if (actualurl.contains(expectedurl)) {
				break;
			}

		}

	}

	public String screenshot(WebDriver driver, String screenshotName) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File tempfile = ts.getScreenshotAs(OutputType.FILE);
		File destinationFile = new File("./Screenshot/" + screenshotName + ".png");
		FileUtils.copyFile(tempfile, destinationFile);
		return destinationFile.getAbsolutePath();
	}

}
