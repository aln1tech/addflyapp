package com.aln1tech.addflyapp.controller.shortlink;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/shortLink")
public class ShortLinkAddController {
    public static List<String> URL = new ArrayList<>();

    static {
        URL.add("http://aorracer.com/D8P");
        URL.add("http://aorracer.com/Cwa");
        URL.add("http://aorracer.com/24XX");
        URL.add("http://aorracer.com/24XX");
        URL.add("http://aorracer.com/Cwa");
        URL.add("http://aorracer.com/24XX");
    }

    @GetMapping("/")
    public void shortLink() throws InterruptedException {
        runShortLink();
    }

    public void runShortLink() throws InterruptedException {
        for (int i = 1; i <= 10; i++) {
            System.out.println("Loop No:" + i + " Start /*******");
            System.setProperty("webdriver.chrome.driver", "chromedriver");
            WebDriver driver = new ChromeDriver();
            int random = getRandom(URL.size());
            System.out.println("URL Index:" + random);
            driver.get(URL.get(random));
            System.out.println("URL Launched !!!");
            System.out.println("First Thread Waiting for 12000 Milli sec..");
            Thread.sleep(12000);
            System.out.println("First Thread Waiting Time Completed.");
            System.out.println("Skip Add Button Visibility Check.");
            visibilityElement(driver, driver.findElement(By.xpath("//*[@id=\"skip_bu2tton\"]/img")));
            System.out.println("Click Skip Add Button.");
            driver.findElement(By.xpath("//*[@id=\"skip_bu2tton\"]/img")).click();
            System.out.println("Second Thread Waiting for 12000 Milli sec..");
            Thread.sleep(12000);
            System.out.println("Second Thread Waiting Time Completed. Clear Cache & Quit Browser !!!");
            driver.manage().deleteAllCookies();
            driver.quit();
            System.out.println("Loop No:" + i + " End *******/");
        }
    }

    private static void visibilityElement(final WebDriver driver, final WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static int getRandom(int max) {
        return (int) (Math.random() * max);
    }
}
