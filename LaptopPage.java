import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class LaptopPage extends AbstractClass {
    public LaptopPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "button-cart")
    private WebElement buttonAddToCart;

    @FindBy(xpath = "//strong[contains(text(),'View Cart')]")
    WebElement buttonaViewCart;


    @FindBy(xpath = "//div[@class='alert alert-success']")
     WebElement alertMessage;

    @FindBy(xpath = "//div[@class='caption']//h4")
    private List<WebElement> productsList;

    @FindBy(css = "#cart > button")
    private WebElement buttonCart;

    @FindBy(xpath = "//button[@data-original-title = 'Add to Wish List']")
    private WebElement buttonWishList;

    @FindBy(xpath = "//button[2]")
    private WebElement buttonCompare;


    public void clickButtonViewCart() {
        buttonaViewCart.click();
    }

    public String getAlertMessageText() {
        return alertMessage.getText();
    }

    public void clickButtonWishList() {
        buttonWishList.click();
    }

    public void clickButtonCompare() {
        buttonCompare.click();
    }

    public void clickCartButton() {
        buttonCart.click();
    }

    public void clickAddToCartButton() {
        buttonAddToCart.click();
    }

    public List<WebElement> getProductsList() {
        return productsList;
    }
}