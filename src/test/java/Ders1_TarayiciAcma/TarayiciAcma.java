package Ders1_TarayiciAcma;

import com.microsoft.playwright.*;

import java.awt.*;


public class TarayiciAcma {

    public static void main(String[] args) {

            Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
            int width = (int) dimension.getWidth();
            int height = (int) dimension.getHeight();

            Playwright playwright = Playwright.create();
            Browser browser = playwright.chromium().launch(
                    new BrowserType.LaunchOptions().setHeadless(false));


            BrowserContext context = browser.newContext(new Browser.NewContextOptions());

            Page page = context.newPage();


            page.navigate("http://playwright.dev");
            System.out.println(page.title());


            page.close();
            browser.close();
            playwright.close();


        }
    }