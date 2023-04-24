package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class FBPosting {
    public static void main(String[] args) throws InterruptedException {

        // Creates an instance of ChromeOptions and adds options
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-notifications");
        /* This option opens the Chrome window with specified user profile.
        It is useful for when you wish to already be logged in.
        Replace the dir path with the path to your own user. */
        options.addArguments("--user-data-dir=C:\\Users\\adamj\\AppData\\Local\\Google\\Chrome\\User Data\\Profile 2");

        try {
            // Create an instance of ChromeDriver with the options
            ChromeDriver driver = new ChromeDriver(options);
            driver.manage().window().maximize();

            // Navigate to user profile
            driver.get("https://www.facebook.com/profile");

            // Find & click posting text field
            WebElement onYourMind = driver.findElement(By.xpath("//*[contains(text(), 'on your')]"));
            onYourMind.click();
            Thread.sleep(1000);
            Logback.navigationSuccess();

            // Find & put down sample post text into text field
            WebElement active = driver.switchTo().activeElement();
            active.sendKeys("Royale with Cheese");
            Thread.sleep(1000);

            /* Could not locate the element for the post button, so this uses
            TAB & ENTER keys to navigate to and push the button instead */
            for (int i = 0; i < 10; i++) {
                //active.sendKeys(Keys.TAB);
                active = driver.switchTo().activeElement();
            }
            active.sendKeys(Keys.ENTER);

            // Find the post, loggs the outcome
            try {
                // Obviously only works with one unique post...
                WebElement post = driver.findElement(By.xpath("//*[contains(text(), 'Royale')]"));
                Logback.postSuccess();
            } catch (Exception all) {
                Logback.postFailure();
            }
        } catch (Exception all) {
            Logback.navigationFailure();
        }
    }
}
