package DemoGuru;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import CommonLib.Browser;
import Data.Data;
import URL.url;
import locators.locators;

public class DeleteAccount {

	Browser br=new Browser();
	url ur =new url();
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
	
	@Test(priority=1)
	public void login() {
		
		br.driver.findElement(By.xpath(loc.username)).sendKeys(data.loginid);
		br.driver.findElement(By.xpath(loc.password)).sendKeys(data.password);
		br.driver.findElement(By.xpath(loc.loginbutton)).click();
		String expected_result="Manger Id : mngr350302";
		String actual_result=br.driver.findElement(By.xpath(loc.loginverify)).getText();
		Assert.assertEquals(actual_result, expected_result);
	
	}
	@Test(priority=2)
	public void deleteaccount()  {
		
		try {
			br.driver.findElement(By.xpath(loc.del_account)).click();
			br.driver.findElement(By.xpath(loc.account_no)).sendKeys(Data.account_id);
			System.out.println(Data.account_id);
			br.driver.findElement(By.xpath(loc.submit)).click();
			br.driver.switchTo().alert().accept();
			String actual=br.driver.switchTo().alert().getText();
			String expected="Account Deleted Sucessfully";
			Assert.assertEquals(actual, expected);
			br.driver.switchTo().alert().accept();
			System.out.println(actual);
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		br.driver.switchTo().alert().accept();
	}
	
	
	@Test(priority=3)
	public void ministatement() {
		
		br.driver.findElement(By.xpath(loc.ministatementpage)).click();
		br.driver.findElement(By.xpath(loc.account_no)).sendKeys(Data.account_id);
		br.driver.findElement(By.xpath(loc.submit)).click();
		String expected_result="Account does not exist";
		String actual_result=br.driver.switchTo().alert().getText();
		Assert.assertEquals(actual_result, expected_result);
		br.driver.switchTo().alert().accept();
		
		
	}
	
	@Test(priority=4)
	public void deletedaccountbalance() {
		
		br.driver.findElement(By.xpath(loc.balanceenq)).click();
		br.driver.findElement(By.xpath(loc.account_no)).sendKeys(Data.account_id);
		br.driver.findElement(By.xpath(loc.submit)).click();
		String expected_result="Account does not exist";
		String actual_result=br.driver.switchTo().alert().getText();
		Assert.assertEquals(actual_result, expected_result);
		br.driver.switchTo().alert().accept();
		
	}
	
	@Test(priority=5)
	public void customized() {
		
		br.driver.findElement(By.xpath(loc.customized)).click();
		br.driver.findElement(By.xpath(loc.account_no)).sendKeys(Data.account_id);
		br.driver.findElement(By.xpath(loc.frm_date)).sendKeys("11/12/2015");
		br.driver.findElement(By.xpath(loc.t_date)).sendKeys("11/12/2016");
		br.driver.findElement(By.xpath(loc.lowerlimit)).sendKeys("500");
		br.driver.findElement(By.xpath(loc.ammount_transaction)).sendKeys("700");
		br.driver.findElement(By.xpath(loc.submit)).click();
		String expected_result="Account does not exist";
		String actual_result=br.driver.switchTo().alert().getText();
		Assert.assertEquals(actual_result, expected_result);
		br.driver.switchTo().alert().accept();
	}
	
	@Test(priority=6)
	public void Deletecustomer()  {
		try {
			br.driver.findElement(By.xpath(loc.deletecustomer)).click();
			br.driver.findElement(By.xpath(loc.del_customerid)).sendKeys(data.userid);
			br.driver.findElement(By.xpath(loc.submit)).click();
			br.driver.switchTo().alert().accept();
			Thread.sleep(3000);
			String expected="Customer deleted Successfully";
			String actual=br.driver.switchTo().alert().getText();
			Assert.assertEquals(actual, expected);
			System.out.println(actual);
			br.driver.switchTo().alert().accept();
//			String expected_result="Manger Id : mngr350302";
//			String actual_result=br.driver.findElement(By.xpath(loc.loginverify)).getText();
//			Assert.assertEquals(actual_result, expected_result);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
