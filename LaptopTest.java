import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class LaptopTest extends AbstractTest {

    @Test
    public void checkLaptops() throws IOException, InterruptedException {
        MainPage mainPage = new MainPage(driver);
        HelperClass helperClass = new HelperClass(driver);
        LaptopPage laptopPage = new LaptopPage(driver);
        ShoppingCart shoppingCart = new ShoppingCart(driver);
        WebDriverWait wait = new WebDriverWait(driver, 5);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);


        mainPage.clickLinkLaptops();
        List<String> data = helperClass.getTestData("src/test/resources/dataForLaptops.txt");

        for (int k = 0; k < data.size(); k++) {
            int skaitliukas = 0;
            System.out.println(data.get(k));
            String name = data.get(k);

            for (int m = 0; m < laptopPage.getProductsList().size(); m++) {
                skaitliukas = 0;
                System.out.println(laptopPage.getProductsList().size() + k + " pirmo ciklo ratas" + m + " antro ciklo ratas");
                if (data.get(k).equals(laptopPage.getProductsList().get(m).getText())) {
//            skaitliukas = 0;
                    System.out.println(name + k + " pirmo ciklo ratas" + m + " antro ciklo ratas");
//                    Thread.sleep(2000);
                    Assert.assertTrue(driver.findElement(By.linkText(name)).isDisplayed());
                    Assert.assertEquals(name, driver.findElement(By.linkText(name)).getText());
                    driver.findElement(By.linkText(name)).click();
                    laptopPage.clickButtonCompare();
//                    Thread.sleep(1000);
//                    wait.until(ExpectedConditions.visibilityOf(laptopPage.alertMessage));
                    Assert.assertTrue(laptopPage.getAlertMessageText().contains("comparison"));
                    laptopPage.clickAddToCartButton();
//                    wait.until(ExpectedConditions.visibilityOf(laptopPage.alertMessage));

                    Thread.sleep(1000);
//                    wait.until(ExpectedConditions.invisibilityOf(laptopPage.alertMessage));
//                    wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy().visibilityOf(laptopPage.alertMessage));
                    Assert.assertTrue(laptopPage.getAlertMessageText().contains("shopping"));
                    laptopPage.clickCartButton();
                    Thread.sleep(1000);
                    wait.until(ExpectedConditions.visibilityOf(laptopPage.buttonaViewCart));
                    wait.until(ExpectedConditions.elementToBeClickable(laptopPage.buttonaViewCart));
                    laptopPage.clickButtonViewCart();
//                    System.out.println(shoppingCart.getProductName().getText().contains(name));
                    System.out.println(k + " pirmo ciklo ratas" + m + " antro ciklo ratas");
//                    Assert.assertTrue(driver.findElement(By.xpath("//a[contains(text(),'\"+name+\"')]"))
//                    Assert.assertTrue(shoppingCart.getProductName().getText().contains(name));
                    Assert.assertTrue(driver.findElement(By.xpath("//a[contains(text(),'" + name + "')]")).getAttribute("text").contains(name));
//                    Assert.assertTrue(!driver.findElement(By.xpath("//a[contains(text(),'" + name + "')]")).isDisplayed()); // kazkodel reikia paneigti t.y. uzdeti ! pradzioje
                    Assert.assertTrue(driver.findElement(By.xpath("//a[contains(text(),'" + name + "')]")).isEnabled());

                    mainPage.clickLinkLaptops();
                    skaitliukas++;
                    break;

                }

            }

            if (skaitliukas == 0) {
                System.out.println(name + " tokios prekes nera");
            }

        }
    }
}
