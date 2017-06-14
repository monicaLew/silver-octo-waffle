/*package application;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.ui.Select;

public class All {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "http://s3.localhost/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testAll() throws Exception {
	  System.setProperty("webdriver.gecko.driver", "c:/MARINA/Soft/geckodriver.exe");
		FirefoxProfile profile = new FirefoxProfile();
		profile.setPreference("browser.startup.homepage", "about:blank");	
	  driver = new FirefoxDriver(profile);
		driver.get(baseUrl);
		driver.findElement(By.id("input_username")).sendKeys("root");
		driver.findElement(By.id("input_password")).sendKeys("root");
		driver.findElement(By.id("input_go")).click();
    driver.get(baseUrl + "/phpMyAdmin/server_sql.php?db=");
    driver.findElement(By.id("button_submit_query")).click();
    driver.findElement(By.linkText("auth")).click();
    driver.findElement(By.linkText("SQL")).click();
    driver.findElement(By.id("button_submit_query")).click();
    driver.findElement(By.cssSelector("img.icon.ic_b_minus")).click();
    driver.findElement(By.cssSelector("a.expander.loaded > img.icon.ic_b_plus")).click();
    driver.findElement(By.linkText("auth")).click();
    driver.findElement(By.linkText("users")).click();
    driver.findElement(By.linkText("SQL")).click();
    driver.findElement(By.id("button_submit_query")).click();
    driver.findElement(By.linkText("SQL")).click();
    driver.findElement(By.xpath("//div[@id='sqlquerycontainer']/div/div/textarea")).clear();
    driver.findElement(By.xpath("//div[@id='sqlquerycontainer']/div/div/textarea")).sendKeys(";");
    acceptNextAlert = false;
    driver.findElement(By.linkText("auth")).click();
    assertTrue(closeAlertAndGetItsText().matches("^You have unsaved changes; are you sure you want to leave this page[\\s\\S]$"));
    driver.findElement(By.id("button_submit_query")).click();
    driver.findElement(By.id("button_submit_query")).click();
    driver.findElement(By.cssSelector("img.icon.ic_b_minus")).click();
    driver.findElement(By.linkText("auth")).click();
    driver.findElement(By.linkText("users")).click();
    driver.findElement(By.xpath("(//a[contains(text(),'u_id')])[2]")).click();
    driver.findElement(By.xpath("(//a[contains(text(),'u_login')])[2]")).click();
    driver.findElement(By.xpath("(//a[contains(text(),'u_password')])[2]")).click();
    driver.findElement(By.id("id_rows_to_delete0_left")).click();
    driver.findElement(By.id("id_rows_to_delete0_left")).click();
    driver.findElement(By.id("id_rows_to_delete1_left")).click();
    driver.findElement(By.id("id_rows_to_delete1_left")).click();
    driver.findElement(By.id("id_rows_to_delete0_left")).click();
    driver.findElement(By.id("id_rows_to_delete1_left")).click();
    driver.findElement(By.id("resultsForm_1563305086_checkall")).click();
    driver.findElement(By.cssSelector("div.print_ignore > label")).click();
    driver.findElement(By.id("resultsForm_1563305086_checkall")).click();
    driver.findElement(By.cssSelector("div.print_ignore > label")).click();
    driver.findElement(By.xpath("(//input[@id='showAll_1563305086'])[2]")).click();
    driver.findElement(By.xpath("(//button[@type='button'])[3]")).click();
    driver.findElement(By.cssSelector("li.database.activePointer > div.block. > a > img.icon.ic_s_db")).click();
    driver.findElement(By.cssSelector("li.database.activePointer > div.block. > a > img.icon.ic_s_db")).click();
    driver.findElement(By.cssSelector("img.icon.ic_b_minus")).click();
    driver.findElement(By.linkText("SQL")).click();
    driver.findElement(By.id("button_submit_query")).click();
    driver.findElement(By.id("button_submit_query")).click();
    driver.findElement(By.linkText("+ Options")).click();
    driver.findElement(By.linkText("- Options")).click();
    driver.findElement(By.xpath("//form[@id='resultsForm_2022004132']/div/table[2]/tbody/tr[2]/td[2]/span/a/span")).click();
    driver.findElement(By.linkText("SQL")).click();
    driver.findElement(By.linkText("Structure")).click();
    driver.findElement(By.id("table_strucuture_id")).click();
    driver.findElement(By.linkText("auth")).click();
  }

  @After
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

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
*/