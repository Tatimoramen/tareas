package pomExercise;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstracComponents.AbstracComponent;

public class ConfirmationClass extends AbstracComponent {

	WebDriver driver;

	public ConfirmationClass(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = ".hero-primary")
	WebElement confirmationMessage;

	public String getConfirmationMessage() {

		return confirmationMessage.getText();
	}
}
