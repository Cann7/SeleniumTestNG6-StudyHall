package StudyHallRidvanTestNG;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class day03_Locators_Continued {

    //1. Open Chrome browser
//2. Go to https://demo.guru99.com/test/radio.html
//3. Verify all checkboxes are not selected (you can use findelements to store in list and use for loop to validate)
//4. Click to checkbox3
//5. Verify checkbox3 is selected

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://demo.guru99.com/test/radio.html");
        driver.manage().window().maximize();

        //input[.='Checkbox3']
        //input[@value='checkbox3']
        WebElement chechBox3=driver.findElement(By.xpath("//input[@value='checkbox3']"));
         // We want to if it is selected or not. if it is selected we will print this message "The checkbox is selected"
        // and if it is not selected we will select it and print this same
        if (chechBox3.isSelected()){
            System.out.println("The checkbox3 is selected");

        }else {
            System.out.println("The checkbox3 was not selected");
            System.out.println("The checkbox3 is selected now");
           // chechBox3.click();
        }

        //input[@type='checkbox']
        List<WebElement> checkboxes=driver.findElements(By.xpath("//input[@type='checkbox']"));

        for (WebElement each : checkboxes){
            if (!each.isSelected()){
                System.out.println(each.getAttribute( "value") + "is not selected");
                if (each.getAttribute("value").contains("checkbox3")){
                    each.click();
                }
            }else {
                System.out.println(each.getAttribute( "value") + "is selected");

            }
        }

    }
}
