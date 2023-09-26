package StepDefinition;

import hooks.CucumberHooks;
import hooks.WebHooks;
import io.cucumber.java.ru.Дано;
import org.junit.jupiter.api.Assertions;


import static PageObject.PageSteps.HeaderElementsSteps.*;
import static PageObject.PageSteps.NewTaskWindowElementsSteps.*;
import static PageObject.PageSteps.ProfilePageElementsSteps.getDisplayedUsername;
import static PageObject.PageSteps.ProjectPageElementsSteps.*;
import static PageObject.PageSteps.ProjectPageElementsSteps.getNumberOfTasks;
import static PageObject.PageSteps.TaskPageElementsSteps.*;
import static PageObject.PageSteps.TaskPageElementsSteps.getChangedTaskStatus;
import static utils.Configuration.getConfigurationValue;

public class StepDefinitions extends WebHooks {
    private static final String PROJECT_NAME_WITH_CODE = "Test (TEST)";
    private static final String PROJECT_NAME = "Test";
    private static final String VERSION = "Version 2.0";
    private static final String TASK_NAME = "Шеф, все пропало!";
    @Дано("Авторизация пользователя.")
    public void Test_UserIsAuthorized() {
        goToUserPage();

        Assertions.assertEquals(getConfigurationValue("username"), getDisplayedUsername(),
                "Пользователь " + getConfigurationValue("username") + " не авторизован.");
    }
    @Дано("Проверка перехода на проект.")
    public void Test_ProjectIsOpen() {
        openProject(PROJECT_NAME_WITH_CODE);

        Assertions.assertEquals(PROJECT_NAME, getProjectName(), "Проект " + PROJECT_NAME + " не найден.");
    }
    @Дано("Общая цифра всех задач.")
    public void Test_ShowNumberOfTasks() {
        openProject(PROJECT_NAME_WITH_CODE);
        clickTasks();
        changeFiltersTo("Все задачи");
        System.out.println(getNumberOfTasks());
    }
    @Дано("Статус задачи и привязка затронутой версии.")
    public void Test_GetTaskStatus() {
        openProject(PROJECT_NAME_WITH_CODE);
        searchTask("TEST-21967");

        Assertions.assertTrue(getTaskStatus().length() > 0, "Статус задачи не задан.");
        Assertions.assertEquals(VERSION, getFixInVersion(), "Версия не соответствует " + VERSION);
    }
    @Дано("Создание задачи.")
    public void Test_CreateTask() {
        openProject(PROJECT_NAME_WITH_CODE);
        clickTasks();
        newTaskWithDialogue();
        setTaskType("Ошибка");
        setTaskName(TASK_NAME);
        setTaskDescription("Помогите, я все уронил!");
        setTaskFixInVersion2();
        setTaskEnvironment("Google Chrome Версия 117.0.5938.89 (Официальная сборка), (64 бит).");
        setTaskMark("Метка");
        setTaskPriority("Highest");
        setTaskAffectedVersion2();
        setConnectedTask("TEST-21967");
        setappointButton();
        acceptAndCreateTask();
        searchTask(getTaskTestNumber(TASK_NAME));

      Assertions.assertEquals("СДЕЛАТЬ", getTaskStatus(), "Статус не равен 'Сделать'.");

        setStatusInProgress();
        Assertions.assertEquals("В РАБОТЕ", getChangedTaskStatus(), "Статус не равен 'В работе'.");

        setStatusResolved();
        Assertions.assertEquals("РЕШЕННЫЕ", getChangedTaskStatus(), "Статус не равен 'Решенные'.");

        setStatusDone();
        Assertions.assertEquals("ГОТОВО", getChangedTaskStatus(), "Статус не равен 'Готово'.");
    }
}


