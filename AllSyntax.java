package test;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.Button;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Location;
import org.sikuli.script.Region;
import org.sikuli.script.Screen;
import org.sikuli.script.ScreenImage;




public class AllSyntax {

	public static void main(String[] args) throws InterruptedException, AWTException, IOException, FindFailed {
		//To call browser
				System.setProperty("webdriver.chrome.driver",
						"E:\\batch227\\chromedriver.exe");
		        WebDriver driver=new ChromeDriver();
		//Get mercury tours site
		             driver.get("http://newtours.demoaut.com/");		             
		             Thread.sleep(5000);
		// navigate to google site             
		             driver.navigate().to("http://www.google.co.in");
		 			 Thread.sleep(5000);
		// to click an element
		             driver.findElement(By.linkText("REGISTER")).click();
		// to get the color
		             String color=driver.findElement(By.name("firstName")).getCssValue("color");
		             System.out.println(color);
		             
		// to enter in text box
		             driver.findElement(By.name("userName")).sendKeys("apj@abdulkalam.com");


				
		// count TAGS in web page
				
			    List<WebElement> l=driver.findElements(By.tagName("img"));
				System.out.println(l.size());
				
		// count no. of elements in web page
				
				List<WebElement> le=driver.findElements(By.tagName("input"));
				int nor=0;
				for(int i=0; i<le.size(); i++)
				{
					String y=le.get(i).getAttribute("type");
					if(y.equals("radio"))
					{
						nor=nor+1;
					}
				}
				System.out.println(nor);
			
		// count particular element
			List<WebElement> l1=driver.findElements(By.xpath("//input[@type='radio']"));
			int nor1=l1.size();
			System.out.println(nor1);  
			
		// Get position of browser window
					int x1=driver.manage().window().getPosition().getX();
					int y1=driver.manage().window().getPosition().getY();
					System.out.println(x1+" "+y1);
					Thread.sleep(5000);
		// Change position of browser window
					Point p=new Point(100,100);
					driver.manage().window().setPosition(p);
					Thread.sleep(5000);
		// Get size of browser window
					int w=driver.manage().window().getSize().getWidth();
					int h=driver.manage().window().getSize().getHeight();
					System.out.println(w+" "+h);
					Thread.sleep(5000);
		// Change size of browser window
					Dimension d=new Dimension(20,20);
					driver.manage().window().setSize(d);
					Thread.sleep(5000);
		// Maximize browser window
					driver.manage().window().maximize();
		//Handle web-alert
					driver.switchTo().alert().dismiss();
					driver.switchTo().alert().accept();
					driver.switchTo().alert().sendKeys("hi");
		//getWindowHandles
		//Handle browser windows
					ArrayList<String> x3=new ArrayList<String>(driver.getWindowHandles());
					driver.switchTo().window(x3.get(1)); //2nd browser
					driver.close();
					Thread.sleep(5000);
					driver.switchTo().window(x3.get(0)); //1st browser
		// switch to frame
					driver.switchTo().frame("iframe"); //tag name
					
					driver.switchTo().frame(0);// index starts with 0 and we can give 1,2 depend on frames
					
		// come out of frame
					driver.switchTo().defaultContent();
		// Navigate
					
					driver.navigate().back();
					Thread.sleep(5000);
					driver.navigate().forward();
					Thread.sleep(5000);
					driver.navigate().refresh();
					
		// get current url
					String x4=driver.getCurrentUrl();
					if(x4.contains("https"))
					{
						System.out.println("Securable site");
					}
					else
					{
						System.out.println("Not securable");
					}
		// method to check if check box or radio button selected or not
					driver.findElement(By.id("id_of_checkbox")).isSelected();
		// How would you check if an element is visible or hidden on the web page?
					driver.findElement(By.id("id_of_element")).isDisplayed();
		// How to check if a button is enabled page?
					driver.findElement(By.id("id_of_element")).isEnabled();
					
		//Delete all existing cookies
					driver.manage().deleteAllCookies();
		//Cookies testing
					if(driver.manage().getCookies().size()!=0)
					{
						System.out.println("Cookies loaded");
					}
					else
					{
						System.out.println("No cookies");
					}
					
		//Handle drop-down using select tag
				    Select s=new Select(driver.findElement(By.name("country")));
				    s.selectByVisibleText("INDIA");
				    s.selectByIndex(0);
				    s.selectByValue("INDIA");
				    s.deselectAll();
				    s.deselectByVisibleText("INDIA");
				    s.deselectByIndex(0);
				    s.deselectByValue("INDIA");
				    
		//  to find dropdown whether multi select or  not 
				    
					Select s1=new Select(driver.findElement(
					   By.name("frm:searchForm:departTime0")));
			if(s1.isMultiple()==true)
			{
				System.out.println("Multiselect drop-down");
			}
			else
			{
				System.out.println("single select drop-down");
			}
			
		// Actions class
			
		// if dropdown is div tag 
			Actions a=new Actions(driver);
			a.sendKeys("jul").build().perform();	
			a.sendKeys(Keys.ENTER).build().perform();
			
		// Handling multiselect dropdown using select tag
			
			Select multi = new Select(driver.findElement(By.id("")));
			Actions act=new Actions(driver);
			act.keyDown(Keys.CONTROL).click(multi.getOptions().get(0)).
			click(multi.getOptions().get(2)).click(multi.getOptions().get(4)).
			keyUp(Keys.CONTROL).build().perform();
			
			
			
			
		// Handling cache elements
			Actions cache=new Actions(driver);
			cache.sendKeys(Keys.DOWN).build().perform();	
			cache.sendKeys(Keys.DOWN).build().perform();	
			cache.sendKeys(Keys.ENTER).build().perform();
			
		// mouse pointer move to element in webpage
			
		//Create DOM to Men element
					WebElement e=driver.findElement(By.xpath("//*[text()='Men']"));
		//Move mouse pointer to element
					Actions move=new Actions(driver);
					move.moveToElement(e).build().perform();
					
		// right click
					Actions right=new Actions(driver);
					right.contextClick(e).build().perform();
		// double click
					Actions doubl=new Actions(driver);
					doubl.doubleClick().build().perform();
		// click
				    Actions clik=new Actions(driver);
					clik.click().build().perform();
					
		// Holding mouse keys and release on specified element
					
					Actions candh=new Actions(driver);
					candh.clickAndHold(e).build().perform();
					candh.release();
					
		// Holding keyboard keys and release
					
					Actions chold=new Actions(driver); 
					chold.keyDown(Keys.CONTROL).build().perform();
					chold.keyUp(Keys.CONTROL).build().perform();
					chold.keyDown(Keys.BACK_SPACE).build().perform();
					chold.keyUp(Keys.BACK_SPACE).build().perform();

					
		// drag and drop
					
					WebElement e1=driver.findElement(
							   By.id("draggable"));
		            WebElement e2=driver.findElement(
							   By.id("droppable"));
		            int dd1=e2.getLocation().getX();
		            int dd2=e2.getLocation().getY();
		            Actions dragdrop=new Actions(driver);
		            dragdrop.dragAndDropBy(e1,dd1,dd2).build().perform();
					
		//Scrolling using JavascripExecutor class
		    		JavascriptExecutor js=(JavascriptExecutor) driver;
		    		js.executeScript("window.scrollTo(0,document.body.scrollHeight);");
		    		Thread.sleep(5000);
		    		js.executeScript("window.scrollTo(document.body.scrollHeight,0);");
		    		Thread.sleep(5000);
		    		WebElement e3=driver.findElement(By.xpath("(//*[text()='About Way2SMS'])[1]"));
		    		js.executeScript("arguments[0].scrollIntoView();",e3);
		    		Thread.sleep(5000);    
		 //Highlight the element
		    		WebElement e4=driver.findElement(By.id("Email"));
					JavascriptExecutor js1=(JavascriptExecutor) driver;
					js1.executeScript("arguments[0].style.border='2px dashed green';",e4);
					
		// Screenshot
					
					File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
					FileUtils.copyFile(src, new File("path to store the screen shot"));
					
	   // Implicitly wait
					
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					
	   // Explicit wait 
					
					WebDriverWait wait=new WebDriverWait(driver, 500);
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("")));
		
	// fluent wait
					Wait<WebDriver> fw= new FluentWait<WebDriver> (driver).withTimeout(30, TimeUnit.SECONDS).pollingEvery(5, TimeUnit.SECONDS);
					fw.until(ExpectedConditions.visibilityOfElementLocated(By.id("")));
					
				
		// uploading file through selenium webdriver
					
					String filename = "test.txt";
					File file = new File(filename);       
					String path = file.getAbsolutePath();

					driver.get("http://www.megafileupload.com/");
					driver.manage().window().maximize();
					driver.findElement(By.cssSelector("i.fa.fa-upload")).click();
					driver.findElement(By.cssSelector("div[class=internal] i.entypo-upload")).sendKeys(path);
					driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
					driver.findElement(By.cssSelector("button.btn.btn-green.btn-lg")).click(); //upload button
					
