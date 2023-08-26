package tek.sdet.framework.pages;

import tek.sdet.framework.base.BaseSetup;

public class POMFactory  extends BaseSetup{

	private RetailSignInPage signInPage;
	private RetailHomePage homePage;
	private RetailAccountPage accountPage;
	private RetailOrderPage orderPage;

	
	
	public POMFactory() {
		this.signInPage = new RetailSignInPage();
		this.homePage = new RetailHomePage();
		this.accountPage = new RetailAccountPage();
		this.orderPage = new RetailOrderPage();

		
	}
	   public RetailSignInPage signInPage() {
	        return this.signInPage;        
	}
	   public RetailHomePage homePage() {
		   return this.homePage;
	   }
	   
	   public RetailAccountPage accountPage() {
		   return this.accountPage;
	   } 
	   public RetailOrderPage orderPage() {
		   return this.orderPage;
	   }
	   
}
