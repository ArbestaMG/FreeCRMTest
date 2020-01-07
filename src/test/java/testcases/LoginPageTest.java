package testcases;

import base.TestBase;
import org.apache.commons.lang3.ObjectUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class LoginPageTest extends TestBase {
    LoginPage loginPage;
    HomePage homePage;
    public LoginPageTest(){
        super();// bunu yazdik boylece TestBasein constructrunu cagirdik
    }// boylece butun data buraya gelmis oluyor
    @BeforeMethod
    public void setUp(){
        initialization();

        loginPage=new LoginPage();

    }

    @Test(priority = 1)
    public void loginPageTitleTest(){
       String title= loginPage.validateLoginPageTitle();
        Assert.assertEquals(title,"CRMPRO");
    }
    @Test(priority = 2)
    public void crmLogoImageTest(){
        boolean flag=loginPage.validateCRMImage();
        Assert.assertTrue(flag);
    }

    @Test(priority = 3)
    public void loginTest(){
      homePage=  loginPage.login(prop.getProperty("username"),prop.getProperty("password"));

    }
    @AfterMethod
    public  void teardown(){
    driver.quit();
    }
}
