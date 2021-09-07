package DemoGuru;

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
import utility.keyworddata;
import utility.keywordforfund;

public class Fundtransfer {
	
	Browser br=new Browser();
	url ur=new url();
	locators loc=new locators();
	keyworddata keydata=new keyworddata();
	keywordforfund keyfund=new keywordforfund();
	
	
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
		
		keyfund.newlogin(br);
	}
	@Test(priority=2)
	public void creation() throws InterruptedException {
	
		keyfund.newcustomer1(br, "llbfcbd", "11/06/1254", "kakod", "kakod", "kakod", "670662", "5454855447", "thsbsbfa@gvai.com", "anybody123");
		keyfund.addnewaccount1(br);
		keyfund.newcustomer2(br, "llvcmbd", "11/06/1254", "kakod", "kakod", "kakod", "670662", "5454855447", "adgg@mvai.com", "anybody123");
		keyfund.addnewaccount2(br);
		System.out.println("Account id1:"+keydata.keywordaccid1);
		System.out.println("Account id2:"+keydata.keywordaccid2);
		System.out.println("cname id1:"+keydata.keyworduserid1);
		System.out.println("cname id1:"+keydata.keyworduserid2);

	}
	
	@Test(priority=3)
	public void fundtransfer() throws InterruptedException {
		
		br.driver.findElement(By.xpath(loc.fundtransfer)).click();
		br.driver.findElement(By.xpath(loc.payersaccount)).sendKeys(keydata.keywordaccid1);
		br.driver.findElement(By.xpath(loc.payeesaccount)).sendKeys(keydata.keywordaccid2);
		br.driver.findElement(By.xpath(loc.amount)).sendKeys("200");
		br.driver.findElement(By.xpath(loc.desc)).sendKeys("cash");
		br.driver.findElement(By.xpath(loc.submit)).click();
		String expected="Fund Transfer Details";
		String actual=br.driver.findElement(By.xpath(loc.fundverify)).getText();
		Assert.assertEquals(actual, expected);
		
	}
	
	@Test(priority=4)
	public void refresh() {
		
		br.driver.navigate().refresh();
		String expected="Fund transfer";
		String actual=br.driver.findElement(By.xpath("//p[@class=\"heading3\"]")).getText();
		Assert.assertEquals(actual, expected);
	}
	@Test(priority=5)
	public void verifytransfer() throws InterruptedException {
		
		br.driver.findElement(By.xpath(loc.customized)).click();
		br.driver.findElement(By.xpath(loc.account_no)).sendKeys(keydata.keywordaccid1);
		br.driver.findElement(By.xpath(loc.frm_date)).sendKeys("06/09/2021");
		br.driver.findElement(By.xpath(loc.t_date)).sendKeys("07/09/2021");
		br.driver.findElement(By.xpath(loc.submit)).click();
		Thread.sleep(7000);
		br.driver.switchTo().alert().accept();
		
	}
	
	@Test(priority=6)
	public void systembehaviour() throws InterruptedException {
		
		br.driver.findElement(By.xpath(loc.fundtransfer)).click();
		br.driver.findElement(By.xpath(loc.payersaccount)).sendKeys("1234");
		br.driver.findElement(By.xpath(loc.payeesaccount)).sendKeys(keydata.keywordaccid2);
		br.driver.findElement(By.xpath(loc.amount)).sendKeys("500");
		br.driver.findElement(By.xpath(loc.desc)).sendKeys("cash");
		br.driver.findElement(By.xpath(loc.submit)).click();
		String expected="Account 1234does not exist!!!";
		String actual=br.driver.switchTo().alert().getText();
		Assert.assertEquals(actual, expected);
		Thread.sleep(7000);
		br.driver.switchTo().alert().accept();
		
		
	}
	
	@Test(priority=7)
	public void systembehaviour_whenmanager() {
		br.driver.findElement(By.xpath(loc.fundtransfer)).click();
		br.driver.findElement(By.xpath(loc.payersaccount)).sendKeys(keydata.keywordaccid1);
		br.driver.findElement(By.xpath(loc.payeesaccount)).sendKeys(keydata.keywordaccid2);
		br.driver.findElement(By.xpath(loc.amount)).sendKeys("500");
		br.driver.findElement(By.xpath(loc.desc)).sendKeys("cash");
		br.driver.findElement(By.xpath(loc.submit)).click();
		String expected="You are not authorize to do fund transfer!!";
		String actual=br.driver.findElement(By.xpath(loc.fundverify)).getText();
		Assert.assertEquals(actual, expected);
	}
	
//	
//	@Test(priority=4)
//	public void delete() {
//		
//	}

}
