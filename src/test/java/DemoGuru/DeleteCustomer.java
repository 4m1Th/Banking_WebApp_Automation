package DemoGuru;

import java.util.concurrent.BrokenBarrierException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import CommonLib.Browser;
import Data.Data;
import URL.url;
import locators.locators;
import utility.keyword;

public class DeleteCustomer {

	Browser br=new Browser();
	url ur=new url();
	Data data=new Data();
	locators loc=new locators();
	keyword key=new keyword();
	
	@BeforeClass()
	public void open() {
		
		br.web(ur.url);
	}
	@AfterClass()
	public void close() {
		
		br.driver.close();
		br.driver.quit();
	}
	@Test(priority=1)
	public void login() {
		
		key.newlogin(br);
	}
	@Test(priority=2)
	public void deletecustomer_accountexist() throws InterruptedException {
		
		key.newcustomer(br);
		key.addnewaccount(br);
		key.Deletecustomer(br);
		key.deleteaccount(br);
			try {
				br.driver.findElement(By.xpath(loc.deletecustomer)).click();
				br.driver.findElement(By.xpath(loc.del_customerid)).sendKeys(data.userid);
				br.driver.findElement(By.xpath(loc.submit)).click();
				br.driver.switchTo().alert().accept();
				Thread.sleep(3000);
				br.driver.switchTo().alert().accept();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	@Test(priority=3)
	public void customerdelete_withnoaccount() throws InterruptedException {
		
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
		Data.userid=br.driver.findElement(By.xpath(loc.customerid_path)).getText();
		
			br.driver.findElement(By.xpath(loc.deletecustomer)).click();
			br.driver.findElement(By.xpath(loc.del_customerid)).sendKeys(Data.userid);
			br.driver.findElement(By.xpath(loc.submit)).click();
			br.driver.switchTo().alert().accept();
			Thread.sleep(3000);
			String expected="Customer deleted Successfully";
			String actual=br.driver.switchTo().alert().getText();
			Assert.assertEquals(actual, expected);
			System.out.println(actual);
			br.driver.switchTo().alert().accept();
	
	}
	
	@Test(priority=4)
	public void customercantbeedited_ifnotexist() {
		
		br.driver.findElement(By.xpath(loc.editcustomer)).click();
		br.driver.findElement(By.xpath(loc.customerid1)).sendKeys(Data.userid);
		br.driver.findElement(By.xpath(loc.submit)).click();
		String expected="Customer does not exist!!";
		String actual=br.driver.switchTo().alert().getText();
		Assert.assertEquals(actual, expected);
		System.out.println(actual);
		br.driver.switchTo().alert().accept();
	}
	@Test(priority=5)
	public void deletecustomer_whichdoesnotexist() {
		
		br.driver.findElement(By.xpath(loc.deletecustomer)).click();
		br.driver.findElement(By.xpath(loc.customerid)).sendKeys(Data.userid);
		br.driver.findElement(By.xpath(loc.submit)).click();
		br.driver.switchTo().alert().accept();
		String expected="Customer does not exist!!";
		String actual=br.driver.switchTo().alert().getText();
		Assert.assertEquals(actual, expected);
		System.out.println(actual);
		br.driver.switchTo().alert().accept();
		
	}
}
