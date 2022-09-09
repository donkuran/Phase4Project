package com.simplilearn.Phase4Project;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.MobileElement;
import testcases.BaseClass;

public class HomePage {

	WebDriver driver = BaseClass.driver;

	@FindBy(id = "com.flipkart.android:id/search_autoCompleteTextView")
	MobileElement SearchBar;

	MobileElement SearchShoes = ((MobileElement) driver).findElementByXPath("//android.widget.RelativeLayout[2]");


	public HomePage() {

		PageFactory.initElements(driver, this);
	}

	public void SearchFunction(String ProductVal) {

		SearchBar.sendKeys(ProductVal);

		SearchShoes.click();

	}

}
