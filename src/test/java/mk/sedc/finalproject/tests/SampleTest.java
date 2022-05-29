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
        accountPage.clickSignIn();
        accountPage.enterEmail(email);
        accountPage.clickCreateAccount();
        accountPage.clickTitle();
        accountPage.enterFirstName(firstName);
        accountPage.enterLastName(lastName);
        scroll(0,400);
        accountPage.enterPassword(password);
        accountPage.enterAddress(fullAddress);
        accountPage.enterCity(city);
        accountPage.stateSelection(state);
        accountPage.enterZipCode(zip);
        accountPage.enterPhoneNumber(phoneNumber.cellPhone());
        accountPage.enterAliasAddress(address.secondaryAddress());
        accountPage.stateSelection(state);
        accountPage.clickRegister();
        String actualInfoAccount = homePage.getInfoAccount();
        Assert.assertEquals(actualInfoAccount, "Welcome to your account. Here you can manage all of your personal information and orders.", "User has not created an account");
    }

    @Test(dependsOnGroups = "register")
    public void testAddToCart(){
        accountPage.login(email, password);

        int qty = 2;
        String size = "M";

        dressesPage.clickDresses();
        scroll(0,400);
        dressesPage.clickSummerDresses();
        scroll(0,400);
        String productName = dressesPage.clickProduct();
        dressDetailsPage.enterQty(qty);
        dressDetailsPage.sizeSelection(size);
        scroll(0,400);
        String color = dressDetailsPage.clickColor();
        dressDetailsPage.clickAddToCart();
        String markedProductName = itemConfirmationPage.getProductName();
        Assert.assertEquals(markedProductName, productName, "Product name is not as expected");
        String[] productAttributes = itemConfirmationPage.getProductAtrributes();
        Assert.assertEquals(productAttributes[0].trim(), color);
        Assert.assertEquals(productAttributes[1].trim(), size);
        int productQty = itemConfirmationPage.getProductQty();
        Assert.assertEquals(productQty, qty, "Incorrect quantity");
        double productPrice = itemConfirmationPage.getProductPrice();
        double totalPrice = itemConfirmationPage.getTotalPrice();
        double expectedTotalPrice = productPrice * productQty;
        Assert.assertEquals(totalPrice, expectedTotalPrice, "Incorrect total price");
        itemConfirmationPage.clickProceedToCheckout();
        scroll(0,400);
    }

    @Test (dependsOnGroups = "register")
    public void testRemoveFromCart(){
        accountPage.login(email, password);

        int qty = 2;
        String size = "M";

        dressesPage.clickDresses();
        scroll(0,400);
        dressesPage.clickSummerDresses();
        scroll(0,400);
        String productName = dressesPage.clickProduct();
        dressDetailsPage.enterQty(qty);
        dressDetailsPage.sizeSelection(size);
        scroll(0,400);
        String color = dressDetailsPage.clickColor();
        dressDetailsPage.clickAddToCart();
        itemConfirmationPage.clickProceedToCheckout();
        scroll(0,400);
        sleep(2000);
        cartSummaryPage.clickDeleteBtn();
        String actualDeleteInfo = cartSummaryPage.getDeleteInfo();
        Assert.assertEquals(actualDeleteInfo, "Your shopping cart is empty.");
    }

    @Test (dependsOnGroups = "register")
    public void testOrderCheckout(){
        accountPage.login(email, password);

        int qty = 2;
        String size = "M";

        dressesPage.clickDresses();
        scroll(0,400);
        dressesPage.clickSummerDresses();
        scroll(0,400);
        String productName = dressesPage.clickProduct();
        dressDetailsPage.enterQty(qty);
        dressDetailsPage.sizeSelection(size);
        scroll(0,400);
        String color = dressDetailsPage.clickColor();
        dressDetailsPage.clickAddToCart();
        itemConfirmationPage.clickProceedToCheckout();
        scroll(0,600);
        itemConfirmationPage.clickProceedToCheckout();
        scroll(0, 600);
        String actualAddress = cartSummaryPage.getAddress();
        Assert.assertEquals(actualAddress, fullAddress);
        String actualCityStateZip = cartSummaryPage.getCityStateZip();
        Assert.assertEquals(actualCityStateZip, city +", "+state+" "+zip);
    }
}
