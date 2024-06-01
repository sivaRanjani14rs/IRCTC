package handlingpopup;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class TravelBooking {
	public static void main(String[] args) throws InterruptedException {
		ChromeOptions option=new ChromeOptions();
		option.addArguments("--disable-notifications");
		WebDriver driver = new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.get("https://www.irctc.co.in/nget/train-search");
		driver.findElement(By.xpath("//div[@class='h_menu_drop_button hidden-xs']")).click();
		driver.findElement(By.xpath("//label[text()='BUSES']")).click();

		

		Thread.sleep(1000);
		
		Set<String> parent = driver.getWindowHandles();
		Object[] xyz = parent.toArray();
		String aa = xyz[0].toString();
		String ab = xyz[1].toString();
		System.out.println(aa);
		System.out.println(ab);
		driver.switchTo().window(ab);

		driver.findElement(By.name("departFrom")).sendKeys("Chennai");
	      Thread.sleep(1000);
		List<WebElement> startPoint = driver.findElements(By.xpath("//li[@class='ui-menu-item']"));

		// get the text of all autosuggestion option ***********************************
		// select startPoint option from departFrom
		// **************************************
		for (int i = 0; i < startPoint.size(); i++)
		{
			System.out.println(startPoint.get(i).getText());
		}
		for (int i = 0; i < startPoint.size(); i++)
			if (startPoint.get(i).getText().equalsIgnoreCase("Chennai")) 
			{
				System.out.println("si::::::" + startPoint.get(i).getText() );
				startPoint.get(i).click();
				break;
			}
		
		
	      Thread.sleep(1000);
	      
		driver.findElement(By.name("goingTo")).sendKeys("Bangalore");
		Thread.sleep(1000);
		List<WebElement> endPoint = driver.findElements(By.xpath("//li[@class='ui-menu-item']"));
		
		for (int i = 0; i < endPoint.size(); i++) {
			System.out.println(endPoint.get(i).getText());
			if (endPoint.get(i).getText().equalsIgnoreCase("Bangalore")) 
			{
				endPoint.get(i).click();
			}
		}Thread.sleep(1000);
		// select departure date 
		driver.findElement(By.partialLinkText("30")).click();
		// search to bus
		driver.findElement(By.xpath("/html/body/app-root/ng-component/div[3]/div[2]/div[2]/form/div[4]/button")).click();
		Thread.sleep(4000);
		// select seat
		WebElement selectbus=driver.findElement(By.xpath("//*[@id=\"accordionExample\"]/div[1]/div[7]/button"));
		Actions ac=new Actions(driver);
		ac.click(selectbus).build().perform();
		Thread.sleep(3000);
		// Select a Seat
		//*[@id="seatLayout0"]/div/div/div[1]/div/div[2]/div/div[2]/div[2]/span[7]
		WebElement selectseat=driver.findElement(By.xpath("//*[@id=\"seatLayout0\"]/div/div/div[1]/div/div/div/div[2]/div[4]/span[11]"));
		Actions ac1=new Actions(driver);
		ac1.click(selectseat).build().perform();
		Thread.sleep(3000);
		//select bourding time
		WebElement boardTime=driver.findElement(By.xpath("//*[@id=\"myTabContent\"]/div/div/table/tbody/tr[1]/td[1]/input"));
		Actions ac2=new Actions(driver);
		ac2.click(boardTime).build().perform();
		Thread.sleep(3000);
		// select dropping time
		WebElement droptime=driver.findElement(By.xpath("//*[@id=\"myTabContent\"]/div/div/table/tbody/tr[1]/td[1]/input"));
		Actions ac3=new Actions(driver);
		ac3.click(droptime).build().perform();
		Thread.sleep(3000);
		//driver.findElement(By.xpath("//button[text()='Proceed to Book']")).click();*/
		for(int i=0;i<10;i++) {
			driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
		}
		driver.findElement(By.xpath("//*[@id=\"seatLayout0\"]/div/div/div[2]/div[2]/div[4]/button")).click();
		Thread.sleep(3000);
		// guest user login
		driver.findElement(By.xpath("//a[@id='profile-tab']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='emailLogin']")).sendKeys("krsivaranjaniece@gmail.com");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='phoneLogin']")).sendKeys("8973162977");
		Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"profile\"]/div/form/div[3]/button")).click();
        Thread.sleep(10000);
        driver.findElement(By.xpath("//input[@name='address']")).sendKeys("Velachery");        
        //driver.findElement(By.xpath("//a[@href='javascript:void(0)']")).click();
        Thread.sleep(3000);
        WebElement selectCountry=driver.findElement(By.xpath("//select[@name='country']"));
        Select s1=new Select(selectCountry);
        s1.selectByValue("India");
        Thread.sleep(3000);
        WebElement selectState=driver.findElement(By.xpath("//select[@name='state']"));
        Select s2=new Select(selectState);
        s2.selectByValue("31++TAMIL NADU");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@name='pincode']")).sendKeys("600042");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//a[@id='dropdown11']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//a[text()='Logout']")).click();
	}

} 



