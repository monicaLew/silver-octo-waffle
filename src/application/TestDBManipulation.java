package application;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.Assert;
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

public class TestDBManipulation {
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
	
	String select_from_table = "Select * from table `users`;";
	
	@BeforeClass
	public static void testIni(){
		System.setProperty("webdriver.gecko.driver", "c:/MARINA/Soft/geckodriver.exe");
		FirefoxProfile profile = new FirefoxProfile();
		profile.setPreference("browser.startup.homepage", "about:blank");		
	}
	
	
	@Test	
	@Ignore
	public void testCreateDB() {				
		driver = new FirefoxDriver(profile);
		driver.get(pathToPHP);
		driver.findElement(By.id("input_username")).sendKeys("root");
		driver.findElement(By.id("input_password")).sendKeys("root");
		driver.findElement(By.id("input_go")).click();
		WebDriverWait wait = new WebDriverWait(driver, 21);		
//		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@href='server_sql.php?db=']")));
//		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//		driver.findElement(By.xpath("//a[@href='server_sql.php?db=']")).click();			
//		//wait.until(ExpectedConditions.numberOfElementsToBe(By.id("sqlquery"), 1));	
//		//driver.findElement(By.xpath("//div[@id='sqlquerycontainer']/div/div/textarea")).clear();     		//   пример 	из 		IDE 
//		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='sqlquerycontainer']/div/div/textarea")));
//		//wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("textarea[id=sqlquery]")));
//		WebElement textarea = driver.findElement(By.cssSelector("textarea[id=sqlquery]"));		
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("textarea[id=sqlquery]")));   // не работает - возможно он неидим
//		String c_db_q = db_create_query.replaceAll("\n", Keys.ENTER.toString());
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("textarea[id=sqlquery]")));
//		textarea.sendKeys(c_db_q);		
//		wait.until(ExpectedConditions.elementToBeClickable(By.id("button_submit_query")));
//		driver.findElement(By.id("button_submit_query")).click();
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("auth")));
		WebElement element_auth = driver.findElement(By.linkText("auth"));	    	 //db_structure.php?server=1&db=aut
		Assert.assertNotNull(element_auth);
		Assert.assertNotNull(element_auth.getText());
		Assert.assertEquals("a", element_auth.getTagName());
		Assert.assertTrue(element_auth.isEnabled());
		driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);	
		element_auth.click();
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//form[@id='create_table_form_minimal']")));
		WebElement element_cr_table = driver.findElement(By.xpath("//form[@id='create_table_form_minimal']"));
		Assert.assertNotNull(element_cr_table);
		Assert.assertNotNull(element_cr_table.getText());
		Assert.assertEquals("form", element_cr_table.getTagName());
		Assert.assertTrue(element_cr_table.isEnabled());
	}
	
	@Ignore
	@Test
	public void testCreateTable() {
		driver = new FirefoxDriver(profile);
		driver.get(pathToPHP);
		driver.findElement(By.id("input_username")).sendKeys("root");
		driver.findElement(By.id("input_password")).sendKeys("root");
		driver.findElement(By.id("input_go")).click();
		WebDriverWait wait = new WebDriverWait(driver, 20);		
//		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@href='server_sql.php?db=']")));
//		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//		driver.findElement(By.xpath("//a[@href='server_sql.php?db=']")).click();			
//		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("textarea[id=sqlquery]")));
//		WebElement textarea = driver.findElement(By.cssSelector("textarea[id=sqlquery]"));			
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("textarea[id=sqlquery]")));
//		String t_c_q = table_create_query.replaceAll("\n", Keys.ENTER.toString());
//		textarea.sendKeys(t_c_q);
//		wait.until(ExpectedConditions.elementToBeClickable(By.id("button_submit_query")));
//		driver.findElement(By.id("button_submit_query")).click();				
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("auth"))).click();
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@href='sql.php?db=auth&goto=db_structure.php&table=users&pos=0']")));
		WebElement element_users = driver.findElement(By.xpath("//a[@href='sql.php?db=auth&goto=db_structure.php&table=users&pos=0']"));
		Assert.assertNotNull(element_users);
		Assert.assertNotNull(element_users.getText());
		Assert.assertEquals("a", element_users.getTagName());
		Assert.assertTrue(element_users.isEnabled());
		driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);	
		element_users.click();
		
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//th[@data-column='u_id']")));
		Assert.assertNotNull(driver.findElement(By.xpath("//th[@data-column='u_id']")));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//th[@data-column='u_login']")));
		Assert.assertNotNull(driver.findElement(By.xpath("//th[@data-column='u_login']")));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//th[@data-column='u_password']")));
		Assert.assertNotNull(driver.findElement(By.xpath("//th[@data-column='u_password']")));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//th[@data-column='u_email']")));
		Assert.assertNotNull(driver.findElement(By.xpath("//th[@data-column='u_email']")));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//th[@data-column='u_name']")));
		Assert.assertNotNull(driver.findElement(By.xpath("//th[@data-column='u_name']")));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//th[@data-column='u_remember']")));		
		Assert.assertNotNull(driver.findElement(By.xpath("//th[@data-column='u_remember']")));
	}
	
	//@Ignore                        //           я остановилась тут !!!
	@Test		
	public void testInsertDB() {		
		driver = new FirefoxDriver(profile);
		driver.get(pathToPHP);
		driver.findElement(By.id("input_username")).sendKeys("root");
		driver.findElement(By.id("input_password")).sendKeys("root");
		driver.findElement(By.id("input_go")).click();
		WebDriverWait wait = new WebDriverWait(driver, 20);		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@href='server_sql.php?db=']")));
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a[@href='server_sql.php?db=']")).click();						
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("textarea[id=sqlquery]")));
		WebElement textarea = driver.findElement(By.cssSelector("textarea[id=sqlquery]"));		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("textarea[id=sqlquery]")));
		String i_db_q = insert_query.replaceAll("\n", Keys.ENTER.toString());		
		textarea.sendKeys(i_db_q);		
		wait.until(ExpectedConditions.elementToBeClickable(By.id("button_submit_query")));
		driver.findElement(By.id("button_submit_query")).click();				
	}
	
	@Ignore
	@Test	
	public void testAllInOne() {				
				driver = new FirefoxDriver(profile);
				driver.get(pathToPHP);
				driver.findElement(By.id("input_username")).sendKeys("root");
				driver.findElement(By.id("input_password")).sendKeys("root");
				driver.findElement(By.id("input_go")).click();
				WebDriverWait wait = new WebDriverWait(driver, 20);			
				wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@href='server_sql.php?db=']")));
				driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				driver.findElement(By.xpath("//a[@href='server_sql.php?db=']")).click();				
				wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("textarea[id=sqlquery]")));
				WebElement textarea = driver.findElement(By.cssSelector("textarea[id=sqlquery]"));		
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("textarea[id=sqlquery]")));   // не работает - возможно он неидим
				String c_db_q = db_create_query.replaceAll("\n", Keys.ENTER.toString());				
				textarea.sendKeys(c_db_q);		
				wait.until(ExpectedConditions.elementToBeClickable(By.id("button_submit_query")));
				driver.findElement(By.id("button_submit_query")).click();
				driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);	
				
				
				wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@href='server_sql.php?db=']")));
				driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				driver.findElement(By.xpath("//a[@href='server_sql.php?db=']")).click();						
				wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("textarea[id=sqlquery]")));
				WebElement textarea2 = driver.findElement(By.cssSelector("textarea[id=sqlquery]"));						
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("textarea[id=sqlquery]")));
				String cq = table_create_query.replaceAll("\n", Keys.ENTER.toString());
				textarea2.sendKeys(cq);
				wait.until(ExpectedConditions.elementToBeClickable(By.id("button_submit_query")));
				driver.findElement(By.id("button_submit_query")).click();		
				driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);											
				
						
				wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@href='server_sql.php?db=']")));
				driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				driver.findElement(By.xpath("//a[@href='server_sql.php?db=']")).click();						
				wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("textarea[id=sqlquery]")));
				WebElement textarea3 = driver.findElement(By.cssSelector("textarea[id=sqlquery]"));		
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("textarea[id=sqlquery]")));
				String i_db_q = insert_query.replaceAll("\n", Keys.ENTER.toString());		
				textarea3.sendKeys(i_db_q);		
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
