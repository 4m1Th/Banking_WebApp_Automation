package utility;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import CommonLib.Browser;
import Data.Data;
import locators.locators;

public class keywordforfund {
	locators loc=new locators();
	Data data=new Data();
	keyworddata keydata=new keyworddata();
	
	public void newcustomer1(Browser br, String  cname,String date, String address, String city, String state, String PIN, String mobileno, String email, String passwd) {
		
		
		br.driver.findElement(By.xpath(loc.addnewcustomer)).click();
		br.driver.findElement(By.xpath(loc.customername)).sendKeys(cname);
		br.driver.findElement(By.xpath(loc.male)).click();
		br.driver.findElement(By.xpath(loc.dob)).sendKeys(date);
		br.driver.findElement(By.xpath(loc.address)).sendKeys(address);
		br.driver.findElement(By.xpath(loc.city)).sendKeys(city);
		br.driver.findElement(By.xpath(loc.state)).sendKeys(state);
		br.driver.findElement(By.xpath(loc.PIN)).sendKeys(PIN);
		br.driver.findElement(By.xpath(loc.telephone)).sendKeys(mobileno);
		br.driver.findElement(By.xpath(loc.email)).sendKeys(email);
		br.driver.findElement(By.xpath(loc.passwd)).sendKeys(passwd);
		br.driver.findElement(By.xpath(loc.submit)).click();
//		br.driver.switchTo().alert().accept();
		keydata.keyworduserid1=br.driver.findElement(By.xpath(loc.customerid_path)).getText();
	}
	
	
	
public void newcustomer2(Browser br, String  cname,String date, String address, String city, String state, String PIN, String mobileno, String email, String passwd) {
		
		
		br.driver.findElement(By.xpath(loc.addnewcustomer)).click();
		br.driver.findElement(By.xpath(loc.customername)).sendKeys(cname);
		br.driver.findElement(By.xpath(loc.male)).click();
		br.driver.findElement(By.xpath(loc.dob)).sendKeys(date);
		br.driver.findElement(By.xpath(loc.address)).sendKeys(address);
		br.driver.findElement(By.xpath(loc.city)).sendKeys(city);
		br.driver.findElement(By.xpath(loc.state)).sendKeys(state);
		br.driver.findElement(By.xpath(loc.PIN)).sendKeys(PIN);
		br.driver.findElement(By.xpath(loc.telephone)).sendKeys(mobileno);
		br.driver.findElement(By.xpath(loc.email)).sendKeys(email);
		br.driver.findElement(By.xpath(loc.passwd)).sendKeys(passwd);
		br.driver.findElement(By.xpath(loc.submit)).click();
//		br.driver.switchTo().alert().accept();
		keydata.keyworduserid2=br.driver.findElement(By.xpath(loc.customerid_path)).getText();
	}
	
public void newlogin(Browser br) {
		
		br.driver.findElement(By.xpath(loc.username)).sendKeys(data.loginid);
		br.driver.findElement(By.xpath(loc.password)).sendKeys(data.password);
		br.driver.findElement(By.xpath(loc.loginbutton)).click();

}

public void addnewaccount1(Browser br)  {
	
	br.driver.findElement(By.xpath(loc.addnewaccount)).click();
	br.driver.findElement(By.xpath(loc.customerid)).sendKeys(keydata.keyworduserid1);
	Select acctype= new Select(br.driver.findElement(By.xpath(loc.accounttype)));
	acctype.selectByVisibleText("Savings");
	br.driver.findElement(By.xpath(loc.inideposit)).sendKeys("10000");
	br.driver.findElement(By.xpath(loc.submit)).click();
	keydata.keywordaccid1=br.driver.findElement(By.xpath(loc.account_id)).getText();
//	br.driver.switchTo().alert().accept();
	
	
	
}
public void addnewaccount2(Browser br)  {
	
	br.driver.findElement(By.xpath(loc.addnewaccount)).click();
	br.driver.findElement(By.xpath(loc.customerid)).sendKeys(keydata.keyworduserid2);
	Select acctype= new Select(br.driver.findElement(By.xpath(loc.accounttype)));
	acctype.selectByVisibleText("Savings");
	br.driver.findElement(By.xpath(loc.inideposit)).sendKeys("500");
	br.driver.findElement(By.xpath(loc.submit)).click();
	keydata.keywordaccid2=br.driver.findElement(By.xpath(loc.account_id)).getText();
//	br.driver.switchTo().alert().accept();
	
	
	
}

}
