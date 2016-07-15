package ru.stqa.selenium;


import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Monitoring {
  private WebDriver driver;
  private String baseUrl;
  
  private StringBuffer verificationErrors = new StringBuffer();

  @BeforeClass(alwaysRun = true)
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "https://camdrive.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testAccountEntry() throws Exception {
    driver.get(baseUrl + "/");
    driver.findElement(By.name("password")).clear();
    driver.findElement(By.name("password")).sendKeys("monitoring");
    driver.findElement(By.name("username")).clear();
    driver.findElement(By.name("username")).sendKeys("monitoring");
    driver.findElement(By.id("login")).click();
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if (isElementPresent(By.cssSelector("li#node_6002 ul"))) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

  }

  @AfterClass(alwaysRun = true)
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

}
