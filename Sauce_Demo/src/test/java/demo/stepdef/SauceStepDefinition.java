package demo.stepdef;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import demo.basepage.BasePage;
import demo.elementpage.PageFactoryElements;
import demo.utility.CommonUtilities;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SauceStepDefinition extends BasePage {

	PageFactoryElements pf;
	
	@Given("User can open any browser")
	public void user_can_open_any_browser() {
		pf = PageFactory.initElements(driver, PageFactoryElements.class);
	    
	}

	@Given("User is able to enter saucedemo url")
	public void user_is_able_to_enter_saucedemo_url() {
		driver.navigate().to(prop.getProperty("URL"));
	}

	@When("User enter the userName and password")
	public void user_enter_the_user_name_and_password() {
		CommonUtilities.getExplicitWait(pf.getUserName(), driver, 10);
		pf.getUserName().sendKeys(prop.getProperty("username"));
		CommonUtilities.getExplicitWait(pf.getPwd(), driver, 10);
		pf.getPwd().sendKeys(prop.getProperty("password"));
	    
	}

	@When("User click on the Login button")
	public void user_click_on_the_login_button() {
		CommonUtilities.getExplicitWait(pf.getPwd(), driver, 10);
		pf.getPwd().submit();
	    
	}

	@Then("User able to successfully login to sauce demo website")
	public void user_able_to_successfully_login_to_sauce_demo_website() {
		String expected = "Swag Labs";
		Assert.assertEquals(pf.getTitles(), expected);
	    
	}
	
	@Given("User clicks on the dropdown")
	public void user_clicks_on_the_dropdown() {
		CommonUtilities.getExplicitWait(pf.getSort(), driver, 10);
		pf.getSort().click();
	}

	@Then("User can change sorting from by name to by low to high price")
	public void user_can_change_sorting_from_by_name_to_by_low_to_high_price() {
		pf.handleDropDownMenu("Price (low to high)");
	}



	@Given("User clicks on Add to Cart on the first item")
	public void user_clicks_on_add_to_cart_on_the_first_item() {
		pf.selectItem(0);
	    
	}

	@Given("User clicks on Add to cart on second item")
	public void user_clicks_on_add_to_cart_on_second_item() {
		pf.selectItem(1);
	    
	}

	@Given("User clicks on Add to cart on third item")
	public void user_clicks_on_add_to_cart_on_third_item() {
		pf.selectItem(2);
	    
	}

	@When("User clicks on the Shopping Cart")
	public void user_clicks_on_the_shopping_cart() {
		try{
			pf.getCart().click();
		     
		  }
		  catch(Exception e){
			 pf.getCartLink().click();
		  }
		
		
	    
	}

	
	@Then("User can verify the items")
	public void user_can_verify_the_items() {
		String item1 = "Sauce Labs Backpack";
		String item2 = "Sauce Labs Bolt T-Shirt";
		String item3 = "Sauce Labs Onesie";
		
		Assert.assertEquals(item1, pf.itemText(0).get(0).getText());
		Assert.assertEquals(item2, pf.itemText(1).get(1).getText());
		Assert.assertEquals(item3, pf.itemText(2).get(2).getText());
	}

	@When("User clicks the remove button")
	public void user_clicks_the_remove_button() { 
	    pf.removeItem(0);
	}

	@When("User clicks on Continue shopping button")
	public void user_clicks_on_continue_shopping_button() {
		CommonUtilities.getExplicitWait(pf.getContinueShopping(), driver, 10);
	    pf.getContinueShopping().click();
	    
	}
	
	@Then("User returns to products page to continue shopping")
	public void user_returns_to_products_page_to_continue_shopping() {
	    String title = "Swag Labs";
	    Assert.assertEquals(title, pf.getTitles());
	    
	}


	@When("User clicks on Checkout")
	public void user_clicks_on_checkout() {
		CommonUtilities.getExplicitWait(pf.getCheckout(), driver, 10);
	    pf.getCheckout().click();
	    
	}
	
	@When("User adds personal detail & clicks on Continue")
	public void user_adds_personal_detail_clicks_on_continue() {
	   pf.getFirstName().sendKeys(prop.getProperty("firstname"));
	   pf.getLastName().sendKeys(prop.getProperty("lastname"));
	   pf.getPostalCode().sendKeys(prop.getProperty("postal"));
	   pf.getContinueBtn().click();
	}

	@Then("Verify the total price")
	public void verify_the_total_price() {
		String expected = "Total: $58.29";
		String actual = pf.getTotalPrice().getText();
	    Assert.assertEquals(actual, expected);
	}
	
	@Then("User can finish the checkout")
	public void user_can_finish_the_checkout() {
		CommonUtilities.getExplicitWait(pf.getFinishBtn(), driver, 10);
	    pf.getFinishBtn().click();
	    
	}




}
