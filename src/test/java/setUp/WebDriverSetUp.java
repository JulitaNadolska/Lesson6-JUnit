package setUp;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WebDriverSetUp {
    private static Logger logger = LoggerFactory.getLogger(WebDriverSetUp.class);
    WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }

    @BeforeAll
    static void setupDriver() {
        WebDriverManager.chromedriver().setup();
        logger.info("Webdriver started successfully");
    }

    @BeforeEach
    void startOfProgram() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        logger.info("Browser has been opened");
    }

    @AfterEach
    void quitDriver() {
        driver.quit();
        logger.info("Webdriver closed properly");
    }
}