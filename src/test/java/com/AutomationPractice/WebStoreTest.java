package com.AutomationPractice;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebStoreTest {

    @Test
    public void webStoreTest() {

        System.setProperty("webdriver.chrome.driver", "/Users/annaguscina/Desktop/chromedriver 3");
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("http://automationpractice.com");

        WebElement womenLink = driver.findElement(By.linkText("Women"));
        womenLink.click();

        WebElement leftBlockSubcategory = driver.findElement(By.xpath("//div[@id='categories_block_left']"));
    }

}
