package com.htc.ReadDemoExcel.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.htc.ReadExcel.Excel_Read;
import com.htc.ReadExcel.RegistrationDemo;


public class TestRegistration {
	WebDriver driver=null;
	RegistrationDemo registration=null;
	Properties data=null;


	@BeforeClass
	public void loadProptiesFile()
	{
	  data=new Properties();
	  try 
	  {
		  data.load(new FileReader("C:\\Users\\SAUMYARUP\\eclipse-workspace-selenium\\ReadExcelUsingDemoSite\\src\\main\\resources\\Application.properties"));
	  }  
	  catch (IOException e) 
	  {
		// TODO Auto-generated catch block
		e.printStackTrace();
	  }
	}
	
	@BeforeMethod
	public void setup() 
	{
		System.setProperty("webdriver.chrome.driver", data.getProperty("driverpath"));
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		registration=new RegistrationDemo(driver);
		
		driver.get(data.getProperty("url"));
	}
	
	@DataProvider
	public Object[][] browserStackSignValidData()
	{
		
		Excel_Read ref= new Excel_Read(data.getProperty("excelpath"));
		
		Object[][] loginDataSet=ref.getRecords(data.getProperty("valid_registration_details"));
		
		System.out.println(loginDataSet.length);
		return loginDataSet;
		
	}
	
	@DataProvider
	public Object[][] browserStackSigninInValidData()
	{
		
		Excel_Read ref= new Excel_Read(data.getProperty("excelpath"));
		
		Object[][] loginDataSet=ref.getRecords(data.getProperty("invalid_registration_details"));
		
		System.out.println(loginDataSet.length);
		return loginDataSet;
		
	}
	
	@Test(dataProvider ="browserStackSignValidData",enabled=false)
	public void testBrowserStackSignin_ValidloginCredential_ShouldDisplayDashboard(String ... parameters)
	{
		String firstname=parameters[0];
		String middlename=parameters[1];
		String lastname=parameters[2];
		String emailid=parameters[3];
		String password=parameters[4];
		String confirmpassword=parameters[5];
		
		registration.clickaccountBy();
	    registration.clickregisterBy();
	    registration.setfirstnameBy(firstname);
	    registration.setmiddlenameBy(middlename);
	    registration.setlastnameBy(lastname);
	    registration.setemailidBy(emailid);
	    registration.setpasswordBy(password);
	    registration.setconfirmpasswordBy(confirmpassword);
	    registration.setregistrationBy();
	    Assert.assertEquals(registration.assertcheckBy(),"Hello, "+firstname+" "+middlename+" "+lastname+"!");
	    System.out.println("Login has done success");
	    String status = "Pass";

	
	}
	
	  @Test(dataProvider ="browserStackSigninInValidData") 
	  public void testBrowserStackSignin_InValidloginCredential_ShouldErrorInSigninPage(String ... parameters) 
	  { 
		  String firstname=parameters[0];
		  String middlename=parameters[1];
		  String lastname=parameters[2];
		  String emailid=parameters[3];
		  String password=parameters[4];
		  String confirmpassword=parameters[5];
		  registration.clickaccountBy();
		  registration.clickregisterBy();
		    registration.setfirstnameBy(firstname);
		    registration.setmiddlenameBy(middlename);
		    registration.setlastnameBy(lastname);
		    registration.setemailidBy(emailid);
		    registration.setpasswordBy(password);
		    registration.setconfirmpasswordBy(confirmpassword);
		    registration.setregistrationBy();
		    System.out.println("Invalid credentials");
		    Assert.assertEquals(registration.falseassertcheckBy(), "There is already an account with this email address. If you are sure that it is your email address, click here to get your password and access your account.");
		    //System.out.println(registration.falseassertcheckBy());
		    String status = "Fail";

		}
}
