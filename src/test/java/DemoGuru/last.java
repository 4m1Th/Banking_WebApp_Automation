package DemoGuru;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import CommonLib.Browser;
import URL.url;
import locators.locators;
import locators.locatorsnew;
import utility.keyworddata;
import utility.keywordforfund;

public class last {
	
	Browser br=new Browser();
	url ur=new url();
	locators loc=new locators();
	keywordforfund key=new keywordforfund();
	locatorsnew loc1=new locatorsnew();
	keyworddata keydata=new keyworddata();
	JavascriptExecutor jse = (JavascriptExecutor)br.driver;


		
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
			
			key.newcustomer1(br, "hikiike", "11/06/1254", "kkxbcd", "kakod", "kakod", "670662", "5454855447", "hikjie@scd.com", "anybody123");
			br.driver.findElement(By.xpath(loc.editcustomer)).click();
			br.driver.findElement(By.xpath(loc.customerid1)).sendKeys(keyworddata.keyworduserid1);
			br.driver.findElement(By.xpath(loc.submit)).click();
			br.driver.findElement(By.xpath("//textarea[@name=\"addr\"]")).sendKeys("Hello");
			br.driver.findElement(By.xpath(loc.submit)).click();
			String expected="Customer details updated Successfully!!!";
			String actual=br.driver.findElement(By.xpath("//p[@class=\"heading3\"]")).getText();
			Assert.assertEquals(actual, expected);
			
		}
		@Test(priority=3)
		public void verifycustomercanlogin() {
			
			key.newcustomer1(br, "zaarzsk", "11/06/1254", "kkxbcd", "kakod", "kakod", "670662", "5454855447", "zaika@dbhiaa.com", "zaraaa123");
			
			
		}
		@Test(priority=4)
		public void cont() {
			
			br.driver.findElement(By.xpath(loc.addnewcustomer)).click();
			br.driver.findElement(By.cssSelector("body > div:nth-child(6) > div > ul > li:nth-child(15) > a")).click();
//			jse.executeScript("arguments[0].click();", logout);
			br.driver.switchTo().alert().accept();
			br.driver.findElement(By.xpath(loc.username)).sendKeys(keyworddata.keyworduserid1);
			br.driver.findElement(By.xpath(loc.password)).sendKeys("zaraaa123");
			br.driver.findElement(By.xpath(loc.loginbutton)).click();
			String expected="Guru99 Bank";
			String actual=br.driver.findElement(By.xpath("//h2[@class=\"barone\"]")).getText();
			Assert.assertEquals(actual, expected);

		}
		@Test(priority=5)
		public void logout() {
			
			br.driver.findElement(By.xpath("//a[@href=\"Logout.php\"]")).click();
			String expected="You Have Succesfully Logged Out!!";
			String actual=br.driver.switchTo().alert().getText();
			Assert.assertEquals(actual, expected);
			br.driver.switchTo().alert().accept();
		}
}
