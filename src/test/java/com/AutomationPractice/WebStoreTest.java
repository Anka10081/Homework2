package com.AutomationPractice;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterAll;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class WebStoreTest {
    private static WebDriver driver;

    private final By LEFT_BLOCK_SUBCATEGORIES = By.xpath(".//div[@id='categories_block_left']/div/ul/li/a");
    private final By CENTER_COLUMN_SUBCATEGORIES = By.xpath(".//div[@id='subcategories']//h5/a");

    @BeforeAll
    public static void setUp() {
        System.setProperty("webdriver.chrome.driver", "/Users/annaguscina/Desktop/chromedriver 3");
        driver = new ChromeDriver();

        //Open web page
        driver.manage().window().maximize();
        driver.get("http://automationpractice.com");
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        //Find in a menu Women
        WebElement womenLink = driver.findElement(By.linkText("Women"));

        //Click on Woman
        womenLink.click();
    }

    @Test
    public void twoSubcategories() {
        List<WebElement>leftBlockSubcategories = driver.findElements(LEFT_BLOCK_SUBCATEGORIES);

        Assertions.assertEquals(leftBlockSubcategories.size(), 2, "Wrong number of subcategories in left block");
    }

    @Test
    public void subcategoriesAreEqualBetweenBlocks() {
        List<WebElement>leftBlockSubcategories = driver.findElements(LEFT_BLOCK_SUBCATEGORIES);
        List<WebElement>centerColumnSubcategories = driver.findElements(CENTER_COLUMN_SUBCATEGORIES);

        String leftBlockTops = leftBlockSubcategories.get(0).getText();
        String centerColumnTops = centerColumnSubcategories.get(0).getText();
        String leftBlockDresses = leftBlockSubcategories.get(1).getText();
        String centerColumnDresses = centerColumnSubcategories.get(1).getText();

        Assertions.assertEquals(leftBlockTops, centerColumnTops, "Wrong first subcategory name");
        Assertions.assertEquals(leftBlockDresses, centerColumnDresses, "Wrong second subcategory name");
    }

    @AfterAll
    public static void cleanUp(){
        driver.close();
        driver.quit();
    }
}




