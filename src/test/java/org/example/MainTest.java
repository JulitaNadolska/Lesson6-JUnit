package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.assertj.core.api.Assertions.assertThat;

class MainTest {
    WebDriver driver;

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


    @ParameterizedTest
    @ValueSource(strings = {"Rozwiązania i usługi IT, inżynierii i BPO - Sii Polska"})
    @Tag("Regression")
    @Tag("Sii")
    void checkTitleSii() {
        driver.get("https://www.sii.pl");
        String actualTitle = driver.getTitle();
        String expectedTitle = "Rozwiązania i usługi IT, inżynierii i BPO - Sii Polska";
        assertThat(actualTitle).isEqualTo(expectedTitle);
    }

    @ParameterizedTest
    @ValueSource(strings = {"Onet – Jesteś na bieżąco"})
    @Tag("Regression")
    @Tag("Onet")
    void checkTitleOnet() {
        driver.get("https://www.onet.pl");
        String actualTitle = driver.getTitle();
        String expectedTitle = "Onet – Jesteś na bieżąco";
        assertThat(actualTitle).isEqualTo(expectedTitle);
    }

    @ParameterizedTest
    @ValueSource(strings = {"Kotuszkowo- blog o kotach"})
    @Tag("Regression")
    @Tag("Kotuszkowo")
    void checkTitleKotuszkowo() {
        driver.get("http://kotuszkowo.pl/");
        String actualTitle = driver.getTitle();
        String expectedTitle = "Kotuszkowo- blog o kotach";
        assertThat(actualTitle).isEqualTo(expectedTitle);
    }

    @ParameterizedTest
    @ValueSource(strings = {"Filmweb - filmy takie jak Ty!"})
    @Tag("Regression")
    @Tag("Filmweb")
    void checkTitleFilmweb(String title) {
        driver.get("https://www.filmweb.pl/");
        String actualTitle = driver.getTitle();
        assertThat(actualTitle).isEqualTo(title);
    }

    @ParameterizedTest
    @ValueSource(strings = {"WebDriver | Selenium"})
    @Tag("Regression")
    @Tag("SeleniumDocs")
    void checkTitleSeleniumDocs() {
        driver.get("https://www.selenium.dev/documentation/en/webdriver/");
        String actualTitle = driver.getTitle();
        String expectedTitle = "WebDriver | Selenium";
        assertThat(actualTitle).isEqualTo(expectedTitle);
    }
}