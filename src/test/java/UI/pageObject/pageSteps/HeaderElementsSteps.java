package UI.pageObject.pageSteps;

import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Когда;
import io.qameta.allure.Step;

import static UI.pageObject.pageElements.HeaderElements.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public final class HeaderElementsSteps {
    public void logout() {
        userHeaderMenuButton.click();
        logOutButton.click();
    }

    @Когда("Открыть страницу пользователя")
    @Step("Открыть страницу пользователя")
    public static void goToUserPage() {
        userHeaderMenuButton.click();
        profileButton.click();
    }

    @Когда("Открыть проект {string}")
    @Step("Открыть проект {projectName}")
    public static void openProject(String projectName) {
        projectsButton.click();
        $(byText(projectName)).click();
    }

    @И("Найти задачу под номером {string}")
    @Step("Найти задачу под номером {projectName}")
    public static void searchTask(String projectName) {
        searchField.setValue(projectName + "\n");
    }

    @И("Найти и открыть созданную задачу {string}")
    @Step("Найти и открыть созданную задачу {projectName}")
    public static void searchCreatedTask(String projectName) {
        searchTask(ProjectPageElementsSteps.getTaskTestNumber(projectName));
    }

    @Step("Переход на главную страницу")
    public void clickMainLogo() {
        headerLogo.click();
    }
}
