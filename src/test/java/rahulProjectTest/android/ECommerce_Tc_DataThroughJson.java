package rahulProjectTest.android;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import rahulProject.pageObjects.android.CartPage;
import rahulProject.pageObjects.android.FormPage;
import rahulProject.pageObjects.android.ProductCatalogPage;
import rahulProjectTest.testUtils.AndroidBaseTestEcommerce;

public class ECommerce_Tc_DataThroughJson extends AndroidBaseTestEcommerce { 
	
	@Test(dataProvider = "getData")
	public void handleWebView(HashMap<String, String> input) throws InterruptedException
	{
		
		FormPage form = new FormPage(driver);
		ProductCatalogPage productCatalog = new ProductCatalogPage(driver);
		CartPage cart = new CartPage(driver);
		
		form.setCountrySelection(input.get("country")); 
		form.setNameField(input.get("name"));
		form.setGender(input.get("gender"));
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
	public Object[][] getData() throws IOException
	{
		List<HashMap<String, String>>data = getJsonData(System.getProperty("user.dir")+ "//src//test//java//rahulProjectTest//testData//ecommerce.json");
		return new Object [] [] {{data.get(0)},{data.get(1)}};
	}

}
