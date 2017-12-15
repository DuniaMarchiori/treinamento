package autopractice.exercise;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebElement;
import static org.junit.Assert.*;
import autopractice.pageobject.ProductList;
import core.WebDriverManager;
import core.WebDriverRunner;

@RunWith(WebDriverRunner.class)
public class TesteRegra7 {
	// Os �ltimos dois produtos visualizados devem ser listados por ordem inversa de visita em VIEWED PRODUCTS
	
	@Test
	public void teste_nenhumProdutoVisualizado() {
		// Nenhum produto foi visualizado. A lista de VIEWED PRODUCTS deve estar vazia
		TesteRegra1.acessarListaSummerDresses();	
		
	}
	
	@Test
	public void teste_umProdutoVisualizado() {
		// Um produto foi visualizado. A lista de VIEWED PRODUCTS deve mostr�-lo
		TesteRegra1.acessarListaSummerDresses();	
		
	}
	
	@Test
	public void teste_tresProdutosVisualizados() {
		// Tr�s produtos foram visualizados. A lista de VIEWED PRODUCTS deve mostrar os dois �ltimos.
		TesteRegra1.acessarListaSummerDresses();	
		
	}
}
