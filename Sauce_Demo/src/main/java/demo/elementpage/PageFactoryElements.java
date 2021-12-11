package demo.elementpage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import demo.basepage.BasePage;
import demo.utility.CommonUtilities;

public class PageFactoryElements extends BasePage {

	public PageFactoryElements(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "user-name")
	@CacheLookup
	private WebElement userName;

	public WebElement getUserName() {
		return userName;
	}

	@FindBy(id = "password")
	@CacheLookup
	private WebElement pwd;

	public WebElement getPwd(){
		return pwd;
	}

	@FindBy(id = "")
	@CacheLookup
	private WebElement item1;

	public WebElement getItem1(){
		return item1;
	}
	
	@FindBy(id = "shopping_cart_container")
	@CacheLookup
	private WebElement item2;

	public WebElement getItem2(){
		return item2;
	}
	
	@FindBy(id = "shopping_cart_container")
	@CacheLookup
	private WebElement item3;

	public WebElement getItem3(){
		return cart;
	}
	
	@FindBy(id = "shopping_cart_container")
	@CacheLookup
	private WebElement cart;

	public WebElement getCart(){
		return cart;
	}
	
	@FindBy(xpath = "//*[@class='shopping_cart_link']")
	@CacheLookup
	private WebElement cartLink;

	public WebElement getCartLink(){
		return cartLink;
	}
	
	@FindBy(id = "continue-shopping")
	@CacheLookup
	private WebElement continuebtn;

	public WebElement getContinueShopping(){
		return continuebtn;
	}
	
	@FindBy(id = "checkout")
	@CacheLookup
	private WebElement checkoutbtn;

	public WebElement getCheckout(){
		return checkoutbtn;
	}
	
	@FindBy(id = "first-name")
	@CacheLookup
	private WebElement firstName;

	public WebElement getFirstName(){
		return firstName;
	}
	
	@FindBy(id = "last-name")
	@CacheLookup
	private WebElement lastName;

	public WebElement getLastName(){
		return lastName;
	}
	
	@FindBy(id = "postal-code")
	@CacheLookup
	private WebElement postalCode;

	public WebElement getPostalCode(){
		return postalCode;
	}
	
	@FindBy(id = "continue")
	@CacheLookup
	private WebElement continueBtn;

	public WebElement getContinueBtn(){
		return continueBtn;
	}
	
	@FindBy(xpath = "//*[@class='summary_total_label']")
	@CacheLookup
	private WebElement total;

	public WebElement getTotalPrice(){
		return total;
	}
	
	@FindBy(id = "finish")
	@CacheLookup
	private WebElement finishBtn;

	public WebElement getFinishBtn(){
		return finishBtn;
	}
	
	@FindBy(xpath = "//*[@class='product_sort_container']")
	@CacheLookup
	private WebElement sort;

	public WebElement getSort(){
		return sort;
	}
	
	
	public String getTitles() {
		  String title = driver.getTitle();
		  return title;
		
	}
	
	public void handleDropDownMenu(String dropDownValues) {

		List<WebElement> list = driver.findElements(By.xpath("//*[@class='product_sort_container']/option"));
		for (WebElement option : list) {
			if (option.getText().contains(dropDownValues)) {
				option.click();
				break;
			}
		}	
		
		
		
	}
	
	public List<WebElement> selectItem(int num) {

		List<WebElement> element = driver.findElements(By.xpath("//*[contains(text(),'Add to cart')]"));
		CommonUtilities.waitVisibilityOfAllElements(element);

		for (int i = 0; i <= element.size(); i++) {
			if (i >= num) {			
				element.get(i).click();
				break;
			}
		}
		return element;
	}
	
	
	public List<WebElement> itemText(int num) {

		List<WebElement> element = driver.findElements(By.xpath("//*[@class='inventory_item_name']"));
		CommonUtilities.waitVisibilityOfAllElements(element);

		for (int i = 0; i <= element.size(); i++) {
			if (i >= num) { 
				element.get(i).getText();
				break;
			}
		}
		return element;
	}
	
	public List<WebElement> removeItem(int num) {

		List<WebElement> element = driver.findElements(By.xpath("//*[@class='btn btn_secondary btn_small cart_button']"));
		CommonUtilities.waitVisibilityOfAllElements(element);

		for (int i = 0; i <= element.size(); i++) {
			if (i >= num) { 
				element.get(i).click();
				break;
			}
		}
		return element;
	}
	

	

	
}
