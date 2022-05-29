package mk.sedc.finalproject.tests;

import com.github.javafaker.Address;
import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import mk.sedc.finalproject.pages.*;
import mk.sedc.finalproject.utils.BaseHelper;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BaseTest {
    public WebDriver driver;
    public WebDriverWait wait;
    public String browser = "chrome";
    public static final int TIMEOUT=20;
    public static final String URL="https://automationpractice.com";
    protected AccountPage accountPage;
    protected DressesPage dressesPage;
    protected DressDetailsPage dressDetailsPage;
    protected ItemConfirmationPage itemConfirmationPage;
    protected CartSummaryPage cartSummaryPage;
    protected HomePage homePage;
    public Faker faker = new Faker();
    public BaseHelper helper = new BaseHelper();
    public String email;
    public String password;
    public Address address;
    public String fullAddress;
    public String city;
    public String state;
    public String zip;

    @BeforeClass
    public void setUserCredentials(){
         email = helper.randomEmail();
         password = "proba1";
         address = faker.address();
         fullAddress = address.fullAddress();
         city = address.city();
         state = address.state();
         zip = "99950";
    }

    @BeforeMethod
    public void beforeMethod(){
        if(browser.equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }else if(browser.equalsIgnoreCase("firefox")){
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }else if(browser.equalsIgnoreCase("edge")){
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }else if(browser.equalsIgnoreCase("ie")){
            WebDriverManager.iedriver().setup();
            driver = new InternetExplorerDriver();
        }else {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }

        wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));

        initPageObjects();

        driver.manage().window().maximize();
        driver.navigate().to(URL);
    }

    private void initPageObjects() {
        accountPage = new AccountPage(driver,wait);
        dressesPage = new DressesPage(driver,wait);
        dressDetailsPage = new DressDetailsPage(driver,wait);
        itemConfirmationPage = new ItemConfirmationPage(driver,wait);
        cartSummaryPage = new CartSummaryPage(driver,wait);
        homePage = new HomePage(driver,wait);
    }

    @AfterMethod
    public void afterMethod(){
        driver.quit();
    }

    public void sleep(int timeout){
        try {
            Thread.sleep(timeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void scroll(int h, int v){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy("+h+","+v+")");
    }
}
