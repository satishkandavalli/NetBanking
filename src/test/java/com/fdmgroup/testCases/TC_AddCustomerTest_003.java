package com.fdmgroup.testCases;

import java.io.IOException;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.fdmgroup.pageObjects.AddCustomerPage;
import com.fdmgroup.pageObjects.LoginPage;

public class TC_AddCustomerTest_003 extends BaseClass {

	@Test
	public void addNewCustomer() throws InterruptedException, IOException {
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(username);
		logger.info("User name is provided");
		lp.setPassword(password);
		logger.info("Passsword is provided");
		lp.clickSubmit();

		Thread.sleep(3000);

		AddCustomerPage addcust = new AddCustomerPage(driver);

		addcust.clickAddNewCustomer();

		logger.info("providing customer details....");

		addcust.custName("Satidh");
		addcust.custgender("male");
		addcust.custdob("10","15","1985");
		Thread.sleep(5000);
		addcust.custaddress("Canada");
		addcust.custcity("Ottawa");
		addcust.custstate("ON");
		addcust.custpinno("500575");
		addcust.custtelephoneno("5145467869");

		String email = randomestring() + "@gmail.com";
		addcust.custemailid(email);
		addcust.custpassword("abcdef");
		addcust.custsubmit();

		Thread.sleep(3000);

		logger.info("validation started....");

		boolean res = driver.getPageSource().contains("Customer Registered Successfully!!!");

		if (res == true) {
			Assert.assertTrue(true);
			logger.info("test case passed....");

		} else {
			logger.info("test case failed....");
			captureScreen(driver, "addNewCustomer");
			Assert.assertTrue(false);
		}

	}

	private String randomestring() {

		String randomString = RandomStringUtils.randomAlphabetic(5);
		return (randomString);
	}
	private String randomeNum() {

		String randomNUm = RandomStringUtils.randomNumeric(4);
		return (randomNUm);
	}
	

}
