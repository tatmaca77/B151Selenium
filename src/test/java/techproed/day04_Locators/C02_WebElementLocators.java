package techproed.day04_Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class C02_WebElementLocators {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        /**
        amazon sayfasina gidiniz.
        arama kutusuna " city bike" yazip aratin
        sonuc yazisini yazdirin
        sonuc sayisini yazdirin
        ilk ürün locateini alin
        ilk ürünün, görünür olup olmadigini true, false seklinde yazdirin
        ilk ürünün, erisilebilir olup olmadigini true, false seklinde yazdirin
        ilk ürünün secilebilir, olup olmadigini true, false seklinde yazdirin
        ilk ürüne tiklayin
        sayfayi kapatin
         */
        //amazon sayfasina gidiniz.
       driver.get("https://www.amazon.com");

       //locate alin
       /** WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox")); */
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("city bike" + Keys.ENTER);

       // arama kutusuna " city bike" yazip aratin
       /** aramaKutusu.sendKeys("city bike");
       aramaKutusu.submit(); */ // Bu alternativ'dir.

       //sonuc yazisini yazdirin
        /** List'lerde index sifirdan baslar.*/
        /**cok fazla sonuc yazisi var unique degil. Bu yüzden Locate alirken findElements() kullaniriz.
         Bu 120 tane sonuc yazisi icerir.
         Bu yüzden Bir List'e atariz. */
        List<WebElement> sonucYazilari = driver.findElements(By.className("sg-col-inner"));//sonuc yazisinin Locate'aldim.
        WebElement sonucYazisi = sonucYazilari.get(0); // Bu sekilde ilk sonuc yazisini almis oluruz.
        //System.out.println(sonucYazisi); // Bu sekilde WebElement direkt yazdirilirsa Hash Code'larda gelir.
        System.out.println(sonucYazisi.getText()); // String'e dönüstürüp yazdirmaliyiz. !!!!!

        //sonuc sayisini yazdirin
        /** String'e döndürdük. split() ile bosluklardan ayirdim. Array olarak hafizada tutar.*/
        String sonucSayisi [] = sonucYazisi.getText().split(" ");
        System.out.println(Arrays.toString(sonucSayisi)); // Array olarak index index ayirir.
        System.out.println(sonucSayisi[2]);// 2. index'teki istedigimiz veriyi yazdirir.

        // ilk ürün locateini alin
        List <WebElement> sonuclar = driver.findElements(By.className("s-image"));// 87 tane var List'e atadik.
        WebElement ilkUrun = sonuclar.get(0);

        // ilk ürünün, görünür olup olmadigini true, false seklinde yazdirin
        System.out.println(ilkUrun.isDisplayed()); // true --> ilk ürün görünür oldugu icin true döndürdü.

        //ilk ürünün, erisilebilir olup olmadigini true, false seklinde yazdirin
        System.out.println(ilkUrun.isEnabled());

        // ilk ürünün secilebilir, olup olmadigini true, false seklinde yazdirin
        System.out.println(ilkUrun.isSelected()); // false
        /** burda "false" gelir. secilebilir birsey form gibi kutucuklu olmalidir.
          "checkbox" veya "radio" butonlari gibi.
         */

        // ilk ürüne tiklayin
        ilkUrun.click();

        // sayfayi kapatin
        driver.close();


    }
}
