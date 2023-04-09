package testcases;

import org.testng.annotations.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


public class TestingCSRF {
	

	//interface
		WebDriver driver;

	  @Test
	  public void canGetWebapp()
	  {
		  driver.get("https://dsb.victorzhou.com/login");
		  
		  Assert.assertTrue(driver.getTitle().contains("Definitely Secure Bank"));
		 // driver.close();

	  }
	  
	  @Test
	  public void first_test() throws InterruptedException
	  {
		 
		  WebDriverWait wait = new WebDriverWait(driver, 10);
		  JavascriptExecutor java =(JavascriptExecutor)driver;
		  java.executeScript("window.scrollBy(0,350)", "");
		  //java.executeScript("document.getElementById('query').focus();");
			//driver.findElement(By.name("query")).sendKeys("<script>alert('XSS');</script>");
		  //driver.findElement(By.xpath("//*[@id=\"game-frame-container\"]"));
		 // driver.findElement(By.id("game-frame-container"));
		 // WebElement gm_frm =(WebElement) amrdriver.findElement(By.xpath("//*[@id=\"query\"]"));
		//  driver.findElement(By.name("query")).sendKeys("<script>alert('XSS');</script>");
		//Locating element by link text and store in variable "Element"        		
	      //WebElement Element = driver.findElement(By.linkText("Try Selenium Testing For Free"));
		  //driver.switchTo().frame(0);
		WebElement Element = driver.findElement(By.name("username"));
		//Element.getAttribute("onfocus");
	      // Scrolling down the page till the element is found		
	      java.executeScript("arguments[0].scrollIntoView();", Element);
	      //Reflected XSS attack
	      //inject reflected XSS attack
	     Element.sendKeys("Akii");
	      Thread.sleep(500);
		 // Element.sendKeys("
	      driver.findElement(By.name("password")).sendKeys("Alnass");
	      Thread.sleep(500);
	      WebElement sign_btn =driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/form/button"));
	      sign_btn.click();
	      	//Alert alert = wait.until(ExpectedConditions.alertIsPresent());
	      	//Thread.sleep(2000);
	      	//alert.accept();
	      	driver.switchTo().defaultContent();
	      	//WebElement Element1= amrdriver.findElement(By.xpath("//h1[@id='level-title']"));
	      	//java.executeScript("arguments[0].scrollIntoView();", Element1);
	      	java.executeScript("window.scrollBy(0,-100)", "");
	      	Thread.sleep(2000);
	      	 WebElement Element2 = driver.findElement(By.linkText("Advance to next level >>"));
	      	 Element2.click();
	      	
	     
	  }
	  @Test
	  public void nextPage() throws Exception {
		  WebDriverWait wait = new WebDriverWait(driver, 10);
		  WebElement transfer_btn= driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div/button"));
		  transfer_btn.click();
		  Alert alert = wait.until(ExpectedConditions.alertIsPresent());
	      	Thread.sleep(2000);
	      	alert.accept();
		  
	  }
	  @Test
	  public void storedXSS() throws InterruptedException
	  {
	      	 // stored XSS
	      	 //<img src='x' onerror='alert(1)'>
		  WebDriverWait wait = new WebDriverWait(driver, 10); 	
		  JavascriptExecutor java =(JavascriptExecutor)driver;
	      	driver.switchTo().frame(0);
			
			java.executeScript("window.scrollBy(0,350)", "");
			WebElement level2Element = driver.findElement(By.name("content"));
			level2Element.sendKeys("<img src='x' onerror='alert(/Stored XSS/)'>");
			//level2Element.sendKeys("<img src=x onerror=alert(document.location)>");
			//level2Element.sendKeys("<a href=javaSCRIPT&colon;alert(/XSS/)>XSS</a>");
			WebElement level2btn =driver.findElement(By.className("share"));
			level2btn.click();
	      	Alert alert2 = wait.until(ExpectedConditions.alertIsPresent());
	      	Thread.sleep(1000);
	      	alert2.accept();
	    	driver.switchTo().defaultContent();
	      	//WebElement Element1= amrdriver.findElement(By.xpath("//h1[@id='level-title']"));
	      	//java.executeScript("arguments[0].scrollIntoView();", Element1);
	      	java.executeScript("window.scrollBy(0,-100)", "");
	      	Thread.sleep(2000);
	      	 WebElement Element2 = driver.findElement(By.linkText("Advance to next level >>"));
	      	 Element2.click();
	  }
	  @BeforeClass
	public void open_browser()
	{
		  //System.setProperty("webdriver.chrome.whitelistedIps", "");
		System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		

	}
	  @AfterClass
	  public void close_browser()
	 {
		 //amrdriver.close();
		  
	  }
	}

