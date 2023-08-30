package tek.sdet.framework.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import tek.sdet.framework.base.BaseSetup;

public class RetailOrderPage extends BaseSetup{

	public RetailOrderPage() {
		PageFactory.initElements(getDriver(), this);
	}
	@FindBy(id= "search")
	public WebElement allDepartmentDropdown;
	
	@FindBy(id = "searchInput")
	public WebElement searchInputField;
	
	@FindBy(id = "searchBtn")
	public WebElement searchBttn;
	
	@FindBy(xpath = "//img[@alt='Kasa Outdoor Smart Plug']")
	public WebElement itemkasaoutdoorsmartplug;
	
	@FindBy(xpath = "//select[starts-with(@class,'product')]")
	public WebElement qtyDropdown;
	
	@FindBy(id = "addToCartBtn")
	public WebElement addToCartBttn;
	
	@FindBy(xpath = "//span[@id='cartQuantity']")
	public WebElement cartItemQty;

	@FindBy(xpath = "//span[@class='top-nav__cart-quantity' and text()='7']")
	public WebElement filledCartBttn;
	
	@FindBy(id = "cartBtn")
	public WebElement cartBttn;
	
	@FindBy(id = "proceedBtn")
	public WebElement proceedToCheckoutBttn;
	
	@FindBy(id = "placeOrderBtn")
	public WebElement placeOrderBttn;

	@FindBy(xpath = "//div[text()='Order Placed Successfully']")
	public WebElement orderPlacedSuccessfullyMssg;
	
	@FindBy(xpath = "//img[starts-with(@alt,'Apex Legends')]")
	public WebElement apexLegendsItem;
	
	
	
	
	@FindBy(linkText= "Orders")
	public WebElement ordersBttn;
	
	@FindBy(id = "cancelBtn")
	public WebElement cancelOrderBttn;
	
	@FindBy(xpath = "//div[@class='order__content-actions']//button[@class='order__content-btn' and text()='Return Items']")
	public WebElement returnOrderBttn; 
	
	@FindBy(xpath = "//select[@id='reasonInput']//option[@value='wrong']")
	public WebElement reasonBttn; 
	
	@FindBy(xpath ="//select[@id='reasonInput']//option[@value='damage']")
	public WebElement wrongItemReasonBttn; 
	
	@FindBy(xpath = "//select//option[@value='fedex']")
	public WebElement dropOffOption; 
	
	@FindBy(id = "orderSubmitBtn")
	public WebElement returnOrderSubmitBttn; 
	
	@FindBy(xpath = "//div//button[@class='order__cancel-submit']")
	public WebElement cancelOrderSubmitBttn;
	
	@FindBy(xpath = "//p[text()='Return was successfull']")
	public WebElement returnOrderMssg; 
	
	@FindBy(xpath = "//div[@class='cancel__confirm-wrapper']")
	public WebElement cancelOrderMssg;
	
	@FindBy(xpath = "//div//p[@class='order__header-btn' and text()='Show Details']")
	public WebElement orderDetailBttn;
	
	
	
	
	@FindBy(id = "reviewBtn")
	public WebElement reviewBttn;
	
	@FindBy(id = "headlineInput")
	public WebElement headlineReviewInput;
	
	@FindBy(id = "descriptionInput")
	public WebElement reviewInput;
	
	@FindBy(id = "reviewSubmitBtn")
	public WebElement reviewSubmitBttn;
	
	@FindBy(xpath = "//div[text()='Your review was added successfully']")
	public WebElement reviewAddedMssg;
	
	

}
