package day06_radioButton_checkBox;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chromium.ChromiumDriver;

import java.time.Duration;

public class C04_Assertions {
    WebDriver driver;

    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown(){
        driver.close();
    }

    @Test
    public void test01(){
        // eger test methodunda hicbir test yoksa ,test calistikdan sonra
        // hicbir problemle karsilasmadigini raporlamak icin "tests passed" yazisi cikar
        /*
        Eger testleri if ile yaparsak test failed olsa bile
        kodlar problemsiz calistigi icin kod calismasi bittiginde
        ekranin sol alt kisiminda test passed yazacaktir
         */

        driver.get("https://www.amazon.com");
     /*
        // url'in https://www.facebook.com oldugunu kontrol edin.
        if (driver.getCurrentUrl().equals("https://www.facebook.com")){
            System.out.println("Url testi PASSED");
        }else {
            System.out.println("Url testi FAILED");
        }
     */
       String expectedUrl="https://www.facebook.com";
       String actualUrl=driver.getCurrentUrl();

        Assert.assertEquals("Url beklenenden farkli",expectedUrl,actualUrl);
      /*
       Assert ile yaptigimiz testlerde assertion failed olursa
       java kodlarin calismasini durdurur ve assert class'i bizi hata konusunda  bilgilendiri

            org.junit.ComparisonFailure: Url beklenenden farkli
           Expected :https://www.facebook.com
           Actual   :https://www.amazon.com/
          <Click to see difference>
       Boylece hatanin nerede oldugunu arastirmamiza gerek  kalmadan
       JUnit bize rapor verir
       */

    }
}
