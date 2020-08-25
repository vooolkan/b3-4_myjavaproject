package com.techproedpackage;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day1Review {


public static void main(String[] args) {
    System.setProperty("webdriver.chrome.driver","/Users/techproed/Documents/selenium libraries/drivers/chromedriver");
    WebDriver driver = new ChromeDriver();
    //    Using ChromeDriver, Go to youtube and verify if page title is “youtube”, If not, print the correct title.
    driver.get("https://www.youtube.com");
    String actualYoutubeTitle=driver.getTitle();
    String expectedYoutubeTitle="youtube";
    if (actualYoutubeTitle.equals(expectedYoutubeTitle)){
        System.out.println("PASS");
    }else{
        System.out.println("FAIL");
    }
    //    Verify if the page URL contains youtube if not, print the right url
    String actualYoutubeURL=driver.getCurrentUrl();
    String expectedYoutubeURL="youtube";
    if (actualYoutubeURL.contains(expectedYoutubeURL)){
        System.out.println("PASS");
    }else{
        System.out.println("FAIL");
        System.out.println("EXPECTED YOUTUBE URL ===>>>> "+expectedYoutubeURL);
        System.out.println("ACTUAL YOUTUBE URL ===>>>> "+actualYoutubeURL);
    }
    //    Then Navigate to https://www.amazon.com/
    driver.navigate().to("https://www.amazon.com");
    //    Navigate back to youtube
    driver.navigate().back();
    //    Refresh the page
    driver.navigate().refresh();
    //    Navigate forward to amazon
    driver.navigate().forward();
    //    Maximize the window
    driver.manage().window().maximize();
    //    Then verify if page title includes(contains) “Amazon”, If not, print the correct title
    if (driver.getTitle().contains("Amazon")){
        System.out.println("PASS");
    }else{
        System.out.println("FAIL");
        System.out.println("ACTUAL AMAZON TITLE : "+driver.getTitle());
    }
//    Verify if the page URL is(equals) https://www.amazon.com/, if not print the correct url
    if (driver.getCurrentUrl().equals("https://www.amazon.com/")){
        System.out.println("PASS");
    }else{
        System.out.println("FAIL");
        System.out.println("ACTUAL AMAZON URL : "+driver.getCurrentUrl());
    }
    //    Quit the browser
    driver.quit();
}
}
