package com.yamilov.test.pages;

import com.codeborne.selenide.SelenideElement;
import org.junit.Assert;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class SearchResultsPage {
    private static final By RESULTS_FOUND = By.xpath("//div[@class='serp-adv__found']");
    private final SelenideElement resultsFound = $(RESULTS_FOUND);

    public void checkResults() {
        String text = resultsFound.getText();
        Assert.assertTrue("Общее количество результатов меньше 1000", text.matches(".*(млн|тыс).*"));
    }
}
