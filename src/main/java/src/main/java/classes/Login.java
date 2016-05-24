package src.main.java.classes;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login {
	private WebDriver driver;

	public void realizarLogin() {

		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

		driver.findElement(By.id("btn-sign-up")).click();
	}

	public Login(WebDriver driver) {
		this.driver = driver;
	}
}
