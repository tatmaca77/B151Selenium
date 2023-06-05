package techproed.day03_Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class LoginTest {

    public static void main(String[] args) {

        /**
        1.Bir class oluşturun: LoginTest
        2. Main method oluşturun ve aşağıdaki görevi tamamlayın.
           a. https://www.heroku.com/home adresine gidiniz.
           b. Log in butonuna basin
           c. email textbox,password textbox, and signin button elementlerini locate ediniz..
           d. Kullanıcı adını ve şifreyi aşağıya girin ve oturum aç (sign in)buttonunu tıklayın:
           i. Username : testtechproed@gmail.com
           ii. Password : Test1234!
           e. Expected user id nin testtechproed@gmail.com oldugunu dogrulayin(verify).
           f. “Addresses” ve “Sign Out” textlerinin görüntülendiğini( displayed)
               doğrulayin(verify).
         3. Sayfada kac tane link oldugunu bulun.
         */

        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        /** a. https://www.heroku.com/home adresine gidiniz. */
        driver.get("https://www.heroku.com/home");

        WebElement akzeptieren = driver.findElement(By.xpath("//button[text()='Alle Cookie akzeptieren']"));
        akzeptieren.click();

        /**  b. Log in butonuna basin */
        WebElement logIn = driver.findElement(By.xpath("//a[text()='Log in']"));
        logIn.click();

        /** c. email textbox,password textbox, and signin button elementlerini locate ediniz.. */
        WebElement email = driver.findElement(By.xpath("//input[@placeholder='Email address']"));
        WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
        WebElement button = driver.findElement(By.xpath("//button[text()='Log In']"));

        /** d. Kullanıcı adını ve şifreyi aşağıya girin ve oturum aç (sign in)buttonunu tıklayın:
         i. Username : testtechproed@gmail.com
         ii. Password : Test1234! */
        email.sendKeys("testtechproed@gmail.com");
        password.sendKeys("Test1234!");
        button.click();

        /** e. Expected user id nin testtechproed@gmail.com oldugunu dogrulayin(verify). */
        /*String expectedUserId = "testtechproed@gmail.com";
        WebElement userIdElement = driver.findElement(By.className("//input[@placeholder='Email address']"));
        String actualUserId = userIdElement.getText();
        if (actualUserId.equals(expectedUserId)) {
            System.out.println("Expected user id doğrulandı.");
        } else {
            System.out.println("Expected user id doğrulanamadı.");
        }*/

        /** f. “HerOku” textlerinin görüntülendiğini( displayed) doğrulayin(verify). */
        WebElement herOku = driver.findElement(By.xpath("//a[text()='Heroku']"));

        if (herOku.isDisplayed()){
            System.out.println("HerOku is displayed");
        } else {
            System.out.println("HerOku is not displayed");
        }

        /** 3. Sayfada kac tane link oldugunu bulun. */
        String linkCount = String.valueOf(driver.findElement(By.tagName("a")).getSize());
        System.out.println("Sayfada bulunan link sayisi : " + linkCount);

        driver.close();







    }
}
