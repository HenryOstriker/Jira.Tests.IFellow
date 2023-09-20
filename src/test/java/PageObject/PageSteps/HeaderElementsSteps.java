package PageObject.PageSteps;

import static PageObject.PageElements.HeaderElements.*;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public final class HeaderElementsSteps {
    public void logout() {
        userHeaderMenuButton.click();
        logOutButton.click();
    }

    public static void goToUserPage() {
        userHeaderMenuButton.click();
        profileButton.click();
    }

    public static void openProject(String projectName) {
        projectsButton.click();
        $(byText(projectName)).click();
    }

    public static void searchTask(String projectName) {
        searchField.setValue(projectName + "\n");
    }

    public void clickMainLogo() {
        headerLogo.click();
    }
}
