import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

public class FewMoreFeatures {

    public static void main (String[] args) throws IOException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        String name = driver.findElement(By.xpath("//tr/td[1]")).getText();
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://rahulshettyacademy.com/angularpractice/");
        Set<String> handles = driver.getWindowHandles();
        Iterator <String> it = handles.iterator();

        String parentWindow = it.next();

        String childWindow = it.next();
        driver.switchTo().window(childWindow);
        driver.findElement(By.name("name")).sendKeys(name);
        WebElement nameEditbox = driver.findElement(By.name("name"));
        File file=nameEditbox.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file, new File("logo.png"));



//driver.quit();
    }

}
