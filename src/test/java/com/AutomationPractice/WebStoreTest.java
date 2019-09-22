package com.AutomationPractice;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterAll;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebStoreTest {
    private static WebDriver driver;

    @BeforeAll
    public static void setUp(){
        System.setProperty("webdriver.chrome.driver", "/Users/annaguscina/Desktop/chromedriver 3");
        driver = new ChromeDriver();
    }

    @Test
    public void webStoreTest() {
        driver.manage().window().maximize();
        driver.get("http://automationpractice.com");

        WebElement womenLink = driver.findElement(By.linkText("Women"));
        womenLink.click();

        WebElement leftBlockSubcategory = driver.findElement(By.xpath("//div[@id='categories_block_left']"));
    }

    @AfterAll
    public static void cleanUp(){
        if (driver != null) {
            driver.close();
            driver.quit();
        }
    }
}
