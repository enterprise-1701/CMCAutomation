package automationFramework.PageObjects;


import java.awt.AWTException;
import java.io.IOException;
import java.util.Set;

import org.eclipse.jetty.util.log.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import com.gargoylesoftware.htmlunit.WebClient;
import automationFramework.Utilities.Global;
import automationFramework.Utilities.Global;
import automationFramework.Utilities.Utils;

public class NewCustomerPage extends BasePage {

	WebDriverWait wait = new WebDriverWait(driver, 90);

	// Element Locators
		private static final String CUSTOMERTYPE = "//*[@id='searchCustomer_customerType_sel']";	
		private static final String FIRSTNAME = "//*[@id='searchCustomer_firstname_txt']";							
		private static final String LASTNAME = "//*[@id='searchCustomer_last_txt']";
		private static final String EMAIL = "//*[@id='searchCustomer_email_txt']";
		private static final String PHONE = "//*[@id='searchCustomer_phone_txt']";
		private static final String CONTINUE = "//*[@id='searchCustomer_continue_btn']";
		private static final String NOT_DUPLICATE = "//*[@id='searchcustomer_continueCustomerCreation_btn']";
		private static final String CANCEL = ".//*[@id='searchCustomer_cancel_btn']";
		private static final String CUSTOMER_MENU = "//*[@id='customerMenu']";
		private static final String EMAIL_ERROR = "//*[@id='v-email-alert']";
		private static final String PHONE_ERROR = "//*[@id='v-email-alert']";
		
	
	public NewCustomerPage(WebDriver driver) {
		super(driver);
	}

	public void clickCustomerType(WebDriver driver, String value) throws InterruptedException, AWTException{
		Select mySelect= new Select(driver.findElement(By.xpath(CUSTOMERTYPE)));
		mySelect.selectByValue(value);
	
	}

	public void enterFirstname(WebDriver driver, String firstname) throws InterruptedException, AWTException{
		driver.findElement(By.xpath(FIRSTNAME)).click();
		driver.findElement(By.xpath(FIRSTNAME)).sendKeys(firstname);
	}
	
	public void enterLastname(WebDriver driver, String lastname) throws InterruptedException, AWTException{
		driver.findElement(By.xpath(LASTNAME)).click();
		driver.findElement(By.xpath(LASTNAME)).sendKeys(lastname);
	}

	public void enterEmail(WebDriver driver, String email) throws InterruptedException, AWTException{
		driver.findElement(By.xpath(EMAIL)).click();
		driver.findElement(By.xpath(EMAIL)).clear();
		driver.findElement(By.xpath(EMAIL)).sendKeys(email);
	}
	
	public void enterPhone(WebDriver driver, String phone) throws InterruptedException, AWTException{
		driver.findElement(By.xpath(PHONE)).click();
		driver.findElement(By.xpath(PHONE)).sendKeys(phone);
	}
	
	public void clickContinue(WebDriver driver) throws InterruptedException, AWTException{
		driver.findElement(By.xpath(CONTINUE)).click();
	}
	
	public void clickCancel(WebDriver driver) throws InterruptedException, AWTException{
		driver.findElement(By.xpath(CANCEL)).click();
	}
	
	public void clickCustomerMenu(WebDriver driver) throws InterruptedException, AWTException{
		driver.findElement(By.xpath(CUSTOMER_MENU)).click();
	}
	
	@SuppressWarnings("deprecation")
	public void clickNotDuplicate(WebDriver driver) throws InterruptedException, AWTException{
		if(!driver.findElements(By.xpath(NOT_DUPLICATE)).isEmpty()){	
		driver.findElement(By.xpath(NOT_DUPLICATE)).click();
		}
		else{ Log.info("No duplicate message displayed");
	    }
	}
	
	public String getFirstname(WebDriver driver) throws InterruptedException, AWTException{
		return driver.findElement(By.xpath(FIRSTNAME)).getText();
	}
	
	public String getEmailError(WebDriver driver) throws InterruptedException, AWTException{
		return driver.findElement(By.xpath(EMAIL_ERROR)).getText();
	}
	
	public String getPhoneError(WebDriver driver) throws InterruptedException, AWTException{
		return driver.findElement(By.xpath(PHONE_ERROR)).getText();
	}
	
	public boolean isContinueEnabled(WebDriver driver) throws InterruptedException, AWTException{
		return driver.findElement(By.xpath(CONTINUE)).isEnabled();
		}
}