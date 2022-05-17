package mk.sedc.finalproject.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
    private WebDriver driver;
    private WebDriverWait wait;
    private By signIn = By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a");
    private By email = By.id("email_create");
    private By createAccountButton = By.id("SubmitCreate");
    private By firstName=By.id("customer_firstname");
    private By lastName = By.id("customer_lastname");
    private By password = By.id("passwd");
    private By fname = By.id("firstname");
    private By lname = By.id("lastname");
    private By address = By.id("address1");
    private By city = By.id("city");
    private By zipCode = By.id("postcode");
    private By phone = By.id("phone_mobile");
    private By addressAlias = By.id("alias");
    private By registerButton = By.id("submitAccount");

    public HomePage(WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
    }
    public void click_signIn(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(signIn)).click();
    }

    public void enterEmail(String email){
        wait.until(ExpectedConditions.visibilityOfElementLocated(this.email)).sendKeys(email);
    }
    public String randomEmail(){
        String myEmailAddress = "myaddress" + System.nanoTime() + "@gmail.com";
        System.out.println(myEmailAddress);
        return myEmailAddress;
    }
    public void click_createAccount(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(createAccountButton)).click();
    }
    public void enterFirstName(String fname){
        wait.until(ExpectedConditions.visibilityOfElementLocated(this.firstName)).sendKeys(fname);
    }
    public void enterLastName(String lname){
        wait.until(ExpectedConditions.visibilityOfElementLocated(this.lastName)).sendKeys(lname);
    }
    public void enterPassword(String pass){
        wait.until(ExpectedConditions.visibilityOfElementLocated(this.password)).sendKeys(pass);
    }

}
