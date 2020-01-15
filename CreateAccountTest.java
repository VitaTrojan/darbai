import org.junit.Assert;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

//@RunWith(Suite.class)
public class CreateAccountTest extends AbstractTest {
    @Test
    public void createAccount() {
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS) ;
        MainPage mainPage = new MainPage(driver);
        RegisterPage registerPage = new RegisterPage(driver);

        mainPage.clickLinkMyAccount();
        mainPage.clickLinkRegister();
        registerPage.enterInputName();
        registerPage.enterInputLastname();
        registerPage.enterInputEmail();
        String email = registerPage.getEmail();
        registerPage.enterInputTelephone();
        registerPage.enterInputAddress1();
        registerPage.enterInputCity();
        registerPage.enterInputPostcode();
        registerPage.enterInputSelectCountry();
        registerPage.enterInputSelectRegion();
        registerPage.enterInputPostcode();
        registerPage.enterInputPassword();
        registerPage.enterInputPasswordConfirm();
        registerPage.clickAgreeButton();
        registerPage.clickButtonContinue();
//        Assert.assertTrue(driver.getTitle().contains("My Account"),"");
        registerPage.clickButtonContinue2();
        driver.findElement(By.partialLinkText("Edit your account information")).click();

        org.junit.Assert.assertEquals("Vita", driver.findElement(By.name("firstname")).getAttribute("value"));
        org.junit.Assert.assertEquals("Pavarde", driver.findElement(By.name("lastname")).getAttribute("value"));
        org.junit.Assert.assertEquals(registerPage.getEmail(), driver.findElement(By.name("email")).getAttribute("value"));
        Assert.assertEquals("811111111", driver.findElement(By.name("telephone")).getAttribute("value"));



    }
}
