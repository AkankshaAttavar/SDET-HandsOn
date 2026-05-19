import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static java.lang.Thread.sleep;

public class TestOnLocators {

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //Opening site demoblaze

        driver.get("https://www.demoblaze.com");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.id("login2")).click();

        driver.findElement(By.id("loginusername")).sendKeys("testuser123");
        driver.findElement(By.id("loginpassword")).sendKeys("password123");

        Thread.sleep(1000);

        driver.findElement(By.xpath("//button[@onclick='logIn()']")).click();
        Thread.sleep(3000);
        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();
        System.out.println(driver.getTitle());
        // driver.quit();
    }
}
