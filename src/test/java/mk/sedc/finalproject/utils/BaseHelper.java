package mk.sedc.finalproject.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;

public class BaseHelper {

    public String randomEmail(){
        String myEmailAddress = "myaddress" + System.nanoTime() + "@gmail.com";
        System.out.println(myEmailAddress);
        return myEmailAddress;
    }

    public WebElement choseRandomElement(By selector, WebDriver driver){
        List<WebElement> elements = driver.findElements(selector);
        int randomIndex = random(elements.size());
        return elements.get(randomIndex);
    }

    public int random(int number){
        Random ran = new Random();
        int x = ran.nextInt(number);
        return x;
    }
}
