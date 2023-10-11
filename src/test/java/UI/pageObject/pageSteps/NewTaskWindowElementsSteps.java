package UI.pageObject.pageSteps;

import io.cucumber.java.ru.И;
import io.qameta.allure.Step;

import static UI.pageObject.pageElements.NewTaskWindowElements.*;
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
    @И("Сохранить и создать задачу")
    @Step("Сохранить и создать задачу")
    public static void acceptAndCreateTask() {
        submitButton.click();
    }

    @И(("Заполнить поля задачи: {string}, {string}, {string}, {string}, {string}, {string}, {string}"))
    @Step("Заполнить поля задачи: {string}, {string}, {string}, {string}, {string}, {string}, {string}")
    public static void setTaskFields(String taskType, String taskName, String taskDescription, String taskFixInVersion,
                                     String taskEnvironment, String taskAffectedVersion, String connectedTask) {
        setTaskType(taskType);
        setTaskName(taskName);
        setTaskDescription(taskDescription);
        setTaskFixInVersion(taskFixInVersion);
        setTaskEnvironment(taskEnvironment);
        setTaskAffectedVersion(taskAffectedVersion);
        setConnectedTask(connectedTask);
    }
}
