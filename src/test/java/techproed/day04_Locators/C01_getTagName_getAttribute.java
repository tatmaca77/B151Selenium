package techproed.day04_Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_getTagName_getAttribute {

    public static void main(String[] args) {
        /*
           "https://www.amazon.com" sayfasina gidiniz.
           arama kutusunu locate ediniz.
           arama kutusunun tagName'inin "input" oldugunu test ediniz.
           arama kutusunun name attribute'nun degerinin "field-keywords" oldugunu test ediniz.
           sayfasiyi kapatiniz.
         */
        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        // Site'ye git.
        driver.get("https://www.amazon.com");

        //arama kutusunu locate ediniz.
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));// "id" unique ve guvenlidir.

        // arama kutusunun tagName'inin "input" oldugunu test ediniz.
        String actualTagName = aramaKutusu.getTagName();
        String expectedTagName = "input";

        if (actualTagName.equals(expectedTagName)) {          // String ifadelerin esitliginin kontrolü "equals" ile olur.
            System.out.println("Test PASSED");
        }else {
            System.out.println("Test FAILED");            // Sag tikla incele yapip HTML CODE'larini inceleriz.
        }                                             // Xpath ile unique locate cok rahatlikla aliriz. Professional islem.

        //  arama kutusunun name attribute'nun degerinin "field-keywords" oldugunu test ediniz.
        String actualAtt = aramaKutusu.getAttribute("name");
        String expectedAtt = "field-keywords";

        if (actualAtt.equals(expectedAtt)) {
            System.out.println("Test PASSED");
        }else {
            System.out.println("Test FAILED");
        }

        driver.close();




    }

}
