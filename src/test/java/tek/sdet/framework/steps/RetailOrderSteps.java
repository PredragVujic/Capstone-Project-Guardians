package tek.sdet.framework.steps;

import org.junit.Assert;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import tek.sdet.framework.pages.POMFactory;
import tek.sdet.framework.utilities.CommonUtility;

public class RetailOrderSteps extends CommonUtility {

	POMFactory pomFactory = new POMFactory();

	@Then("User change the category to {string}")
	public void userChangeTheCategoryTo(String catgory) {
		selectByVisibleText(pomFactory.orderPage().allDepartmentDropdown, catgory);
		logger.info("Category was selected successfully from dropdown");

	}

	@Then("User search for an item {string}")
	public void userSearchForAnItem(String kasaOutdoorSmartPlug) {
		sendText(pomFactory.orderPage().searchInputField, kasaOutdoorSmartPlug);
		logger.info("Item name was entered successfuylly");

	}

	@Then("User click on Search icon")
	public void userClickOnSearchIcon() {
		click(pomFactory.orderPage().searchBttn);
		logger.info("Search button was clicked successfully");

	}

	@Then("User click on item")
	public void userClickOnItem() {
		click(pomFactory.orderPage().itemkasaoutdoorsmartplug);
		logger.info("Item was clicked successfully");

	}

	@Then("User select quantity {string}")
	public void userSelectQuantity(String itemQty) {
		selectByVisibleText(pomFactory.orderPage().qtyDropdown, itemQty);
		logger.info("Item quantity was selected successfully");

	}

	@Then("User click add to Cart button")
	public void userClickAddToCartButton() {
		click(pomFactory.orderPage().addToCartBttn);
		logger.info("Add ittem to the cart button was clicked successfully");

	}

	@Then("the cart icon quantity should change to {string}")
	public void theCartIconQuantityShouldChangeTo(String itemQtyInTheCart) {
		Assert.assertEquals(itemQtyInTheCart, pomFactory.orderPage().cartItemQty.getText());
		logger.info("Item qty in the cart was validated successfully");

	}
// addItemToCartAndCheckout

	@When("User change the category to {string} Apex Legends")
	public void userChangeTheCategoryToApexLegends(String electronics) {
		selectByVisibleText(pomFactory.orderPage().allDepartmentDropdown, electronics);
		logger.info("Category changed to electronics successfully");
	}

	@When("User search for an item {string} Apex Legends")
	public void userSearchForAnItemApexLegends(String apexLegends) {
		sendText(pomFactory.orderPage().searchInputField, apexLegends);
		logger.info("Item name was entered successfully");
	}

	@When("User click on item Apex Legends")
	public void userClickOnItemApexLegends() {
		click(pomFactory.orderPage().apexLegendsItem);
		logger.info("Item Apex Legends was clicked successfully");
	}

	@When("User select quantity {string} for Apex Legends")
	public void userSelectQuantityForApexLegends(String aplexLegendsQty) {
		selectByVisibleText(pomFactory.orderPage().qtyDropdown, aplexLegendsQty);
		logger.info("Apex Legends qty was changed successfully");
	}

	@Then("the cart icon quantity should change to {string} Apex Legends")
	public void theCartIconQuantityShouldChangeToApexLegends(String itemQtyInTheCart) {
		Assert.assertEquals(itemQtyInTheCart, pomFactory.orderPage().cartItemQty.getText());
		logger.info("Item qty in the cart was validated successfully");
	}

	@Then("User click on Cart option")
	public void userClickOnCartOption() {
		click(pomFactory.orderPage().cartBttn);
		logger.info("Cart Button was clicked successfully");
	}

	@Then("User click on Proceed to Checkout button")
	public void userClickOnProceedToCheckoutButton() {
		click(pomFactory.orderPage().proceedToCheckoutBttn);
		logger.info("Proceed to check out button was clicked successfully");
	}

	@Then("User click on Place Your Order")
	public void userClickOnPlaceYourOrder() {
		click(pomFactory.orderPage().placeOrderBttn);
		logger.info("Place your order button was clicked successfully");

	}
	
	@Then("a message should be displayed")
	public void aMessageShouldBeDisplayed() {
		waitTillPresence(pomFactory.orderPage().orderPlacedSuccessfullyMssg);
		logger.info("Order Placed Successfully");
	}

