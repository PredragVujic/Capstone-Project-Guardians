package tek.sdet.framework.steps;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import tek.sdet.framework.pages.POMFactory;
import tek.sdet.framework.utilities.CommonUtility;

public class RetailSignInSteps extends CommonUtility {

	POMFactory pomFactory = new POMFactory();

	@Given("User is on retail website")
	public void userIsOnRetailWebsite() {
		Assert.assertTrue(pomFactory.signInPage().tekSchoolLogo.isDisplayed());
		logger.info("User is on retail website");
	}

	@When("User click on Sign in option")
	public void userClickOnSignInOption() {
		click(pomFactory.signInPage().signInLink);
		logger.info("User click on Sign in option");
	}

	@When("User enter email {string} and password {string}")
	public void userEnterEmailAndPassword(String email, String password) {
		sendText(pomFactory.signInPage().emailField, email);
		sendText(pomFactory.signInPage().passwordField, password);
		logger.info("User enetered email and password successfully");
	}

	@When("User click on login button")
	public void userClickOnLoginButton() {
		click(pomFactory.signInPage().logInBttn);
		logger.info("User click on login button");
	}

	@Then("User should be logged in into Account")
	public void userShouldBeLoggedInIntoAccount() {
		Assert.assertTrue(pomFactory.signInPage().logoutBttn.isDisplayed());
		logger.info("User is logged into account");
	}

	// creating account

	@When("User click on Create New Account button")
	public void userClickOnCreateNewAccountButton() {
		click(pomFactory.signInPage().newAccountBttn);
		logger.info("Create new account bttn clicked successfully");
	}

	@When("User fill the signUp information with below data")
	public void userFillTheSignUpInformationWithBelowData(DataTable dataTable) {
		List<Map<String, String>> createAccInfo = dataTable.asMaps(String.class, String.class);
		sendText(pomFactory.signInPage().nameInputField, createAccInfo.get(0).get("name"));
		clearTextUsingSendKeys(pomFactory.signInPage().emailInputField);
		sendText(pomFactory.signInPage().emailInputField, createAccInfo.get(0).get("email"));
		clearTextUsingSendKeys(pomFactory.signInPage().passwordInputField);
		sendText(pomFactory.signInPage().passwordInputField, createAccInfo.get(0).get("password"));
		sendText(pomFactory.signInPage().confirmPassInputField, createAccInfo.get(0).get("confirmPassword"));
		logger.info("User fill the signUp information successfully");
	}

	@When("User click on SignUp button")
	public void userClickOnSignUpButton() {
		click(pomFactory.signInPage().signupBttn);
		logger.info("User clicked on signup button successfully");
	}

	@Then("User should be logged into account page")
	public void userShouldBeLoggedIntoAccountPage() {
		waitTillPresence(pomFactory.signInPage().yourProfileText);
		Assert.assertTrue(pomFactory.signInPage().yourProfileText.isDisplayed());
		logger.info("User account is created successfully");
	}

}
