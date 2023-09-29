package pageObject.pageSteps;

import static pageObject.pageElements.TaskPageElements.*;
import com.codeborne.selenide.Condition;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Тогда;
import org.junit.jupiter.api.Assertions;

public final class TaskPageElementsSteps {
    public static String getTaskStatus() {
        return taskStatus.getText();
    }

    @Тогда("Проверить, что статус задачи равен {string}")
    public static void checkTaskStatus(String taskStatus) {
        Assertions.assertEquals(taskStatus, getTaskStatus(), "Начальный статус не равен '" + taskStatus + "'.");
    }

    @Тогда("Проверить, что у задачи есть статус")
    public static void checkTaskStatusIsSet() {
        Assertions.assertTrue(getTaskStatus().length() > 0, "Статус задачи не задан.");
    }

    public static String getChangedTaskStatus() {
        String status = taskStatus.getText();
        return taskStatus.shouldNotHave(Condition.exactText(status)).getText();
    }

    @Тогда("Проверить, что новый статус задачи равен {string}")
    public static void checkChangedTaskStatus(String taskStatus) {
        Assertions.assertEquals(taskStatus, getChangedTaskStatus(), "Статус не равен '" + taskStatus + "'.");
    }

    public static String getFixInVersion() {
        return taskFixInVersion.getText();
    }

    @И("Проверить, что задача должна быть исправлена в {string}")
    public static void checkFixInVersion(String version) {
        Assertions.assertEquals(version, getFixInVersion(), "Версия для исправления не соответствует " + version);
    }

    @Тогда("Поменять статус задачи на \"В работе\"")
    public static void setStatusInProgress() {
        taskInProgressButton.click();
    }

    @Тогда("Поменять статус задачи на \"Решенные\"")
    public static void setStatusResolved() {
        taskBusinessProcess.click();
        taskResolved.click();
        taskAccept.click();
    }

    @Тогда("Поменять статус задачи на \"Готово\"")
    public static void setStatusDone() {
        taskBusinessProcess.click();
        taskDone.click();
        taskAccept.click();
    }
}