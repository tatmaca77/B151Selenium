package techproed.day01_IlkTest_DriverMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_IlkTest {

    public static void main(String[] args) {

        // Java uygulamalarinda system özelliklerini ayarlamak icin setProperty() methodu ile kullaniriz.
        // setProperty() methodu ile class'imiza driver'in fiziki yolunu belirtiriz.
        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver.exe");

        // getProperty() ile "Key" degerini girerek "value"'ya ulasabilirim.
        System.out.println(System.getProperty("webdriver.chrome.driver"));

        //ChromeDriver türünde bir "Object" olusturduk.
        WebDriver driver = new ChromeDriver();

        // get() methodu ile String olarak girilen URL'e gideriz.
        driver.get("https://techproeducation.com");

    }
}
