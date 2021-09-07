package DemoGuru;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import CommonLib.Browser;
import Data.Data;
import URL.url;
import locators.locators;
import utility.keyword;

public class Newcustomer {
	
	Browser br=new Browser();
	url ur =new url();
	locators loc=new locators();
	Data data=new Data();
	keyword key=new keyword();
	
	@BeforeClass
	public void open() {
		
		
		br.web(ur.url);
		
	}
	
	@AfterClass
	public void close() {
		
		br.driver.quit();
	}
	
	@Test(priority=1)
	public void login() {
		
		
		key.newlogin(br);
		String expected_result="Manger Id : mngr350302";
		String actual_result=br.driver.findElement(By.xpath(loc.loginverify)).getText();
		Assert.assertEquals(actual_result, expected_result);
	}
	
	@Test(priority=2)
	public void newcustomer() throws InterruptedException {
		
		br.driver.findElement(By.xpath(loc.addnewcustomer)).click();
		br.driver.findElement(By.xpath(loc.customername)).sendKeys(data.customername);
		br.driver.findElement(By.xpath(loc.male)).click();
		br.driver.findElement(By.xpath(loc.dob)).sendKeys(data.date);
		br.driver.findElement(By.xpath(loc.address)).sendKeys(data.address);
		br.driver.findElement(By.xpath(loc.city)).sendKeys(data.city);
		br.driver.findElement(By.xpath(loc.state)).sendKeys(data.state);
		br.driver.findElement(By.xpath(loc.PIN)).sendKeys(data.PIN);
		br.driver.findElement(By.xpath(loc.telephone)).sendKeys(data.mobilenumber);
		br.driver.findElement(By.xpath(loc.email)).sendKeys(data.email);
		br.driver.findElement(By.xpath(loc.passwd)).sendKeys(data.password);
		br.driver.findElement(By.xpath(loc.submit)).click();
//		br.driver.switchTo().alert().accept();
		String expected_result="Customer Registered Successfully!!!";
		String actual_result=br.driver.findElement(By.xpath("//p[@class=\"heading3\"]")).getText();
		Assert.assertEquals(actual_result, expected_result);
		data.userid=br.driver.findElement(By.xpath(loc.customerid_path)).getText();

		System.out.println(data.userid);
		
		
	}

	@Test(priority=3)
	public void addnewaccount()  {
		

		br.driver.findElement(By.xpath(loc.addnewaccount)).click();
		br.driver.findElement(By.xpath(loc.customerid)).sendKeys(data.userid);
		Select acctype= new Select(br.driver.findElement(By.xpath(loc.accounttype)));
		acctype.selectByVisibleText("Savings");
		br.driver.findElement(By.xpath(loc.inideposit)).sendKeys("500");
		br.driver.findElement(By.xpath(loc.submit)).click();
		Data.account_id=br.driver.findElement(By.xpath(loc.account_id)).getText();
		
		
		
	}
	


}
