package mk.sedc.finalproject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccountPage {
    private final WebDriver driver;
    private final WebDriverWait wait;
    private By signIn = By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a");
    private By email = By.id("email_create");
    private By createAccountButton = By.id("SubmitCreate");
    private By titleMrs = By.id("uniform-id_gender2");
    private By firstName=By.id("customer_firstname");
    private By lastName = By.id("customer_lastname");
    private By password = By.id("passwd");
    private By address = By.id("address1");
    private By city = By.id("city");
    private By zipCode = By.id("postcode");
    private By phone = By.id("phone_mobile");
    private By aliasAddress = By.id("alias");
    private By registerButton = By.id("submitAccount");

    public AccountPage(WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
    }

    public void clickSignIn(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(signIn)).click();
    }

    public void login(String email, String password){
        clickSignIn();
        enterEmailForLogin(email);
        enterPasswordForLogin(password);
        clickSignInButton();
    }

    public void enterEmailForLogin(String email){
        WebElement emailForLogin = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
        emailForLogin.sendKeys(String.valueOf(email));
    }

    public void enterPasswordForLogin(String password){
        WebElement passwordForLogin = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("passwd")));
        passwordForLogin.sendKeys(String.valueOf(password));
    }

    public void clickSignInButton(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("SubmitLogin"))).click();
    }

    public void enterEmail(String email){
        wait.until(ExpectedConditions.visibilityOfElementLocated(this.email)).sendKeys(email);
    }

    public void clickCreateAccount(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(createAccountButton)).click();
    }

    public void clickTitle(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(titleMrs)).click();
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

    public void enterAddress(String address){
        wait.until(ExpectedConditions.visibilityOfElementLocated(this.address)).sendKeys(address);
    }

    public void enterCity(String city){
        wait.until(ExpectedConditions.visibilityOfElementLocated(this.city)).sendKeys(city);
    }

    public void enterZipCode(String zipCode){
        wait.until(ExpectedConditions.visibilityOfElementLocated(this.zipCode)).sendKeys(zipCode);
    }

    public void enterPhoneNumber(String phone){
        wait.until(ExpectedConditions.visibilityOfElementLocated(this.phone)).sendKeys(phone);
    }

    public void enterAliasAddress(String aliasAddress){
        wait.until(ExpectedConditions.visibilityOfElementLocated(this.aliasAddress)).sendKeys(aliasAddress);
    }

    public void stateSelection(String state){
        Select sl = new Select(wait.until(ExpectedConditions.presenceOfElementLocated(By.id("id_state"))));
        sl.selectByVisibleText(state);
    }

    public void clickRegister(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(registerButton)).click();
    }
}
