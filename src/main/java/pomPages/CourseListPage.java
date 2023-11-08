package pomPages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CourseListPage {
	
	//declaration
	@FindBy(xpath = "//h1[normalize-space(text())=\"Users\"]")
	private WebElement pageHeader;
	@FindBy(xpath = "//a[text()=\" New\"]")
	private WebElement newButton;
	@FindBy(xpath = "//table/tbody/tr/td[1]")
	private List<WebElement> courseList;
	@FindBy(xpath = "//h4/[text()=' Success!']")
	private WebElement SuccessMessage;
	private String deletpath="//td[text()='%s']/following-sibling::td/button[text()=' Delete']";
	
	@FindBy(xpath="//button[@name='delete']")
	private WebElement deleteButton;
	


	//Initialization
	public CourseListPage(WebDriver driver)
	{
		PageFactory.initElements( driver,this);
	}
	//Utilization
	public String getPageHeader()
	{
		return pageHeader.getText();
		
	}
	public void clickNewButton()
	{
		newButton.click();
	}
    public List<WebElement> getCourseList(){
    	return courseList;
		
    }
    public String getSuccessMessage()
    {
    	return SuccessMessage.getText();
    }
    	 public void clickDeleteButton(String courseName, WebDriver driver)
    	 {
    		 String requiredpath = String.format(deletpath, courseName);
    		 driver.findElement(By.xpath(requiredpath)).click();
    	 }
    	 public void clickDelete()
    	 {
    		 deleteButton.click();
    		
    		 
    	}
    	

    
    }
