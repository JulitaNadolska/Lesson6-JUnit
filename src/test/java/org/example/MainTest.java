package org.example;

import setUp.WebDriverSetUp;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import static org.assertj.core.api.Assertions.assertThat;
class MainTest extends WebDriverSetUp {

    @ParameterizedTest
    @CsvFileSource(resources = "/data.csv")
    @Tag("Regression")
    @DisplayName("Page title test")
    public void TestPageTitle(String pageName, String pageUrl, String expectedTitle) {
        getDriver().get(pageUrl);
        System.out.println(pageName);
        String actualTitle = getDriver().getTitle();
        assertThat(actualTitle).isEqualTo(expectedTitle);
    }
}