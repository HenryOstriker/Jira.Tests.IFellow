package PageObject.PageSteps;

import static PageObject.PageElements.NewTaskWindowElements.*;
import static com.codeborne.selenide.Selenide.actions;

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
    public static void setTaskMark (String taskMark){
        taskMarkfield.click();
        actions().sendKeys(taskMark).perform();
    }
    public static void setTaskPriority(String taskPriority) {
        taskPrioritySelector.click();
        taskPrioritySelector.sendKeys(taskPriority + "\n");
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
    public static void setappointButton(){appointButton.click();}

    public static void acceptAndCreateTask() {
        submitButton.click();
    }
}
