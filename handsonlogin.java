package ShrinivasProj;

import java.util.concurrent.TimeUnit;

import javax.swing.text.html.MinimalHTMLWriter;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class handsonlogin {
	WebDriver driver;
	@Given("navigate to home page")
	public void navigate_to_home_page() {
		System.setProperty("webdriver.chrome.driver","C:\\sele\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://10.232.237.143:443/TestMeApp/login.htm");
	}
	@When("user enters {word} as username")
	public void user_enters_lalitha_as_username(String uname) {
		driver.findElement(By.id("userName")).sendKeys(uname);
	}
	@When("user enters {word} as password")
	public void user_enters_Password_as_password(String pwd) {
		driver.findElement(By.id("password")).sendKeys(pwd);
	}
	@Then("User login successful")
	public void user_login_successful() throws InterruptedException {
		driver.findElement(By.cssSelector("input[value='Login']")).click();
		//driver.wait(5);;
		//driver.manage().timeouts().implicitlyWait(500,MilliSeconds);
		String a= driver.getTitle();
		//System.out.println(a);
		Assert.assertEquals("Home", a);
	}
}
