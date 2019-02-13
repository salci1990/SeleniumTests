package page_objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DynamicLoading extends PageObject {

    public DynamicLoading(WebDriver driver) {
        super(driver);
    }

    @FindBy(linkText = "Example 1: Element on page that is hidden")
    private WebElement example1;

    @FindBy(tagName = "button")
    private WebElement start;

    @FindBy(id = "finish")
    private WebElement finishElement;

    public void clickStart(){
        start.click();
    }

    public void clickExample(){
        example1.click();
    }

    public Boolean helloWorldFinder(){
       return finishElement.isDisplayed();
    }
}
