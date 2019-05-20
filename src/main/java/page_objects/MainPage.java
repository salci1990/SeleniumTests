package page_objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends PageObject {

    public MainPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(linkText = "Key Presses")
    private WebElement keyPresLink;

    @FindBy(linkText = "Dynamic Loading")
    private WebElement dynamicLoadingLink;

    @FindBy(linkText = "Drag and Drop")
    private WebElement dragAndDropLink;

    @FindBy(linkText = "JavaScript Alerts")
    private WebElement alertJSLink;

    @FindBy(linkText = "Hovers")
    private WebElement hoversLink;

    @FindBy(linkText = "Form Authentication")
    private WebElement formAuthenticationLink;


    @FindBy(linkText = "Forgot Password")
    private WebElement forgotPasswordLink;

    public void clickHoversLink() {
        hoversLink.click();
    }

    public void clickForgotPasswordLink() {
        forgotPasswordLink.click();
    }

    public void clickFormAuthenticationLink() {
        formAuthenticationLink.click();
    }

    public void clickDragAndDropLink() {
        dragAndDropLink.click();
    }

    public void clickAlertJSLink() {
        alertJSLink.click();
    }

    public void clickDynamicLoadingLink() {
        dynamicLoadingLink.click();
    }

    public void clickKeyPressLink() {
        keyPresLink.click();
    }

}