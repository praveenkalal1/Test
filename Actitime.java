package test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Actitime {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\prash\\Desktop\\framework\\dataDriven\\src\\main\\resources\\browserdrivers\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.get("https://online.actitime.com/central/login.do");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//login
		
		driver.findElement(By.name("username")).sendKeys("praveeng5031@gmail.com");
		driver.findElement(By.name("pwd")).sendKeys("Actitime@143");
		driver.findElement(By.id("loginButton")).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//WebDriverWait wait=new WebDriverWait(driver, 500);
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'New')]")));
		//enter in to webtable method
		
		driver.findElement(By.xpath("//*[@id='addTasksLink']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		/*driver.findElement(By.xpath("//*[@id='createTasksPopup_content']/div[1]/div[1]/div/div[1]/div/table/tbody/tr[1]/td[1]/div/div/div[1]/div[3]")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id='createTasksPopup_content']/div[1]/div[1]/div/div[1]/div/table/tbody/tr[1]/td[1]/div/div/div[2]/div/div[1]/div/div[3]")).click();
		driver.findElement(By.xpath("//*[@id='createTasksPopup_content']/div[1]/div[1]/div/div[1]/div/table/tbody/tr[3]/td[1]/div/div/div[1]/div[3]")).click();
		driver.findElement(By.xpath("//*[@id='createTasksPopup_content']/div[1]/div[1]/div/div[1]/div/table/tbody/tr[3]/td[1]/div/div/div[2]/div/div[1]/div/div[4]")).click();
		*/
		int count=driver.findElements(By.xpath("//*[@id='createTasksPopup_content']/div[1]/div[1]/div/div[3]/div/div[1]/table/tbody/tr")).size();
		
		for(int i=1; i<=count; i++){
			
			String selectdate="12/21/2019";
			Date d=new Date(selectdate);
			SimpleDateFormat dt=new SimpleDateFormat("MMM/dd/yyyy");
			String date=dt.format(d);
			System.out.println(date);
			
			String[] split=date.split("/");
			System.out.println(split[0]+" "+split[1]+" "+split[2]);
			String year=split[2];
			System.out.println("year:  "+year);
			String month=split[0];
			System.out.println("month:  "+month);
			String day=split[1];
			System.out.println("day:  "+day);
			
			
			String firstpath= "//*[@id='createTasksPopup_content']/div[1]/div[1]/div/div[3]/div/div[1]/table/tbody/tr[";
			String secondpath= "]";
			String finalpath=firstpath+i+secondpath;
			
			//enter task name
			
			String enterTaskName=finalpath+"/td[1]/input";
			System.out.println("enter task name: "+enterTaskName);
			driver.findElement(By.xpath(enterTaskName)).sendKeys("Task: "+i);
			
			//estimate
			
			String estimate=finalpath+"/td[1]/following-sibling::td[2]/input";
			System.out.println("estimate: "+estimate);
			driver.findElement(By.xpath(estimate)).sendKeys("Iam test");
			
			// Deadline
			
			String deadline=finalpath+"/td[1]/following-sibling::td[3]/child::*/child::table/child::*/child::*/child::td[2]/em/button";
			System.out.println("deadline: "+deadline);
			driver.findElement(By.xpath(deadline)).click();
			if(i>=1){
				driver.findElements(By.xpath("//*[@class='x-date-picker x-unselectable atap-base-date-picker atap-date-picker']/table/tbody/tr/td[2]/table/tbody/tr/td[2]/em/button")).get(i-1).click();
			}
			String monthObject=month;
			System.out.println("MonthObject: "+monthObject);
			String yearObject=year;
			System.out.println("YearObject: "+yearObject);
			
			driver.findElement(By.linkText(monthObject)).click();
			driver.findElement(By.linkText(yearObject)).click();
			if(i>=1){
				driver.findElements(By.xpath("//button[@class='x-date-mp-ok']")).get(i-1).click();
			}
			driver.findElement(By.linkText(day)).click();
			
			//Type of work
			
			String typeofwork=finalpath+"/td[5]/div[2]/div";
			System.out.println("typeofwork: "+typeofwork);
			driver.findElement(By.xpath(typeofwork)).click();
			String selectWork=finalpath+"/td[5]/div[1]/div/div/div[1]/div/div[9]/div";
			driver.findElement(By.xpath(selectWork)).click();
			
		}
		// Add extra rows
		WebElement element= driver.findElement(By.xpath("//*[@id='createTasksPopup_content']/div[1]/div[1]/div/div[3]/div/div[2]/div[1]"));
		if(element.isDisplayed()){
			
			//Add three rows in webtable
			
			for(int k=1; k<4; k++){
				element.click();
			}
			//driver.findElement(By.xpath("//*[@id='createTasksPopup_content']/div[1]/div[1]/div/div[3]/div/div[2]/div[1]")).click();
			//driver.findElement(By.xpath("//*[@id='createTasksPopup_content']/div[1]/div[1]/div/div[3]/div/div[2]/div[1]")).click();
			//driver.findElement(By.xpath("//*[@id='createTasksPopup_content']/div[1]/div[1]/div/div[3]/div/div[2]/div[1]")).click();
			
			int count1=driver.findElements(By.xpath("//*[@id='createTasksPopup_content']/div[1]/div[1]/div/div[3]/div/div[1]/table/tbody/tr")).size();
			System.out.println("before loop: "+count1);
         for(int j=4; j<=count1; j++){
			System.out.println("after loop: "+count1);
			String selectdate="12/21/2019";
			Date d=new Date(selectdate);
			SimpleDateFormat dt=new SimpleDateFormat("MMM/dd/yyyy");
			String date=dt.format(d);
			System.out.println(date);
			
			String[] split=date.split("/");
			System.out.println(split[0]+" "+split[1]+" "+split[2]);
			String year=split[2];
			System.out.println("year:  "+year);
			String month=split[0];
			System.out.println("month:  "+month);
			String day=split[1];
			System.out.println("day:  "+day);
			
			
			String firstpath= "//*[@id='createTasksPopup_content']/div[1]/div[1]/div/div[3]/div/div[1]/table/tbody/tr[";
			String secondpath= "]";
			String finalpath=firstpath+j+secondpath;
			
			//enter task name
			
			String enterTaskName=finalpath+"/td[1]/input";
			System.out.println("enter task name: "+enterTaskName);
			driver.findElement(By.xpath(enterTaskName)).sendKeys("Task: "+j);
			
			//estimate
			
			String estimate=finalpath+"/td[1]/following-sibling::td[2]/input";
			System.out.println("estimate: "+estimate);
			driver.findElement(By.xpath(estimate)).sendKeys("Iam test");
			
			// Deadline
			
			String deadline=finalpath+"/td[1]/following-sibling::td[3]/child::*/child::table/child::*/child::*/child::td[2]/em/button";
			System.out.println("deadline: "+deadline);
			driver.findElement(By.xpath(deadline)).click();
			if(j>=1){
				driver.findElements(By.xpath("//*[@class='x-date-picker x-unselectable atap-base-date-picker atap-date-picker']/table/tbody/tr/td[2]/table/tbody/tr/td[2]/em/button")).get(j-1).click();
			}
			String monthObject=month;
			System.out.println("MonthObject: "+monthObject);
			String yearObject=year;
			System.out.println("YearObject: "+yearObject);
			
			driver.findElement(By.linkText(monthObject)).click();
			driver.findElement(By.linkText(yearObject)).click();
			if(j>=1){
				driver.findElements(By.xpath("//button[@class='x-date-mp-ok']")).get(j-1).click();
			}
			driver.findElement(By.linkText(day)).click();
			
			//Type of work
			
			String typeofwork=finalpath+"/td[5]/div[2]/div";
			System.out.println("typeofwork: "+typeofwork);
			driver.findElement(By.xpath(typeofwork)).click();
			String selectWork=finalpath+"/td[5]/div[1]/div/div/div[1]/div/div[9]/div";
			driver.findElement(By.xpath(selectWork)).click();
         
         }
		}
		else 
		{
			System.out.println("not displayed");
		}
		
		/*
		  first row
		 
		to get xpath for all rows
		//*[@id="createTasksPopup_content"]/div[1]/div[1]/div/div[3]/div/div[1]/table/tbody/tr
		 
		to get task name first input box
		//*[@id="createTasksPopup_content"]/div[1]/div[1]/div/div[3]/div/div[1]/table/tbody/tr[1]/td[1]/input
		
		String firstpath= "//*[@id="createTasksPopup_content"]/div[1]/div[1]/div/div[3]/div/div[1]/table/tbody/tr["
		String secondpath= "]"
		
		String finalpath=firstpath+i+secondpath
		finalpath+"/td[1]/input"
		
		to get estimate first input box xpath
		//*[@id="createTasksPopup_content"]/div[1]/div[1]/div/div[3]/div/div[1]/table/tbody/tr[1]/td[1]/following-sibling::td[2]/input
		
		finalpath+"/td[1]/following-sibling::td[2]/input"
		
		to get Deadline first input box
		*/
		//*[@id="createTasksPopup_content"]/div[1]/div[1]/div/div[3]/div/div[1]/table/tbody/tr[1]/td[1]/following-sibling::td[3]/child::*/child::table/child::*/child::*/child::td[2]/em/button
		
		//finalpath+"/td[1]/following-sibling::td[3]/child::*/child::table/child::*/child::*/child::td[2]/em/button"
		
		// to get type of work first input box xpath
		//*[@id="createTasksPopup_content"]/div[1]/div[1]/div/div[3]/div/div[1]/table/tbody/tr[1]/td[5]/div[2]/div
		
		//finalpath+"/td[1]/following-sibling::td[4]/div/div"
		/*
		  secod row
		  		 
		to get task name xpath
		//*[@id="createTasksPopup_content"]/div[1]/div[1]/div/div[3]/div/div[1]/table/tbody/tr[2]/td[1]/input
		to get estimate  xpath
		//*[@id="createTasksPopup_content"]/div[1]/div[1]/div/div[3]/div/div[1]/table/tbody/tr[2]/td[1]/following-sibling::td[2]/input
		to get Deadline xpath
		*/
		//*[@id="createTasksPopup_content"]/div[1]/div[1]/div/div[3]/div/div[1]/table/tbody/tr[2]/td[1]/following-sibling::td[3]/child::*/child::table/child::*/child::*/child::td[2]/em/button
		// to get type of work xpath
		//*[@id="createTasksPopup_content"]/div[1]/div[1]/div/div[3]/div/div[1]/table/tbody/tr[2]/td[1]/following-sibling::td[4]/div/div
		
		/*
		third row
 		 
		to get task name xpath
		//*[@id="createTasksPopup_content"]/div[1]/div[1]/div/div[3]/div/div[1]/table/tbody/tr[3]/td[1]/input
		to get estimate  xpath
		//*[@id="createTasksPopup_content"]/div[1]/div[1]/div/div[3]/div/div[1]/table/tbody/tr[3]/td[1]/following-sibling::td[2]/input
		to get Deadline xpath
		*/
		//*[@id="createTasksPopup_content"]/div[1]/div[1]/div/div[3]/div/div[1]/table/tbody/tr[3]/td[1]/following-sibling::td[3]/child::*/child::table/child::*/child::*/child::td[2]/em/button
		// to get type of work xpath
		//*[@id="createTasksPopup_content"]/div[1]/div[1]/div/div[3]/div/div[1]/table/tbody/tr[3]/td[1]/following-sibling::td[4]/div/div
		

	}
 
}
