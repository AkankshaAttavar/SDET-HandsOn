import io.github.bonigarcia.wdm.WebDriverManager;
import org.jspecify.annotations.NonNull;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;
import java.util.stream.Collectors;

public class JavastreamsSort {

    public static void main (String[] args){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
        driver.findElement(By.xpath("//tr/th[1]")).click();
        List <WebElement> listOfVegetables = driver.findElements(By.xpath("//tr/td[1]"));
        List <String> originalList = listOfVegetables.stream().map(s->s.getText()).collect(Collectors.toList());
        List <String> sortedList = originalList.stream().sorted().collect(Collectors.toList());
        Assert.assertTrue(sortedList.equals(originalList));

        List <String> price = listOfVegetables.stream().filter(s->s.getText().contains("Apple")).map(s->getPrice(s)).collect(Collectors.toList());
price.forEach(a->System.out.println(a));

    }
    public static String getPrice(WebElement s){

        String priceValue = s.findElement(By.xpath("following-sibling::td[1]")).getText();
        return priceValue;

    }
}
