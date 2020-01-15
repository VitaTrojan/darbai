import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ShoppingCart extends AbstractClass {
    public ShoppingCart(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "#cart > button")
    private WebElement buttonCart;

    @FindBy (xpath = "//strong[contains(text(),'View Cart')]")
    private WebElement buttonaViewCart;

    @FindBy (xpath = "//form//tbody//td[2]")
    private WebElement tableColummProductName;

    public WebElement getProductName () { return tableColummProductName;}

    public void clickButtonCart () { buttonCart.click();}

    public  void clickButtonViewCart (){ buttonaViewCart.click();}
}
