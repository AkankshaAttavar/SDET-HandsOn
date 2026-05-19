import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;

public class InvalidLoginTest {

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://rahulshettyacademy.com/locatorspractice/");
// INPUT INVALID LOGIN
        driver.findElement(By.id("inputUsername")).sendKeys("rahul");
        driver.findElement(By.name("inputPassword")).sendKeys("hello123");
        driver.findElement(By.className("signInBtn")).click();
        Assert.assertEquals(driver.findElement(By.cssSelector("p.error")).getText(), "* Incorrect username or password");

        System.out.println("Invalid login test PASSED");
//FORGOT PASSWORD AND RETRIVE PASSWORD
        driver.findElement(By.linkText("Forgot your password?")).click();

        driver.findElement(By.xpath("//input[@placeholder = 'Name']")).sendKeys("rahul");
        driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("rahulshettyacademy@gmail.com");
        driver.findElement(By.xpath("//input[@placeholder = 'Phone Number']")).sendKeys("9192838465");
        Thread.sleep(1000);
        driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
        Thread.sleep(1000);
        String successMessage = driver.findElement(By.cssSelector("form p")).getText();
        System.out.println(successMessage);

        String password = successMessage.split("'")[1];
        System.out.println("Extracted password is: " + password);

//GO TO LOGIN AND LOGIN SUCESSFULLY
        driver.findElement(By.xpath("//button[@class ='go-to-login-btn']")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("inputUsername")).sendKeys("rahul");
        driver.findElement(By.name("inputPassword")).sendKeys(password);
        driver.findElement(By.className("signInBtn")).click();

//CHECK IF LOGGED IN?
        System.out.println(driver.getTitle());
        Thread.sleep(3000);
        System.out.println(driver.findElement(By.tagName("p")).getText());
        Assert.assertEquals(driver.findElement(By.xpath("//p[text()='You are successfully logged in.']")).getText(), "You are successfully logged in.");

        driver.quit();


    }


}
