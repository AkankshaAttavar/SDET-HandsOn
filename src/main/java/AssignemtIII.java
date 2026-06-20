import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class AssignemtIII {

    public static void main (String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://rahulshettyacademy.com/loginpagePractise/");

        driver.findElement(By.id("username")).sendKeys("rahulshettyacademy");
        driver.findElement(By.name("password")).sendKeys("Learning@830$3mK2");
        driver.findElement(By.xpath("//input[@value='user']")).click();


        WebDriverWait waits = new WebDriverWait(driver, Duration.ofSeconds(10));
        waits.until(ExpectedConditions.elementToBeClickable(By.id("okayBtn")));
        driver.findElement(By.id("okayBtn")).click();
        driver.findElement(By.id("okayBtn")).click();
        //waits.until(ExpectedConditions.elementToBeClickable(By.cssSelector("select.form-control")));
        Select dropdown = new Select(driver.findElement(By.cssSelector("select.form-control")));
        dropdown.selectByVisibleText("Consultant");
        driver.findElement(By.id("terms")).click();
        driver.findElement(By.id("signInBtn")).click();


        // After sign in
        waits.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button.btn-info")));
        List<WebElement> addButtons = driver.findElements(By.cssSelector("button.btn-info"));
        System.out.println("Total buttons: " + addButtons.size());

        // Click each button and handle modal
        for(int i = 0; i < addButtons.size(); i++) {
            addButtons.get(i).click();

            driver.findElement(By.cssSelector("button.btn-info")).click();
        }

// Go to cart
        driver.findElement(By.cssSelector("a.nav-link.btn.btn-primary")).click();
        waits.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button.btn.btn-success")));
        driver.findElement(By.cssSelector("button.btn.btn-success")).click();
//Closing
        driver.quit();
        }
    }




