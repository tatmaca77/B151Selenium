package techproed.day05_XpathCssSelector;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class C04_relativeLocators {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //amazona gidelim
        driver.get("https://amazon.com");

        //city bike aratalım
        WebElement aramaKutusu = driver.findElement(By.xpath("//*[@type='text']"));
        aramaKutusu.sendKeys("city bike", Keys.ENTER);

        //relative locator kullanarak rennräader altındaki elemente tıklayalım
        //Webelementlerin yazısını konsola yazdıralım
        WebElement rennräder = driver.findElement(By.xpath("(//*[@class='a-size-base a-color-base'])[6]")); // index vererekte istedigimizi alabiliriz. !!!!
        System.out.println(rennräder.getText());
        WebElement crossräder = driver.findElement(with(By.tagName("a")).below(rennräder));
        System.out.println(crossräder.getText()); // altindaki'nin altindakini tiklattik.
        WebElement elektrofahräder = driver.findElement(with(By.tagName("a")).below(crossräder));
        System.out.println(elektrofahräder.getText());
        System.out.println("*******************************************************************");
        /** Yani aslinda bike kismindaki butun elemanlari tek tek yazdirdik ve tikladik.
            Bunu "relative locator" ile yapariz. Yani bir tanesinin locate alip below above gibi seyler kullaniriz.
         */

        //Bikes altındaki tüm linkleri(webelement) konsola yazdıralım
        List<WebElement> linlkerListesi = driver.findElements(By.xpath("(//*[@class='a-size-base a-color-base'])[position()>=6 and position()<=12]"));

        /** Bu asama XPath icin güzel bir locate alma yöntemidir. Cok fazla webelement icinden istediklerimizi almis oluruz.
                      (//*[@class='a-size-base a-color-base'])[position()>=7 and position()<=13]
         Burda istedigimiz webelement'i buluruz, sonrasinda kac tanesini yazdirmak istiyorsak ona gore position aliriz.
         Bu sekilde 7 tane webelementi bize vermis olur.

         Coklu data verecegi icinde onlari bir List icine atadik.
            */

        /**
            XPATH kullanımında bir sayfadaki webelementlere müdehale etmek istediğimizde xpath ile locate aldığımızda birden fazla sonuc
        verebilir. [position()>=10 and position()<=16] bu kullanımla aralık belirterek isteğimiz WE leri seçip müdehale edebiliriz.
         */

        //lambda ile yazdırdık !!!!!
        linlkerListesi.forEach(t-> System.out.println(t.getText()));
        System.out.println("********************************************************************");

        //foreach ile yazdırdık  !!!!!!
        for (WebElement w:linlkerListesi) {
            System.out.println(w.getText());
        }

        //Bu linklerin hepsini tıklayalım ve sayfa başlıklarını alalım
        for (int i = 0; i < linlkerListesi.size(); i++) {
            linlkerListesi = driver.findElements(By.xpath("(//*[@class='a-list-item'])[position()>6 and position()<=13]"));
            System.out.println(linlkerListesi.get(i).getText());
            linlkerListesi.get(i).click();
            Thread.sleep(3000);
            driver.navigate().back();
            Thread.sleep(3000);
        }


        //completeBike.click();
        driver.quit();

    }


}
