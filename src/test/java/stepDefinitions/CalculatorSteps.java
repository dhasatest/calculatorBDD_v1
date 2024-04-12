package stepDefinitions;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;
import pageObjects.CalculatorHome;



public class CalculatorSteps extends BaseClass {
	public CalculatorHome cal;
	public  Logger log;
	
	@Given("I open the calculator website")
	public void i_open_the_calculator_website() {
		log = Logger.getLogger("Calculator");
		PropertyConfigurator.configure("log4j.properties");
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		cal = new CalculatorHome(driver);
		
		log.info("Opening Calculator application.. " + baseUrl);
		driver.get(baseUrl);

	}
	
	
	@When("I enter number1 {string}")
	public void i_enter_number1(String n1) {
		cal.clickNumberButtons(n1);
	}
	

	@When("I select {string} operation")
	public void i_select_operation(String op) {
		
		if(op.equals("+")||op.equals("-") || op.equals("/") || op.equals("*") ) {
			cal.clickOperationButton(op);
		}else {
			log.error("Invalid operator: " + op + ", Wrong input data");
			driver.close();
			Assert.assertFalse("Invalid operator: " + op + ", Wrong input data", true);		
		}
		
		
	}
	

	@When("I enter number2 {string}")
	public void i_enter_number2(String n2) {
		cal.clickNumberButtons(n2);
	}
	

	@Then("the result should be {string}")
	public void the_result_should_be(String result) {
		String resulttxt = cal.getResult();
		log.info("Validating the result " +resulttxt);
		Assert.assertEquals(result,resulttxt.replace(" ", ""));		
	}
	

	@And("Click All Clear and Close")
	public void Click_All_Clear_and_Close() {
		cal.clickAllClear();
		log.info("Closing the browser...");
		driver.quit();
	}

}
