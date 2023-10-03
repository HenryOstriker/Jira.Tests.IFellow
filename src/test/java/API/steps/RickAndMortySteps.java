package API.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static API.endpoints.EndPoints.RICK_AND_MORTY_CHARACTERS;
import static API.hooks.ApiHooks.rickAndMorty;
import static API.specifications.RequestSpecifications.specWithoutAuth;
import static API.steps.Asserts.*;
import static utils.Configuration.getConfigurationValue;

public final class RickAndMortySteps {
    private static Response response;

    private static String characterSpecies;
    private static String characterLocation;
    private static String lastEpisode;
    private static String lastCharacterUrl;
    private static String lastCharacterSpecies;
    private static String lastCharacterLocation;

    @Step("Получаем значение поля {path} из JSON ответа")
    private static String getValueOfField(String path) {
        return getJsonPath(response, path);
    }

    @Step("Получаем данные о расе персонажа")
    public static void getCharacterSpecies() {
        characterSpecies = getValueOfField("results[0].species");
    }

    @Step("Получаем данные о местонахождении персонажа")
    public static void getCharacterLocation() {
        characterLocation = getValueOfField("results[0].location.name");
    }

    @Step("Получаем последний эпизод, в котором появлялся персонаж")
    public static void getLastEpisode() {
        lastEpisode = getValueOfField("results[0].episode[-1]");
    }

    @Step("Получаем ссылку на последнего персонажа в эпизоде")
    public static void getLastCharacterUrl() {
        lastCharacterUrl = getValueOfField("characters[-1]");
    }

    @Step("Получаем данные о расе указанного персонажа")
    public static void getLastCharacterSpecies() {
        lastCharacterSpecies = getValueOfField("species");
    }

    @Step("Получаем данные о местонахождении указанного персонажа")
    public static void getLastCharacterLocation() {
        lastCharacterLocation = getValueOfField("location.name");
    }


    @Step("GET запрос с помощью queryParam для получения данных о персонаже")
    public static void getCharacterData() {
        response = specWithoutAuth(rickAndMorty)
                .queryParam(getConfigurationValue("queryName"), getConfigurationValue("queryObjects"))
                .get(RICK_AND_MORTY_CHARACTERS);

        getCharacterSpecies();
        getCharacterLocation();
    }

    private static Response getWithoutAuth(RequestSpecification specification, String url) {
        return specWithoutAuth(specification)
                .get(url);
    }


    @Step("Запрос на получение последнего персонажа в эпизоде")
    public static void getLastCharacterInEpisode() {
        response = getWithoutAuth(rickAndMorty, lastEpisode);

        getLastCharacterUrl();
    }


    @Step("Запрос на получение данных по указанному персонажу")
    public static void getLastCharacterData() {
        response = getWithoutAuth(rickAndMorty, lastCharacterUrl);

        getLastCharacterSpecies();
        getLastCharacterLocation();
    }

    @Step("Проверить расу персонажей")
    public static void checkBothSpeciesAreEqual() {
        checkSpeciesAreEqual(characterSpecies, lastCharacterSpecies);
    }

    @Step("Проверить местонахождение персонажей")
    public static void checkBothOnSameLocation() {
        checkOnSameLocation(characterLocation, lastCharacterLocation);
    }
}
