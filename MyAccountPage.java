import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;

public class MyAccountPage extends AbstractClass {

    @FindBy(linkText = "Edit")
    private WebElement linkEdit;
}
