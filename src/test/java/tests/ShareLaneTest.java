package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ShareLaneTest {
    //1. Open browser, URL - https://www.sharelane.com/cgi-bin/register.py
    //2. Enter valve in ZIP code field.
    //3. Click Continue button.

    @Test
    public void fillInZipCodeFieldTest(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.sharelane.com/cgi-bin/register.py");
        driver.findElement(By.name("zip_code")).sendKeys("111111");
        driver.findElement(By.xpath("//*[@value='Continue']")).click();
        driver.findElement(By.xpath("//*[@value='Register']")).click();
        String text = driver.findElement(By.xpath("//*[@class='error_message']")).getText();
        Assert.assertEquals(text,"Oops, error on page. Some of your fields have invalid data or email was previously used");
        driver.quit();
    }
    @Test
    public void fillInZipCodeFieldAllFieldsTest(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.sharelane.com/cgi-bin/register.py");
        driver.findElement(By.name("zip_code")).sendKeys("111111");
        driver.findElement(By.xpath("//*[@value='Continue']")).click();
        driver.findElement(By.name("first_name")).sendKeys("Vitaliy");
        driver.findElement(By.name("last_name")).sendKeys("Vasilevich");
        driver.findElement(By.name("email")).sendKeys("Vitaliy@sharelane.sy");
        driver.findElement(By.name("password1")).sendKeys("12345");
        driver.findElement(By.name("password2")).sendKeys("12345");
        driver.findElement(By.xpath("//*[@value='Register']")).click();
        driver.quit();
    }
    @Test
    public void fillInZipCodeFieldSingleFieldTest(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.sharelane.com/cgi-bin/register.py");
        driver.findElement(By.name("zip_code")).sendKeys("222222");
        driver.findElement(By.xpath("//*[@value='Continue']")).click();
        driver.findElement(By.name("last_name")).sendKeys("Vasilevich");
        driver.findElement(By.xpath("//*[@value='Register']")).click();
        driver.quit();
    }
    @Test
    public void fillInZipCodeFieldRequiredFieldsTest(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.sharelane.com/cgi-bin/register.py");
        driver.findElement(By.name("zip_code")).sendKeys("333333");
        driver.findElement(By.xpath("//*[@value='Continue']")).click();
        driver.findElement(By.name("first_name")).sendKeys("Vitaliy");
        driver.findElement(By.name("email")).sendKeys("Vitaliy@sharelane.sy");
        driver.findElement(By.name("password1")).sendKeys("12345");
        driver.findElement(By.name("password2")).sendKeys("12345");
        driver.findElement(By.xpath("//*[@value='Register']")).click();
        driver.quit();
    }
    @Test
    public void fillInZipCodeFieldIncorrecEmailtTest(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.sharelane.com/cgi-bin/register.py");
        driver.findElement(By.name("zip_code")).sendKeys("44444444");
        driver.findElement(By.xpath("//*[@value='Continue']")).click();
        driver.findElement(By.name("first_name")).sendKeys("Vitaliy");
        driver.findElement(By.name("last_name")).sendKeys("Vasilevich");
        driver.findElement(By.name("email")).sendKeys("Vitaliysharelane.sy");
        driver.findElement(By.name("password1")).sendKeys("12345");
        driver.findElement(By.name("password2")).sendKeys("12345");
        driver.findElement(By.xpath("//*[@value='Register']")).click();
        driver.quit();
    }
    @Test
    public void fillInZipCodeFieldDifferentPasswordstTest(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.sharelane.com/cgi-bin/register.py");
        driver.findElement(By.name("zip_code")).sendKeys("555555");
        driver.findElement(By.xpath("//*[@value='Continue']")).click();
        driver.findElement(By.name("first_name")).sendKeys("Vitaliy");
        driver.findElement(By.name("last_name")).sendKeys("Vasilevich");
        driver.findElement(By.name("email")).sendKeys("Vitaliysharelane.sy");
        driver.findElement(By.name("password1")).sendKeys("12345");
        driver.findElement(By.name("password2")).sendKeys("54321");
        driver.findElement(By.xpath("//*[@value='Register']")).click();
        driver.quit();
    }
}