package Tests;

import Pages.FinalCasePage;
import Utilities.Driver;
import Utilities.ReusableMethods;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;

public class FinalCaseTest extends Driver  {

    @Parameters("arananKelime")
    @Test
    public void Test1(String arananKelime) throws InterruptedException {

        FinalCasePage fc=new FinalCasePage();
        Actions actions=new Actions(Driver.driver);
        ReusableMethods rm=new ReusableMethods();
        WebDriverWait wait=new WebDriverWait(Driver.driver, Duration.ofSeconds(30));

        rm.clickFunction(fc.cerezKabulEt);
        actions.moveToElement(fc.girisYap).build().perform();
        actions.moveToElement(fc.girisYapButton).build();
        rm.clickFunction(fc.girisYapButton);
        rm.sendKeysFunction(fc.emailGiris,"yunus.grb130@gmail.com");
        rm.sendKeysFunction(fc.sifreYaz,"Dryyns1.");

        // rm.clickFunction(fc.sifreGirisYap);
       // rm.Bekle(5);
        wait.until(ExpectedConditions.visibilityOf(fc.hesabim));
        String hesapGiris=fc.hesabim.getText();
        Assert.assertEquals("Hesabım",hesapGiris);

        rm.sendKeysFunction(fc.searchInput,arananKelime);
        rm.clickFunction(fc.urunSec);
        rm.getSwitchWindow();

        String secilenUrun1= fc.saticiAdi1.getText()+fc.urun1Fiyati.getText()+",00 TL";
        String secilenUrun2= fc.saticiAdi2.getText()+fc.urun2fiyati.getText();

        System.out.println("secilenUrun2+\"    \"+ secilenUrun1 = " + secilenUrun2+"    "+ secilenUrun1);

        rm.clickFunction(fc.sepeteEkle);
        rm.clickFunction(fc.xKapat);
        rm.clickFunction(fc.sepeteEkle2);
        rm.clickFunction(fc.sepeteGit);
        rm.Bekle(5);

        String sepetUrun1=fc.sepetSatici1.getText()+fc.sepetUrun1Fiyati.getText();
        String sepetUrun2=fc.sepetSatici2.getText()+fc.sepetUrun2Fiyati.getText();
        System.out.println("sepetUrun1 = " + sepetUrun1);
        System.out.println("sepetUrun2 = " + sepetUrun2);

        Assert.assertTrue(secilenUrun1.toLowerCase().equals(sepetUrun1.toLowerCase()));
        Assert.assertTrue(secilenUrun2.equalsIgnoreCase(sepetUrun2));



    }
    @Parameters("arananKelime")
    @Test
    public void Test2WithoutLogin(String arananKelime){
        FinalCasePage fc=new FinalCasePage();
        ReusableMethods rm=new ReusableMethods();

        fc.cerezKabulEt.click();
        fc.searchInput.sendKeys(arananKelime+ Keys.ENTER);
       // rm.Bekle(3)
        // fc.urunSec.click();
        rm.clickFunction(fc.urunSec);
        rm.getSwitchWindow();

        String secilenUrun1= fc.saticiAdi1.getText()+fc.urun1Fiyati.getText()+",00 TL";
        String secilenUrun2= fc.saticiAdi2.getText()+fc.urun2fiyati.getText();


        //fc.sepeteEkle.click();
        rm.clickFunction(fc.sepeteEkle);
       // rm.Bekle(5);
        //fc.xKapat.click();
        rm.clickFunction(fc.xKapat);
        rm.clickFunction(fc.sepeteEkle2);
        //rm.clickFunction(fc.xKapat);
        //rm.Bekle(5);
        rm.clickFunction(fc.sepeteGit);
        rm.Bekle(5);

        String sepetUrun1=fc.sepetSatici1.getText()+fc.sepetUrun1Fiyati.getText();
        String sepetUrun2=fc.sepetSatici2.getText()+fc.sepetUrun2Fiyati.getText();
        System.out.println("sepetUrun1 = " + sepetUrun1);
        System.out.println("sepetUrun2 = " + sepetUrun2);

        Assert.assertTrue(secilenUrun1.toLowerCase().equals(sepetUrun1.toLowerCase()));
        Assert.assertTrue(secilenUrun2.equalsIgnoreCase(sepetUrun2));






    }
}
