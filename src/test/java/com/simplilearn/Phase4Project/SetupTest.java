package com.simplilearn.Phase4Project;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

public class SetupTest {

	private AndroidDriver driver;

	@Before
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

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void startTest() {

		MobileElement selLanguage = (MobileElement) driver
				.findElementByXPath("//android.widget.RelativeLayout[4]/android.widget.RelativeLayout");
		selLanguage.click();

		MobileElement selLanguageRadio = (MobileElement) driver.findElementById("com.flipkart.android:id/select_btn");
		selLanguageRadio.click();

		MobileElement closePhoneSel = (MobileElement) driver
				.findElementById("com.flipkart.android:id/custom_back_icon");
		closePhoneSel.click();
	}

	@After
	public void tearDown() {
		driver.quit();
	}
}
