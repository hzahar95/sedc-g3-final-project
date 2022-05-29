package mk.sedc.finalproject.pages;

import mk.sedc.finalproject.utils.BaseHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DressDetailsPage {
    private final WebDriver driver;
    private final WebDriverWait wait;
    private By colorSelect = By.className("color_pick");
    private By quantity = By.xpath("//*[@id=\"quantity_wanted\"]");
    private BaseHelper helper = new BaseHelper();

    public DressDetailsPage(WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
    }

    public String clickColor() {
        WebElement color = helper.choseRandomElement(colorSelect, driver);
        String colorText = color.getAccessibleName();
        color.click();
        System.out.println("Color name: " + colorText);
        return colorText;
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

    public void clickAddToCart() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("add_to_cart"))).click();
    }
}
