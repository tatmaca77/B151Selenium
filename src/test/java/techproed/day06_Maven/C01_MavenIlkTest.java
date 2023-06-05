package techproed.day06_Maven;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C01_MavenIlkTest {

    public static void main(String[] args) {


        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //https://www.amazon.com/ sayfasina gidelim
        driver.get("https://amazon.com");

        //arama kutusunu locate edelim
        WebElement aramaKutusu = driver.findElement(By.cssSelector("input#twotabsearchtextbox"));

        //“Samsung headphones” ile arama yapalim
        aramaKutusu.sendKeys("Samsung headphones", Keys.ENTER);

        //Bulunan sonuc sayisini yazdiralim
        WebElement sonucYazisi = driver.findElement(By.xpath("(//*[@class='sg-col-inner'])[1]"));
        //1-16 of 201 results for "Samsung headphones"
        String [] sonucSayisi = sonucYazisi.getText().split(" ");
        System.out.println("Sonuc Sayisi = "+sonucSayisi[2]);

        //Ilk urunu tiklayalim
        driver.findElement(By.xpath("(//h2//a)[1]")).click();

        //Sayfadaki tum basliklari yazdiralim
        List<WebElement> sayfaBasliklari = driver.findElements(By.xpath("//h1 | //h2"));
        sayfaBasliklari.forEach(t-> System.out.println(t.getText()));

        //sayfayı kapatınız
        driver.close();

    }

}
