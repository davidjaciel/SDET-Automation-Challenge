package pageMethods;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PageMethods {
	
	public int scrollDown(WebDriver driver) throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		long past_height = 0;
		long current_height = 0;

		while (true) {
			Thread.sleep(1000);
			current_height = (long) js.executeScript("return document.body.scrollHeight");
			if (past_height < current_height) {
				js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
				past_height = current_height;
			} else
				break;
		}
		List<WebElement> links = driver.findElements(By.tagName("a"));
		return links.size();

	}

	
	public String firstnonFreeItem(WebDriver driver) throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		long past_height = 0;
		long current_height = 0;
		for (int i = 0; i < 6; i++) {
			Thread.sleep(1000);
			current_height = (long) js.executeScript("return document.body.scrollHeight");
			if (past_height < current_height) {
				js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
				past_height = current_height;

			}
		}
		List<WebElement> nonfreeItems = driver.findElements(By.xpath("//*/span[contains(text(),'$')]"));

		return nonfreeItems.get(3).getText();
	}
	
}
