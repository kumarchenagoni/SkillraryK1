package pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UsersPage {
	
	//Declaration
	
		@FindBy(xpath = "//h1[normalize-space(text())='Users']")
		private WebElement PageHeader;

		@FindBy(xpath = "//a[text()=' New']")
		private WebElement plusNewButton;
		
		@FindBy(xpath = "//ul[@class='pagination']/li[last()-1]/a")
		private WebElement userListLastPage;
		
		@FindBy(xpath = "//table/tbody/tr[last()]/td[3]")
		private WebElement lastUser;
		
		@FindBy(xpath = "")
		private WebElement successMessage;
		
		//Initialization
		public UsersPage(WebDriver driver) {
			PageFactory.initElements(driver, this);
		}
		//Utilization
		public String getpageHeader() {
			return PageHeader.getText();
			
		}
	public void clickplusNewButton() {
		 plusNewButton.click();
		
	}
	public void clickuserListLastPage() {
		 userListLastPage.click();
		
	}
	public String getLastUserName() {
		return lastUser.getText();
	
	}
	public String getSuccesesMessage() {
		return successMessage.getText();
	}
		
		


}
