package mk.sedc.finalproject.utils;

public class BaseHelper {

    public String randomEmail(){
        String myEmailAddress = "myaddress" + System.nanoTime() + "@gmail.com";
        System.out.println(myEmailAddress);
        return myEmailAddress;
    }
}
