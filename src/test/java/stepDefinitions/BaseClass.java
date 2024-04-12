package stepDefinitions;
import org.openqa.selenium.WebDriver;
import utilities.ReadConfig;

public class BaseClass {
	
	ReadConfig readconfig = new ReadConfig();	
	public String baseUrl = readconfig.getApplicationUrl();	
	public WebDriver driver;
			
	
}
