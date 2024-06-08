package pomExercise;

import java.io.IOException;
import java.util.List;

import org.testng.annotations.Test;

import TestComponents.BaseTest;

import org.openqa.selenium.WebElement;
import org.testng.Assert;


public class ErrorValidation extends BaseTest{

	@Test
	public void loginErrorValidation() throws IOException, InterruptedException {
		String productName = "ZARA COAT 3";
		String email = "anshika@gmail.com";
		String password = "Iamking@000";

		landingPage.loginApplication(email, password);
		//Assert.assertEquals("Incorrect email or password", landingPage.getErrorMessage());
	}
	
	@Test
	public void ProductErrorValidation() throws IOException, InterruptedException {
		String productName = "ZARA COAT 3";
		String email = "anshika@gmail.com";
		String password = "Iamking@000";
		ProductCatalog productCatalog = landingPage.loginApplication(email, password);

		List<WebElement> products = productCatalog.getProductList();
		productCatalog.addProductToCart(productName);
		productCatalog.goToCartPage();
		CartPage cartPage = productCatalog.goToCartPage();
		Boolean match = cartPage.verifyProdctDisplay(productName);
		Assert.assertTrue(match);

	}
}
