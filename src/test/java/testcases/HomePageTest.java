package testcases;

import base.TestBase;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ContactsPage;
import pages.HomePage;
import pages.LoginPage;
import util.TestUtil;

public class HomePageTest extends TestBase {
    LoginPage loginPage;
    HomePage homePage;
    TestUtil testUtil;
    ContactsPage contactsPage;


    public HomePageTest(){
        super();
    }
    @BeforeMethod
    public void setUp(){
        initialization();
        testUtil=new TestUtil();
        loginPage=new LoginPage();
        homePage=  loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
    }

    @Test(priority = 1)
    public void verifyHomePageTitleTest(){
        String homePageTitle=homePage.verifyHomePageTitle();
        Assert.assertEquals(homePageTitle,"CRMPRO","Home page title not mathed");
    }
    @Test(priority = 2)
    public void verifyUserNameTest(){
        testUtil.switchToFrame();
        Assert.assertTrue(homePage.verifyCorrectUserName());
    }

    @Test
    public void verifyContactsLinkTest(){
        testUtil.switchToFrame();
        contactsPage=homePage.clickOnContactsLink();

    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }


}
