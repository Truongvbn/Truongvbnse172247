package assignment;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class TC10Page {
    private WebDriver driver;
    private WebDriverWait wait;

    public TC10Page(WebDriver driver) {
        this.driver = driver;
    }

    private final By Username = By.id("username");
    private final By Password = By.id("login");
    private final By SubmitBtn = By.cssSelector("input[type='submit']");
    private final By CloseBtn = By.cssSelector("a[title='close'] span");
    private final By NavBar = By.id("nav");
    private final By DBSales = By.linkText("Sales");
    private final By Orders = By.linkText("Orders");
    private final By DBExport = By.id("sales_order_grid_export");
    private final By Export = By.cssSelector("button[title='Export']");
    private final By OrderId = By.id("order_id"); // replace with the actual id
    private final By FromDate = By.id("from_date"); // replace with the actual id
    private final By ToDate = By.id("to_date"); // replace with the actual id
    private final By SearchBtn = By.id("search_button"); // replace with the actual id




    public void login(String username, String password) {
        driver.findElement(Username).sendKeys(username);
        driver.findElement(Password).sendKeys(password);
        driver.findElement(SubmitBtn).click();
    }
    public void closeMsgBox(){
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(CloseBtn)).click();
    }
    public void goToOrders() {
        driver.findElement(NavBar).findElement(DBSales).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(Orders)).click();
    }
    public void exportOrdersToCSV() {
        WebElement exportDropdown = driver.findElement(DBExport);
        Select select = new Select(exportDropdown);
        select.selectByVisibleText("CSV");
        driver.findElement(Export).click();
    }
    public void inputOrderId(String orderId) {
        driver.findElement(OrderId).sendKeys(orderId);
    }

    public void inputFromDate(String fromDate) {
        driver.findElement(FromDate).sendKeys(fromDate);
    }

    public void inputToDate(String toDate) {
        driver.findElement(ToDate).sendKeys(toDate);
    }

    public void clickSearchButton() {
        driver.findElement(SearchBtn).click();
    }

    public void takeScreenshot(String filePath) {
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(scrFile, new File(filePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


