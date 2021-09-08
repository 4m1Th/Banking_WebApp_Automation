package DemoGuru;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import CommonLib.Browser;
import URL.url;
import locators.locators;
import utility.keyword;
import utility.keyworddata;
import utility.keywordforfund;

public class Editcustomer {
	
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
	}
	
	@Test(priority=2)
	public void newcustomer1() {
		
		key.newcustomer1(br, "rfxcxbv", "11/06/1254", "kkxbcd", "kakod", "kakod", "670662", "5454855447", "ntb@gxvc.com", "anybody123");
		System.out.println("Customer id1:"+keyworddata.keyworduserid1);

	}
	
	@Test(priority=3)
	public void verify_editcustomer() {
		
		br.driver.findElement(By.xpath(loc.editcustomer)).click();
		br.driver.findElement(By.xpath(loc.customerid1)).sendKeys(keyworddata.keyworduserid1);
		br.driver.findElement(By.xpath(loc.submit)).click();
		String actual=br.driver.findElement(By.xpath("//p[@class=\"heading3\"]")).getText();
		String expected="Edit Customer";
		Assert.assertEquals(actual, expected);
		
	}

}
