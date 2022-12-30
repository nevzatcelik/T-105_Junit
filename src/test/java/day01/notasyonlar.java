package day01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.units.qual.C;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class notasyonlar {
    WebDriver driver;
    String https="https://www.";

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown(){
     driver.quit();
    }

    @Test
    public void test01() throws InterruptedException {
        driver.get(https+"amazon.com");
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        driver.navigate().to(https+"google.com");
        Thread.sleep(2000);
        driver.navigate().back();
        System.out.println(driver.getWindowHandle());
        Thread.sleep(2000);
        driver.navigate().forward();
        System.out.println(driver.getWindowHandle());
        Thread.sleep(1000);
        driver.navigate().refresh();


    }

    @Test
    public void test02() throws InterruptedException {
        driver.get(https+"google.com");
        String ilksayfaHandleDegeri=driver.getWindowHandle();
        System.out.println(driver.getWindowHandle());
        driver.switchTo().newWindow(WindowType.TAB);
        Thread.sleep(2000);
        driver.get(https+"amazon.com");
      //  driver.navigate().to(https+"amazon.com");
        Thread.sleep(2000);
        System.out.println(driver.getWindowHandles());
        driver.switchTo().window(ilksayfaHandleDegeri);
        Thread.sleep(2000);
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get(https+"wisequarter.com");

    }
}
