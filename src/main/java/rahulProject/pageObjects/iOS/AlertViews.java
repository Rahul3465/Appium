package rahulProject.pageObjects.iOS;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import rahulProject.utils.IOSActions;

public class AlertViews extends IOSActions{
	IOSDriver driver;
	
	public AlertViews(IOSDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@iOSXCUITFindBy(accessibility="Alert Views")
	private WebElement alertViews;
	
	@iOSXCUITFindBy(iOSClassChain="**/XCUIElementTypeStaticText[`label == 'Text Entry'`]")
	private WebElement textEntryMenu;
	
	@iOSXCUITFindBy(iOSClassChain="**/XCUIElementTypeCell")
	private WebElement textEnter;
	
	@iOSXCUITFindBy(accessibility="OK")
	private WebElement buttonOk;
	
	@iOSXCUITFindBy(iOSNsPredicate="label=='Confirm / Cancel'")
	private WebElement buttonConfirm_Cancel;
	
	@iOSXCUITFindBy(iOSNsPredicate="name BEGINSWITH[c],'A message'")
	private WebElement confirmTextMessage;
	
	@iOSXCUITFindBy(iOSNsPredicate="label=='Confirm'")
	private WebElement buttonConfirm;
	
	public void textEntry()
	{
		textEntryMenu.click();
	}
	
	public void enterText(String ele)
	{
		textEnter.sendKeys(ele);
	}
	
	public void okButton()
	{
		buttonOk.click();
	}
	
	public void confirm_CancelButton() {
		buttonConfirm_Cancel.click();
	}
	
	public String getConfirmMessage()
	{
		return confirmTextMessage.getText();
	}
	
	public void buttonConfirm() {
		buttonConfirm.click();
	}
}
