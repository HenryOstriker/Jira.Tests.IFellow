package pageObject.pageElements;

import com.codeborne.selenide.SelenideElement;


import static com.codeborne.selenide.Selenide.$x;

public final class NewTaskWindowElements {
    public static final SelenideElement taskTypeSelector = $x("//div[@id='issuetype-single-select']/input");
    public static final SelenideElement taskThemeField = $x("//input[@id='summary']");
    public static final SelenideElement taskDescriptionField =
            $x("//div[@class='field-group' and contains(., 'Описание')]/descendant::iframe");
    public static final SelenideElement taskEnvironmentField =
            $x("//div[@class='field-group' and contains(., 'Окружение')]/descendant::iframe");
    public static final SelenideElement taskFixInVersion2 =
            $x("//select[@id='fixVersions']/descendant::option[contains(text(), 'Version 2.0')]");
    public static final SelenideElement taskAffectedVersion2 =
            $x("//select[@id='versions']/descendant::option[contains(text(), 'Version 2.0')]");
    public static final SelenideElement taskConnected = $x("//textarea[@id='issuelinks-issues-textarea']");
    public static final SelenideElement taskMarkfield = $x("//textarea[@id='labels-textarea']");
    public static final SelenideElement taskPrioritySelector = $x("//input[@id='priority-field']");

    public static final SelenideElement appointButton = $x("//button[@id='assign-to-me-trigger' and text()='Назначить меня']");
    public static final SelenideElement submitButton = $x("//input[@id='create-issue-submit']");

    public static void setTaskFixInVersion(String taskFixInVersion) {
        $x("//select[@id='fixVersions']/descendant::option[contains(text(), '" + taskFixInVersion + "')]").click();
    }

    public static void setTaskAffectedVersion(String taskAffectedVersion) {
        $x("//select[@id='versions']/descendant::option[contains(text(), '" + taskAffectedVersion + "')]").click();
    }
}