/*sendKeys(); function works only in some scenarios, you have following other options to deal with upload scenarios.

Use AutoIT tool for upload, but this works only for windows machine

Use ROBOT class of java for upload function, ROBOT class simulates the actual keyboard functions.	*/
		// window based by Robot class
					
					
					//Handle file upload pop-up window
					
					StringSelection f=new StringSelection("file path");
					Toolkit.getDefaultToolkit().getSystemClipboard()
					                              .setContents(f,null);
					Robot r=new Robot();
					r.keyPress(KeyEvent.VK_CONTROL);
					r.keyPress(KeyEvent.VK_V);
					r.keyRelease(KeyEvent.VK_V);
					r.keyRelease(KeyEvent.VK_CONTROL);
					Thread.sleep(5000);
					r.keyPress(KeyEvent.VK_ENTER);
					r.keyRelease(KeyEvent.VK_ENTER);
					
	//SIKULI (Using Snipping tool we need to capture the buttons as .png images)
					
					//click elements using sikuli
					
					Screen ss=new Screen();
					ScreenImage si=ss.capture(); //total screen
					BufferedImage bi=si.getImage();
					File f1=new File("E:\\batch227\\image1.png");
					ImageIO.write(bi,"png",f1);
					Region rr=ss.create(0, 0,100,100);
					ScreenImage sri=ss.capture(rr); //region
					BufferedImage bri=sri.getImage();
					File f2=new File("E:\\batch227\\image2.png");
					ImageIO.write(bri,"png",f2);
					Location ll=new Location(300,200);
					ss.wheel(ll,Button.LEFT,0);
					ss.click("E:\\batch227\\images\\pause.png");
					Thread.sleep(10000);
					ss.wheel(ll,Button.LEFT,0);
					ss.click("E:\\batch227\\images\\play.png");
					Thread.sleep(10000);
					ss.wheel(l,Button.LEFT,0);
					ss.click("E:\\batch227\\images\\volume.png");

	}

}
