package mk.sedc.finalproject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartSummaryPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    public CartSummaryPage(WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
    }

    public void clickDeleteBtn() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("cart_quantity_delete"))).click();
    }

    public String getDeleteInfo(){
        WebElement deleteInfo = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"center_column\"]/p")));
        String deleteIteminfo = deleteInfo.getText();
        return deleteIteminfo;
    }

    public String getAddress(){
        WebElement address = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"address_delivery\"]/li[3]")));
        String addressText = address.getText();
        return addressText;
    }

    public String getCityStateZip(){
        WebElement cityStateZip = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"address_delivery\"]/li[4]")));
        String cityStateZipcode = cityStateZip.getText();
        return cityStateZipcode;
    }

}
