package page_objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DragAndDrop extends PageObject {

    public DragAndDrop(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "column-a")
    private WebElement columnA;

    @FindBy(id = "column-b")
    private WebElement columnB;

    public WebElement moveColumnA() {
        return columnA;
    }

    public WebElement moveColumnB() {
        return columnB;
    }
}