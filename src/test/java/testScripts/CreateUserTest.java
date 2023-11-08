package testScripts;

import java.util.Map;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import genericLibraries.BaseClass;
import genericLibraries.IConstantPath;

public class CreateUserTest extends BaseClass {
	@Test
	public void createUserTest() {

	SoftAssert soft = new SoftAssert();
	home.clickcourseTab();
	
	soft.assertTrue(users.getpageHeader().contains("Users"));
	
	users.clickplusNewButton();
	soft.assertEquals(addUser.getPageHeader(), "Add New User");
	Map<String, String>map=excel.readFromExcel("Sheet1", "Add User");
	addUser.createNewUser(map.get("Email"),map.get("Password"),
	map.get("Firstname"),map.get("LastName"),map.get("Address"),
	map.get("Contact Info"),map.get("Photo"));
	
	soft.assertTrue(course.getSuccessMessage().contains("Success"));
	
	if(course.getSuccessMessage().contains("Success"))
		
		excel.writeToexcel("Sheet1", "Add User","Pass", IConstantPath.EXCEL_PATH);
	else
		excel.writeToexcel("Sheet1", "Add User","Fail", IConstantPath.EXCEL_PATH);
	
	soft.assertAll();
//	
//}
//
//
//}
//
//
//
//
	}}

