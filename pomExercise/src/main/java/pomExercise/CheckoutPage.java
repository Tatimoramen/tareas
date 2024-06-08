package pomExercise;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstracComponents.AbstracComponent;

public class CheckoutPage extends AbstracComponent{

	WebDriver driver;
	
	public CheckoutPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = ".action__submit")
	WebElement submit;
	
	@FindBy(css = "[placeholder='Select Country']")
	WebElement country;
	
	@FindBy(css = ".ta-results")
	WebElement results;
	
	@FindBy(xpath = "//button[@class='ta-item list-group-item ng-star-inserted'][2]")
	WebElement selectCountry;
	
	public void selectCountry(String coutryName) {
		
		Actions a = new Actions(driver);
		
		a.sendKeys(country, "India").build().perform();
		waitForElementToAppear(By.cssSelector(".ta-results"));
		selectCountry.click();	
		
	}
	
	public ConfirmationClass submitOrder() {
		
		submit.click();	
		return new ConfirmationClass(driver);
		
	}

}


