package UI.pageObject.pageSteps;

import UI.projectUtils.Waiters;
import com.codeborne.selenide.Condition;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Тогда;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;

import static UI.pageObject.pageElements.ProjectPageElements.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public final class ProjectPageElementsSteps implements Waiters {
    public static String getProjectName() {
        return projectName.getAttribute("title");
    }

    @Тогда("Проверить, что открытый проект называется {string}")
    @Step("Проверить, что открытый проект называется {projectName}")
    public static void checkProjectName(String projectName) {
        Assertions.assertEquals(projectName, getProjectName(), "Проект " + projectName + " не найден.");
    }

    @И("Открыть список задач")
    @Step("Открыть список задач")
    public static void clickTasks() {
        tasksButton.click();
        filtersButton.shouldBe(Condition.visible);
    }

    @И("Поменять фильтр отображения задач на {string}")
    @Step("Поменять фильтр отображения задач на {filtersType}")
    public static void changeFiltersTo(String filtersType) {
        filtersButton.click();
        $(byText(filtersType)).click();
    }

    public String waitForElementIsUpdated() {
        return waitFor(numberOfTasks, 1000);
    }

    public static String getNumberOfTasks() {
        return new ProjectPageElementsSteps().waitForElementIsUpdated().substring("1 из ".length());
    }

    @Тогда("Вывести общее кличество задач")
    @Step("Вывести общее кличество задач")
    public static void printNumberOfTasks() {
        System.out.println(getNumberOfTasks());
    }

    @И("Нажать \"Создать задачу\" внизу экрана и выбрать \"Открыть в диалоговом окне\"")
    @Step("Нажать \"Создать задачу\" внизу экрана и выбрать \"Открыть в диалоговом окне\"")
    public static void newTaskWithDialogue() {
        createTaskButton.click();
        openInDialogueButton.shouldBe(Condition.visible);
        openInDialogueButton.click();
        taskCreationHeader.shouldBe(Condition.visible);
    }

    public static String getTaskTestNumber(String taskName) {
        String taskDescription = $x("//div[@class='issue-content-container' and span[contains(., '" + taskName + "')]]").getText();
        return taskDescription.substring(0, taskDescription.indexOf('\n'));
    }
}
