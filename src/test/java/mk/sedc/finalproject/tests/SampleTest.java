package mk.sedc.finalproject.tests;

import com.github.javafaker.PhoneNumber;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SampleTest extends BaseTest{

    @Test(groups = "register")
    public void testCreateAnAccount(){
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();

        PhoneNumber phoneNumber = faker.phoneNumber();
        homePage.clickSignIn();
        homePage.enterEmail(email);
        homePage.clickCreateAccount();
        homePage.clickTitle();
        homePage.enterFirstName(firstName);
        homePage.enterLastName(lastName);
        scroll(0,400);
        homePage.enterPassword(password);
        homePage.enterAddress(fullAddress);
        homePage.enterCity(city);
        homePage.stateSelection(state);
        homePage.enterZipCode(zip);
        homePage.enterPhoneNumber(phoneNumber.cellPhone());
        homePage.enterAliasAddress(address.secondaryAddress());
        homePage.stateSelection(state);
        homePage.clickRegister();
        String actualInfoAccount = homePage.getInfoAccount();
        Assert.assertEquals(actualInfoAccount, "Welcome to your account. Here you can manage all of your personal information and orders.", "User has not created an account");
    }

    @Test(dependsOnGroups = "register")
    public void testAddToCart(){
        homePage.login(email, password);

        int qty = 2;
        String size = "M";

        cartPage.click_dresses();
        scroll(0,400);
        cartPage.click_summerDresses();
        scroll(0,400);
        String productName = cartPage.click_product();
        cartPage.enterQty(qty);
        cartPage.sizeSelection(size);
        scroll(0,400);
        String color = cartPage.click_color();
        cartPage.click_addToCart();
        String markedProductName = cartPage.getProductName();
        Assert.assertEquals(markedProductName, productName, "Product name is not as expected");
        String[] productAttributes = cartPage.getProductAtrributes();
        Assert.assertEquals(productAttributes[0].trim(), color);
        Assert.assertEquals(productAttributes[1].trim(), size);
        int productQty = cartPage.getProductQty();
        Assert.assertEquals(productQty, qty, "Incorrect quantity");
        double productPrice = cartPage.getProductPrice();
        double totalPrice = cartPage.getTotalPrice();
        double expectedTotalPrice = productPrice * productQty;
        Assert.assertEquals(totalPrice, expectedTotalPrice, "Incorrect total price");
        cartPage.click_proceedToCheckout();
        scroll(0,400);
    }

    @Test (dependsOnGroups = "register")
    public void testRemoveFromCart(){
        homePage.login(email, password);

        int qty = 2;
        String size = "M";

        cartPage.click_dresses();
        scroll(0,400);
        cartPage.click_summerDresses();
        scroll(0,400);
        String productName = cartPage.click_product();
        cartPage.enterQty(qty);
        cartPage.sizeSelection(size);
        scroll(0,400);
        String color = cartPage.click_color();
        cartPage.click_addToCart();
        cartPage.click_proceedToCheckout();
        scroll(0,400);
        sleep(2000);
        cartPage.clickDeleteBtn();
        String actualDeleteInfo = cartPage.getDeleteInfo();
        Assert.assertEquals(actualDeleteInfo, "Your shopping cart is empty.");
    }

    @Test (dependsOnGroups = "register")
    public void testOrderCheckout(){
        homePage.login(email, password);

        int qty = 2;
        String size = "M";

        cartPage.click_dresses();
        scroll(0,400);
        cartPage.click_summerDresses();
        scroll(0,400);
        String productName = cartPage.click_product();
        cartPage.enterQty(qty);
        cartPage.sizeSelection(size);
        scroll(0,400);
        String color = cartPage.click_color();
        cartPage.click_addToCart();
        cartPage.click_proceedToCheckout();
        scroll(0,600);
        cartPage.click_proceedToCheckout();
        scroll(0, 600);
        String actualAddress = cartPage.getAddress();
        Assert.assertEquals(actualAddress, fullAddress);
        String actualCityStateZip = cartPage.getCityStateZip();
        Assert.assertEquals(actualCityStateZip, city +", "+state+" "+zip);
    }
}
