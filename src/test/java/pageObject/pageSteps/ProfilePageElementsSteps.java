package pageObject.pageSteps;

import io.cucumber.java.ru.Тогда;
import org.junit.jupiter.api.Assertions;

import static pageObject.pageElements.ProfilePageElements.*;
import static utils.Configuration.getConfigurationValue;

public final class ProfilePageElementsSteps {
    public static String getDisplayedUsername() {
        return displayedUserName.getText().trim();
    }

@Тогда("Пользователь {string} авторизован")
public static void checkUserIsLogged(String username) {
    Assertions.assertEquals(username, getDisplayedUsername(),
            "Пользователь " + getConfigurationValue("username") + " не авторизован.");
}
}
