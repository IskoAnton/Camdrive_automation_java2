package ru.stqa.selenium;


import org.testng.annotations.*;
import org.openqa.selenium.*;


public class LoginTrue extends TestNgTestBase {
  

  @Test
  public void testLoginTrue() throws Exception {
    driver.get(baseUrl + "/");
    driver.findElement(By.name("username")).clear();
    driver.findElement(By.name("username")).sendKeys("tester6");
    driver.findElement(By.name("password")).clear();
    driver.findElement(By.name("password")).sendKeys("tester6");
    driver.findElement(By.id("login")).click();
  }
}
