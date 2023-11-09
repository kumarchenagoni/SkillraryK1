package genericLibraries;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;


import pomPages.AddNewCategoryPage;
import pomPages.AddNewCoursePage;
import pomPages.AddNewUserPage;
import pomPages.AdminHomepage;
import pomPages.CategoryPage;
import pomPages.CourseListPage;
import pomPages.LoginPage;
import pomPages.UsersPage;
import pomPages.WelComePage;

public class BaseClass {
	//@BeforeSuite
	//@BeforeTest
	protected PropertiesUtility property;
	protected ExcelUtility excel;
	protected JavaUtility jutil;
	protected WebDriverUtility webUtil;
	protected WebDriver driver;
	
	public static WebDriver sdriver;
	public static JavaUtility sjUtil;
	
	protected WelComePage welCome;
	protected LoginPage login;
	protected AdminHomepage home;
	protected UsersPage users;
	protected CourseListPage course;
	protected CategoryPage category;
	protected AddNewUserPage addUser;
	protected AddNewCoursePage addCourse;
	protected AddNewCategoryPage addCategory;
	
	@BeforeClass
	public void ClassConfig() {
		property = new PropertiesUtility();
		excel = new ExcelUtility();
		jutil = new JavaUtility();
		webUtil = new WebDriverUtility();
		
		
		property.propertiesInitialization(IConstantPath.PROPERTIES_PATH);
		driver=webUtil.launchBrowser(property.readFromProperties("browser"));
		
		sdriver=driver;
		sjUtil=jutil;
	}
	
	
	@BeforeMethod
	public void methodConfi() {
	
		excel.excelIntialization(IConstantPath.EXCEL_PATH);
		
		welCome = new WelComePage(driver);
		login = new LoginPage(driver);
		home = new AdminHomepage(driver);
		users = new  UsersPage(driver);
		course = new CourseListPage(driver);
		category = new CategoryPage(driver);
		addUser = new AddNewUserPage(driver);
		addCourse = new AddNewCoursePage(driver);
		addCategory = new AddNewCategoryPage(driver);
		
		webUtil.navigateToApp(property.readFromProperties("url"));
		Assert.assertEquals(welCome.getLogo(), "SkillRary-ECommerce");
		
		long time=Long.parseLong(property.readFromProperties("usernmae"));
		webUtil.waitTillElementFound(time);
		
		welCome.clickLoginButton();
		Assert.assertEquals(login.getPageHeader(), "LOGIN");
		login.setEmail(property.readFromProperties("username"));
		login.setPassword(property.readFromProperties("password"));
		login.clickLogin();
		Assert.assertEquals(home.getAdminIcon(),"SkillRary Admin");
		
	}
	@AfterMethod
	public void methodTeardown()
	{
		excel.closeExcel();
		home.sigOutOfApp();
	}
	
	@AfterClass
	public void classTeardown()
	{
		webUtil.closeAllWindows();
		
	}
	//@AfterTest
	//@AfterSuite
	


		
		
		
	}


