package page_objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ForgotPassword extends PageObject {

    public ForgotPassword(WebDriver driver){
        super(driver);
    }

    @FindBy(id="email")
    private WebElement emailField;

    @FindBy(id="form_submit")
    private WebElement submitButton;

    public void enterEmail(String email){
        emailField.sendKeys(email);
    }

    public void clickSubmitButton(){
        submitButton.click();
    }
}
