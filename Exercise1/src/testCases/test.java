package testCases;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import pageMethods.PageMethods;
import webElements.WebElements;

public class test {

	@Test
	public void testCase1() throws InterruptedException {
		 System.setProperty("webdriver.chrome.driver",
				 "C:\\Users\\david\\Documents\\WebDriver for Chrome\\Version 106\\ChromeDriver.exe");
		 WebDriver driver = new ChromeDriver();
		PageMethods methods = new PageMethods();
		WebElements elements = new WebElements(driver);
		WebDriverWait wait = new WebDriverWait(driver, 3);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		driver.manage().window().maximize();
		driver.get("https://www.microsoft.com/es-mx/");

		elements.getWindowsMenu().click();
		elements.getSearchButton().click();
		elements.getSearchBar().sendKeys("Xbox");
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//*/ul[@id='universal-header-search-auto-suggest-ul']/li[@class='c-menu-item'][1]"))).click();
		// "Registration" pop up close
		wait.until(ExpectedConditions
				.elementToBeClickable(By.cssSelector("button[aria-label='Cerrar ventana de diálogo']"))).click();
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//*/div[@class='c-uhfh-actions']/div[@class='wf-menu']"))).click();

		elements.getAppsOption().click();
		Thread.sleep(1000);
		// Count the elements on the first 3 pages and print the sum of elements and all
		// the titles
		int page1links = methods.scrollDown(driver);
		js.executeScript("window.scrollBy(0,-1000000)");
		elements.getPage2Button().click();
		int page2links = methods.scrollDown(driver);
		js.executeScript("window.scrollBy(0,-10000)");
		elements.getPage3Button().click();
		int page3links = methods.scrollDown(driver);
		js.executeScript("window.scrollBy(0,-10000)");
		int result = page1links + page2links + page3links;
		System.out.println("Numero de links pagina 1:" + page1links + "\nNumero de links pagina 2:" + page2links
				+ "\nNumero de links pagina 3:" + page3links + "\nNumero total de links:" + result);
		// Go back to the first page and select the first NON-FREE option and STORE the
		// price for later comparison
		elements.getHomePageButton().click();
		Thread.sleep(1000);
		String nonfreeItem = methods.firstnonFreeItem(driver);
		js.executeScript("window.scrollBy(0,-10000)");
		elements.getPage2Button().click();
		js.executeScript("window.scrollBy(0,300)");
		String currentpriceItem = driver.findElement(By.xpath("//div/span[contains(text(),'$')][2]")).getText();
		elements.getBuyAppButton().click();
		// compare first price vs current prince and they didn't match because the first
		// non-free element has a different price
		Assert.assertNotEquals(nonfreeItem, currentpriceItem);
		System.out.println("First non-free item price: " + nonfreeItem + "\nCurrent price:" + currentpriceItem);

		driver.quit();
	}

}
