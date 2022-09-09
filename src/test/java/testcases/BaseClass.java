package testcases;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class BaseClass {

	public static AndroidDriver driver;

	XSSFWorkbook wbook;
	XSSFSheet sheet;

	public static ExtentReports report;

	@BeforeTest
	public void DataSetUp() throws IOException {

		FileInputStream fis = new FileInputStream("userdata.xlsx");

		wbook = new XSSFWorkbook(fis);
		sheet = wbook.getSheet("inputdata");

		report = new ExtentReports("ExtentReport.html");
	}

	@AfterTest
	public void DataTeardown() throws IOException {

		wbook.close();
		report.flush();
		report.close();
	}

	@BeforeMethod
	public void setUp() throws MalformedURLException {
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability("platformName", "Android");
		desiredCapabilities.setCapability("appium:platformVersion", "11.0");
		desiredCapabilities.setCapability("appium:deviceName", "Android SDK built for x86");
		desiredCapabilities.setCapability("appium:app", "C:\\APKS\\Flipkart-7.18.apk");
		desiredCapabilities.setCapability("appium:ensureWebviewsHavePages", true);
		desiredCapabilities.setCapability("appium:nativeWebScreenshot", true);
		desiredCapabilities.setCapability("appium:newCommandTimeout", 3600);
		desiredCapabilities.setCapability("appium:connectHardwareKeyboard", true);

		URL remoteUrl = new URL("http://localhost:4723/wd/hub");

		driver = new AndroidDriver(remoteUrl, desiredCapabilities);

		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);

		MobileElement selLang = (MobileElement) driver
				.findElementByXPath("//android.widget.RelativeLayout[4]/android.widget.RelativeLayout");
		selLang.click();

		MobileElement selLanguageRadio = (MobileElement) driver.findElementById("com.flipkart.android:id/select_btn");
		selLanguageRadio.click();

		MobileElement closePhoneSel = (MobileElement) driver
				.findElementById("com.flipkart.android:id/custom_back_icon");
		closePhoneSel.click();

		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
