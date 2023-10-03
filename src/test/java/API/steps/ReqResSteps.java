package API.steps;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.json.JSONObject;

import static API.endpoints.EndPoints.REQRES_CREATE_USER;
import static API.hooks.ApiHooks.reqRes;
import static API.specifications.RequestSpecifications.specWithoutAuth;
import static API.steps.Asserts.*;
import static utils.Configuration.getConfigurationValue;

public final class ReqResSteps extends BaseTestSteps {
    private static Response response;

    @Step("Сборка body запроса для создания нового пользователя в ReqRes")
    public static JSONObject createBodyForNewUser() {
        return getJSONObject("createUser.json")
                .put("name", getConfigurationValue("name"))
                .put("job", getConfigurationValue("job"));
    }

    @Step("Отправка GET запроса на регистрацию нового пользователя")
    public static void createUser() {
        response = specWithoutAuth(reqRes)
                .body(createBodyForNewUser().toString())
                .post(REQRES_CREATE_USER);
    }

    @Step("Полученный ответ имеет валидные данные в JSON")
    public static void checkResponseIsValid() {
        checkStatusCode(201, response.getStatusCode());
        checkJsonFieldIsPresent(response, "name");
        checkJsonFieldIsPresent(response, "job");
        checkJsonFieldIsPresent(response, "id");
        checkJsonFieldIsPresent(response, "createdAt");
        checkJsonFieldIsEquals(response,"Tomato", "name");
        checkJsonFieldIsEquals(response,"Eat market", "job");
        checkJsonFieldIsNotEmpty(response, "", "id");
        checkJsonFieldIsNotEmpty(response, "", "createdAt");
    }
}
