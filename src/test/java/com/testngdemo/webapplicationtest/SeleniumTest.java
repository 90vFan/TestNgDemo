package com.testngdemo.webapplicationtest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class SeleniumTest {
    public static void main(String[] args) {
        WebDriver chromeDriver = new ChromeDriver();
        chromeDriver.get("http://localhost:8080/index-demo");
        WebElement el = chromeDriver.findElement(By.id("label-id"));
        System.out.println("By.id:" + el.getText());

        WebElement e8 = chromeDriver.findElement(By.cssSelector("div > p:nth-child(9) > label"));
        System.out.println("By.cssSelector:" + e8.getText());

        WebElement e2 = chromeDriver.findElement(By.cssSelector("input"));
        e2.sendKeys("Input text by selenium");

        WebElement e9 = chromeDriver.findElement(By.id("my-button"));
        e9.click();
    }
}
