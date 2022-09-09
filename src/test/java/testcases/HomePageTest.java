package testcases;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.simplilearn.Phase4Project.HomePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;

public class HomePageTest extends BaseClass {
	
	private AndroidDriver driver;

	@Test
	public void SearchSuccessTest() {
		
//		(new TouchAction(driver)).tap(PointOption.point(197, 390)).perform();

		String ProductVal = sheet.getRow(1).getCell(0).getStringCellValue();

		HomePage Search = new HomePage();
		Search.SearchFunction(ProductVal);

		MobileElement ShoesTitle = (MobileElement) driver.findElementByLinkText("Top Rated");

		String ActualMsg = ShoesTitle.getText();
		String ExpMsg = "Top Rated";

		Assert.assertEquals(ActualMsg, ExpMsg);

	}

}
