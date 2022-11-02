package Utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.ExtentSparkReporterConfig;
import com.aventstack.extentreports.service.ExtentService;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.extension.ExtendWith;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import javax.crypto.KeyAgreement;
import java.time.Duration;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;



public class Driver {


public static WebDriver driver;
public static String anaSayfaWinddowId="";

    @Parameters("browser")
    @BeforeClass
    public void BaslangicIslemleri(String browser) {
        System.out.println("Driver start ....");

        Locale.setDefault(new Locale("EN"));
        System.setProperty("user.language", "EN");

        System.setProperty(org.slf4j.impl.SimpleLogger.DEFAULT_LOG_LEVEL_KEY, "Error");


        switch (browser){
        case "chrome":
            ChromeOptions optCh = new ChromeOptions();
            optCh.addArguments("--disable-extensions");
            optCh.addArguments("--profile-directory=Default");
            optCh.addArguments("--incognito");
            optCh.addArguments("--disable-plugins-discovery");
            optCh.addArguments("--start-maximized");
            optCh.addArguments("--ignore-certificate-errors");
            optCh.addArguments("--allow-insecure-localhost");
            optCh.addArguments("--acceptInsecureCerts");
            optCh.addArguments("--disable-blink-features=AutomationControlled");

            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver(optCh);
            break;

        case "firefox":
            WebDriverManager.firefoxdriver().setup();
            FirefoxOptions optFF=new FirefoxOptions();
            optFF.addArguments("--disable-extensions");
            optFF.addArguments("--profile-directory=Default");
            optFF.addArguments("--incognito");
            optFF.addArguments("--disable-plugins-discovery");
            optFF.addArguments("--start-maximized");
            optFF.addArguments("--ignore-certificate-errors");
            optFF.addArguments("--allow-insecure-localhost");
            optFF.addArguments("--acceptInsecureCerts");
            optFF.addArguments("--disable-blink-features=AutomationControlled");

            driver = new FirefoxDriver(optFF);
            break;

        case "edge":
            WebDriverManager.edgedriver().setup();
            EdgeOptions optEd = new EdgeOptions();
            optEd.addArguments("--disable-extensions");
            optEd.addArguments("--profile-directory=Default");
            optEd.addArguments("--incognito");
            optEd.addArguments("--disable-plugins-discovery");
            optEd.addArguments("--start-maximized");
            optEd.addArguments("--ignore-certificate-errors");
            optEd.addArguments("--allow-insecure-localhost");
            optEd.addArguments("--acceptInsecureCerts");
            optEd.addArguments("--disable-blink-features=AutomationControlled");

            driver=new EdgeDriver(optEd);
            break;
    }

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));

        driver.get("https://www.hepsiburada.com/");

        anaSayfaWinddowId= driver.getWindowHandle();
    }

    @AfterClass
    public void BitisIslemleri() {
        System.out.println("Driver stop ....");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        ExtentService.getInstance().setSystemInfo("User Name", "Yunus Gurbuz");
        ExtentService.getInstance().setSystemInfo("Application Name", "A101 Web");
        ExtentService.getInstance().setSystemInfo("Operating System Info", System.getProperty("os.name").toString());
        ExtentService.getInstance().setSystemInfo("Department", "QA");

        driver.quit();
    }

}
