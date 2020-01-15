import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends AbstractClass {
        @FindBy (linkText = "My Account")
//    @FindBy(xpath = "//div[@id='top-links']//a[@title='My Account']")
    private WebElement linkMyAccount;

    @FindBy(linkText = "Register")
    private WebElement linkRegister;

    @FindBy (linkText = "MP3 Players")
    private WebElement linkMp3Player;

    @FindBy (linkText = "Laptops & Notebooks")
    private WebElement linkLaptops;

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public void clickLinkLaptops() { linkLaptops.click();}

    public void clickMp3Player(){
        linkMp3Player.click();
    }

    public void clickLinkMyAccount() {
        linkMyAccount.click();
    }

    public void clickLinkRegister() {
        linkRegister.click();
    }
}
