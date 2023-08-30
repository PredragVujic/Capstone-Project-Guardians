package tek.sdet.framework.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import tek.sdet.framework.base.BaseSetup;

public class RetailAccountPage extends BaseSetup{

	public RetailAccountPage() {
		PageFactory.initElements(getDriver(), this);
		
  }
	
	//@updatePI
	
	@FindBy(linkText = "Account")
	public WebElement accountLink;
	
	@FindBy(id = "nameInput")
	public WebElement nameField;
	
	@FindBy(id = "personalPhoneInput")
	public WebElement phoneField;
	
	@FindBy(id = "personalUpdateBtn")
	public WebElement updateBttn;
	
	@FindBy(xpath = "//div[text()='Personal Information Updated Successfully']")
	public WebElement personalInfoUpdateSuccessMssg;
	
	//@addPayment
	
	@FindBy(xpath = "//p[text()='Add a payment method']")
	public WebElement addAPaymentMethodLink;
	
	@FindBy(id = "cardNumberInput")
	public WebElement cardNumberField; ///
	
	@FindBy(id = "nameOnCardInput")
	public WebElement nameOnCardField; ///
	
	@FindBy(id = "expirationMonthInput")
	public WebElement expirationMonthField; ///
	
	@FindBy(id = "expirationYearInput")
	public WebElement expirationYearField; ///
	
	@FindBy(id = "securityCodeInput")
	public WebElement securityCodeField; ///
	
	@FindBy(id = "paymentSubmitBtn")
	public WebElement paymentSubmitBtn; ///
	
	@FindBy(xpath = "//div[text()='Payment Method added sucessfully']")
	public WebElement paymentMethodSuccessMssg;
	
	@FindBy(xpath = "//div[text()='Address Added Successfully']")
	public WebElement addressSuccessMssg;
	
	@FindBy(xpath = "//div[starts-with(@class,'account__address-new-')]")
	public WebElement addAddressLink;
	
	//@editCard
	
	@FindBy(xpath = "//div[@class='account__payment-image-wrapper']")
	public WebElement accPaymentBox; // recent
	
	@FindBy(xpath = "//p[text()='Add a payment method']")
	public WebElement accPaymentImg;
	
	@FindBy(xpath = "//div//button[@class='text-blue-800 cursor-pointer hover:underline' and text()='Edit']")
	public WebElement editCardBttn;
	
	
	@FindBy(xpath = "//div[text()='Payment Method updated Successfully']")
	public WebElement updateCardMssg;
	
	@FindBy(xpath = "//div[@class='account__btn-wrapper']//button[@id='paymentSubmitBtn']")
	public WebElement updateCardBttn;
	
	@FindBy(xpath = "//div//button[@class='text-blue-800 cursor-pointer hover:underline' and text()='remove']")
	public WebElement removeCardBttn;
	
	@FindBy(xpath = "//div//button[@class='account__btn-submit' and text()='Add Your card']")
	public WebElement addCardBttn;
	
	//addAddress
	
	@FindBy(id = "countryDropdown")
	public WebElement addressCountryDropdown;
	
	@FindBy(id = "fullNameInput")
	public WebElement addressNameField;
	
	@FindBy(id = "phoneNumberInput")
	public WebElement addressPhoneField;
	
	@FindBy(id = "streetInput")
	public WebElement addressStreetField;
	
	@FindBy(id = "apartmentInput")
	public WebElement addressApartmentNum;
	
	@FindBy(id = "cityInput")
	public WebElement addressCityField;
	
	@FindBy(name = "state")
	public WebElement addressStateDropdown;
	
	@FindBy(id = "zipCodeInput")
	public WebElement addressZipCodeField;
	
	@FindBy(xpath = "//div//button[@class='account__btn-submit' and text()='Add Your Address']")
	public WebElement addressAddBttn;
	
	@FindBy(xpath = "//div//button[@class='account__address-btn' and text()='Edit']")
	public WebElement editAddressOpt;
	
	

	@FindBy(xpath ="//div//button[@class='account__btn-submit' and text()='Update Your Address']")
	public WebElement updateAddressBttn;
	
	@FindBy(xpath = "//div[text()='Address Updated Successfully']")
	public WebElement addressUpdateMssg;
	
	@FindBy(xpath = "//div//button[@class='account__btn-submit' and text()='Add Your Address']")
	public WebElement addAddress;
	
	@FindBy(xpath = "//div//button[@class='account__address-btn' and text()='Remove']")
	public WebElement removeAddressBttn;
}