package page_objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class JSAlerts extends PageObject {

    public JSAlerts(WebDriver driver) {
        super(driver);
    }

    @FindBy(tagName = "button")
    private WebElement alertJS;

    public void clickOnButton(){
         alertJS.click();
    }
}
