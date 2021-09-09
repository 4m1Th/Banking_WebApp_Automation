package DemoGuru;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import CommonLib.Browser;
import URL.url;
import locators.locators;
import utility.keyworddata;
import utility.keywordforfund;

public class Deposit {
	
	Browser br=new Browser();
	url ur=new url();
	locators loc=new locators();
	keyworddata keydata=new keyworddata();
	keywordforfund key=new keywordforfund();
	
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
		key.newcustomer1(br, "czcxikn", "11/06/1254", "kakod", "kakod", "kakod", "670662", "5454855447", "bfa@gikvi.com", "anybody123");
		key.addnewaccount1(br);
	}
	@Test(priority=2)
	public void deposit() {
		
		br.driver.findElement(By.xpath(loc.deposit)).click();
		br.driver.findElement(By.xpath(loc.accountno)).sendKeys(keydata.keywordaccid1);
		br.driver.findElement(By.xpath(loc.amount)).sendKeys("500");
		br.driver.findElement(By.xpath(loc.desc)).sendKeys("cash");
		br.driver.findElement(By.xpath(loc.submit)).click();
		String expected=keydata.keywordaccid1;
		String actual=br.driver.findElement(By.xpath("//*[@id=\"deposit\"]/tbody/tr[7]/td[2]")).getText();
		Assert.assertEquals(actual, expected);
	}
	@Test(priority=3)
	public void refresh() {
		
		br.driver.navigate().refresh();
		String expected="Amount Deposit Form";
		String actual=br.driver.findElement(By.xpath("//p[@class=\"heading3\"]")).getText();
		Assert.assertEquals(actual, expected);
	}

}
