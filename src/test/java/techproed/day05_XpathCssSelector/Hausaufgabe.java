package techproed.day05_XpathCssSelector;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Hausaufgabe {

    /**
     * ÖDEV
     * // http://the-internet.herokuapp.com/add_remove_elements/ adresine gidiniz
     * // Add Element butonuna 100 defa basınız
     * // 100 defa basıldığını test ediniz
     * // 90 defa delete butonuna basınız
     * // 90 defa basıldığını doğrulayınız
     * // Sayfayı kapatınız
     */

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        driver.get("http://the-internet.herokuapp.com/add_remove_elements/");

        for (int i = 0; i < 100; i++) {
            WebElement addButton = driver.findElement(By.cssSelector("button[onclick='addElement()']"));
            addButton.click();
            }

        int addedElementsCount = driver.findElements(By.xpath("//button[contains(text(), 'Delete')]")).size();
        if (addedElementsCount == 100) {
            System.out.println("Add Element butonuna 100 defa basıldı.");
        } else {
            System.out.println("Add Element butonuna 100 defa basılmadi.");
        }

        for (int i = 0; i < 90 ; i++) {
            WebElement deleteButton = driver.findElement(By.cssSelector("button[onclick='deleteElement()']"));
            deleteButton.click();
        }

        int deletedElementsCount = driver.findElements(By.xpath("//button[contains(text(), 'Delete')]")).size();
        if (deletedElementsCount == 10) {
            System.out.println("Delete butonuna 90 defa basildi.");
        } else {
            System.out.println("Delete butonuna 90 defa basilmadi.");
        }

        driver.quit();






    }


}



