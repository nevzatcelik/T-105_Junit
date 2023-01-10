package day04;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class ActionsMethods {
    WebDriver driver;
    // driverimiz ile ilgili kurulumlari baslatalim
    // https://www.booking.com/ sayfasina gidelim
    // para birimi olarak TL secelim
    // ulke olarak Turkiye yi secelim
    // sayfanin en altindan ulkeler kismini secelim
    // ulkeler sayfasindan turkiye yi secelim
    // turkiye sayfasinin secildigini test edin
    String https="https://www.";

    @Before
    public void setUp(){
        // driverimiz ile ilgili kurulumlari baslatalim
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown(){
        // driver.close();
    }

    @Test
    public void bookingTest() throws InterruptedException {
        // https://www.booking.com/ sayfasina gidelim
        driver.get(https+"booking.com/");
        driver.findElement(By.xpath("//*[text()='Accept']")).click();
        // para birimi olarak TL secelim
        Actions booking=new Actions(driver);
        WebElement paraBirimi= driver.findElement(By.xpath("(//button[@class='bui-button bui-button--light bui-button--large'])[1]"));
        booking.moveToElement(paraBirimi).click(paraBirimi).perform();
        booking.sendKeys(Keys.ARROW_UP).
                sendKeys(Keys.ARROW_UP).perform();
        Thread.sleep(1500);
        WebElement turkishLira= driver.findElement(By.xpath("(//a[@class='bui-list-item bui-list-item--size-small '])[52]"));
        booking.moveToElement(turkishLira).click(turkishLira).perform();
        // ulke olarak Turkiye yi secelim
        WebElement language= driver.findElement(By.xpath("(//button[@class='bui-button bui-button--light bui-button--large'])[2]"));
        booking.moveToElement(language).click(language).perform();
        WebElement turkishLanguge= driver.findElement(By.xpath("//div[@lang='tr']"));
        booking.moveToElement(turkishLanguge).click(turkishLanguge).perform();
        // sayfanin en altindan ulkeler kismini secelim
        booking.sendKeys(Keys.END).perform();
        Thread.sleep(1000);
        WebElement ulkeler= driver.findElement(By.xpath("(//a[@data-ga='seoindexlinks'])[1]"));
        ulkeler.click();
        WebElement turkiye= driver.findElement(By.xpath("//*[@id=\"countryTmpl\"]/div[43]/div[1]/h2/a"));
        booking.scrollToElement(turkiye).click(turkiye).perform();

     }
}
