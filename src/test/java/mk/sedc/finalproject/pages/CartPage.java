package mk.sedc.finalproject.pages;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;
import java.util.Random;

public class CartPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private By dresses = By.xpath("//*[@id=\"block_top_menu\"]/ul/li[2]/a");
    private By summerDresses = By.xpath("//*[@id=\"subcategories\"]/ul/li[3]");
    private By quantity = By.xpath("//*[@id=\"quantity_wanted\"]");
    private By productLink = By.className("product-container");
    private By colorSelect = By.className("color_pick");
    private By checkout = By.xpath("//*[text()[contains(.,'Proceed to checkout')]]");


    public CartPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void click_dresses() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(dresses)).click();
    }

    public void click_summerDresses() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(summerDresses)).click();
    }

//    public void click_product(){
//        List<WebElement> elements = driver.findElements(productLink);
//        int productNumber = random(elements.size());
//        elements.get(productNumber).click();
//    }

    public String click_product(){
        WebElement product = choseRandomElement(productLink);
        String productText = product.findElement(By.className("product-name")).getText();
        product.click();
        System.out.println("Product name: "+productText);
        return productText;
    }

    public String click_color(){
        WebElement color = choseRandomElement(colorSelect);
        String colorText = color.getAccessibleName();
        color.click();
        System.out.println("Color name: "+colorText);
        return colorText;
    }

    public WebElement choseRandomElement(By selector){
        List<WebElement> elements = driver.findElements(selector);
        int randomIndex = random(elements.size());
        return elements.get(randomIndex);
    }


    public int random(int number){
        Random ran = new Random();
        int x = ran.nextInt(number);
        return x;
    }
    public void enterQty(int qty){
        WebElement quantityInput = wait.until(ExpectedConditions.visibilityOfElementLocated(this.quantity));
        quantityInput.clear();
        quantityInput.sendKeys(String.valueOf(qty));
    }

    public void sizeSelection(String size){
        Select sl = new Select(wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//select[@id='group_1']"))));
        sl.selectByVisibleText(size);
    }

    public void click_addToCart() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("add_to_cart"))).click();
    }

    public void validate(String productName, String color, String size, int quantity) {
      validateProductName(productName);
      validateAttributes(color, size);
    }

    private void validateProductName(String productName){
        WebElement layer_cart_product_title = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@id='layer_cart_product_title']")));
        String layerCartProductTitle = layer_cart_product_title.getText();
        Assert.assertEquals(layerCartProductTitle, productName);
    }

    private void validateAttributes(String color, String size){
        WebElement layer_cart_product_attributes = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@id='layer_cart_product_attributes']")));
        String layerCartProductAttributes = layer_cart_product_attributes.getText();
        String[] attributes  = layerCartProductAttributes.split(",");
        Assert.assertEquals(attributes[0].trim(), color);
        Assert.assertEquals(attributes[1].trim(), size);
    }

    public void click_proceedToCheckout() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(checkout)).click();
    }
}
