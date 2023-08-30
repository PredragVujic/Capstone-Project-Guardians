package tek.sdet.framework.steps;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import tek.sdet.framework.pages.POMFactory;
import tek.sdet.framework.utilities.CommonUtility;
import tek.sdet.framework.utilities.DataGenerator;

public class RetailAccountSteps extends CommonUtility {

	POMFactory pomFactory = new POMFactory();

	// updatePI

	@When("User click on Account option")
	public void userClickOnAccountOption() {
		click(pomFactory.accountPage().accountLink);
		logger.info("Account link was clicked successfully");

	}

	@When("User update Name {string} and Phone {string}")
	public void userUpdateNameAndPhone(String name, String phoneNumber) {
		clearTextUsingSendKeys(pomFactory.accountPage().nameField);
		sendText(pomFactory.accountPage().nameField, name);
		logger.info("Name was entered successfully");
		clearTextUsingSendKeys(pomFactory.accountPage().phoneField);
		sendText(pomFactory.accountPage().phoneField, phoneNumber);
		logger.info("Phone number entered succcessfully");

	}

	@When("User click on Update button")
	public void userClickOnUpdateButton() {
		click(pomFactory.accountPage().updateBttn);
		logger.info("Update button was clicked successfully");

	}

	@Then("user profile information should be updated")
	public void userProfileInformationShouldBeUpdated() {
		waitTillPresence(pomFactory.accountPage().personalInfoUpdateSuccessMssg);
		String expectedMssg = "Personal Information Updated Successfully";
		String actualMssg = pomFactory.accountPage().personalInfoUpdateSuccessMssg.getText();
		Assert.assertEquals(expectedMssg, actualMssg);
		logger.info("Personal Information Updated Successfully");

	}

	//addPaymentMethod

	@When("User click on Add a payment method link")
	public void userClickOnAddAPaymentMethodLink() {
		click(pomFactory.accountPage().addAPaymentMethodLink);
		click(pomFactory.accountPage().cardNumberField); // freshly added
		logger.info("Add payment link clicked successfully");

	}

	@When("User fill Debit or credit card information")
	public void userFillDebitOrCreditCardInformation(DataTable dataTable) {
		List<Map<String, String>> paymentInfo = dataTable.asMaps(String.class, String.class);
		sendText(pomFactory.accountPage().cardNumberField, paymentInfo.get(0).get("cardNumber"));
		sendText(pomFactory.accountPage().nameOnCardField, paymentInfo.get(0).get("nameOnCard"));
		selectByVisibleText(pomFactory.accountPage().expirationMonthField, paymentInfo.get(0).get("expirationMonth"));
		selectByVisibleText(pomFactory.accountPage().expirationYearField, paymentInfo.get(0).get("expirationYear"));
		sendText(pomFactory.accountPage().securityCodeField, paymentInfo.get(0).get("securityCode"));
		logger.info("Payment information was entered successfully");

	}

	@When("User click on Add your card button")
	public void userClickOnAddYourCardButton() {
		click(pomFactory.accountPage().paymentSubmitBtn);
		logger.info("Payment Method Submit bttn clicked successfully");

	}

	@Then("a message should be displayed {string}")
	public void aMessageShouldBeDisplayed(String expectedMssg) {

		if (expectedMssg.contains("Payment Method added successfully")) {
			waitTillPresence(pomFactory.accountPage().paymentMethodSuccessMssg);
			Assert.assertEquals(expectedMssg, pomFactory.accountPage().paymentMethodSuccessMssg.getText());
			logger.info("ExpectedMssg : " + expectedMssg);

		} else if (expectedMssg.contains("Address Added")) {
			waitTillPresence(pomFactory.accountPage().addressSuccessMssg);
			Assert.assertEquals(expectedMssg, pomFactory.accountPage().addressSuccessMssg.getText());
			logger.info("Expected Message: " + expectedMssg);

		} else if (expectedMssg.contains("Order Placed")) {
			waitTillPresence(pomFactory.orderPage().orderPlacedSuccessfullyMssg);
			Assert.assertEquals(expectedMssg, pomFactory.orderPage().orderPlacedSuccessfullyMssg.getText());

		}

	}

	// editCard

	@When("User click on Account")
	public void userClickOnAccount() {
		click(pomFactory.accountPage().accountLink);
		logger.info("Account link was clicked successfully");

	}

	@When("User click on Edit option of card section")
	public void userClickOnEditOptionOfCardSection() {
		
		click(pomFactory.accountPage().accPaymentBox);
		click(pomFactory.accountPage().editCardBttn);
		logger.info("User clicked on Edit option successfully");

	}

	@When("user edit information with below data")
	public void userEditInformationWithBelowData(DataTable dataTable) {
		List<Map<String, String>> paymentInfo = dataTable.asMaps(String.class, String.class);
		clearTextUsingSendKeys(pomFactory.accountPage().cardNumberField);
		sendText(pomFactory.accountPage().cardNumberField, paymentInfo.get(0).get("cardNumber"));
		clearTextUsingSendKeys(pomFactory.accountPage().nameOnCardField);
		sendText(pomFactory.accountPage().nameOnCardField, paymentInfo.get(0).get("nameOnCard"));
		selectByVisibleText(pomFactory.accountPage().expirationMonthField, paymentInfo.get(0).get("expirationMonth"));
		selectByVisibleText(pomFactory.accountPage().expirationYearField, paymentInfo.get(0).get("expirationYear"));
		clearTextUsingSendKeys(pomFactory.accountPage().securityCodeField);
		sendText(pomFactory.accountPage().securityCodeField, paymentInfo.get(0).get("securityCode"));
		logger.info("User edited inforamtion successfully");

	}

