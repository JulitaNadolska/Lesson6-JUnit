package setUp;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverSetUp {
    WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }

    @BeforeAll
    static void setupDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void startOfProgram() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterEach
    void quitDriver() {
        driver.quit();
    }
}