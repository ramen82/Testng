package stepDefinition;
 
import java.time.Duration;
 
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
 
public class LoginFeatureTset {
	static WebDriver driver;
	@Given("User is on the login page")
	public void user_is_on_the_login_page() {
	    // Write code here that turns the phrase above into concrete actions
	    driver = new ChromeDriver();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	    driver.get("https://ctmvalidation.cliniops.com/login");
	}
 
	@When("User enters valid username and password")
	public void user_enters_valid_username_and_password() {
	    // Write code here that turns the phrase above into concrete actions
	    driver.findElement(By.id("tmp_name")).sendKeys("sc");
	    driver.findElement(By.id("tmp_pwd")).sendKeys("Clini123#");
	}
 
	@And("Click on login button")
	public void click_on_login_button() {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.id("authenticate")).click();
	}
	
	@Then("User is navigated to Dashboard page1")
	public void user_is_navigated_to_dashboard_page1() {
	//Write code here that turns the phrase above into concrete actions
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//html/body/div[1]"))); 
	}
 
	
	@And("Click on the desired URL on dashboard page1")
	public void click_desiredURL_dashboardpage1() {
		
	//Write code here that turns the phrase above into concrete actions
	WebElement loginUrl1 = driver.findElement(By.xpath("//*[@id=\"CliniOps\"]/div[2]"));
	loginUrl1.click();
    driver.get("https://validation.cliniops.com/investigator");
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	
	@Then("Go to the Actual Portal")
	public void Go_to_actualportal() {
	//Write code here that turns the phrase above into concrete actions
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"navbarSupportedContent\"]/ul/li[1]/a"))); 
	}
	
	@Then("Go to the Configure Tab")
	public void Go_to_configuretab() {
	//Write code here that turns the phrase above into concrete actions
	driver.get("https://validation.cliniops.com/investigator/configurestudy/general/");
	WebElement loginButton = driver.findElement(By.xpath("//*[@id='navbarSupportedContent']/ul/li[2]/a/img"));
	loginButton.click();
	}
	
	/* @Then("Click on the Advance setting button")
	 * public void clickOnAdvanceSettingButton() {
	    try {
	        String buttonText = "Advanced Settings";
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	        // Scroll the page until the button is visible
	        JavascriptExecutor js = (JavascriptExecutor) driver;
	        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");

	        // Wait for the button to become clickable (adjust timeout as needed)
	        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(String.format("//button[normalize-space()='%s']", buttonText))));
	        button.click();

	        // Add logging if needed
	        System.out.println("Clicked on Advanced Settings button");
	    } catch (Exception e) {
	        // Handle exception appropriately
	        System.err.println("Failed to click on Advanced Settings button: " + e.getMessage());
	        // Consider rethrowing or reporting the error based on your testing framework
	    }
	}*/
	
	@Then("Click on the Advance setting button")
	public void clickOnAdvanceSettingButton() {
	    try {
	        String buttonText = "Advanced Settings";
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(500));
	        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(String.format("//button[normalize-space()='%s']", buttonText))));
	        button.click();
	        //log.info("Clicked on Advanced Settings button");
	    } catch (Exception e) {
	        //log.error("Failed to click on Advanced Settings button:", e);
	        //throw e; // Rethrow to propagate the failure
	    }
	}
	
	/*@Then("Setting pop-up opened")
	public void verifySettingPopupOpened() {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));

	    // Check for a specific element within the popup (replace with your actual locator)
	    WebElement popupElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"your-popup-element-id\"]")));

	    // Add more assertions if needed (e.g., checking text content, buttons, etc.)
	    Assert.assertTrue(popupElement.getText().contains("Expected text in popup"));

	    // Handle potential errors
	}*/
	
	@Then("Setting pop-up opened")
	public void Setting_popup_opened() {
	//Write code here that turns the phrase above into concrete actions
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"studyParamsForm\"]/div/div[1]"))); 
	}
	
	@And("Close the browser")
	public void close_the_browser() {
	    // Write code here that turns the phrase above into concrete actions
	    driver.close();
	}
}