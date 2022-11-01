package Tests;

import Pages.FinalCasePage;
import Utilities.Driver;
import Utilities.ReusableMethods;
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
    public void Test1(String str)
    {
        FinalCasePage fc=new FinalCasePage();
        ReusableMethods rm=new ReusableMethods();
        WebDriverWait wait=new WebDriverWait(Driver.driver, Duration.ofSeconds(30));

        rm.clickFunction(fc.cerezKabulEt);
        rm.hoverOverFunction(fc.girisYap);
        rm.hoverOverFunction(fc.girisYapButton);
        rm.clickFunction(fc.girisYapButton);
        rm.sendKeysFunctionWithEnter(fc.emailGiris,"yunus.grb130@gmail.com");

        rm.sendKeysFunctionWithEnter(fc.sifreYaz,"Sampiyon1.");

        wait.until(ExpectedConditions.visibilityOf(fc.hesabim));
        String hesapGiris=fc.hesabim.getText();
        Assert.assertEquals("Hesabım",hesapGiris);

        rm.sendKeysFunctionWithEnter(fc.searchInput,str);
        rm.clickFromList(fc.urunList,0);
        rm.getSwitchWindow();

        String secilenUrun1= fc.saticiAdi1.getText()+" "+rm.noktalamaKaldirma(fc.urunFiyati.getAttribute("content"));
        System.out.println("secilenUrun1 = " + secilenUrun1);

        rm.clickFunction(fc.sepeteEkle);
        rm.clickFunction(fc.xKapat);

        rm.getSwitchAnaSayfa();
        rm.clickFromList(fc.urunList,1);

        rm.getSwitchWindow();
        String secilenUrun2= fc.saticiAdi1.getText()+" "+rm.noktalamaKaldirma(fc.urunFiyati.getAttribute("content"));

        System.out.println("secilenUrun2 = " + secilenUrun2);
        rm.clickFunction(fc.sepeteEkle);
        rm.clickFunction(fc.sepeteGit);

        String sepetUrun1=wait.until(ExpectedConditions.visibilityOf(fc.sepetSatici1)).getText()+" "+rm.noktalamaKaldirma(fc.sepetUrun1Fiyati.getText());
        String sepetUrun2=wait.until(ExpectedConditions.visibilityOf(fc.sepetSatici2)).getText()+" "+rm.noktalamaKaldirma(fc.sepetUrun2Fiyati.getText());
        System.out.println("sepetUrun1 = " + sepetUrun1);
        System.out.println("sepetUrun2 = " + sepetUrun2);

        Assert.assertEquals(sepetUrun1.toLowerCase(), secilenUrun1.toLowerCase());
        Assert.assertEquals(sepetUrun2.toLowerCase(), secilenUrun2.toLowerCase());


    }

    @Parameters("arananKelime")
    @Test
    public void Test2WithoutLogin(String arananKelime)
    {
        FinalCasePage fc=new FinalCasePage();
        ReusableMethods rm=new ReusableMethods();
        WebDriverWait wait=new WebDriverWait(Driver.driver, Duration.ofSeconds(30));

        fc.cerezKabulEt.click();
        rm.sendKeysFunctionWithEnter(fc.searchInput,arananKelime);
        rm.clickFromList(fc.urunList,0);
        rm.getSwitchWindow();

        String secilenUrun1= fc.saticiAdi1.getText()+rm.noktalamaKaldirma(fc.urunFiyati.getAttribute("content")+" TL");
        System.out.println("secilenUrun1 = " + secilenUrun1);

        rm.clickFunction(fc.sepeteEkle);
        rm.clickFunction(fc.xKapat);

        rm.getSwitchAnaSayfa();
        rm.clickFromList(fc.urunList,1);

        rm.getSwitchWindow();
        String secilenUrun2= fc.saticiAdi1.getText()+rm.noktalamaKaldirma(fc.urunFiyati.getAttribute("content")+" TL");;

        System.out.println("secilenUrun2 = " + secilenUrun2);
        rm.clickFunction(fc.sepeteEkle);
        rm.clickFunction(fc.sepeteGit);

        String sepetUrun1=wait.until(ExpectedConditions.visibilityOf(fc.sepetSatici1)).getText()+rm.noktalamaKaldirma(fc.sepetUrun1Fiyati.getText());
        String sepetUrun2=wait.until(ExpectedConditions.visibilityOf(fc.sepetSatici2)).getText()+rm.noktalamaKaldirma(fc.sepetUrun2Fiyati.getText());
        System.out.println("sepetUrun1 = " + sepetUrun1);
        System.out.println("sepetUrun2 = " + sepetUrun2);

        Assert.assertEquals(sepetUrun1.toLowerCase(), secilenUrun1.toLowerCase());
        Assert.assertEquals(sepetUrun2.toLowerCase(), secilenUrun2.toLowerCase());

    }
}
