package mk.sedc.finalproject.tests;

import com.github.javafaker.Faker;
import org.testng.annotations.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;

public class SampleTest extends BaseTest{

    @Test
    public void testSignIn(){
        String password = "proba1";
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        homePage.click_signIn();
        sleep(2000);
        homePage.enterEmail(homePage.randomEmail());
        sleep(2000);
        homePage.click_createAccount();
        sleep(2000);
        homePage.enterFirstName(firstName);
        sleep(1000);
        homePage.enterLastName(lastName);
        scroll(0,400);
        sleep(2000);
        homePage.enterPassword(password);
        sleep(2000);
    }

    @Test
    public void testAddToCart(){
        int qty = 2;
        String size = "M";

        cartPage.click_dresses();
        sleep(2000);
        scroll(0,400);
        cartPage.click_summerDresses();
        sleep(2000);
        scroll(0,400);
        String productName = cartPage.click_product();
        System.out.println(productName);
        sleep(2000);
        cartPage.enterQty(qty);
        sleep(2000);
        cartPage.sizeSelection(size);
        sleep(2000);
        scroll(0,400);
        String color = cartPage.click_color();
        sleep(2000);
        cartPage.click_addToCart();
        //sleep(15000);
        cartPage.validate(productName,color,size,qty);
        cartPage.click_proceedToCheckout();
        sleep(4000);
        scroll(0,400);
    }

    @Test(groups="ignore")
    public void test2(){
        Faker faker = new Faker();
        HashMap<String, String> user = new HashMap<String, String>();
        user.put("username", "hristina");
        user.put("password", "P@$$w)rd");
        user.put("email", "christinezahar+1@yahoo.com");

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        LocalDateTime now = LocalDateTime.now();
        System.out.println(dtf.format(now));
        user.put("email", "christinezahar+" + dtf.format(now) + "@gmail.com");
        System.out.println(user.get("email"));

        /*System.out.println("Firstname: " + user.get("username"));

        System.out.println();
        String username = "hristina";
        String password = "nesto";*/
    }
}