	// @cancelTheOrder

	@When("User click on Orders section")
	public void userClickOnOrdersSection() {
		click(pomFactory.orderPage().ordersBttn);
		logger.info("User clicked on Orders section successfully");

	}

	@When("User click on first order in list")
	public void userClickOnFirstOrderInList() {
		click(pomFactory.orderPage().orderDetailBttn);
		logger.info("User clicked on first order on the list");
	}

	@When("User click on Cancel The Order button")
	public void userClickOnCancelTheOrderButton() {
		waitTillPresence(pomFactory.orderPage().cancelOrderBttn);
		click(pomFactory.orderPage().cancelOrderBttn);
		logger.info("User clicked on Cancel the Order button successfully");
	}

	@When("User select the cancelation Reason {string}")
	public void userSelectTheCancelationReason(String reason) {
		waitTillPresence(pomFactory.orderPage().reasonBttn);
		click(pomFactory.orderPage().reasonBttn);
		logger.info("User selects cancelation reason");
	}

	@When("User click on Cancel Order button")
	public void userClickOnCancelOrderButton() {
		click(pomFactory.orderPage().cancelOrderSubmitBttn);
		logger.info("User click on Cancel Order Button successfully");
	}

	@Then("a cancelation message should be displayed {string}")
	public void aCancelationMessageShouldBeDisplayed(String orderCancel) {
		Assert.assertTrue(pomFactory.orderPage().cancelOrderMssg.isDisplayed());
		logger.info("Cancelation Message is Displayed");
	}

	// returnOrder

	@When("User click on Return Items button")
	public void userClickOnReturnItemsButton() {
		waitTillPresence(pomFactory.orderPage().returnOrderBttn);
		click(pomFactory.orderPage().returnOrderBttn);
		logger.info("User clicked on return items button successfully");
	}

	@When("User select the Return Reason {string}")
	public void userSelectTheReturnReason(String itemDamaged) {
		waitTillPresence(pomFactory.orderPage().wrongItemReasonBttn);
		click(pomFactory.orderPage().wrongItemReasonBttn);
		logger.info("User select the return reason");
	}

	@When("User select the drop off service {string}")
	public void userSelectTheDropOffService(String FedEx) {
		waitTillPresence(pomFactory.orderPage().dropOffOption);
		click(pomFactory.orderPage().dropOffOption);
		logger.info("User select the FedEx drop off");
	}

	@When("User click on Return Order button")
	public void userClickOnReturnOrderButton() {
		click(pomFactory.orderPage().cancelOrderSubmitBttn);
		logger.info("User clicked on return Order Button successfully");
	}

	@Then("a return message should be displayed {string}")
	public void aReturnMessageShouldBeDisplayed1(String returnOrderMssg) {
		Assert.assertTrue(pomFactory.orderPage().returnOrderMssg.isDisplayed());
		logger.info("Comformation Message is Displayed");
	}

	// addReview

	@When("User click on Review button")
	public void userClickOnReviewButton() {
		click(pomFactory.orderPage().reviewBttn);
		logger.info("User clicked on Review button successfully");
	}

	@When("User write Review headline {string} and {string}")
	public void userWriteReviewHeadlineAnd(String exellentCode, String featuresDone) {
		sendText(pomFactory.orderPage().headlineReviewInput, exellentCode);
		sendText(pomFactory.orderPage().reviewInput, featuresDone);
		logger.info("User wrote Reviev successfully");
	}

	@When("User click Add your Review button")
	public void userClickAddYourReviewButton() {
		click(pomFactory.orderPage().reviewSubmitBttn);
		logger.info("USer clicked on Add ypur Review button successfuly");
	}

	@Then("a review message should be displayed {string}")
	public void aReviewMessageShouldBeDisplayed(String reviewAddedMssg) {
		if (reviewAddedMssg.contains("Your review was added successfully")) {
			waitTillPresence(pomFactory.orderPage().reviewAddedMssg);
			Assert.assertEquals(reviewAddedMssg, pomFactory.orderPage().reviewAddedMssg.getText());
			logger.info("Review message is displayed");
		}

	}
}
