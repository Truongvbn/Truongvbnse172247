package assignment;



import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import driver.driverFactory;

public class TC10Test {
    @Test
    public void Main() {
        WebDriver driver = driverFactory.getChromeDriver();
        TC10Page page = new TC10Page(driver);

        // Step 1: Go to backend login page
        driver.get("http://live.techpanda.org/index.php/backendlogin");

        // Step 2: Login with provided credentials
        page.login("user01", "guru99com");

        // Step 3: Navigate to Sales -> Orders menu
        page.closeMsgBox();
        page.goToOrders();

        // Step 4: Input OrderId and FromDate -> ToDate
        page.inputOrderId("12345"); // replace with actual OrderId
        page.inputFromDate("2022-01-01"); // replace with actual FromDate
        page.inputToDate("2022-12-31"); // replace with actual ToDate

// Step 5: Click Search button
        page.clickSearchButton();

// Step 6: Take a screenshot
        page.takeScreenshot("screenshot.png"); // replace with actual file path

        driver.quit();
    }
}
