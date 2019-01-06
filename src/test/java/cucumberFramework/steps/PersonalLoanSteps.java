package cucumberFramework.steps;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class PersonalLoanSteps {
	
	private WebDriver driver;

	@Before()
	public void setup() {
	System.setProperty("webdriver.chrome.driver",
				"src/test/java/cucumberFramework/resources/chromedriver");
		this.driver = new ChromeDriver();
		
//		System.setProperty("webdriver.gecko.driver",
//				"src/test/java/CucumberFramework/resources/geckodriver");
//		this.driver = new FirefoxDriver();
		this.driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
//		this.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	@Given("^Existing user with valid credentials navigates to Credible website$")
	public void existing_user_with_valid_credentials_navigates_to_Credible_website() throws Throwable {
	    this.driver.get("https://www.credible.com/");
//	    this.driver.manage().window().maximize();
		
	}

	@Given("^User clicks on personal loan button$")
	public void user_clicks_on_personal_loan_button() throws Throwable {
//		this.driver.findElement(By.xpath("//div[@data-test-id='product-card-PL']//button[@class='_3C1j52R8 _1C-qWrPQ'][contains(text(),'Get My Loan Rates')]")).click();
		this.driver.findElement(By.xpath("//div[@data-test-id='product-card-PL']//button[contains(text(),'Get My Loan Rates')]")).click();
	}

	@Given("^User clicks find my rates button$")
	public void user_clicks_find_my_rates_button() throws Throwable {
//		this.driver.findElement(By.xpath("//div[@data-test-id='product-card-PL']//button[contains(text(),'Find My Rate')]")).click();
		WebElement personalLoanCard = this.driver.findElement(By.xpath("//div[@data-test-id='product-card-PL']"));
		List<WebElement> buttons = personalLoanCard.findElements(By.tagName("button"));
		for(WebElement button : buttons)
		{
			if(button.getText().contains("Find My Rate"))
			{
				System.out.println(button.getText());
				button.click();
			}
		}
	}

	@Given("^User enters personal loan amount$")
	public void user_enters_personal_loan_amount() throws Throwable {
		this.driver.findElement(By.xpath("//input[@id='homeLoanAmount']")).sendKeys("25000");
	}

	@Given("^User enters the purpose of loan$")
	public void user_enters_the_purpose_of_loan() throws Throwable {
		waitUntilPageIsVisible("loan-purpose");
		this.driver.findElement(By.xpath("//span[contains(text(),'Home improvement')]")).click();
	}

	@Given("^User click continue button$")
	public void user_click_continue_button() throws Throwable {
		this.driver.findElement(By.xpath("//button[@type='submit']")).click();
	}

	@Given("^User enters education level$")
	public void user_enters_education_level() throws Throwable {
		waitUntilPageIsVisible("education");
		this.driver.findElement(By.xpath("//span[contains(text(),\"Bachelor's\")]")).click();
	}

	@Given("^User enters employment status$")
	public void user_enters_employment_status() throws Throwable {
		waitUntilPageIsVisible("employment");
		this.driver.findElement(By.xpath("//span[contains(text(),'Full-time employed')]")).click();
	}

	@Given("^User enters annual income$")
	public void user_enters_annual_income() throws Throwable {
		waitUntilPageIsVisible("income");
		this.driver.findElement(By.xpath("//input[@id='employment.incomeYearly']")).sendKeys("135000");
	}

	@Given("^User enters credit score$")
	public void user_enters_credit_score() throws Throwable {
		waitUntilPageIsVisible("credit");
		this.driver.findElement(By.xpath("//span[contains(text(),'Excellent (750+)')]")).click();
	}

	@Given("^User enters first name and last name$")
	public void user_enters_first_name_and_last_name() throws Throwable {
		waitUntilPageIsVisible("about-you");
		this.driver.findElement(By.xpath("//input[@placeholder='First name']")).sendKeys("Great");
		this.driver.findElement(By.xpath("//input[@placeholder='Last name']")).sendKeys("CredibleProd");
	}

	@Given("^User enters date of birth$")
	public void user_enters_date_of_birth() throws Throwable {
		waitUntilPageIsVisible("dob");
		this.driver.findElement(By.xpath("//input[@placeholder='Date of birth (MM/DD/YYYY)']")).sendKeys("01/01/1980");
	}

	@Given("^User enters home address$")
	public void user_enters_home_address() throws Throwable {
		waitUntilPageIsVisible("address");
		this.driver.findElement(By.xpath("//input[@placeholder='Address']")).sendKeys("9 Willedrob Road, Bloomington, IL");
		
		WebElement divSuggest = (new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='geosuggest__suggests-wrapper']")));
		WebElement ul = divSuggest.findElements(By.xpath(".//*")).get(0);
		List <WebElement> listItems = ul.findElements(By.tagName("li"));
		listItems.get(0).click();
//		this.driver.findElement(By.xpath("//input[@placeholder='Unit (Optional)']")).sendKeys("5");
	}

	@Given("^User enters residential status$")
	public void user_enters_residential_status() throws Throwable {
		waitUntilPageIsVisible("housing-status");
		this.driver.findElement(By.xpath("//span[contains(text(),'Rent')]")).click();
	}

	@Given("^User enters housing payment$")
	public void user_enters_housing_payment() throws Throwable {
		waitUntilPageIsVisible("monthly-housing-payment");
		this.driver.findElement(By.xpath("//input[@id='expenses.housingPayment']")).sendKeys("625");
	}

	@Given("^User enters US citizen status$")
	public void user_enters_US_citizen_status() throws Throwable {
		waitUntilPageIsVisible("citizenship");
		this.driver.findElement(By.xpath("//span[contains(text(),'Yes')]")).click();
	}

	@Given("^User enters SSN$")
	public void user_enters_SSN() throws Throwable {
		waitUntilPageIsVisible("social");
		this.driver.findElement(By.xpath("//input[@placeholder='Social security number']")).sendKeys("078233223");
	}

	@Given("^User enters phone number$")
	public void user_enters_phone_number() throws Throwable {
		waitUntilPageIsVisible("phone");
		this.driver.findElement(By.xpath("//input[@placeholder='Phone number']")).sendKeys("3091234321");
	}

	@Given("^User enters email address$")
	public void user_enters_email_address() throws Throwable {
		waitUntilPageIsVisible("email");
		this.driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys("Great0101@credible.com");
	}

	@Given("^User enters valid password$")
	public void user_enters_valid_password() throws Throwable {
		waitUntilPageIsVisible("account");
		this.driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("Passw0rd");
	}

	@Given("^User hit agree$")
	public void user_hit_agree() throws Throwable {
//		Uncomment below code if you want to submit for quote
//		this.driver.findElement(By.xpath("//button[@type='submit']")).click();
		System.out.println("user_hit_agree");
	}

	@Then("^User gets personal loan qoute$")
	public void user_gets_personal_loan_qoute() throws Throwable {
		System.out.println("VERIFY PERSONAL LOAN QUOTE");
	}

	private void waitUntilPageIsVisible(String str) {
		str = "//div[@data-test-id='"+str+"']";
		WebElement div = (new WebDriverWait(this.driver, 15)).until(ExpectedConditions.elementToBeClickable(By.xpath(str)));
	}
}
