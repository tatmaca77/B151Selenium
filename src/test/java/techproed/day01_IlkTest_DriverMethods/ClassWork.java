package techproed.day01_IlkTest_DriverMethods;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class ClassWork {

    public static void main(String[] args) throws InterruptedException {

        /**
        1.Yeni bir Class olusturalim.C07_ManageWindowSet
        2. Amazon soyfasina gidelim. https://www.amazon.com/
        3. Sayfanin konumunu ve boyutlarini yazdirin
        4. Sayfanin konumunu ve boyutunu istediginiz sekilde
           ayarlayin
        5. Sayfanin sizin istediginiz konum ve boyuta geldigini test
          edin
        8. Sayfayi kapatin
         */

        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        driver.get("https://www.amazon.com/");

        System.out.println("Location : " + driver.manage().window().getPosition());
        System.out.println("Size : " + driver.manage().window().getSize());

        /** 4. Sayfanin konumunu ve boyutunu istediginiz sekilde ayarlayin */
        Point location = new Point(100,100);
        Dimension neuSize = new Dimension(800,600);
        driver.manage().window().setPosition(location);
        driver.manage().window().setSize(neuSize);

        Thread.sleep(3000);

        /** 5. Sayfanin sizin istediginiz konum ve boyuta geldigini test edin. */
        if (driver.manage().window().getSize().equals(neuSize) &&
            driver.manage().window().getPosition().equals(location)) {
            System.out.println("Test PASSED");
        } else {
            System.out.println("Test FAILED");
        }

        driver.close();

    }
}
