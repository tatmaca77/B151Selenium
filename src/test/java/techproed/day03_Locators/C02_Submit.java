package techproed.day03_Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_Submit {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        /**Soru 1 :
         // https://www.amazon.com sayfasına gidiniz
         // aramakutusunu locate ediniz ve Nutella aratınız
         // sayfayı kapatınız.
         */

        driver.get("https://www.amazon.com");

        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));// id ile Locate yaptik.
        aramaKutusu.sendKeys("Nutella");
        aramaKutusu.submit();

        driver.close();

    }
}
