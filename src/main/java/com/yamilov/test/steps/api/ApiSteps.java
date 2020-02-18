package com.yamilov.test.steps.api;

import com.google.gson.*;
import com.yamilov.test.data.json.Account;
import com.yamilov.test.util.RestClient;
import io.cucumber.java.ru.Если;
import io.cucumber.java.ru.Тогда;
import org.junit.Assert;

import java.time.LocalDateTime;

public class ApiSteps {
    private static final String serviceUrl = "http://kn-ktapp.herokuapp.com/apitest/accounts/";

    @Если("^выполнить запрос информации по счетам$")
    public void getAccounts() {
        RestClient.get(serviceUrl);
    }

    @Тогда("^в ответе значение account_id не пустое$")
    public void checkAccountIdNotEmpty() {
        JsonElement response = JsonParser.parseString(RestClient.getResponseBody());
        // Если выполняем запрос по отдельному счету
        if (response.isJsonObject()) {
            checkAccountIdNotEmpty(response.getAsJsonObject());
        }
        // Если выполняем запрос по всем счетам
        else if (response.isJsonArray()) {
            JsonArray array = response.getAsJsonArray();
            for (JsonElement element : array) {
                checkAccountIdNotEmpty(element.getAsJsonObject());
            }
        }
        // Если в ответе пришел не объект и не массив
        else throw new RuntimeException("Некорректный ответ от веб-сервиса");
    }

    @Если("^выполнить запрос информации по счету \"(\\d+)\"$")
    public void getAccount(int acountNumber) {
        RestClient.get(serviceUrl + acountNumber);
    }

    public void checkAccountIdNotEmpty(JsonObject accountJsonObject) {
        Gson gson = new GsonBuilder().registerTypeAdapter(LocalDateTime.class, (JsonDeserializer<LocalDateTime>) (json, type, jsonDeserializationContext) ->
                LocalDateTime.parse(json.getAsJsonPrimitive().getAsString())).create();
        Account account = gson.fromJson(accountJsonObject, Account.class);
        int actualAccountId = account.getAccountId();
        Assert.assertTrue("Поле account_id указано некорректно: " + actualAccountId, actualAccountId > 0);
    }
}
