package techproed.day03_Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C03_findElements {

    public static void main(String[] args) {


        /**
            https://www.amazon.com sayfasına gidiniz
           Amazon sayfasında kac tane link olduğunu konsolda yazdırın
           Linkleri konsolda yazdırın
           sayfayı kapatın
         */

        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        driver.get("https://www.amazon.com");// Amazon'a gideriz.

        /** Link'leri bir List'e assign ederiz. Elemnts oldugu icin bize coklu veri verir. */
        List <WebElement> linkSayisi = driver.findElements(By.tagName("a"));// Html'de link'in tag'i "a" oldugu icin.
        System.out.println("Linklerin Sayisi: " + linkSayisi.size()); // 363

        /** Link'leri console'da "for-each" loop ile yazdirdik. */
        for (WebElement w : linkSayisi) {
            System.out.println(w.getText()); // Bu WebElement'i get.Text ile String'e dönüstürürüz.
        }                                    // Eger String'e dönüstürmezsek hepsinin HashCode ile görürüz. Uzun olur.

        driver.close();
    }
}
