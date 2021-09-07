package DemoGuru;

import org.junit.Before;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import CommonLib.Browser;
import Data.Data;
import URL.url;
import locators.locators;

public class Demoguru {
	
	Browser br=new Browser();
	url ur=new url();
	locators loc=new locators();
	Data data=new Data();

	
	@BeforeClass
	public void open() {
		
		br.web(ur.url);
		
	}
	
	@AfterClass
	public void close() {
		
		br.driver.close();
	}
	
	//Verify the invalid login credentials
	@Test(priority=1, dataProvider="LoginTesting")
	public void invalid(String username, String password) {
		br.driver.navigate().to(ur.url);
		br.driver.findElement(By.xpath(loc.username)).sendKeys(username);
		br.driver.findElement(By.xpath(loc.password)).sendKeys(password);
		br.driver.findElement(By.xpath(loc.loginbutton)).click();
		String actual_result=br.driver.switchTo().alert().getText();
		String expected_result="User or Password is not valid";
		Assert.assertEquals(actual_result, expected_result);
		br.driver.switchTo().alert().accept();
	
		
		
	}
	@DataProvider(name="LoginTesting")
	public Object[][] Authentication(){
		
		//Create an object array with 2 rows and 2 columns
		Object[][] demoguru= new Object[3][2];
		
		demoguru[0][0]="any";
		demoguru[0][1]="123456$";
		demoguru[1][0]="mngr350302";
		demoguru[1][1]="gigjh";
		demoguru[2][0]="kjfjbej";
		demoguru[2][1]="lnklnl";
		return demoguru;
		
	}
	
	@Test(priority=2)
	public void login() {
		br.driver.navigate().to(ur.url);
		br.driver.findElement(By.xpath(loc.username)).sendKeys(data.loginid);
		br.driver.findElement(By.xpath(loc.password)).sendKeys(data.password);
		br.driver.findElement(By.xpath(loc.loginbutton)).click();
		String expected_result="Manger Id : mngr350302";
		String actual_result=br.driver.findElement(By.xpath(loc.loginverify)).getText();
		Assert.assertEquals(actual_result, expected_result);
		
	}
	
	
	@Test(priority=3, dataProvider="ChangePassword")
	public void changepassword(String oldpassword, String newpassword) {
		
		br.driver.findElement(By.xpath(loc.changepassword)).click();
		br.driver.findElement(By.xpath(loc.oldpassword)).sendKeys(oldpassword);
		br.driver.findElement(By.xpath(loc.newpassword)).sendKeys(newpassword);
		br.driver.findElement(By.xpath(loc.confirmpassword)).sendKeys(newpassword);
		br.driver.findElement(By.xpath(loc.submit)).click();
		br.driver.switchTo().alert().accept();
		
	}
	//Verify the invalid passowrd change
	@DataProvider(name="ChangePassword")
	public Object[][] Passchange(){
		
		Object[][] changepass= new Object[3][2];
		
		changepass[0][0]="any123";
		changepass[0][1]="123456";
		changepass[1][0]="123456";
		changepass[1][1]="123456$";
		changepass[2][0]="123456";
		changepass[2][1]="123456";
		return changepass;
		
	}
	
	@Test(priority=4)
	public void newlogin() {
		
		br.driver.findElement(By.xpath(loc.logout)).click();
		br.driver.switchTo().alert().accept();
		br.driver.findElement(By.xpath(loc.username)).sendKeys(data.loginid);
		br.driver.findElement(By.xpath(loc.password)).sendKeys(data.password);
		br.driver.findElement(By.xpath(loc.loginbutton)).click();
		String expected_result="Manger Id : mngr350302";
		String actual_result=br.driver.findElement(By.xpath(loc.loginverify)).getText();
		Assert.assertEquals(actual_result, expected_result);
		
	}
}