package rahulProjectTest.android;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import rahulProject.pageObjects.android.CartPage;
import rahulProject.pageObjects.android.FormPage;
import rahulProject.pageObjects.android.ProductCatalogPage;
import rahulProjectTest.testUtils.AndroidBaseTestEcommerce;

public class ECommerce_Tc_DataProvider extends AndroidBaseTestEcommerce { 
	
	@Test(dataProvider = "getData")
	public void handleWebView(String country, String name, String gender) throws InterruptedException
	{
		
		FormPage form = new FormPage(driver);
		ProductCatalogPage productCatalog = new ProductCatalogPage(driver);
		CartPage cart = new CartPage(driver);
		
		form.setCountrySelection(country);
		form.setNameField(name);
		form.setGender(gender);
		form.submitForm();

		//Products Page
		productCatalog.addItemToCartByIndex(0);
		productCatalog.addItemToCartByIndex(0);
		productCatalog.gotoCart();
		
		//Cart Page
		Thread.sleep(4000);
//		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
//		wait.until(ExpectedConditions.attributeContains(driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title")), "text", "Cart"));
		double totalSum = cart.getProductSum();
		Double displayformattedSum = cart.getTotalAmountDisplayed();
		Assert.assertEquals(totalSum, displayformattedSum);
		cart.acceptTermsAndConditions();
		cart.submitOrder();
	}

	@DataProvider
	public Object[][] getData()
	{
		return new Object [] [] {{"Argentina","Pinky","female"},{"Argentina","Rahul","male"}};
	}

}
