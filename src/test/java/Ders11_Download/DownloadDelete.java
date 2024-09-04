package Ders11_Download;

import com.microsoft.playwright.*;

import java.awt.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class DownloadDelete {

    public static void main(String[] args) throws InterruptedException, IOException {

        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int) dimension.getWidth();
        int height = (int) dimension.getHeight();

        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

        Page page = browser.newPage();
        page.setViewportSize(width, height);

        page.navigate("https://demoqa.com/upload-download");

        // Wait for the download to start
        Download download = page.waitForDownload(() -> {
            // Perform the action that initiates download
            page.getByText("Download").last().click();
        });
        /*
        String tarih = new SimpleDateFormat("_hh_mm_ss_ddMMyyy").format(new Date());
        String filePath = System.getProperty("user.home") + "/Downloads/" + tarih + "file.jpg";

         */
        String filePath = System.getProperty("user.home") + "/Downloads/";
        download.saveAs(Paths.get(filePath, download.suggestedFilename()));

        boolean isFileDownloaded = Files.exists(Paths.get(filePath, download.suggestedFilename()));
        assert isFileDownloaded;
        System.out.println("dosya durumu " + isFileDownloaded);

        download.delete();
        System.out.println("dosya durumu 2 " + Files.exists(Paths.get(filePath, download.suggestedFilename())));

        Files.deleteIfExists(Paths.get(filePath,download.suggestedFilename()));

        System.out.println("dosya durumu 3 " + Files.exists(Paths.get(filePath, download.suggestedFilename())));

        Thread.sleep(2000);
        page.close();
        browser.close();
        playwright.close();


    }
}
