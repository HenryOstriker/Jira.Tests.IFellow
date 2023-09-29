package pageObject.pageSteps;

import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Когда;

import static pageObject.pageElements.HeaderElements.*;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public final class HeaderElementsSteps {
    public void logout() {
        userHeaderMenuButton.click();
        logOutButton.click();
    }

    @Когда("Открыть страницу пользователя")
    public static void goToUserPage() {
        userHeaderMenuButton.click();
        profileButton.click();
    }
@Когда("Открыть проект {string}")
    public static void openProject(String projectName) {
        projectsButton.click();
        $(byText(projectName)).click();
    }
@И("Найти задачу под номером {string}")
    public static void searchTask(String projectName) {
        searchField.setValue(projectName + "\n");
    }

    public void clickMainLogo() {
        headerLogo.click();
    }
}
