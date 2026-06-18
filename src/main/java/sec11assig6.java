import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class sec11assig6 {

    public static void main (String[] args){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.findElement(By.id("checkBoxOption3")).click();
        String selection = driver.findElement(By.xpath("//label[@for='honda']")).getText();
        System.out.println(selection);
        Select option = new Select(driver.findElement(By.id("dropdown-class-example")));
        option.selectByVisibleText(selection);
        driver.findElement(By.xpath("//input[@placeholder='Enter Your Name']")).sendKeys(selection);
        driver.findElement(By.id("alertbtn")).click();
        String alertText = driver.switchTo().alert().getText();
        System.out.println(alertText);
        driver.switchTo().alert().accept();
    }
}
