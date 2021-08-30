package com.alevel.selenium.elmir;

import com.alevel.selenium.pageobjects.ElmirPageTestCases;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import listeners.Helper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

@Listeners(Helper.class)
public class ElmirTest {

    private WebDriver driver;
    private ElmirPageTestCases elmirPageTestDefinitions;

    @BeforeMethod
    public void beforeMethod() {
        Config applicationConfig = ConfigFactory.parseResources("application.conf");

        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(applicationConfig.getString("test.baseUrl"));

        elmirPageTestDefinitions = PageFactory.initElements(driver, ElmirPageTestCases.class);
    }

    @AfterMethod
    public void afterMethod() {
        driver.quit();
    }

     @Test
     public void registration() {
         elmirPageTestDefinitions.runRegistrationTestCase();
     }

     @Test
     public void enterPurchaseViaTheSideMenu() {
         elmirPageTestDefinitions.runBuyFromSideBarTestCase();
    }

    @Test
    public void buyingACarThroughTheLine() {
        elmirPageTestDefinitions.runBuyFromSearchLineTestCase("Авто");
    }

    @Test
    public void sorted() {
        elmirPageTestDefinitions.runSortTestCase();
    }

    @Test
    public void comparisons() {
        elmirPageTestDefinitions.runComparisonTestCase();
    }

}


