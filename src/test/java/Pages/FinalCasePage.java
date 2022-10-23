package Pages;

import Utilities.Driver;
import Utilities.ReusableMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FinalCasePage extends ReusableMethods {

    public FinalCasePage() {
        PageFactory.initElements(Driver.driver,this);
    }

    @FindBy(id = "onetrust-accept-btn-handler")
    public WebElement cerezKabulEt;
    @FindBy(css = "[title='Giriş Yap']")
    public WebElement girisYap;

    @FindBy(id = "login")
    public WebElement girisYapButton;

    @FindBy(xpath = "//input[@name='username']")
    public WebElement emailGiris;

    @FindBy(id = "btnLogin")
    public WebElement emailGirisYap;

    @FindBy(xpath= "//input[contains(@class,'hb-AxiLy')]")
    public WebElement sifreYaz;

    @FindBy(id = "btnEmailSelect")
    public WebElement sifreGirisYap;

    @FindBy(xpath = "(//span[contains(@class,'sf-OldMyAccount')])[1]")
    public WebElement hesabim;

    @FindBy(css = "[class='desktopOldAutosuggestTheme-UyU36RyhCTcuRs_sXL9b']")
    public WebElement searchInput;

    @FindBy(id = "i1")
    public WebElement urunSec;

    @FindBy(xpath = "(//a[contains(@class,' hbus')])[2]")
    public WebElement saticiAdi1;

    @FindBy(xpath = "//span[@class='price merchant price-new-old']/span")
    public WebElement urun1Fiyati;

    @FindBy(xpath = "(//a[@class='merchantStore small'])[1]")
    public WebElement saticiAdi2;

    @FindBy(xpath = "(//span[@class='price-text'])[1]")
    public WebElement urun2fiyati;

    @FindBy(css = "[class='button big with-icon']")
    public WebElement sepeteEkle;

    @FindBy(css = "[class='checkoutui-Modal-2iZXl']")
    public WebElement xKapat;

    @FindBy(xpath = "(//button[@class='add-to-basket button small'])[1]")
    public WebElement sepeteEkle2;

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
