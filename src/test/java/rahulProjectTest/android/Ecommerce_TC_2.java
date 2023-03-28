package rahulProjectTest.android;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import rahulProjectTest.testUtils.AndroidBaseTestEcommerce;

public class Ecommerce_TC_2 extends AndroidBaseTestEcommerce {

	@Test
	public void addAProductToCart() throws InterruptedException
	{
		driver.findElement(By.id("android:id/text1")).click();
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));"));
		driver.findElement(By.xpath("//android.widget.TextView[@text='Argentina']")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Pinky");
		driver.hideKeyboard();
		driver.findElement(By.xpath("//android.widget.RadioButton[@text='Female']")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();

		//Products Page
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Jordan 6 Rings\"));"));
		int count = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).size();
		for(int i =0; i<count; i++) 
		{
			String productName = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).get(i).getText();
			if(productName.equalsIgnoreCase("Jordan 6 Rings"))
			{
				driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i).click();
			}
		}
		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();

		//Cart Page
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.attributeContains(driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title")), "text", "Cart"));
		String  cartProductName= driver.findElement(By.id("com.androidsample.generalstore:id/productName")).getText();
		Assert.assertEquals(cartProductName, "Jordan 6 Rings");
	}

}
