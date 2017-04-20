package stepDefinition;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Test_Steps {
	private static WebDriver driver;

	@Given("^User is on Person Form$")
	public void user_is_on_Person_Form() throws Throwable {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		driver.get("http://localhost:8090");
	}

	@When("^User enters Name and Age$")
	public void user_enters_Name_and_Age() throws Throwable {
		WebElement nameInput = driver.findElement(By.id("nameInput"));
		WebElement ageInput = driver.findElement(By.id("ageInput"));
		WebElement submitButton = driver.findElement(By.id("submitButton"));
		
		nameInput.sendKeys("test");
		ageInput.sendKeys("30");
		submitButton.click();
	}

	@Then("^Message field about success is displayed$")
	public void message_displayed_Congratulations_You_are_old_enough_to_sign_up_for_this_site() throws Throwable {
		driver.findElement(By.id("message"));
		System.out.println("Person details submitted successfully");
		
	}
	
	@When("^User enters \"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_enters_and(String name, String age) throws Throwable {
		WebElement nameInput = driver.findElement(By.id("nameInput"));
		WebElement ageInput = driver.findElement(By.id("ageInput"));
		WebElement submitButton = driver.findElement(By.id("submitButton"));
		
		nameInput.sendKeys(name);
		ageInput.sendKeys(age);
		submitButton.click();
	}
	
	@Then("^Validation error for name is displayed$")
	public void validation_error_for_name_is_displayed() throws Throwable {
		driver.findElement(By.id("nameError"));
		
	}
	
	@Then("^Validation error for age is displayed$")
	public void validation_error_for_age_is_displayed() throws Throwable {
		driver.findElement(By.id("ageError"));
	}
	
	@After
	public void after() {
		driver.quit();
	}
	
}
