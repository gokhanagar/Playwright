package Ders6_Assertions;

import com.microsoft.playwright.*;

import java.awt.*;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class LocatorAssertions {
    public static void main(String[] args) {

        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int) dimension.getWidth();
        int height = (int) dimension.getHeight();

        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

        Page page = browser.newPage();
        page.setViewportSize(width, height);

        page.navigate("https://www.ebay.com/");

        //Locator assertions
        // containsText
        Locator signin = page.getByText("Sign in").first();
        assertThat(signin).containsText("Sign");

        // has Attribute
        Locator searchBox = page.getByPlaceholder("Search for anything");
        assertThat(searchBox).hasAttribute("type","text");

        // hasText
        Locator register = page.getByText("register").first();
        assertThat(register).hasText("register");

        // isEditable
        assertThat(searchBox).isEditable();
        System.out.println(searchBox.isEditable());

        // isEmpty
        assertThat(searchBox).isEmpty();

        // isVisible
        assertThat(searchBox).isVisible();










        page.close();
        browser.close();
        playwright.close();

    }
}
