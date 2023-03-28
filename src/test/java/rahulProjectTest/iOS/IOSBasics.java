package rahulProjectTest.iOS;

import org.testng.Assert;
import org.testng.annotations.Test;

import rahulProject.pageObjects.iOS.AlertViews;
import rahulProject.pageObjects.iOS.HomePage;
import rahulProjectTest.testUtils.IOSBaseTest;

public class IOSBasics extends IOSBaseTest {

	@Test
	public void basics()
	{
		//xpath, className, accessibility ID, id, IOSClassChain, IOSPredicateString, IOS
		HomePage home = new HomePage(driver);
		home.selectAlertViews();
		AlertViews alertviews = new AlertViews(driver);
		alertviews.textEntry();
		alertviews.enterText("Hello World");
		alertviews.okButton();
		alertviews.confirm_CancelButton();
		String actualmessage = alertviews.getConfirmMessage();
		Assert.assertEquals(actualmessage, "A message should be short, complete sentence.");
		alertviews.buttonConfirm();
	}

}
