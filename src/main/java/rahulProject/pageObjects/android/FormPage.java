package rahulProject.pageObjects.android;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import rahulProject.utils.AndroidActions;

public class FormPage extends AndroidActions {

	AndroidDriver driver;
	
	public FormPage(AndroidDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(id="android:id/text1")
	private WebElement countrySelection;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/nameField")
	private WebElement nameField;
	
	@AndroidFindBy(xpath="//android.widget.RadioButton[@text='Female']")
	private WebElement genderFemale;
	
	@AndroidFindBy(xpath="//android.widget.RadioButton[@text='Male']")
	private WebElement genderMale;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/btnLetsShop")
	private WebElement letsShop;
	
	public void setNameField(String name)
	{
		nameField.sendKeys(name);
		driver.hideKeyboard();
	}
	
	public void setGender(String gender)
	{
		if(gender.contains("female"))
			genderFemale.click();
		else
			genderMale.click();
	}
	
	public void setCountrySelection(String CountryName)
	{
		countrySelection.click();
		scrollToText(CountryName);
		driver.findElement(By.xpath("//android.widget.TextView[@text='"+CountryName+"']")).click();
	}
	
	public void submitForm()
	{
		letsShop.click();
	}
}
