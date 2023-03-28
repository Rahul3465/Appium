package rahulProjectTest.testUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import rahulProject.utils.AppiumUtils;

public class AndroidBaseTestEcommerce extends AppiumUtils {

	public AndroidDriver driver;

	@BeforeMethod
	public void ConfigureAppium() throws IOException
	{
		Properties prop = new Properties();
		//FileInputStream fis = new FileInputStream("D://Eclipse Workspace//AppiumFrameworkDesign//src//main//java//rahulProject//resources//data.properties");
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+  "//src//main//java//rahulProject//resources//data.properties");
		prop.load(fis);
		
		String ipAddress = prop.getProperty("ipAddress");
		String port = prop.getProperty("port");
		
		service = startAppiumServer(ipAddress, Integer.parseInt(port));

		//AndroidDriver/IOSDriver
		UiAutomator2Options options = new UiAutomator2Options();
		//options.setDeviceName("Rahul Emulator");
		options.setDeviceName(prop.getProperty("AndroidDeviceName"));
		options.setChromedriverExecutable("C://Users//jrahu//Downloads//Mobile Automation//chromedriver.exe");
		//options.setApp("D://Eclipse Workspace//AppiumFrameworkDesign//src//test//java//rahulProjectTest//resources//General-Store.apk");
		options.setApp(System.getProperty("user.dir")+ "//src//test//java//rahulProjectTest//resources//General-Store.apk");
		driver = new AndroidDriver(service.getUrl(), options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@AfterMethod
	public void teatDown() {
		driver.quit();
		service.stop();
	}

}
