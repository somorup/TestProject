package com.htc.ReadExcel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationDemo {
	WebDriver driver = null;
	private By accountBy=By.xpath("(//span[@class='label'])[3]");
	private By registerBy=By.xpath("//div[@id='header-account']//div//ul//li//a[@title='Register']");
	private By firstnameBy=By.xpath("//input[@id='firstname']");
	private By middlenameBy=By.xpath("//input[@id='middlename']");
	private By lastnameBy=By.xpath("//input[@id='lastname']");
	private By emailidBy=By.xpath("//input[@id='email_address']");
	private By passwordBy=By.xpath("//input[@id='password']");
	private By confirmpasswordBy=By.xpath("//input[@id='confirmation']");
	private By registerbuttonBy=By.xpath("//button[@class='button']");
	private By assertcheckBy=By.xpath("//div[@class='welcome-msg']//p[@class='hello']//strong");
	private By falseassertcheckBy=By.cssSelector("li[class=\"error-msg\"]");
	
	public RegistrationDemo(WebDriver driver) {
		this.driver=driver;
	}
	public void clickaccountBy()
	{
		driver.findElement(accountBy).click();
	}
	public void clickregisterBy()
	{
		driver.findElement(registerBy).click();
	}
	public void setfirstnameBy(String firstname)
	{
		driver.findElement(firstnameBy).sendKeys(firstname);
	}
	public void setmiddlenameBy(String middlename)
	{
		driver.findElement(middlenameBy).sendKeys(middlename);
	}
	public void setlastnameBy(String lastname)
	{
		driver.findElement(lastnameBy).sendKeys(lastname);
	}
	public void setemailidBy(String emailid)
	{
		driver.findElement(emailidBy).sendKeys(emailid);
	}
	public void setpasswordBy(String password)
	{
		driver.findElement(passwordBy).sendKeys(password);
	}
	public void setconfirmpasswordBy(String confirmpassword)
	{
		driver.findElement(confirmpasswordBy).sendKeys(confirmpassword);
	}
	public void setregistrationBy()
	{
		driver.findElement(registerbuttonBy).click();
	}
	public String assertcheckBy()
	{
       return driver.findElement(assertcheckBy).getText();
	}
	public String falseassertcheckBy()
	{
       return driver.findElement(falseassertcheckBy).getText();
	}
}
