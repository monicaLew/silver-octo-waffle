package application;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class PhpTest {
	String pathToPHP = "http://s3.localhost/phpMyAdmin/index.php";
	final String user = "root";
	final String password = "root";	
	WebDriver driver = null;
	FirefoxProfile profile;
	String db_name = "auth";
	String db_create_query = "DROP SCHEMA IF EXISTS `auth`;\nCREATE DATABASE `auth` CHARACTER SET `UTF8`";
	String table_create_query = "USE auth;\nCREATE TABLE IF NOT EXISTS `users`("
			+ "`u_id` int(11) NOT NULL AUTO_INCREMENT,"
			+ "`u_login`varchar(255) NOT NULL,"
			+ "`u_password`char(40)NOT NULL,"
			+ "`u_email`varchar(255) NOT NULL,"
			+ "`u_name` varchar(255) NOT NULL,"
			+ "`u_remember`char(40) NOT NULL,"
			+ "PRIMARY KEY (`u_id`))"
			+ "ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=3";
	
	String table_name = "users";
	
	String insert_query = "USE auth;\nINSERT INTO `users` (`u_id`, `u_login`, `u_password`, `u_email`, `u_name`, `u_remember`) VALUES"
	   + "(1, 'user1', 'e38ad214943daad1d64c102faec29de4afe9da3d', 'user1@mail.com', 'Pupkin', ''),"
	   + "(2, 'user2', '2aa60a8ff7fcd473d321e0146afd9e26df395147', 'user2@mail.com', 'Smith', '');";
	
	@BeforeClass
	public static void testIni(){
		System.setProperty("webdriver.gecko.driver", "c:/MARINA/Soft/geckodriver.exe");
		FirefoxProfile profile = new FirefoxProfile();
		profile.setPreference("browser.startup.homepage", "about:blank");		
	}
	
	
	@Test	
	@Ignore
	public void testCreateDB() {		
		//System.setProperty("webdriver.gecko.driver", "c:/MARINA/Soft/geckodriver.exe");
		//FirefoxProfile profile = new FirefoxProfile();
		//profile.setPreference("browser.startup.homepage", "about:blank");
		driver = new FirefoxDriver(profile);
		driver.get(pathToPHP);
		driver.findElement(By.id("input_username")).sendKeys("root");
		driver.findElement(By.id("input_password")).sendKeys("root");
		driver.findElement(By.id("input_go")).click();
		WebDriverWait wait = new WebDriverWait(driver, 11);
	//	wait.until(ExpectedConditions.numberOfElementsToBe(By.id("input_username"), 0));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@href='server_sql.php?db=']")));
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a[@href='server_sql.php?db=']")).click();		
		
		wait.until(ExpectedConditions.numberOfElementsToBe(By.id("sqlquery"), 1));		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("textarea[id=sqlquery]")));
		//wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("textarea[id=sqlquery]")));
		WebElement textarea = driver.findElement(By.cssSelector("textarea[id=sqlquery]"));		
		String c_db_q = db_create_query.replaceAll("\n", Keys.ENTER.toString());
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("textarea[id=sqlquery]")));
		textarea.sendKeys(c_db_q);		
		wait.until(ExpectedConditions.elementToBeClickable(By.id("button_submit_query")));
		driver.findElement(By.id("button_submit_query")).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
	}
	
	@Ignore
	@Test
	public void testCreateTable() {
		driver = new FirefoxDriver(profile);
		driver.get(pathToPHP);
		driver.findElement(By.id("input_username")).sendKeys("root");
		driver.findElement(By.id("input_password")).sendKeys("root");
		driver.findElement(By.id("input_go")).click();
		WebDriverWait wait = new WebDriverWait(driver, 11);
		//wait.until(ExpectedConditions.numberOfElementsToBe(By.id("input_username"), 0));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@href='server_sql.php?db=']")));
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a[@href='server_sql.php?db=']")).click();		
		//driver.findElement(By.cssSelector("a[href*='server_sql.php?db=']")).click();
		wait.until(ExpectedConditions.numberOfElementsToBe(By.id("sqlquery"), 1));
		//((JavascriptExecutor)driver).executeScript("arguments[0].checked = true;", driver.findElement(By.className("CodeMirror-line")));
		//((JavascriptExecutor)driver).executeScript("arguments[0].click();" , element);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("textarea[id=sqlquery]")));
		WebElement textarea = driver.findElement(By.cssSelector("textarea[id=sqlquery]"));		
		String cq = table_create_query.replaceAll("\n", Keys.ENTER.toString());
		//driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("textarea[id=sqlquery]")));
		textarea.sendKeys(cq);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("button_submit_query")));
		driver.findElement(By.id("button_submit_query")).click();		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	@Ignore
	@Test		
	public void testInsertDB() {		
		driver = new FirefoxDriver(profile);
		driver.get(pathToPHP);
		driver.findElement(By.id("input_username")).sendKeys("root");
		driver.findElement(By.id("input_password")).sendKeys("root");
		driver.findElement(By.id("input_go")).click();
		WebDriverWait wait = new WebDriverWait(driver, 11);
	//	wait.until(ExpectedConditions.numberOfElementsToBe(By.id("input_username"), 0));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@href='server_sql.php?db=']")));
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a[@href='server_sql.php?db=']")).click();		
		
		wait.until(ExpectedConditions.numberOfElementsToBe(By.id("sqlquery"), 1));		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("textarea[id=sqlquery]")));
		//wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("textarea[id=sqlquery]")));
		WebElement textarea = driver.findElement(By.cssSelector("textarea[id=sqlquery]"));		
		String c_db_q = insert_query.replaceAll("\n", Keys.ENTER.toString());
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("textarea[id=sqlquery]")));
		textarea.sendKeys(c_db_q);		
		wait.until(ExpectedConditions.elementToBeClickable(By.id("button_submit_query")));
		driver.findElement(By.id("button_submit_query")).click();				
	}
	@Test	
	public void testAllInOne() {				
				driver = new FirefoxDriver(profile);
				driver.get(pathToPHP);
				driver.findElement(By.id("input_username")).sendKeys("root");
				driver.findElement(By.id("input_password")).sendKeys("root");
				driver.findElement(By.id("input_go")).click();
				WebDriverWait wait = new WebDriverWait(driver, 11);
			//	wait.until(ExpectedConditions.numberOfElementsToBe(By.id("input_username"), 0));
				wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@href='server_sql.php?db=']")));
				driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
				driver.findElement(By.xpath("//a[@href='server_sql.php?db=']")).click();		
				
				wait.until(ExpectedConditions.numberOfElementsToBe(By.id("sqlquery"), 1));		
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("textarea[id=sqlquery]")));
				//wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("textarea[id=sqlquery]")));
				WebElement textarea1 = driver.findElement(By.cssSelector("textarea[id=sqlquery]"));		
				String c_db_q = db_create_query.replaceAll("\n", Keys.ENTER.toString());
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("textarea[id=sqlquery]")));
				textarea1.sendKeys(c_db_q);		
				wait.until(ExpectedConditions.elementToBeClickable(By.id("button_submit_query")));
				driver.findElement(By.id("button_submit_query")).click();
				driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				
				
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("textarea[id=sqlquery]")));
				WebElement textarea2 = driver.findElement(By.cssSelector("textarea[id=sqlquery]"));		
				String cq = table_create_query.replaceAll("\n", Keys.ENTER.toString());
				//driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);		
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("textarea[id=sqlquery]")));
				textarea2.sendKeys(cq);
				wait.until(ExpectedConditions.elementToBeClickable(By.id("button_submit_query")));
				driver.findElement(By.id("button_submit_query")).click();		
				driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
													
				
						
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("textarea[id=sqlquery]")));
				//wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("textarea[id=sqlquery]")));
				WebElement textarea3 = driver.findElement(By.cssSelector("textarea[id=sqlquery]"));		
				String i_query = insert_query.replaceAll("\n", Keys.ENTER.toString());
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("textarea[id=sqlquery]")));
				textarea3.sendKeys(i_query);		
				wait.until(ExpectedConditions.elementToBeClickable(By.id("button_submit_query")));
				driver.findElement(By.id("button_submit_query")).click();			
	}
	
		@AfterClass
		public static void testClose(){		
		try {
			Runtime.getRuntime().exec("taskkill /F /IM geckodriver.exe");
			System.out.println("Kill gecko");
		} catch (IOException e) {			
			e.printStackTrace();
		}
	}
}