	@When("user click on Update Your Card button")
	public void userClickOnUpdateYourCardButton() {
		waitTillPresence(pomFactory.accountPage().updateCardBttn);
		click(pomFactory.accountPage().updateCardBttn);
		logger.info("Payment Method updated Successfully");

	}

	@When("User click on remove option of card section")
	public void userClickOnRemoveOptionOfCardSection() {
		
		click(pomFactory.accountPage().accPaymentBox);
		click(pomFactory.accountPage().removeCardBttn);
		logger.info("User click on remove button successfully");

	}

	@Then("payment details should be removed")
	public void paymentDetailsShouldBeRemoved() {
		Assert.assertTrue(pomFactory.accountPage().addCardBttn.isDisplayed());
		logger.info("Payment method removed successfully");

	}

	
	//addAddress
	
	
	@When("User click on Add address option")
	public void userClickAddAddressOption() {
		click(pomFactory.accountPage().addAddressLink);
		logger.info("Add Address clicked Successfully");
	
	}
	
	
	// Data Generator:

	@When("user fill new address form with below information")
	public void userFillNewAddressFormWithBelowInformation1(DataTable dataTable) {
		List<Map<String, String>> addressInfo = dataTable.asMaps(String.class, String.class);
		selectByVisibleText(pomFactory.accountPage().addressCountryDropdown,
				DataGenerator.addressGenerator(addressInfo.get(0).get("country")));
		sendText(pomFactory.accountPage().addressNameField,
				DataGenerator.addressGenerator(addressInfo.get(0).get("fullName")));
		sendText(pomFactory.accountPage().addressPhoneField,
				DataGenerator.addressGenerator(addressInfo.get(0).get("phoneNumber")));
		sendText(pomFactory.accountPage().addressStreetField,
				DataGenerator.addressGenerator(addressInfo.get(0).get("streetAddress")));
		sendText(pomFactory.accountPage().addressApartmentNum,
				DataGenerator.addressGenerator(addressInfo.get(0).get("apt")));
		sendText(pomFactory.accountPage().addressCityField, 
				DataGenerator.addressGenerator(addressInfo.get(0).get("city")));
		selectByVisibleText(pomFactory.accountPage().addressStateDropdown,
				DataGenerator.addressGenerator(addressInfo.get(0).get("state")));
		sendText(pomFactory.accountPage().addressZipCodeField, 
				DataGenerator.addressGenerator(addressInfo.get(0).get("zipCode")));
		logger.info("Address form was filled out successfully");

	}


	@When("User click Add Your Address button")
	public void userClickAddYourAddressButton() {
		waitTillPresence(pomFactory.accountPage().addAddress);
		click(pomFactory.accountPage().addAddress);
		waitTillPresence(pomFactory.accountPage().addressSuccessMssg);
		Assert.assertTrue(pomFactory.accountPage().addressSuccessMssg.isDisplayed());
		logger.info("Address Added Successfully");

	}
	
	
	// editAddress

	@When("User click on edit address option")
	public void userClickOnEditAddressOption() {
		click(pomFactory.accountPage().editAddressOpt);
		logger.info("User clicked on edit address option successfully");

  }

	@When("user edit address form with below information")
	public void userEditAddressFormWithBelowInformation(DataTable dataTable) {
		List<Map<String, String>> editAddressInfo = dataTable.asMaps(String.class, String.class);
		clearTextUsingSendKeys(pomFactory.accountPage().addressCountryDropdown);
		sendText(pomFactory.accountPage().addressCountryDropdown, editAddressInfo.get(0).get("country"));
		clearTextUsingSendKeys(pomFactory.accountPage().addressNameField);
		sendText(pomFactory.accountPage().addressNameField, editAddressInfo.get(0).get("fullName"));
		clearTextUsingSendKeys(pomFactory.accountPage().addressPhoneField);
		sendText(pomFactory.accountPage().addressPhoneField, editAddressInfo.get(0).get("phoneNumber"));
		clearTextUsingSendKeys(pomFactory.accountPage().addressStreetField);
		sendText(pomFactory.accountPage().addressStreetField, editAddressInfo.get(0).get("streetAddress"));
		clearTextUsingSendKeys(pomFactory.accountPage().addressApartmentNum);
		sendText(pomFactory.accountPage().addressApartmentNum, editAddressInfo.get(0).get("apt"));
		clearTextUsingSendKeys(pomFactory.accountPage().addressCityField);
		sendText(pomFactory.accountPage().addressCityField, editAddressInfo.get(0).get("city"));
		clearTextUsingSendKeys(pomFactory.accountPage().addressStateDropdown);
		sendText(pomFactory.accountPage().addressStateDropdown, editAddressInfo.get(0).get("state"));
		clearTextUsingSendKeys(pomFactory.accountPage().addressZipCodeField);
		sendText(pomFactory.accountPage().addressZipCodeField, editAddressInfo.get(0).get("zipCode"));
		logger.info("User fills and update address info successfully");

	}

	@When("User click update Your Address button")
	public void userClickUpdateYourAddressButton() {
		click(pomFactory.accountPage().updateAddressBttn);
		logger.info("User updated address info successfully");
	}

	// removeAddress

	@When("User click on remove option of Address section")
	public void userClickOnRemoveOptionOfAddressSection() {
		click(pomFactory.accountPage().removeAddressBttn);
		logger.info("User clicked on remove address option sucessfully");

	}

	@Then("Address details should be removed")
	public void addressDetailsShouldBeRemoved() {
		Assert.assertTrue(pomFactory.accountPage().addCardBttn.isDisplayed());
		logger.info("Address details are removed successfully");

	}

}