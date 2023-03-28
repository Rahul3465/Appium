package rahulProjectTest.testUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import rahulProject.utils.AppiumUtils;

public class IOSBaseTest extends AppiumUtils{
	public IOSDriver driver;

	@BeforeClass
	public void ConfigureAppium() throws IOException
	{
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir"+ "//src//main//java//rahulProject//resources//data.properties"));
		prop.load(fis);
		startAppiumServer(null, 0);

		//IOSDriver
		XCUITestOptions options = new XCUITestOptions();
		options.setDeviceName("iPhone 13 Pro");
		options.setPlatformVersion("15.3");
		//Appium --> WebDriver Agent --> iOS Apps.
		options.setWdaLaunchTimeout(Duration.ofMinutes(20));
		options.setApp("D://Eclipse Workspace//Appium//src//test//java//resources//UIKitCatalog.app");// dummy line of code
		driver = new IOSDriver(service.getUrl(), options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@AfterClass
	public void teatDown() {
		driver.quit();
		service.stop();
	}

}
