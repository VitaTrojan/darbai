import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Mp3PlayersPage extends AbstractClass {

    @FindBy(id = "button-cart")
    private WebElement buttonAddToCart;

@FindBy (xpath = "//strong[contains(text(),'View Cart')]")
private WebElement buttonaViewCart;


    @FindBy(xpath = "//div[@class='alert alert-success']")
    private WebElement alertMessage;

    @FindBy(xpath = "//div[@class='caption']//h4")
     private List<WebElement> productsList;

    @FindBy(css = "#cart > button")
    private WebElement buttonCart;

    @FindBy(xpath = "//button[@data-original-title = 'Add to Wish List']")
    WebElement buttonWishList;



    public Mp3PlayersPage(WebDriver driver) {
        super(driver);
    }

public  void clickButtonViewCart (){ buttonaViewCart.click();}
    public String getAlertMessageText() {
        return alertMessage.getText();
    }

    public void clickButtonWishList(){
        buttonWishList.click();
    }
    public void clickCartButton() {
        buttonCart.click();
    }


//    public List<String> getTestData(String fileName) throws IOException {
//        List<String> records = new ArrayList<String>();
//        String record;
//        try (BufferedReader buffer = new BufferedReader(new FileReader(fileName));) {
//            while ((record = buffer.readLine()) != null) {
//                records.add(record);
//            }
//        }
//        return records;
//    }

//    public void enterProductName() throws IOException {
//        List<String> td = getTestData("src/test/java/resources/Data.txt");
//    }

    public void clickAddToCartButton() {
        buttonAddToCart.click();
    }

    public List <WebElement> getProductsList() {
        return productsList;
    }

}
