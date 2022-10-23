package Utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.time.Duration;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Driver {


    public static WebDriver driver;


    @Parameters("browser")
    @BeforeClass
    public void BaslangicIslemleri(String browser) {
        System.out.println("Driver start ....");
        Logger logger = Logger.getLogger("");
        logger.setLevel(Level.SEVERE);


        switch (browser){
        case "chrome":
            ChromeOptions opt = new ChromeOptions();
            opt.addArguments("--disable-extensions");
            opt.addArguments("--profile-directory=Default");
            opt.addArguments("--incognito");
            opt.addArguments("--disable-plugins-discovery");
            opt.addArguments("--start-maximized");
            opt.addArguments("--ignore-certificate-errors");
            opt.addArguments("--allow-insecure-localhost");
            opt.addArguments("--acceptInsecureCerts");
            opt.addArguments("--disable-blink-features=AutomationControlled");

            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver(opt);
            break;

        case "firefox":
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
            break;

        case "edge":
            WebDriverManager.edgedriver().setup();
            driver=new EdgeDriver();
            break;
    }


        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));

        driver.get("https://www.hepsiburada.com/");


    }

    @AfterClass
    public void BitisIslemleri() {
        System.out.println("Driver stop ....");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
       // driver.quit();
    }

}
