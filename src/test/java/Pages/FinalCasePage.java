package Pages;

import Utilities.Driver;
import Utilities.ReusableMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class FinalCasePage {

    public FinalCasePage() {
        PageFactory.initElements(Driver.driver,this);
    }

    @FindBy(id = "onetrust-accept-btn-handler")
    public WebElement cerezKabulEt;
    @FindBy(css = "[title='Giriş Yap']")
    public WebElement girisYap;

    @FindBy(id = "login")
    public WebElement girisYapButton;

    @FindBy(xpath= "(//input[@placeholder='E-posta adresi veya telefon numarası'])[1]")
    public WebElement emailGiris;

    @FindBy(id = "btnLogin")
    public WebElement emailGirisYap;

    @FindBy(xpath= "(//input[@placeholder='Şifre'])[1]")
    public WebElement sifreYaz;

    @FindBy(id = "btnEmailSelect")
    public WebElement sifreGirisYap;

    @FindBy(xpath = "(//span[contains(@class,'sf-OldMyAccount')])[1]")
    public WebElement hesabim;

    @FindBy(css = "[class='desktopOldAutosuggestTheme-UyU36RyhCTcuRs_sXL9b']")
    public WebElement searchInput;

    @FindBy(css = "[class='productListContent-zAP0Y5msy8OHn5z7T_K_']")
    public List<WebElement> urunList;

    @FindBy(xpath = "(//a[contains(@class,' hbus')])[2]")
    public WebElement saticiAdi1;

    @FindBy(id = "offering-price")
    public WebElement urunFiyati;

    @FindBy(css = "[class='button big with-icon']")
    public WebElement sepeteEkle;

    @FindBy(css = "[class='checkoutui-Modal-2iZXl']")
    public WebElement xKapat;


    @FindBy(xpath = "//button[text()='Sepete git']")
    public WebElement sepeteGit;


    @FindBy(xpath = "(//span[@class='merchantLink_2Ii8s']/a)[1]")
    public WebElement sepetSatici2;

    @FindBy(xpath = "(//div[contains(@class,'co-hbPrice-ibRavm')])[1]")
    public WebElement sepetUrun2Fiyati;

    @FindBy(xpath = "(//span[@class='merchantLink_2Ii8s']/a)[2]")
    public WebElement sepetSatici1;

    @FindBy(xpath = "(//div[contains(@class,'co-hbPrice-ibRavm')])[2]")
    public WebElement sepetUrun1Fiyati;

}
