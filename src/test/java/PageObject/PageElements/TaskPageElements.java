package PageObject.PageElements;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public final class TaskPageElements {
    public static final SelenideElement taskStatus = $x("//span[@id='status-val']");
    public static final SelenideElement taskFixInVersion = $x("//span[@id='fixVersions-field']");
    public static final SelenideElement taskInProgressButton = $(byText("В работе"));
    public static final SelenideElement taskBusinessProcess = $(byText("Бизнес-процесс"));
    public static final SelenideElement taskResolved = $(byText("Исполнено"));
    public static final SelenideElement taskAccept = $x("//input[@id='issue-workflow-transition-submit']");
    public static final SelenideElement taskDone = $(byText("Подтверждено"));
}
