package techproed.day05_XpathCssSelector;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_cssSelector {

    /**
     *   Css selector'de "id" attribute yerine "#" kullanilabilir.
     *   Css selector'de "class" attribute yerine "." kullanilabilir.

     CSS selector'de ; XPath'teki gibi text() ile Locate edilmez. !!!!

        CSS selector ; XPath'e benzer. 3 Ana tip killanilir:

     1-) css = tagName[attribute name= 'value’];
     driver.findElement(By.cssSelector("input[name='session[password]']"));

     2-)  css="tagName#idValue" veya sadece css="#idValue" =>yalnızca id value ile çalışır
     driver.findElement(By.cssSelector("input#session_password"));

     3-)  css="tagName.classValue" veya sadece css=".classValue"=>yalnızca class value ile
     çalışır
     driver.findElement(By.cssSelector(".form-control"));

     */

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        //https://the-internet.herokuapp.com/add_remove_elements/ adresine gidin
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");

        Thread.sleep(2000);

        //Add Element butonuna basin
        WebElement addElement = driver.findElement(By.cssSelector("button[onclick='addElement()']"));
        addElement.click();
        //WebElement addElement = driver.findElement(By.cssSelector("button[onclick='addElement()']")).click();

        Thread.sleep(2000);

        //Delete butonu’nun gorunur oldugunu test edin
        WebElement deleteButonu = driver.findElement(By.cssSelector("button[onclick='deleteElement()']"));

        if(deleteButonu.isDisplayed()){
            System.out.println("Delete Butonu Görünür");
        }else{
            System.out.println("Delete Butonu Görünür Degil");
        }

        Thread.sleep(2000);

        //Delete butonuna basin
        deleteButonu.click();

        Thread.sleep(2000);

        //“Add/Remove Elements” yazisinin gorunur oldugunu test edin
        WebElement addRemoveElement = driver.findElement(By.cssSelector("h3"));

        if(addRemoveElement.isDisplayed()){
            System.out.println("Add/Remove Element Yazisi Görünür");
        }else{
            System.out.println("Add/Remove Element Yazisi Görünür Degil");
        }

        Thread.sleep(2000);

        //Sayfayı kapatın
        driver.close();

        /**

        Xpath ile cssSelector arasındaki farklar:

        - Xpath text ile calısır. !!!!!
        - cssSelector text ile calısmaz !!!!!!
        - Xpath index'e göre arama yapabilir.Daha fazla kombinasyona sahiptir.
        - cssSelector index'e göre arama yapamaz. Daha hızlı calısır

         */

    }



}
