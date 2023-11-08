package pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminHomepage {
	//Declaration
	
		@FindBy(xpath = "//span[text()='SkillRary Admin']")
		private WebElement adiminIcon ;
		
		@FindBy(xpath =  "//span[text()='Users']")
		private WebElement usersTab;
		
		@FindBy(xpath =  "//span[text()='Courses']")
		private WebElement coursesTab;
		
		@FindBy(xpath =  "//a[text()=' Course List']")
		private WebElement courseListLink;
		
		@FindBy(xpath =  "//a[text()=' Category']")
		private WebElement categoryLink;
		
		@FindBy(xpath =  "//a[text()='Sign out']")
		private WebElement signOutLink;
		
		//Initialization
		public AdminHomepage(WebDriver driver) {
			PageFactory.initElements(driver, this);
		}
		//Utilization
		public String getAdminIcon() {
			return adiminIcon.getText();
			
		}
	public void clickuserTab() {
		usersTab.click();
		
	}
	public void clickcourseTab() {
		coursesTab.click();
	}
	public void clickCourseListLink() {
		courseListLink.click();
	}
	public void clickCategoryLink() {
		categoryLink.click();
	}
	public void sigOutOfApp() {
		signOutLink.click();
	}
	
	
	
		

}
