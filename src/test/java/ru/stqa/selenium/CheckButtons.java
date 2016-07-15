package ru.stqa.selenium;


import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;


public class CheckButtons {
  private WebDriver driver;
  private String baseUrl;
    private StringBuffer verificationErrors = new StringBuffer();

  @BeforeClass(alwaysRun = true)
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "http://ms4.camdrive.lan/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testCheckButtons() throws Exception {
	driver.get(baseUrl + "/");
	String login = "tester6";
	String password = "tester6";
	driver.findElement(By.name("username")).clear();
	driver.findElement(By.name("username")).sendKeys(login);
	driver.findElement(By.name("password")).clear();
	driver.findElement(By.name("password")).sendKeys(password);
	driver.findElement(By.id("login")).click();  
    driver.get(baseUrl + "/online");
    driver.findElement(By.xpath("//td//a[@href=\"http://ms4.camdrive.lan/archive\"]")).click();
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if (isElementPresent(By.id("calendar"))) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    driver.findElement(By.xpath("//td//a[@href=\"http://ms4.camdrive.lan/observers\"]")).click();
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if (isElementPresent(By.cssSelector("div#body input.create"))) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    driver.findElement(By.xpath("//td//a[@href=\"http://ms4.camdrive.lan/settings/tariffs\"]")).click();
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if (isElementPresent(By.id("tariff_preset_s"))) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    driver.findElement(By.xpath("//td//a[@href=\"http://ms4.camdrive.lan/payment\"]")).click();
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if (isElementPresent(By.cssSelector("div#filter select.item"))) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    driver.findElement(By.xpath("//td//a[@href=\"http://ms4.camdrive.lan/information\"]")).click();
    driver.findElement(By.xpath("//td//a[@href=\"http://ms4.camdrive.lan/online\"]")).click();
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if (isElementPresent(By.id("screens"))) break; } catch (Exception e) {}
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
