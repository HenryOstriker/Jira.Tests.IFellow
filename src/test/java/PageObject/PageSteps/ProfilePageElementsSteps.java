package PageObject.PageSteps;

import static PageObject.PageElements.ProfilePageElements.*;

public final class ProfilePageElementsSteps {
    public static String getDisplayedUsername() {
        return displayedUserName.getText().trim();
    }
}
