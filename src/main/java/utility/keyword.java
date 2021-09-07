package utility;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import CommonLib.Browser;
import Data.Data;
import locators.locators;

public class keyword {
	
	locators loc=new locators();
	Data data=new Data();
	keyworddata keydata=new keyworddata();
public void newlogin(Browser br) {
		
		br.driver.findElement(By.xpath(loc.username)).sendKeys(data.loginid);
		br.driver.findElement(By.xpath(loc.password)).sendKeys(data.password);
		br.driver.findElement(By.xpath(loc.loginbutton)).click();

}

public void newcustomer(Browser br) throws InterruptedException {
	
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
//	br.driver.switchTo().alert().accept();
	String expected_result="Customer Registered Successfully!!!";
	String actual_result=br.driver.findElement(By.xpath("//p[@class=\"heading3\"]")).getText();
	Assert.assertEquals(actual_result, expected_result);
	data.userid=br.driver.findElement(By.xpath(loc.customerid_path)).getText();


}

public void addnewaccount(Browser br)  {
	
	br.driver.findElement(By.xpath(loc.addnewaccount)).click();
	br.driver.findElement(By.xpath(loc.customerid)).sendKeys(data.userid);
	Select acctype= new Select(br.driver.findElement(By.xpath(loc.accounttype)));
	acctype.selectByVisibleText("Savings");
	br.driver.findElement(By.xpath(loc.inideposit)).sendKeys("500");
	br.driver.findElement(By.xpath(loc.submit)).click();
	Data.account_id=br.driver.findElement(By.xpath(loc.account_id)).getText();
//	br.driver.switchTo().alert().accept();
	
	
	
}

public void Deletecustomer(Browser br)  {
	try {
		br.driver.findElement(By.xpath(loc.deletecustomer)).click();
		br.driver.findElement(By.xpath(loc.del_customerid)).sendKeys(data.userid);
		br.driver.findElement(By.xpath(loc.submit)).click();
		br.driver.switchTo().alert().accept();
		Thread.sleep(3000);
		String expected="Customer could not be deleted!!. First delete all accounts of this customer then delete the customer";
		String actual=br.driver.switchTo().alert().getText();
		Assert.assertEquals(actual, expected);
		System.out.println(actual);
		br.driver.switchTo().alert().accept();
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

}

public void deleteaccount(Browser br)  {
	
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
//	br.driver.switchTo().alert().accept();
}

}