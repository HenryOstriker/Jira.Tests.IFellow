package PageObject.PageElements;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public final class HeaderElements {
    public static final SelenideElement userHeaderMenuButton = $x("//li[@id='user-options']");
    public static final SelenideElement logOutButton = $x("//a[@id='log_out']");
    public static final SelenideElement profileButton = $x("//a[@id='view_profile']");
    public static final SelenideElement projectsButton = $x("//a[@id='browse_link']");
    public static final SelenideElement searchField = $x("//input[@id='quickSearchInput']");
    public static final SelenideElement headerLogo = $x("//span[@id='logo']");
}
