package StudyHallRidvanTestNG;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class day02_Locator_Title_Practice {

    public static void main(String[] args) {

       // http://automationpractice.com/index.php

        //Initialize Browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        // Go to automation practice website
        driver.get("http://automationpractice.com/index.php");
        //Click on Contact US button
        //We are going to use linktext to locate which "Contact us"
        WebElement contacUs=driver.findElement(By.linkText("Contact us"));
        contacUs.click();
        WebElement sendButton=driver.findElement(By.name("submitMessage"));
        sendButton.click();

        WebElement searchBox= driver.findElement(By.id("search_query_top"));
        searchBox.sendKeys("t-shirt"+ Keys.ENTER);

        //First way to click
//        WebElement searchButton= driver.findElement(By.name("submit_search"));
//        searchButton.click();

        //driver.quit();
        String expectedTitle="Search - My Store";
        String actualTitle=driver.getTitle();

        if (actualTitle.equals(expectedTitle)){
            System.out.println("Title verification was successful");
            System.out.println("The title is : "+actualTitle);
        }else {
            System.out.println("Title verification failed");
            System.out.println("The expected title is : "+expectedTitle+ "   ,"+"The actual title is : "+actualTitle);
        }
    }
}
