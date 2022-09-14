package org.example;

import setUp.WebDriverSetUp;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.assertj.core.api.Assertions.assertThat;
class MainTest extends WebDriverSetUp {
    private static Logger logger = LoggerFactory.getLogger(MainTest.class);

    @ParameterizedTest
    @CsvFileSource(resources = "/data.csv")
    @Tag("Regression")
    @DisplayName("Page title test")
    public void TestPageTitle(String pageName, String pageUrl, String expectedTitle) {
        getDriver().get(pageUrl);
        logger.info("PageUrl is: " + pageUrl);
        logger.debug("PageUrl is: " + pageUrl);
        logger.warn("PageUrl is: " + pageUrl);
        logger.error("PageUrl is: " + pageUrl);
        logger.trace("PageUrl is: " + pageUrl);



        System.out.println(pageName);
        String actualTitle = getDriver().getTitle();
        assertThat(actualTitle).isEqualTo(expectedTitle);
    }
}