import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.Random;

public class RegisterPage extends AbstractClass {
    @FindBy(name = "firstname")
    private WebElement inputName;

    @FindBy(name = "lastname")
    private WebElement inputLastname;

    @FindBy(id = "input-email")
    private WebElement inputEmail;

    @FindBy(id = "input-address-1")
    private WebElement inputAddress1;

    @FindBy(id = "input-telephone")
    private WebElement inputTelephone;

    @FindBy(id = "input-city")
    private WebElement inputCity;

    @FindBy(name = "postcode")
    private WebElement inputPostcode;

    @FindBy(id = "input-zone")
    private WebElement inputSelectRegion;

    @FindBy(id = "input-country")
    private WebElement inputSelectCountry;

    @FindBy(id = "input-password")
    private WebElement inputPassword;

    @FindBy(id = "input-confirm")
    private WebElement inputPasswordConfirm;

    @FindBy(css = "input[value='Continue']")
    private WebElement buttonContinue;

    @FindBy(xpath = "//input[@type='checkbox']")
    private WebElement agreeButton;

    @FindBy(linkText = "Continue")
    private WebElement buttonContinue2;

    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    public void clickAgreeButton() {
        agreeButton.click();
    }

    public void clickButtonContinue2(){
        buttonContinue2.click();
    }

    public void clickButtonContinue() {
        buttonContinue.click();
    }

//    public void enterSelectCountry(String value) {
//        Select selectCountry = new Select(this.inputSelectCountry);
//        selectCountry.selectByValue(value);
//    }

    public void enterInputSelectRegion() {
        Select selectRegion = new Select(this.inputSelectRegion);
        selectRegion.selectByVisibleText("Vilnius");
    }


    public void enterInputSelectCountry() {
        Select selectCountry = new Select(this.inputSelectCountry);
        selectCountry.selectByValue("123");
    }

    public void enterInputName() {
        inputName.sendKeys("Vita");

    }

    public void enterInputLastname() {
        inputLastname.sendKeys("Pavarde");
    }

    public void enterInputEmail() {
        inputEmail.sendKeys(new Random().nextInt(1000)+"ceburaska2@miske.lt ");
    }
    public String getEmail() {
         return inputEmail.getAttribute("value");

    }

    public void enterInputAddress1() {
        inputAddress1.sendKeys("kazkur 1");
    }

    public void enterInputCity() {
        inputCity.sendKeys("Vilnuva");
    }

    public void enterInputPostcode() {
        inputPostcode.sendKeys("1111");
    }

    public void enterInputPassword() {
        inputPassword.sendKeys("111aaa");
    }

    public void enterInputPasswordConfirm() {
        inputPasswordConfirm.sendKeys("111aaa");
    }

    public void enterInputTelephone(){
        inputTelephone.sendKeys("811111111");
    }

    public WebElement getInputName() {
        return inputName;
    }

    public WebElement getInputLastname() {
        return inputLastname;
    }

    public WebElement getInputEmail() {
        return inputEmail;
    }

    public WebElement getInputAddress1() {
        return inputAddress1;
    }

    public WebElement getInputTelephone() {
        return inputTelephone;
    }

    public WebElement getInputCity() {
        return inputCity;
    }

    public WebElement getInputPostcode() {
        return inputPostcode;
    }

    public WebElement getInputSelectRegion() {
        return inputSelectRegion;
    }

    public WebElement getInputSelectCountry() {
        return inputSelectCountry;
    }

    public WebElement getInputPassword() {
        return inputPassword;
    }

    public WebElement getInputPasswordConfirm() {
        return inputPasswordConfirm;
    }

}
