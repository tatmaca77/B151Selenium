package techproed.day05_XpathCssSelector;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Arrays;

public class C01_Xpath {

    /** Xpath : En fazla kullanilan Locate Yöntemi'dir.  2'ye ayrilir.

             1-)Absolut Xpath

             2-)Relative Xpath : bu cok kullanilir
     */

    /** Ama oncelikli olarak  "id" HTML Code'larinda varsa id kullanarak Locate edilir. */
    /** XPath ile bütün attributeler ile Locate edebiliriz. */

    /** XPath yazarken 3 temel bilesen kullanilir :
          1-) tag name
          2-) attribute
          3-) attribute value
     Bunlari kullanarak her bir webelement icin unique sonuc veren bir cok XPath yazilabilir.

                      //tagName[@attributeIsmi=‘attributeValue']
     Bu sekilde her zaman unique bir sonuc elde etmis oluruz. !!!!

     INTERVIEW Sorusu : Öncelikli olarak hangi Locate Yöntemini kullanirsiniz ?

                      Eger HTML kodlari icinde "id" attribute varsa id kullanirim. Unique oldugu icin "id" kullanilir.
                     Ancak genellikle XPath daha cok
                    tercih edilen bir yöntemdir. XPath ile id attribute berbaer kullanarak Locate edebiliriz.

     NOTE: Önemli bir diger husus ise; HTML kodlarini inceledigimizde bosta kalan bazi metin ifadeler görürüz.
          Bu durumda Locate islemini text() ile almaliyiz.    //span[text()='Mountainbikes'
     text() oldugunu elmas disinda kladiginda ve herhangi bir attribute atanmamis olanlaridir.

     */

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        // https://www.amazon.com sayfasına gidiniz
        driver.get("https://www.amazon.com");

        // arama kutusuna "city bike"  yazıp aratın
        //WebElement aramaKutusu = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        WebElement aramaKutusu = driver.findElement(By.xpath("//input[@placeholder='Suche Amazon']"));
        aramaKutusu.sendKeys("city bike" + Keys.ENTER);

        // Hybrid Bikes bölümüne tıklayın
        WebElement hybridBikes = driver.findElement(By.xpath("//span[text()='Mountainbikes']"));
        hybridBikes.click();
        /** NOT : Bazi HTML kodlarinda arada kalan bir metin olur. Bu durumda biz text() kullanarak Locate aliriz.*/

        // sonuc sayısını yazdırın
        WebElement sonucYazisi = driver.findElement(By.xpath("//span[text()='1-24 von 30 Ergebnissen oder Vorschlägen für']"));
        System.out.println(sonucYazisi.getText()); // Bu sekilde WebElement'i - String'e cevirmis oluruz.

        String sonucSayisi[] = sonucYazisi.getText().split(" "); // String'e cevirip split ile bosluktan indexledik.
        System.out.println(sonucSayisi[0]);// ilk index'Teki elemani aldik. split methodu bize Array döndürür. !!!!!

        // ilk ürününe tıklayın
        driver.findElement(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']")).click();

        //Sayfayı kapatınız
        driver.close();

    }

}
