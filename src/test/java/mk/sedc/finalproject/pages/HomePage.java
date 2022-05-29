package mk.sedc.finalproject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
    private WebDriver driver;
    private WebDriverWait wait;

    private By fname = By.id("firstname");
    private By lname = By.id("lastname");

    public HomePage(WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
    }

    public String getInfoAccount(){
        WebElement infoAccount = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("info-account")));
        String infoTextAccount = infoAccount.getText();
        return infoTextAccount;
    }

}
