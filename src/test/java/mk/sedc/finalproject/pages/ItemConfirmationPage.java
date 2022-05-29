package mk.sedc.finalproject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ItemConfirmationPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    public ItemConfirmationPage(WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
    }

    public double getProductPrice(){
        WebElement product_price = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("our_price_display")));
        String productPrice = product_price.getText();
        String replaceString=productPrice.replace("$", "");
        double finalProductPrice = Double.parseDouble(replaceString);
        return finalProductPrice;
    }

    public String getProductName(){
        WebElement layer_cart_product_title = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@id='layer_cart_product_title']")));
        String layerCartProductTitle = layer_cart_product_title.getText();
        return layerCartProductTitle;
    }

    public String[] getProductAtrributes(){
        WebElement layer_cart_product_attributes = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@id='layer_cart_product_attributes']")));
        String layerCartProductAttributes = layer_cart_product_attributes.getText();
        String[] attributes = layerCartProductAttributes.split(",");
        return attributes;
    }

    public int getProductQty(){
        WebElement layer_cart_product_qty = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("layer_cart_product_quantity")));
        String layerCartProductQty = layer_cart_product_qty.getText();
        int finalProductQty = Integer.parseInt(layerCartProductQty);
        return finalProductQty;
    }

    public double getTotalPrice(){
        WebElement layer_cart_total_price = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("layer_cart_product_price")));
        String layerCartTotalPrice = layer_cart_total_price.getText();
        String replaceString = layerCartTotalPrice.replace("$", "");
        double finalTotalPrice = Double.parseDouble(replaceString);
        return finalTotalPrice;
    }

    public void clickProceedToCheckout() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Proceed to checkout"))).click();
    }
}
