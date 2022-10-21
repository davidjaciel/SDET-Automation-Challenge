package webElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WebElements {

	protected WebDriver driver;

	public WebElements(WebDriver driver) {
		this.driver = driver;
	}

	private By windowsMenu = By.id("shellmenu_2");
	private By searchButton = By.id("search");
	private By searchBar = By.id("cli_shellHeaderSearchInput");
	private By firstSuggestOption = By.xpath("//*/ul[@id='universal-header-search-auto-suggest-ul']/li[@class='c-menu-item'][1]");
	private By popUpCloseButton = By.cssSelector("button[aria-label='Cerrar ventana de diálogo']");
	private By remove2 = By.id("remove-sauce-labs-bolt-t-shirt");
	private By microsoftMenu = By.xpath("//*/div[@class='c-uhfh-actions']/div[@class='wf-menu']");
	private By appsOption = By.xpath("//a[@id='shellmenu_8']");
	private By page2Button = By.xpath("//div[contains(text(),'Comenzar')]");
	private By page3Button = By.xpath("//div[contains(text(),'Productividad')]");
	private By homePageButton = By.id("navigationbar-Home");
	private By buyAppButton = By.xpath("//*/button[@id='getOrRemoveButton-9N9KBWP6HVQQ']");

	
	
	public WebElement getWindowsMenu() {
		return driver.findElement(windowsMenu);
	}

	public WebElement getSearchButton() {
		return driver.findElement(searchButton);
	}

	public WebElement getSearchBar() {
		return driver.findElement(searchBar);
	}


	public WebElement getFirstSuggestOption() {
		return driver.findElement(firstSuggestOption);
	}

	public WebElement getPopUpCloseButton() {
		return driver.findElement(popUpCloseButton);
	}

	public WebElement getRemove2() {
		return driver.findElement(remove2);
	}

	public WebElement getMicrosoftMenu() {
		return driver.findElement(microsoftMenu);
	}


	public WebElement getAppsOption() {
		return driver.findElement(appsOption);
	}


	public WebElement getPage2Button() {
		return driver.findElement(page2Button);
	}


	public WebElement getPage3Button() {
		return driver.findElement(page3Button);
	}
	
	public WebElement getHomePageButton() {
		return driver.findElement(homePageButton);
	}

	public WebElement getBuyAppButton() {
		return driver.findElement(buyAppButton);
	}

}
