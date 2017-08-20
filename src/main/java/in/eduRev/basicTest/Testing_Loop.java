package in.eduRev.basicTest;


import io.github.bonigarcia.wdm.FirefoxDriverManager;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Testing_Loop {

	/**
	 * @param args
	 */
	 protected WebDriver driver;

	    @BeforeClass
	    public static void setupClass() {
	        FirefoxDriverManager.getInstance().setup();
	    }

	    @Before
	    public void setupTest() {
	        driver = new FirefoxDriver();
	    }

	    @After
	    public void teardown() {
	        if (driver != null) {
	            driver.quit();
	        }
	    }
	    
@Test
public void application(){
		// TODO Auto-generated method stub

//		WebDriver driver = new FirefoxDriver();
		driver.navigate().to("http://www.edurev.in/");

		
		boolean containsText= driver.getPageSource().contains("Alex Cross");
		System.out.println(containsText);
		
		Assert.assertFalse("Element  credit card and Send Tickets to My phone is present.",containsText);
	
		 // String showtimes = "//*[@id='rw3']/li[2]/p/a[2]";

		/*WebElement elementPresent = driver.findElement(By.xpath(showtimes));
		if (elementPresent.isDisplayed()) {
				driver.findElement(By.xpath(showtimes)).click();
		}else
		{
		List<WebElement> dropdownSlect=	driver.findElements(By.xpath("//*[@id='rdate']"));
		dropdownSlect.size();
		
		for(int i=0;i<dropdownSlect.size();){
			
			WebElement xpathFound = driver.findElement(By.xpath("//*[@id='rdate']/option["+ i +"]"));
			
			System.out.println(xpathFound);
			
			WebElement elementPresent1 = driver.findElement(By.xpath(showtimes));
			if(elementPresent1.isDisplayed()){
				 driver.findElement(By.xpath(showtimes)).click();
		
			}
			break;
		}
		}*/

	}

}
