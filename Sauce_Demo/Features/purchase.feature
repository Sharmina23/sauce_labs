Feature: User able to login with valid username & password and purchase an item

Description: "User can login to sauce demo website & add/remove items to the cart &"
        "checkout the items in the cart"  
              
Background: User can login to the sauce demo website
	Given User can open any browser 
	And User is able to enter saucedemo url 
	When User enter the userName and password 
	And User click on the Login button
	Then User able to successfully login to sauce demo website

Scenario: User can change sorting from by name to by price
	Given User clicks on the dropdown
	Then User can change sorting from by name to by low to high price	

	
Scenario: User can add two or more items to the shopping cart
	
	Given User clicks on Add to Cart on the first item
	And User clicks on Add to cart on second item
	And User clicks on Add to cart on third item
	When User clicks on the Shopping Cart
	Then User can verify the items

@Scenario3
Scenario: User can remove an item from the cart and continue shopping

	Given User clicks on Add to Cart on the first item
	And User clicks on Add to cart on second item
	And User clicks on Add to cart on third item
	When User clicks on the Shopping Cart
	And User clicks the remove button
	And User clicks on Continue shopping button
	Then User returns to products page to continue shopping

@Scenario4	
Scenario: User can add another item to the cart and checkout the cart

	Given User clicks on Add to Cart on the first item
	And User clicks on Add to cart on second item
	When User clicks on the Shopping Cart
	And User clicks on Continue shopping button
	And User clicks on Add to cart on third item
	And User clicks on the Shopping Cart
	And User clicks on Checkout
	And User adds personal detail & clicks on Continue
	Then User can verify the items
	And Verify the total price
	And User can finish the checkout
	