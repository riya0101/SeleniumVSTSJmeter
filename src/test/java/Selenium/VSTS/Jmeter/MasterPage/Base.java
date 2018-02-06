package Selenium.VSTS.Jmeter.MasterPage;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;

public class Base {
	
	public static WebDriver dr;
	public static Properties prop;
	
	public Base() throws IOException
	{
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\java\\Selenium\\VSTS\\Jmeter\\ObjectRepository\\ObjectRepository.properties");
	    
		prop= new Properties();
	    prop.load(fis);
	    
	    if(prop.getProperty("browser").equals("chrome"))
	    {
	    	
	    	System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\src\\test\\java\\Selenium\\VSTS\\Jmeter\\drivers\\chromedriver.exe");
	    	
	    	dr=new ChromeDriver();
	    	
	    }
	    else if (prop.getProperty("browser").equals("phantom"))
	    {
	    	System.setProperty("phantomjs.binary.path",System.getProperty("user.dir")+"src\\test\\java\\Selenium\\VSTS\\Jmeter\\drivers\\phantomjs.exe" );		
            dr= new PhantomJSDriver();
	    }
	    else
	    {
	    	  WebDriver driver = new HtmlUnitDriver();
	    }
	    
	     dr.manage().window().maximize();
		 
		 dr.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	    
	    dr.get("http://newtours.demoaut.com/");
		
	}
	
	public static void sendKeys_textbox(String xpathKey,String texttoSend)
	{
		
		dr.findElement(By.xpath(prop.getProperty(xpathKey))).sendKeys(prop.getProperty(texttoSend));
	}
	
	
	public static void click_button(String click_button)
	{
		dr.findElement(By.xpath(prop.getProperty(click_button))).click();

		
	}
	
	public static void close_browser()
	{
		dr.quit();
	}
	

}
