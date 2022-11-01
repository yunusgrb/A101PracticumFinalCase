package Utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.time.Duration;
import java.util.List;
import java.util.Set;

public class ReusableMethods {



    public void getSwitchWindow()
    {
        String anaSayfaWinddowId= Driver.driver.getWindowHandle();
        Set<String> windowsIdler=Driver.driver.getWindowHandles();

        for(String id: windowsIdler) {
            if (id.equals(anaSayfaWinddowId))
                continue;
            Driver.driver.switchTo().window(id);
            System.out.println("Title = " + Driver.driver.getTitle());
        }

    }

    public void getSwitchAnaSayfa(){
        String anaSayfaWinddowId= Driver.anaSayfaWinddowId;
        Driver.driver.switchTo().window(anaSayfaWinddowId);

    }
    public void clickFunction(WebElement element)
    {
       WebDriverWait wait=new WebDriverWait(Driver.driver, Duration.ofSeconds(30));
       wait.until(ExpectedConditions.elementToBeClickable(element));
       element.click();

    }
    public void sendKeysFunctionWithEnter(WebElement element, String value)
    {
        WebDriverWait wait = new WebDriverWait(Driver.driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(element));
        element.clear();
        element.sendKeys(value+ Keys.ENTER);

    }

    public void clickFromList(List<WebElement> elements, int num)
    {
        WebDriverWait wait = new WebDriverWait(Driver.driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfAllElements(elements));
        elements.get(num).click();

    }


    public void scrollToElement(WebElement element)
    {
        JavascriptExecutor js = (JavascriptExecutor) Driver.driver;
        js.executeScript("arguments[0].scrollIntoView();", element);
    }

    public String noktalamaKaldirma(String str)
    {
        String newStr=str.replaceAll("[^0-9-]", "");
        newStr=newStr.replaceAll("[^0-9-]", "");

        return newStr;

    }

    public void hoverOverFunction(WebElement element)
    {
        Actions actions=new Actions(Driver.driver);
        actions.moveToElement(element).build().perform();
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
