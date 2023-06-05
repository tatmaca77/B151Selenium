package techproed.day04_Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class ClassWork {

    public static void main(String[] args) {

        /**
           1.) https://www.diemol.com/selenium-4-demo/relative-locators-demo.html adresine gidin
           2.) Berlin’i 3 farkli relative locator ile locate edin
           3 ) Relative locator’larin dogru calistigini test edin
         */

        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        driver.get("https://www.diemol.com/selenium-4-demo/relative-locators-demo.html");

        driver.findElement(By.xpath("//a/img[@id='pid7_thumb']")); // XPath --> Parent-Child yöntemi
        driver.findElement(By.id("pid7_thumb"));// id yöntemi ile Locate ettim.
        driver.findElement(By.cssSelector("img[src='bots/sl-berlin-bot.png']")); // Css selector yöntemi ile Locate ettim.


        WebElement boston = driver.findElement(By.id("pid6_thumb"));
        WebElement sailor = driver.findElement(By.id("pid11_thumb"));
        WebElement newyork = driver.findElement(By.id("pid3_thumb"));

        WebElement expectedBerlin = driver.findElement(with(By.tagName("li")).above(sailor).toRightOf(boston).below(newyork));
        WebElement actrualBerlin = driver.findElement(By.id("pid7_thumb"));

        if (actrualBerlin.equals(expectedBerlin)) {
            System.out.println("Test PASSED");
        } else {
            System.out.println("Test FAILED");
        }

        driver.close();
    }
}
