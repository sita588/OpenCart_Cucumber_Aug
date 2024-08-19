package stepDefinitions;

import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import factory.BaseClass;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.HomePage;
import pageObjects.RegistrationPage;

public class RegistrationSteps {
	
	WebDriver driver;
	HomePage hp;
	RegistrationPage rp;
	
	@Given("user navigates to Account Register Page")
	public void user_navigates_to_account_register_page() {
		
		hp=new HomePage(BaseClass.getDriver());
		hp.clickMyAccount();
		hp.clickRegister();
	    
	}
	
	
	@When("user enters below details")
	public void user_enters_below_details(DataTable dataTable) {
		
		Map<String,String> dataMap=dataTable.asMap(String.class,String.class);
		
		rp=new RegistrationPage(BaseClass.getDriver());
		rp.setFirstName(dataMap.get("firstname"));
		rp.setLastName(dataMap.get("lastname"));
		rp.setEmail(BaseClass.randomString()+"@gmail.com");
		rp.setTelephone(dataMap.get("telephone"));
		rp.setPassword(dataMap.get("password"));
		rp.setConfirmPassword(dataMap.get("password"));
		
	    
	}
	@When("user selects privacy policy")
	public void user_selects_privacy_policy() {
		
		rp.clickPolicyCheckBox();
	    
	}
	@When("user clicks on continue button")
	public void user_clicks_on_continue_button() {
		
		rp.clickContinueButton();
	    
	}
	
	@Then("user account should be created")
	public void user_account_should_be_created() {
	    
		String msg=rp.getConfirmMsg();
		Assert.assertEquals(msg, "Your Account Has Been Created!");
	}

}
