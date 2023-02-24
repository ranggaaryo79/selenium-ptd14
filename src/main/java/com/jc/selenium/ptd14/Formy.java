package com.jc.selenium.ptd14;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class Formy {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\juaracoding\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String url = "https://formy-project.herokuapp.com/form";
        driver.get(url);
        System.out.println("get URL");
        driver.manage().window().maximize();
        System.out.println("Maximize Browser");

        String title = driver.findElement(By.xpath("/html/body/div/h1")).getText();
        System.out.println("Title page : " +title);

        driver.findElement(By.id("first-name")).sendKeys("John");
        System.out.println("Firstname");

        driver.findElement(By.id("last-name")).sendKeys("Last");
        System.out.println("Lastname");

        driver.findElement(By.id("job-title")).sendKeys("IT Prog");
        System.out.println("Job Title");

       driver.findElement(By.id("radio-button-3")).click();
        System.out.println("Education");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        js.executeScript("window.scrollBy(0,500)");
        System.out.println("Scrolling");

        driver.findElement(By.id("checkbox-1")).click();
        System.out.println("Sex");

        WebElement selectExperience = driver.findElement(By.id("select-menu"));
        Select push = new Select(selectExperience);
        push.selectByValue("3");
        System.out.println("Experience");

        driver.findElement(By.id("datepicker")).sendKeys("26/03/2023");
        System.out.println("Date");

        driver.findElement(By.linkText("Submit")).click();
        System.out.println("Submit");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Delay 5 sec");

        driver.quit();
        System.out.println("Quit Browser");
    }
}