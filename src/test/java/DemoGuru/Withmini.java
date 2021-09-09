package DemoGuru;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import CommonLib.Browser;
import Data.Data;
import URL.url;
import locators.locators;
import locators.locatorsnew;
import utility.keyword;
import utility.keyworddata;
import utility.keywordforfund;

public class Withmini {
	
	Browser br=new Browser();
	url ur=new url();
	locators loc=new locators();
	keywordforfund key=new keywordforfund();
	locatorsnew loc1=new locatorsnew();
	keyworddata keydata=new keyworddata();
	DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy ");
	Date date = new Date();



	String date1= dateFormat.format(date);

	@BeforeClass
	public void open() {
		
		br.web(ur.url);
	}
	@AfterClass
	public void close() {
		
		br.driver.close();
		br.driver.quit();
	}
	@Test(priority=1)
	public void login() {
		
		key.newlogin(br);
		
	}
	@Test(priority=2)
	public void verifywithdrawal() throws InterruptedException {
		
		key.newcustomer1(br, "rikecd", "11/06/1254", "kkxbcd", "kakod", "kakod", "670662", "5454855447", "zbiked@bxc.com", "anybody123");
		key.addnewaccount1(br);
		br.driver.findElement(By.xpath(loc1.withdrawallink)).click();
		br.driver.findElement(By.xpath(loc.accountno)).sendKeys(keyworddata.keywordaccid1);
		br.driver.findElement(By.xpath(loc.amount)).sendKeys("500");
		br.driver.findElement(By.xpath(loc.desc)).sendKeys("Cash");
		br.driver.findElement(By.xpath(loc.submit)).click();
		String expected=keydata.keywordaccid1;
		String actual=br.driver.findElement(By.xpath("//*[@id=\"withdraw\"]/tbody/tr[7]/td[2]")).getText();
		Assert.assertEquals(actual, expected);
		
	}
	
	@Test(priority=3)
	public void verifybalancelow() {
		
		br.driver.navigate().refresh();
		br.driver.findElement(By.xpath(loc.accountno)).sendKeys(keyworddata.keywordaccid1);
		br.driver.findElement(By.xpath(loc.amount)).sendKeys("16000000000");
		br.driver.findElement(By.xpath(loc.desc)).sendKeys("cash");
		br.driver.findElement(By.xpath(loc.submit)).click();
		String expected="Transaction Failed. Account Balance Low!!!";
		String actual=br.driver.switchTo().alert().getText();
		Assert.assertEquals(actual, expected);
		br.driver.switchTo().alert().accept();
		
	}
	
	@Test(priority=4)
	public void verifyministatement() {
		
	 br.driver.findElement(By.xpath(loc.ministatementpage)).click();
	 br.driver.findElement(By.xpath(loc.accountno)).sendKeys(keyworddata.keywordaccid1);
	 br.driver.findElement(By.xpath(loc.submit)).click();
	 String expected="Last Five Transaction Details for Account No: "+keyworddata.keywordaccid1;
	 String actual=br.driver.findElement(By.xpath("//p[@class=\"heading3\"]")).getText();
	 Assert.assertEquals(actual, expected);
	}
	
	@Test(priority=5)
	public void verifybalance() {
		
		br.driver.findElement(By.xpath(loc1.balanceenq)).click();
		br.driver.findElement(By.xpath(loc.accountno)).sendKeys(keyworddata.keywordaccid1);
		br.driver.findElement(By.xpath(loc.submit)).click();
		String expected="Balance Details for Account "+keyworddata.keywordaccid1;
		String actual=br.driver.findElement(By.xpath("//p[@class=\"heading3\"]")).getText();
		Assert.assertEquals(actual, expected);
	}
	
	@Test(priority=6)
	public void verifycustomizedstatement() {
		
		br.driver.findElement(By.xpath(loc.customized)).click();
		br.driver.findElement(By.xpath(loc.accountno)).sendKeys(keyworddata.keywordaccid1);
		br.driver.findElement(By.xpath(loc.frm_date)).sendKeys(date1);
		br.driver.findElement(By.xpath(loc.t_date)).sendKeys(date1);
		br.driver.findElement(By.xpath(loc.lowerlimit)).sendKeys("200");
		br.driver.findElement(By.xpath(loc.ammount_transaction)).sendKeys("3");
		br.driver.findElement(By.xpath(loc.submit)).click();
//		String expected="Transaction Details for Account No: "+keyworddata.keywordaccid1+" from Date: "+date1+" to: "+date1;
//		String actual=br.driver.findElement(By.xpath("//p[@class=\"heading3\"]")).getText();
//		Assert.assertEquals(actual, expected);
		
	}
	
	@Test(priority=7)
	public void verifycusstatementwithhigherfromdate() {
		
		br.driver.findElement(By.xpath(loc.customized)).click();
		br.driver.findElement(By.xpath(loc.accountno)).sendKeys(keyworddata.keywordaccid1);
		br.driver.findElement(By.xpath(loc.frm_date)).sendKeys("17/09/2021");
		br.driver.findElement(By.xpath(loc.t_date)).sendKeys(date1);
		br.driver.findElement(By.xpath(loc.lowerlimit)).sendKeys("200");
		br.driver.findElement(By.xpath(loc.ammount_transaction)).sendKeys("3");
		br.driver.findElement(By.xpath(loc.submit)).click();
		String expected="FromDate field should be lower than ToDate field!!";
		String actual=br.driver.switchTo().alert().getText();
		Assert.assertEquals(actual, expected);
		br.driver.switchTo().alert().accept();
		
		
	}
	

}
