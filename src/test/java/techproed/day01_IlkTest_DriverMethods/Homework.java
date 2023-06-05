package techproed.day01_IlkTest_DriverMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Homework {

    public static void main(String[] args) throws InterruptedException {

        /**
        1.Yeni bir class olusturalim (Homework)
        2.ChromeDriver kullanarak, facebook sayfasina gidin ve sayfa basliginin (title) “facebook”
           oldugunu dogrulayin (verify), degilse dogru basligi yazdirin.
        3.Sayfa URL’inin “facebook” kelimesi icerdigini dogrulayin, icermiyorsa “actual” URL’i
           yazdirin.
        4.https://www.walmart.com/ sayfasina gidin.
        5. Sayfa basliginin “Walmart.com” icerdigini dogrulayin.
        6. Tekrar “facebook” sayfasina donun
        7.Sayfayi yenileyin
        8.Sayfayi tam sayfa (maximize) yapin
        9.Browser’i kapatin
         */

        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        driver.get("https://www.facebook.com/");

        String actualTitle = driver.getTitle();
        String expectedTitle = "Facebook – Anmelden oder Registrieren";

        if (actualTitle.equals(expectedTitle)) {
            System.out.println("Test PASSED");
        } else {
            System.out.println("Sayfa Basligi : " + actualTitle);
        }

        String actuaLink = driver.getCurrentUrl();

        if (actuaLink.contains("facebook")){
            System.out.println("Test PASSED");
        } else {
            System.out.println("URL : " + actuaLink);
        }

        Thread.sleep(3000);

        driver.navigate().to("https://www.walmart.com/");

        String actualTitle2 = driver.getTitle();

        if (actualTitle2.contains("Walmart.com")) {
            System.out.println("Test PASSED");
        } else {
            System.out.println("Test FAILED");
        }

        Thread.sleep(3000);

        driver.navigate().back();

        driver.navigate().refresh();

        driver.manage().window().maximize();

        driver.quit();




    }
}
