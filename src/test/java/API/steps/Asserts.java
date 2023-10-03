package API.steps;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;

public final class Asserts extends BaseTestSteps {
    @Step("Оба персонажа одной расы")
    public static void checkSpeciesAreEqual(String firstCharacter, String secondCharacter) {
        Assertions.assertEquals(firstCharacter, secondCharacter, "Эти персонажи имеют разную расу.");
    }

    @Step("Оба персонажа находятся в разных локациях")
    public static void checkOnSameLocation(String firstCharacter, String secondCharacter) {
        Assertions.assertNotEquals(firstCharacter, secondCharacter, "Эти персонажи находятся в одном месте.");
    }

    @Step("Статус-код ответа равен {expected}")
    public static void checkStatusCode(int expected, int actual) {
        Assertions.assertEquals(expected, actual, "Статус-код не равен '" + expected + "'.");
    }

    @Step("В ответе пришло поле {jsonField}")
    public static void checkJsonFieldIsPresent(Response response, String jsonField) {
        Assertions.assertTrue(response.asString().contains(jsonField), "Отсутствует поле '" + jsonField + "'.");
    }

    @Step("Поле {jsonField} содержит запись {expected}")
    public static void checkJsonFieldIsEquals(Response response, String expected, String jsonField) {
        Assertions.assertEquals(expected, getJsonPath(response, jsonField), "Поле '" + jsonField + "' не равно '" + expected + "'.");
    }

    @Step("Поле {jsonField} содержит не пустую запись")
    public static void checkJsonFieldIsNotEmpty(Response response, String unexpected, String jsonField) {
        Assertions.assertNotEquals(unexpected, getJsonPath(response, jsonField), "Поле '" + jsonField + "' не заполнено.");
    }
}
