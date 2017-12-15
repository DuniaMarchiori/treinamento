package autopractice.exercise;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebElement;
import static org.junit.Assert.*;
import autopractice.pageobject.ProductList;
import core.WebDriverManager;
import core.WebDriverRunner;

@RunWith(WebDriverRunner.class)
public class TesteRegra2 {
	// Quando um item est� selecionado para compara��o o link ADD TO COMPARE deve possuir o s�mbolo "-".
	
	@Test
	public void teste_produtoAdicionadoAoCompare() {
		//Um produto no cat�logo � adiciona ao Compare
		TesteRegra1.acessarListaSummerDresses();	
		WebDriverManager.waitVisibleElement(ProductList.product(1).byButtonAddToCompare()).click();
		WebElement remove = WebDriverManager.waitPresenceElement(ProductList.product(1).byButtonRemoveToCompare());
		assertNotNull(remove);
	}
	
	@Test
	public void teste_produtoRemovidoDoCompare() {
		//Um produto no cat�logo � adiciona ao Compare e depois removido
		
		TesteRegra1.acessarListaSummerDresses();	
		WebDriverManager.waitVisibleElement(ProductList.product(1).byButtonAddToCompare()).click();
		WebDriverManager.waitPresenceElement(ProductList.product(1).byButtonRemoveToCompare());	
		
		// Remove o produto do Compare
		WebDriverManager.waitVisibleElement(ProductList.product(1).byButtonRemoveToCompare()).click();
		WebElement add = WebDriverManager.waitPresenceElement(ProductList.product(1).byButtonAddToCompare());	
		
		assertNotNull(add);
	}

}
