package locators;

public class locators {
	
	//Login
	public String username="//input[@type=\"text\"]";
	public String password="//input[@type=\"password\"]";
	public String loginbutton="//input[@type=\"submit\"]";
	public String loginverify="//tr[@class=\"heading3\"]";
	
	
	//Change password
	public String changepassword="//a[@href=\"PasswordInput.php\"]";
	public String oldpassword="//input[@name=\"oldpassword\"]";
	public String newpassword="//input[@name=\"newpassword\"]";
	public String confirmpassword="//input[@name=\"confirmpassword\"]";
	public String submit="//input[@type=\"submit\"]";
	
	
	//logout
	public String logout="//a[@href=\"Logout.php\"]";
	
	
	//add new customer
	public String addnewcustomer="//a[@href=\"addcustomerpage.php\"]";
	public String customername="//input[@name=\"name\"]";
	public String male="//input[@value=\"m\"]";
	public String dob="//input[@name=\"dob\"]";
	public String address="//textarea[@onkeyup=\"validateAddress();\"]";
	public String city="//input[@onkeyup=\"validateCity();\"]";
	public String state="//input[@onkeyup=\"validateState();\"]";
	public String PIN="//input[@onkeyup=\"validatePIN();\"]";
	public String telephone="//input[@onkeyup=\"validateTelephone();\"]";
	public String email="//input[@onkeyup=\"validateEmail();\"]";
	public String passwd="//input[@onkeyup=\"validatepassword();\"]";
	public String customerid_path="//*[@id=\"customer\"]/tbody/tr[4]/td[2]";
	
	
	//add new account
	public String addnewaccount="//a[@href=\"addAccount.php\"]";
	public String customerid="//input[@name=\"cusid\"]";
	public String savings="//option[@value=\"Savings\"]";
	public String accounttype="//select[@name=\"selaccount\"]";
	public String inideposit="//input[@name=\"inideposit\"]";
	
	
	//delete customer&account
	public String deletecustomer="//a[@href=\"DeleteCustomerInput.php\"]";
	public String del_customerid="//input[@type=\"text\"]";
	public String del_account="//a[@href=\"deleteAccountInput.php\"]";
	public String account_id="//*[@id=\"account\"]/tbody/tr[4]/td[2]";
	public String account_no="//input[@name=\"accountno\"]";
	
	
	//Ministatement
	public String ministatementpage="//a[@href=\"MiniStatementInput.php\"]";
	
	//Balance Enq
	public String balanceenq="//a[@href=\"BalEnqInput.php\"]";
	
	
	//Customized check
	public String customized="//a[@href=\"CustomisedStatementInput.php\"]";
	public String frm_date="//input[@name=\"fdate\"]";
	public String t_date="//input[@name=\"tdate\"]";
	public String lowerlimit="//input[@name=\"amountlowerlimit\"]";
	public String ammount_transaction="//input[@name=\"numtransaction\"]";
	
	
	//Edit customer
	public String editcustomer="//a[@href=\"EditCustomer.php\"]";
	public String customerid1="//input[@name=\"cusid\"]";
	
	
	//Fundtransfer
	public String fundtransfer="//a[@href=\"FundTransInput.php\"]";
	public String payersaccount="//input[@name=\"payersaccount\"]";
	public String payeesaccount="//input[@name=\"payeeaccount\"]";
	public String amount="//input[@name=\"ammount\"]";
	public String desc="//input[@name=\"desc\"]";
	public String fundverify="//p[@class=\"heading3\"]";

}
