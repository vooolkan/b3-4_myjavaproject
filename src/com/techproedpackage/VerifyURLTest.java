package com.techproedpackage;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class VerifyURLTest {
    public static void main(String[] args) {
//        Create a new class: VerifyURLTest
//        Navigate to google homepage
//        Verify if google homepage url is “www.google.com"

        System.setProperty("webdriver.chrome.driver","/Users/techproed/Documents/selenium libraries/drivers/chromedriver");
        WebDriver driver= new ChromeDriver();
        driver.navigate().to("https://www.boeing.com/");
        //getting the page url
        String actualURL=driver.getCurrentUrl();
        String expectedURL="www.boeing.com";

        if (actualURL.equals(expectedURL)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
            System.out.println("ACTUAL : "+actualURL);
            System.out.println("EXPECTED : "+expectedURL);
        }

    }
}
