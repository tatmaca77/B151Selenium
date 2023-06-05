package techproed.day01_IlkTest_DriverMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class GetMethods_Training {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        driver.get("https://amazon.com");
        String sayfaBasligi = driver.getTitle();
        System.out.println("Sayfa Basligi: " + sayfaBasligi);

        if (sayfaBasligi.contains("Amazon")) {
            System.out.println("Test PASSED");
        } else {
            System.out.println("Test FAILED");
        }

        String link = driver.getCurrentUrl();
        System.out.println(link);

        if (link.contains("amazon")) {
            System.out.println("Test PASSED");
        }else {
            System.out.println("Test FAILED");
        }

        System.out.println("Amazon Window Handle Degeri : " + driver.getWindowHandle());

        String gateway = driver.getPageSource();

        if (gateway.contains("Gateway")) {
            System.out.println("Test PASSED");
        } else {
            System.out.println("Test FAILED");
        }

       driver.close();


    }

}
