import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Suite;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class CheckItemTest extends AbstractTest {

    @Test
    public void checkItem() throws IOException, InterruptedException {
        MainPage mainPage = new MainPage(driver);
        Mp3PlayersPage mp3PlayersPage = new Mp3PlayersPage(driver);
        ShoppingCart shoppingCart = new ShoppingCart(driver);
        WebDriverWait wait = new WebDriverWait(driver, 5);
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        HelperClass helperClass = new HelperClass(driver);
        mainPage.clickMp3Player();
        String name = "a";


//        List<WebElement> productsList = driver.findElements(By.xpath("//div[@class='caption']//h4")); // FindBy geriau butu
        List<String> data = helperClass.getTestData("src/test/resources/dataForMp3PlayersTest.txt");
        Thread.sleep(3000);

        for (int k = 0; k < data.size(); k++) {
//            mainPage.clickMp3Player();
            int skaitliukas = 0;
            for (int m = 0; m < mp3PlayersPage.getProductsList().size(); m++) { //padarius su FindBy veikai
                name = data.get(k);
                if (data.get(k).equals(mp3PlayersPage.getProductsList().get(m).getText())) {// cia luzo nes "productList" neranda, nzn kodel - tiesiog nurodzius veikia

                    skaitliukas = 0;
                    Assert.assertTrue(driver.findElement(By.linkText(name)).isDisplayed());
                    Assert.assertEquals(driver.findElement(By.linkText(name)).getText(), name);
                    driver.findElement(By.linkText(name)).click();
                    mp3PlayersPage.clickButtonWishList();
                    wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='alert alert-success']")));
                    Assert.assertTrue(mp3PlayersPage.getAlertMessageText().contains("You must login or"));
                    mp3PlayersPage.clickAddToCartButton();
                    Thread.sleep(5000);
                    wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='alert alert-success']")));
                    Assert.assertTrue(mp3PlayersPage.getAlertMessageText().contains("Success"));
                    mp3PlayersPage.clickCartButton();
                    mp3PlayersPage.clickButtonViewCart();
                    Thread.sleep(5000);
//                    Assert.assertTrue(shoppingCart.getProductName().get(k).getText().contains(name));
                    mainPage.clickMp3Player();

                    skaitliukas++;
                    break;
                }

//                if (skaitliukas == 0) {
//                    System.out.println(name + " nera");
//                }
            } if (skaitliukas == 0) {
                System.out.println(name + " nera");
            }

//            mainPage.clickMp3Player();
        }
    }
}

