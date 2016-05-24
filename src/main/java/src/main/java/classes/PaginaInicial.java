package src.main.java.classes;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PaginaInicial {
	private String baseURL;
	private WebDriver driver;

	public PaginaInicial(WebDriver driver) {
		this.driver = driver;
	}

	public void abre() {
		baseURL = "http://www.walmart.com.br";
		driver.get(baseURL);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

	}

	public void pesquisaProduto() {
		driver.findElement(By.id("suggestion-search")).click();
		driver.findElement(By.id("suggestion-search")).clear();
		driver.findElement(By.id("suggestion-search")).sendKeys("TV");
		driver.findElement(By.cssSelector("button.search-icon")).click();
	}

	public void selecionaProduto() {
		Boolean isPresent = driver.findElements(By.id("category-products")).size() > 0;
		if (isPresent) {
			/* Clica no produto */
			driver.findElement(By
					.xpath("//img[contains(@src,'//static.wmobjects.com.br/imgres/arquivos/ids/4289414-220-220/smart-tv-led-32--samsung-32j4300-com-conversor-digital-2-hdmi-1-usb-wi-fi-integrado.jpg')]"))
					.click();

		}
	}

}
