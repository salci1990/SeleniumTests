package page_objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Hovers extends PageObject {

    public Hovers(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "figcaption")
    private WebElement figureCaption;

    @FindBy(className = "figure")
    private WebElement figure;

    @FindBy(linkText = "View profile")
    private WebElement viewProfile;

    @FindBy(tagName = "h5")
    private WebElement userName;

    public WebElement userNameTest() {
        return userName;
    }

    public WebElement getViewProfileTest() {
        return viewProfile;
    }

    public WebElement figure() {
        return figure;
    }
}