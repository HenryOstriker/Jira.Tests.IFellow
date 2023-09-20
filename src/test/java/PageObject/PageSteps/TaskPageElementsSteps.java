package PageObject.PageSteps;

import static PageObject.PageElements.TaskPageElements.*;
import com.codeborne.selenide.Condition;

public final class TaskPageElementsSteps {
    public static String getTaskStatus() {
        return taskStatus.getText();
    }

    public static String getChangedTaskStatus() {
        String status = taskStatus.getText();
        return taskStatus.shouldNotHave(Condition.exactText(status)).getText();
    }

    public static String getFixInVersion() {
        return taskFixInVersion.getText();
    }

    public static void setStatusInProgress() {
        taskInProgressButton.click();
    }

    public static void setStatusResolved() {
        taskBusinessProcess.click();
        taskResolved.click();
        taskAccept.click();
    }

    public static void setStatusDone() {
        taskBusinessProcess.click();
        taskDone.click();
        taskAccept.click();
    }
}
