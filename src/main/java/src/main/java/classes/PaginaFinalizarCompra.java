package src.main.java.classes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PaginaFinalizarCompra {
	private WebDriver driver;

	public void finalizarCompra() {

		driver.findElement(By.id("suggestion-search")).click();

		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btn-finalize-cart")));

		driver.findElement(By.xpath("//*[@class='buy-button finish-btn btn btn-success']")).click();

	}

	public PaginaFinalizarCompra(WebDriver driver) {
		this.driver = driver;
	}
}
