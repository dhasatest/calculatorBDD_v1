package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;



import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;

import pageObjects.CalculatorHome;

public class CalculatorSteps {
	public WebDriver driver;
	public CalculatorHome cal;

	@Given("I open the calculator website")
	public void i_open_the_calculator_website() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		cal = new CalculatorHome(driver);
		driver.get("https://www.calculator.net/");

	}
	
	
	@When("I enter number1 {string}")
	public void i_enter_number1(String n1) {
		cal.clickNumberButtons(n1);
	}
	

	@When("I select {string} operation")
	public void i_select_operation(String op) {
		cal.clickOperationButton(op);
	}
	

	@When("I enter number2 {string}")
	public void i_enter_number2(String n2) {
		cal.clickNumberButtons(n2);
	}
	

	@Then("the result should be {string}")
	public void the_result_should_be(String result) {
		String resulttxt = cal.getResult();
		Assert.assertEquals(result,resulttxt.replace(" ", ""));
	}
	

	@And("Click All Clear and Close")
	public void Click_All_Clear_and_Close() {
		cal.clickAllClear();
		driver.quit();
	}

}
