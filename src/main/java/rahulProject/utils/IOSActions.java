package rahulProject.utils;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import io.appium.java_client.ios.IOSDriver;

public class IOSActions extends AppiumUtils{

	IOSDriver driver;
	public IOSActions(IOSDriver driver)
	{
		this.driver=driver;
	}
	
	public void scrollDown(WebElement ele)
	{
		 Map<String, Object>parms = new HashMap<>(); 
		 parms.put("direction", "down");
		 parms.put("element",((RemoteWebElement)ele).getId());
		driver.executeScript("mobile:scroll", parms);
	}
	
	public void touchAndHold_LongPresss(WebElement ele)
	{
		Map<String, Object>parms = new HashMap<>();
		parms.put("element", ((RemoteWebElement)ele).getId());
		parms.put("duration", 5);
		driver.executeScript("mobile: touchAndHold", parms);
	}
	
	public void swipeAction(WebElement ele, String direction)
	{
		Map<String, Object> parms1 = new HashMap<String, Object>();
		parms1.put("direction", "left");
		driver.execute("mobile:swipe", parms1);
	}
}
