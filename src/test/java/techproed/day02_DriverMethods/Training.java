package techproed.day02_DriverMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Training {

    public static void main(String[] args) throws InterruptedException {
        /**
        1. Yeni bir class olusturun (TekrarTesti)
        2. Youtube web sayfasına gidin ve sayfa başlığının “youtube” olup olmadığını doğrulayın
           (verify), eğer değilse doğru başlığı(Actual Title) konsolda yazdirin.
        3. Sayfa URL'sinin “youtube” içerip içermediğini (contains) doğrulayın, içermiyorsa doğru
           URL'yi yazdırın.
        4. Daha sonra Amazon sayfasina gidin https://www.amazon.com/
        5. Youtube sayfasina geri donun
        6. Sayfayi yenileyin
        7. Amazon sayfasina donun
        8. Sayfayi tamsayfa yapin
        9. Ardından sayfa başlığının "Amazon" içerip içermediğini (contains) doğrulayın, Yoksa doğru
           başlığı(Actual Title) yazdırın.
        10.Sayfa URL'sinin https://www.amazon.com/ olup olmadığını doğrulayın, degilse doğru
           URL'yi yazdırın
        11.Sayfayi kapatin
         */
        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        driver.navigate().to("https://www.youtube.com/");

        String actualTitle = driver.getTitle();
        String expectedTitle = "YouTube";

        if (actualTitle.equals(expectedTitle)){
            System.out.println("Test PASSED");
        } else {
            System.out.println("Sayfa Basligi : " + actualTitle);
        }

        String link = driver.getCurrentUrl();

        if (link.contains("youtube")) {
            System.out.println("Test PASSED");
        } else {
            System.out.println("URL : " + link);
        }

        Thread.sleep(3000);

        driver.get("https://www.amazon.com");

        Thread.sleep(3000);

        driver.navigate().back();

        driver.navigate().refresh();

        driver.navigate().forward();

        driver.manage().window().fullscreen();

        String actualTitle2 = driver.getTitle();

        if (actualTitle2.contains("Amazon")) {
            System.out.println("Test PASSED");
        } else {
            System.out.println("Sayfa Basligi : " + actualTitle2);
        }

        String link2 = driver.getCurrentUrl();
        String expectedLink2 = "https://www.amazon.com/";

        if (link2.equals(expectedLink2)) {
            System.out.println("Test PASSED");
        } else {
            System.out.println("URL : " + link2);
        }

        driver.close();




    }
}
