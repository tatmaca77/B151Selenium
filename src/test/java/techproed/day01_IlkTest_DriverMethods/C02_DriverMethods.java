package techproed.day01_IlkTest_DriverMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C02_DriverMethods {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        /** getTitle() methodu = Sayfa Basligini verir. */
        driver.get("https://amazon.com");// Url'ye gideriz.
        System.out.println("Amazon Actual Title : " + driver.getTitle());
        System.out.println("Amazon Actual Url : " + driver.getCurrentUrl());
        String amazonWindowHandle = driver.getWindowHandle();
        System.out.println("Amazon Window Handle Degeri : " + amazonWindowHandle);

        driver.get("http://techproeducation.com");
        System.out.println("Techproed Actual Title : " + driver.getTitle());//getTitle() ile Sayfa Basligini verir.

        /** getCurrentUrl () methodu = Gidilen sayfanin Url'ini verir */
        System.out.println("Techproed Actual Url : " + driver.getCurrentUrl());

        /** getPageSource () methodu = Acilan sayfanin kaynak kodlarini verir */
        //System.out.println(driver.getPageSource());
        // Bu kod'u yoruma aliyoruz, cünkü her calistirdigimizda bir sürü kaynak kodlarini vermesin diye. !!!!!
        // Bu cok fazla kullanilan bir method degildir. Daha cok if-else yapisi ile contains () kullaniriz.
        // Iste su kelime kaynak kodlari bu kelimeyi iceriyor mu diye kontrol edebiliriz. !!!!!!!

        /** getWindowHandle () methodu = Gidilen sayfanin handle degerini(hashcode) verir.
             Bu handle degerini sayfalar arasi gecis icin kullaniriz. Yeni sekmede; Sekmeler arasi gecisi saglar. */
        System.out.println("Techproed Window Handle Degeri : " + driver.getWindowHandle());

    }
}
