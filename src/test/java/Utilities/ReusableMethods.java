package Utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

public class ReusableMethods {



    public void getSwitchWindow(){

        String anaSayfaWinddowId= Driver.driver.getWindowHandle();
        Set<String> windowsIdler=Driver.driver.getWindowHandles();

        for(String id: windowsIdler) {
            if (id.equals(anaSayfaWinddowId))
                continue;
            Driver.driver.switchTo().window(id);
            System.out.println("Title = " + Driver.driver.getTitle());
        }


    }
    public void clickFunction(WebElement element){

       WebDriverWait wait=new WebDriverWait(Driver.driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        scrollToElement(element);
        element.click();

    }
    public void sendKeysFunction(WebElement element, String value) {
        WebDriverWait wait = new WebDriverWait(Driver.driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(element));
        scrollToElement(element);
        element.clear();
        element.sendKeys(value+ Keys.ENTER);

    }

    public void scrollToElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) Driver.driver;
        js.executeScript("arguments[0].scrollIntoView();", element);
    }

    public void Bekle(int saniye)
    {

        try {
            Thread.sleep(saniye*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

}
