package com.yamilov.test.pages;

import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class YandexPage {
    private static final String baseUrl = "https://yandex.ru/";
    private static final By SEARCH_FIELD = By.xpath("//input[@id='text']");

    public YandexPage open() {
        Selenide.open(baseUrl);
        return this;
    }

    public SearchResultsPage searchFor(String query) {
        $(SEARCH_FIELD).setValue(query).pressEnter();
        return page(SearchResultsPage.class);
    }
}
