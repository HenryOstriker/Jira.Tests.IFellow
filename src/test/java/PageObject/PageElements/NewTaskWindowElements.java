package PageObject.PageElements;

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
    public static final SelenideElement submitButton = $x("//input[@id='create-issue-submit']");
}
