package com.testngdemo.webapplicationtest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;


public class TestSuite {
    private WebDriver chromeDriver;
    float start;
    float end;

    @BeforeClass
    public void init() {
        chromeDriver = new ChromeDriver();
    }

    @Test
    public void testCase1() {
        start = System.currentTimeMillis() / 1000;

        chromeDriver.get("http://localhost:8080/login");
        waitOneSecond();

        chromeDriver.findElement(By.name("username")).sendKeys("zhangsan");
        chromeDriver.findElement(By.name("password")).sendKeys("zhangsan123456");
        chromeDriver.findElement(By.xpath("//form/p[4]/button")).click();
        waitUntil(chromeDriver, By.xpath("//nav/label/span"), null);

        String expected = "zhangsan";
        String actual = chromeDriver.findElement(By.xpath("//nav/label/span")).getText();
        Assert.assertEquals(expected, actual);

        end = System.currentTimeMillis() / 1000;
    }

    public static void waitOneSecond() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void waitUntil(WebDriver chromeDriver, By by, Integer timeout) {
        if (timeout == null) {
            timeout= 10;
        }
        float _start = System.currentTimeMillis() / 1000;
        WebDriverWait webDriverWait = new WebDriverWait(chromeDriver, timeout);
        try {
            webDriverWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
        } catch (Exception e) {
            e.printStackTrace();
        }
        float _end = System.currentTimeMillis() / 1000;
        System.out.println("Waiting " + (_end - _start) + " seconds!");
    }


    @AfterClass
    public void clear() {
        System.out.println("Test executing lasts " + (end - start) + " seconds!");
        chromeDriver.quit();
    }
}
