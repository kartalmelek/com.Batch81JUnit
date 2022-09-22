package day08_alerts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_Alerts {

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
       /*
         herhangi bir web sitesine gidince veya bir web sitesinden
         herhangi bir islem yaptigimizda ortaya cikan uyarilara alert diyoruz

        eger bir alert inspect yapilabilyorsa, o alert otomasyon ile kullanilabilir,
        bu tur alertlere HTMLalert denir ve bunlar icin ekstra bir islem yapmaya gerek yoktur
        tum webelementler gibi locate edip istedigimiz islemleri yapabilriz
        driver.get("https://www.facebook.com");

        Ancak web uygulamarinda HTML alert yaninda java script alert de bulunabilir
        java script alertler locate edilemez
        seleniumda  JS alertler icin ozel bir yontem gelistirmistir.
    */
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.findElement(By.xpath("//*[text()='Click for JS Alert']")).click();

        //alert'te Ok tusuna basin
        driver.switchTo().alert().accept();

      // result kisminda "you successflly clicked an alert" yazisini test edin
        String expectedResult ="you successflly clicked an alert";
        WebElement sonucYaziElementi= driver.findElement(By.xpath("//p[@id='result']"));
        String actualResultYazisi =sonucYaziElementi.getText();

        Assert.assertEquals(expectedResult,actualResultYazisi);


    }
}
