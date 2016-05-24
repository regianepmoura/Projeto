package src.main.java.classes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PaginaProduto {
	private WebDriver driver;

	public void adicionarCarrinho() {

		/* Clica em Adicionar Carrinho */
		driver.findElement(By.xpath("//*[@class='buy-button btn btn-success']")).click();

		/* Clica para continuar - Modal Garantia */
		driver.findElement(By.id("navegaCarrinho")).click();
		driver.findElement(By.cssSelector("span.cart-icon")).click();

	}

	public PaginaProduto(WebDriver driver) {
		this.driver = driver;
	}
}
