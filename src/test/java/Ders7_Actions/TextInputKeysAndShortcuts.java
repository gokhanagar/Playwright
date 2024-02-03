package Ders7_Actions;

import com.microsoft.playwright.*;

import java.awt.*;

public class TextInputKeysAndShortcuts {

    public static void main(String[] args) throws InterruptedException {

        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int) dimension.getWidth();
        int height = (int) dimension.getHeight();

        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

        Page page = browser.newPage();
        page.setViewportSize(width, height);

        page.navigate("https://www.ebay.com/");

        // Text input
        Locator searchBox = page.getByPlaceholder("Search for anything");
        searchBox.fill("bicycle");

        // Keys and shortcuts
        searchBox.press("Enter");

       // page.keyboard().press("Enter");
        Thread.sleep(3000);


        page.close();
        browser.close();
        playwright.close();


    }
}