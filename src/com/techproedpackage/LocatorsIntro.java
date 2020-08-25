package com.techproedpackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;

public class LocatorsIntro {



//    Sign out from the page
public static void main(String[] args) throws InterruptedException {
    System.setProperty("webdriver.chrome.driver","/Users/techproed/Documents/selenium libraries/drivers/chromedriver");
    WebDriver driver = new ChromeDriver();
    //    user goes to http://a.testaddressbook.com/sign_in
    driver.get("http://a.testaddressbook.com/sign_in");
    //    Locate the elements of email textbox,password textbox, and signin button
    //<input type="email" class="form-control" placeholder="Email" data-test="email" name="session[email]" id="session_email">
    WebElement emailTextBox=driver.findElement(By.id("session_email"));

    //<input class="form-control" placeholder="Password" data-test="password" type="password" name="session[password]" id="session_password">
    WebElement passwordTextBox=driver.findElement(By.id("session_password"));

    //<input type="submit" name="commit" value="Sign in" class="btn btn-primary" data-test="submit" data-disable-with="Sign in">
    WebElement signinButton=driver.findElement(By.name("commit"));

    //    Enter below username and password then click sign in button
    //    Username : testtechproed@gmail.com
    //    Password : Test1234!

    Thread.sleep(1000);
    //Sending username in the email text box
    emailTextBox.sendKeys("testtechproed@gmail.com");
    Thread.sleep(1000);
    //sending the pasword in the password textbox
    passwordTextBox.sendKeys("Test1234!");
    Thread.sleep(1000);
    //click on sign in button
    signinButton.click();

    //    Then verify that the expected user id testtechproed@gmail.com
    String expectedUserIDText="testtechproed@gmail.com";
    WebElement actualUserID= driver.findElement(By.className("navbar-text"));//WebElement: We are not going to get the text when we print
    //System.out.println(actualUserID);//This gives me the webelement reference:[[ChromeDriver: chrome on MAC (c370c8652f23fb7a99565e14354798cf)] -> class name: navbar-text]
    String actualUserIDText=actualUserID.getText();//testtechproed@gmail.com

    if (actualUserIDText.equals(expectedUserIDText)){
        System.out.println("PASS");
    }else{
        System.out.println("FAILS");
        System.out.println("ACTUAL ID : "+actualUserIDText);
        System.out.println("EXPECTED ID : "+expectedUserIDText);
    }

    //    Verify the Addresses and Sign Out texts are displayed
    String expectedAddressText="Addresses";
    //Locating the actual address
    WebElement actualAddress= driver.findElement(By.linkText("Addresses"));
    String actualAddressText=actualAddress.getText();
    if(expectedAddressText.equals(actualAddressText)){
        System.out.println("PASS");
    }else{
        System.out.println("FAIL");
        System.out.println("ACTUAL : "+actualAddressText);
        System.out.println("EXPECTED : "+expectedAddressText);
    }

    //Locating the sign out element
    //<a class="nav-item nav-link" data-test="sign-out" rel="nofollow" data-method="delete" href="/sign_out">Sign out</a>
    //When we use linkText or partialLinkText, we pass the TEXT, NOT THE VALUE
    String expectedSignOutText="Sign Out";
//    WebElement signOut=driver.findElement(By.linkText("Sign out"));
    WebElement signOut=driver.findElement(By.partialLinkText("ign ou"));
    String actualSignOutText=signOut.getText();

    if (expectedSignOutText.equals(actualSignOutText)){
        System.out.println("PASS");
    }else{
        System.out.println("FAILS");
        System.out.println("ACTUAL : "+actualSignOutText);
        System.out.println("EXPECTED : "+expectedSignOutText);
    }
    //We found a bug: actual is Sign out, but expected is Sign Out.
    //We need to take the screenshot of the webpage and report this to the developer first


    // Find the number of total link on the page
    // a tag creates link on a page. We need to find how many a tag on the page
    //To find how many a TAG on th page, we can use tagName("a"); locator

    List<WebElement> numberOfLink=driver.findElements(By.tagName("a"));//We are expecting to get multiple elements. For this reason, we use findElements() method for tagName locator
    int countOfLink=numberOfLink.size();
    System.out.println("Number Of Link : "+countOfLink);

    for (WebElement element:numberOfLink){
        System.out.println(element.getText());
    }
    //SIGN OUT AS HOMEWORK
   }
}
