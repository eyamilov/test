package com.yamilov.test.steps.gui;

import com.yamilov.test.pages.SearchResultsPage;
import com.yamilov.test.pages.YandexPage;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;

public class GuiSteps {
    private YandexPage page;
    private SearchResultsPage results;

    @Когда("^.+ переходит на сайт Яндекса$")
    public void openYandex() {
        page = new YandexPage();
        page.open();
    }

    @И("^выполняет поиск по строке (.*)$")
    public void yandexSearch(String value) {
        results = page.searchFor(value);
    }

    @Тогда("^общее количество результатов больше 1000$")
    public void checkResultsMoreThan1000() {
        results.checkResults();
    }
}
