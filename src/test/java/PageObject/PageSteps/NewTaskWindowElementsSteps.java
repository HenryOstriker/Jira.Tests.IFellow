package PageObject.PageSteps;

import static PageObject.PageElements.NewTaskWindowElements.*;
import static com.codeborne.selenide.Selenide.*;

public final class NewTaskWindowElementsSteps {
    public static void setTaskType(String taskType) {
        taskTypeSelector.click();
        taskTypeSelector.sendKeys(taskType + "\n");
    }

    public static void setTaskName(String taskName) {
        taskThemeField.setValue(taskName);
    }

    public static void setTaskDescription(String description) {
        taskDescriptionField.click();
        actions().sendKeys(description).perform();
    }

    public static void setTaskFixInVersion2() {
        taskFixInVersion2.click();
    }

    public static void setTaskEnvironment(String environment) {
        taskEnvironmentField.click();
        actions().sendKeys(environment).perform();
    }

    public static void setTaskAffectedVersion2() {
        taskAffectedVersion2.click();
    }

    public static void setConnectedTask(String task) {
        taskConnected.sendKeys(task);
    }

    public static void acceptAndCreateTask() {
        submitButton.click();
    }
}
