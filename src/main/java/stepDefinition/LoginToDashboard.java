package stepDefinition;
import java.time.Duration;
 
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
 
public class LoginToDashboard {
	static WebDriver driver;
	@Given("User login page")
	public void user_on_login_page() {
	    // Write code here that turns the phrase above into concrete actions
	    driver = new ChromeDriver();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	    driver.get("https://ctmvalidation.cliniops.com/login");
	}
 
	@When("User entering valid username and password")
	public void user_enters_valid_username_and_password() {
	    // Write code here that turns the phrase above into concrete actions
	    driver.findElement(By.id("tmp_name")).sendKeys("sc");
	    driver.findElement(By.id("tmp_pwd")).sendKeys("Clini123#");
	}
 
	@And("Click login button")
	public void click_on_login_button() {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.id("authenticate")).click();
	}
 
	@Then("User is navigated to Dashboard page2")
	public void user_is_navigated_to_dashboard_page2() {
	//Write code here that turns the phrase above into concrete actions
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//html/body/div[1]"))); 
	}
 
	
	@Then("Click on the desired URL on dashboard page2")
	public void click_desiredURL_dashboardpage2() {
	//Write code here that turns the phrase above into concrete actions
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//td[@id='panelCell-1']//span[1]"))); 
    driver.close();
	}
}