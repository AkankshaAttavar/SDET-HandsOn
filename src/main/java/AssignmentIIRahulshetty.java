import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class AssignmentIIRahulshetty {

    public static void main(String[] args) throws InterruptedException {

        //web handeling
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.get("https://rahulshettyacademy.com/angularpractice/");

        //Filling the form
        driver.findElement(By.xpath("//input[@name='name']")).sendKeys("Akanksha");
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys("akshuattavar@gmail.com");
        driver.findElement(By.id("exampleInputPassword1")).sendKeys("Akankshaspassword");
        driver.findElement(By.id("exampleCheck1")).click();
        Select gender = new Select(driver.findElement(By.id("exampleFormControlSelect1")));
        gender.selectByVisibleText("Female");
        driver.findElement(By.id("inlineRadio1")).click();
        driver.findElement(By.xpath("//input[@name='bday']")).sendKeys("10/08/2001");

        driver.findElement(By.xpath("//input[@type='submit']")).click();
        Thread.sleep(2000);
        System.out.println(driver.findElement(By.cssSelector(".alert.alert-success.alert-dismissible")).getText());

    }

}
