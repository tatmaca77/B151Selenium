package techproed.day02_DriverMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class WindowMethods_Training {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        driver.get("https://amazon.com");
        Thread.sleep(2000);
        driver.manage().window().getPosition();
        Thread.sleep(2000);
        driver.manage().window().getSize();
        Thread.sleep(2000);
        driver.manage().window().minimize();
        Thread.sleep(3000);
        driver.manage().window().maximize();

        System.out.println("Sayfa'nin konumu :" + driver.manage().window().getPosition());
        System.out.println("Sayfa'nin boyutlari :" + driver.manage().window().getSize());
        Thread.sleep(2000);
        driver.manage().window().fullscreen();
        System.out.println("Sayfa'nin konumu :" + driver.manage().window().getPosition());
        System.out.println("Sayfa'nin boyutlari :" + driver.manage().window().getSize());

        driver.close();


    }

}
