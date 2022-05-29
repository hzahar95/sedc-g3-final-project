package mk.sedc.finalproject.pages;

import mk.sedc.finalproject.utils.BaseHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DressesPage {
    private final WebDriver driver;
    private final WebDriverWait wait;
    private By dresses = By.xpath("//*[@id=\"block_top_menu\"]/ul/li[2]/a");
    private By summerDresses = By.xpath("//*[@id=\"subcategories\"]/ul/li[3]");
    private By productLink = By.className("product-container");
    private BaseHelper helper = new BaseHelper();

    public DressesPage(WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
    }

    public void clickDresses() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(dresses)).click();
    }

    public void clickSummerDresses() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(summerDresses)).click();
    }

    public String clickProduct(){
        WebElement product = helper.choseRandomElement(productLink, driver);
        String productText = product.findElement(By.className("product-name")).getText();
        product.click();
        System.out.println("Product name: "+productText);
        return productText;
    }

}
