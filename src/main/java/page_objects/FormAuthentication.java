package page_objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FormAuthentication extends PageObject {

    public FormAuthentication(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "username")
    private WebElement userNameField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(className = "fa")
    private WebElement loginButton;

    @FindBy(id = "flash")
    private WebElement errorElement;

    public Boolean isErrorDisplayd() {
        return errorElement.isEnabled();

    }

    public FormAuthentication enterUserName(String username) {
        userNameField.sendKeys(username);
        return this;
    }

    public FormAuthentication enterPassword(String password) {
        passwordField.sendKeys(password);
        return this;
    }

    public FormAuthentication clickLoginButton() {
        loginButton.click();
        return this;
    }
}