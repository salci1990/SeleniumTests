import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import page_objects.*;

import static org.assertj.core.api.Assertions.assertThat;

public class SeleniumRuner {

    private WebDriver driver;
    private ForgotPassword forgotPassword;
    private MainPage mainPage;
    private FormAuthentication formAuthentication;
    private Hovers hovers;
    private DragAndDrop dragAndDrop;
    private JSAlerts jsAlerts;
    private DynamicLoading dynamicLoading;
    private WebDriverWait wait;
    private KeyPress keyPress;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "lib/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("disable-infobars");
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, 10);

        forgotPassword = new ForgotPassword(driver);
        mainPage = new MainPage(driver);
        formAuthentication = new FormAuthentication(driver);
        hovers = new Hovers(driver);
        dragAndDrop = new DragAndDrop(driver);
        jsAlerts = new JSAlerts(driver);
        dynamicLoading = new DynamicLoading(driver);
        keyPress = new KeyPress(driver);
    }

//    @BeforeTest
//    public void before(){
//        driver.get("https://the-internet.herokuapp.com/");
//    }

    @AfterClass
    public void tearDown() {
        sleep(2000);
        driver.quit();
    }

    @Test
    public void checkboxesTest() {
        driver.get("https://the-internet.herokuapp.com/");
        System.out.println("Page title: " + driver.getTitle());

        mainPage.clickForgotPasswordLink();
        forgotPassword.enterEmail("ja@test.com");
        forgotPassword.clickSubmitButton();
    }

    @Test
    public void formAuthenticationTest() {
        driver.get("https://the-internet.herokuapp.com/");
        mainPage.clickFormAuthenticationLink();

        formAuthentication
                .enterUserName("Artur")
                .enterPassword("password")
                .clickLoginButton();

        assertThat(formAuthentication.isErrorDisplayd()).isTrue();
    }

    @Test
    public void hoverTest() {
        driver.get("https://the-internet.herokuapp.com/");
        mainPage.clickHoversLink();
        assertThat(hovers.figure().isDisplayed()).isTrue();
        Actions builder = new Actions(driver);
        builder.moveToElement(hovers.figure()).build().perform();
        assertThat(hovers.getViewProfileTest().isEnabled());
        assertThat(hovers.userNameTest().isEnabled());
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("View profile")));
    }

    @Test
    public void keyPressTest() {
        driver.get("https://the-internet.herokuapp.com/");
        mainPage.clickKeyPressLink();
        Actions action = new Actions(driver);
        action.sendKeys(Keys.SPACE).build().perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("result")));
        action.sendKeys(Keys.ENTER).build().perform();
    }

    //    @Test
//    public void dragAndDropTest(){
//        driver.get("https://the-internet.herokuapp.com/");
//        mainPage.clickDragAndDropLink();
//        Actions action = new Actions(driver);
//        action.dragAndDrop(dragAndDrop.moveColumnA(), dragAndDrop.moveColumnB()).build().perform();
//        action.dragAndDrop(dragAndDrop.moveColumnB(), dragAndDrop.moveColumnA()).build().perform();
//
//    }
    @Test
    public void jsAlertTest() {
        driver.get("https://the-internet.herokuapp.com/");
        mainPage.clickAlertJSLink();
        jsAlerts.clickOnButton();
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
    }

    @Test
    public void dynamicLoadingTest() {
        driver.get("https://the-internet.herokuapp.com/");
        mainPage.clickDynamicLoadingLink();
        dynamicLoading.clickExample();
        dynamicLoading.clickStart();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("finish")));
        dynamicLoading.helloWorldFinder();
    }
//
//        WebElement element = driver.findElement(By.className("main-links-a.switch-mail"));
//        element.click();

    //        List<WebElement> checkboxes = driver.findElements(By.xpath("//input[@type='checkbox']"));
//
//        WebElement checkbox1 = checkboxes.get(0);
//        WebElement checkbox2 = checkboxes.get(1);
//        assertThat(checkbox1.isSelected()).isFalse();
//        checkbox1.click();
//        assertThat(checkbox1.isSelected()).isTrue();
//
//
//        assertThat(checkbox2.isSelected()).isTrue();
//        checkbox2.click();
//        assertThat(checkbox2.isSelected()).isFalse();


    private static void sleep(int timeout) {
        try {
            Thread.sleep(timeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}