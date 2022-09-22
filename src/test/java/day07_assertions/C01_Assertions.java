package day07_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_Assertions {
    /*
    amazon ana sayfaya gidin
    3 farkli metodu olusturarak asagidaki gorevleri yapin
    1-Url'in amazon icerdigini test edin
    2-title'in facebook icermedigini test edin
    3-sol ust kosede amazon logosunun gorundugunu test edin

     */
     static WebDriver driver;
    @BeforeClass
    public static void setup(){

        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @AfterClass
    public static void tearDown(){
        driver.close();
    }

    @Test
    public void test01(){

        driver.get("https://www.amazon.com");
        //1-Url'in amazon icerdigini test edin
        String aranankelime="amazon";
        String actualUrl= driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(aranankelime));
    }
    @Test
    public void test02(){
       // 2-title'in facebook icermedigini test edin
       String istenmeyenkelime="facebook";
       String actualTitle=driver.getTitle();
       Assert.assertFalse(actualTitle.contains(istenmeyenkelime));
    }

    @Test
    public void test03(){
       // 3-sol ust kosede amazon logosunun gorundugunu test edin
        WebElement logoElementi = driver.findElement(By.id("nav-logo-sprites"));

        Assert.assertTrue(logoElementi.isDisplayed());
    }
}
