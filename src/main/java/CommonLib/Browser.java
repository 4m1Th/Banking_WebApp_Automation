package CommonLib;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Browser {
	
	public WebDriver driver;
//	public RemoteWebDriver driver = null;
//	   String username = "time2stdy";
//		String accessKey = "1VWCmohbzGFRFhg34Yn3YXtMFaHIBiIBcqWsqeOh6AptGrCHoF";
	public void web(String url) {
		
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.navigate().to(url);
		driver.manage().window().maximize();
//        DesiredCapabilities capabilities = new DesiredCapabilities();
//        capabilities.setCapability("platform", "Windows 10");
//	     capabilities.setCapability("browserName", "Chrome");
//	     capabilities.setCapability("version", "92.0"); // If this cap isn't specified, it will just get the any available one
//        capabilities.setCapability("resolution","1024x768");
//        capabilities.setCapability("build", "First Test");
//        capabilities.setCapability("name", "Sample Test");
//        capabilities.setCapability("network", true); // To enable network logs
//        capabilities.setCapability("visual", true); // To enable step by step screenshot
//        capabilities.setCapability("video", true); // To enable video recording
//        capabilities.setCapability("console", true); // To capture console logs
    
//        try {       
//			driver= new RemoteWebDriver(new URL("https://"+username+":"+accessKey+"@hub.lambdatest.com/wd/hub"), capabilities);            
//        } catch (MalformedURLException e) {
//            System.out.println("Invalid grid URL");
//        }
//		
	}

}
