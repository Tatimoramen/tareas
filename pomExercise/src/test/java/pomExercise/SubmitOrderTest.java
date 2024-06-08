package pomExercise;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import TestComponents.BaseTest;

public class SubmitOrderTest extends BaseTest {

	String productName = "ZARA COAT 3";
	String email = "anshika@gmail.com";
	String password = "Iamking@000";
	
	@Test
	public void submitOrder() throws IOException, InterruptedException {

		ProductCatalog productCatalog = landingPage.loginApplication(email, password);
		List<WebElement> products = productCatalog.getProductList();
		productCatalog.addProductToCart(productName);
		productCatalog.goToCartPage();
		CartPage cartPage = productCatalog.goToCartPage();
		
		Boolean match = cartPage.verifyProdctDisplay(productName);
		Assert.assertTrue(match);
		CheckoutPage checkoutPage = cartPage.goToCheckout();
		checkoutPage.selectCountry("india");
		ConfirmationClass confirmationClass = checkoutPage.submitOrder();
		String conformMessage = confirmationClass.getConfirmationMessage();
		Assert.assertTrue(conformMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));

	}
	@Test(dependsOnMethods = {"submitOrder"})
	public void orderHistoryTest() {

		ProductCatalog productCatalog = landingPage.loginApplication(email, password);
		OrderPage orderPage = productCatalog.goToOrderPage();
		Assert.assertTrue(orderPage.verifyOrderDisplay(productName));

	

	}
}
