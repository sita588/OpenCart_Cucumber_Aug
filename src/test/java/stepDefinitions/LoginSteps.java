package stepDefinitions;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import factory.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import utilities.DataReader;

public class LoginSteps {
	
	WebDriver driver;
	HomePage hp;
	LoginPage lp;
	MyAccountPage ap;
	
	List<HashMap<String,String>> datamap;
	
	@Given("user navigates to login page")
	public void user_navigates_to_login_page() {
		BaseClass.getLogger().info("Go to my account --> click on Login");
		hp=new HomePage(BaseClass.getDriver());
		
		hp.clickMyAccount();
		hp.clickLogin();
	    
	}
	
	
	@When("user enters email as {string} and passwors as {string}")
	public void user_enters_email_as_and_passwors_as(String email, String pwd) {
		BaseClass.getLogger().info("Entering username and password");
		lp=new LoginPage(BaseClass.getDriver());
		
		lp.setEmail(email);
		lp.setPassword(pwd);
	   
	}
	
	
	@When("user clicks on Login button")
	public void user_clicks_on_login_button() {
		
		lp.clickLogin();
		BaseClass.getLogger().info("Clicked login button");
	    
	}
	
	
	@Then("user should be redirected to MyAccount Page")
	public void user_should_be_redirected_to_my_account_page() {
		
		ap=new MyAccountPage(BaseClass.getDriver());
		
		boolean targetPage=ap.isMyAccountPageExists();
		Assert.assertEquals(targetPage, true);
	}
	
	@When("user enters email as {string} and password as {string}")
	public void user_enters_email_as_and_password_as(String username, String password) {
	    
		BaseClass.getLogger().info("Entering username and Password");
		lp=new LoginPage(BaseClass.getDriver());
		lp.setEmail(username);
		lp.setPassword(password);
	}
	
	@Then("user should be redirected to MyAccount page by passing email and password with excel row {string}")
	public void user_should_be_redirected_to_my_account_page_by_passing_email_and_password_with_excel_row(String rows) {
	   
		try {
			datamap=DataReader.data(System.getProperty("user.dir")+"\\testData\\Opencart_LoginData.xlsx", "Sheet1");
			
			int index=Integer.parseInt(rows)-1;
			String email=datamap.get(index).get("username");
			String pwd=datamap.get(index).get("password");
			String exp_res=datamap.get(index).get("res");
			
			lp=new LoginPage(BaseClass.getDriver());
			lp.setEmail(email);
			lp.setPassword(pwd);
			
			lp.clickLogin();
			ap=new MyAccountPage(BaseClass.getDriver());
			
			try
			{
				boolean targetpage=ap.isMyAccountPageExists();
				
				if(exp_res.equals("Valid"))
				{
					if(targetpage==true)
					{
						ap.clickLogout();
						Assert.assertTrue(true);
					}
					else
					{
						Assert.assertTrue(false);
					}
				}
				
				if(exp_res.equals("Invalid"))
				{
					if(targetpage==true)
					{
						ap.clickLogout();
						Assert.assertTrue(false);
					}
					else
					{
						Assert.assertTrue(true);
					}
				}
				
				
			}catch(Exception e)
			{
				Assert.assertTrue(false);
			}
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}



}
