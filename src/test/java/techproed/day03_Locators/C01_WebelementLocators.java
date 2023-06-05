package techproed.day03_Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_WebelementLocators {

    public static void main(String[] args) throws InterruptedException {

        /** Bu islemler her yapacagimiz islem öncesinde yapmamiz gereknlerdir. */
        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        /**Soru 1 :
        // https://www.amazon.com sayfasına gidiniz
        // aramakutusunu locate ediniz ve Nutella aratınız
        // sayfayı kapatınız.
         */
        driver.get("https://www.amazon.com"); // Url'ye gideriz.

        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));// id ile Locate yaptik.
        aramaKutusu.sendKeys("Nutella" + Keys.ENTER);// Nutella yazdik ve arattik.

        /** WebElemet'e assign etmeden de islemi yapabiliriz.
            Ama eger biz bunu tekrar tekrar kullancaksak assign etmek daha mantiklidir. */
        //driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Nutella" + Keys.ENTER);

        /*
           Eger bir "webelement"i birden fazla kez kullanmayacaksaniz bir "WebElement"e assign etmeyebilirsiniz.
         */

        Thread.sleep(2000);// Burda 2 saniye beklettik.

        driver.close();// Sayfayi kapatiriz.


       /*
       //farklı yol 2 :
//WebElement aramaTiklama = driver.findElement(By.id("nav-search-submit-button"));
//aramaTiklama.click();
        */





    }
}
