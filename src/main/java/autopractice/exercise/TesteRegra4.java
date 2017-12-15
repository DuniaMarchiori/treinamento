package autopractice.exercise;

import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;
import java.util.ArrayList;
import java.util.List;
import autopractice.dto.ProductDto;
import autopractice.parser.ProductParser;
import autopractice.steps.PriceRange;
import core.WebDriverRunner;
import core.steps.Delay;

@RunWith(WebDriverRunner.class)
public class TesteRegra4 {
	// Ao selecionar um price range, a lista de produtos apresentados devem possuir o pre�o dentro do range.
	
	//Retona uma lista com os pre�os de todos os produtos na p�gina de cat�logo atual
	private List<Float> productsPrices() {
		List<ProductDto> allPresentProducts = ProductParser.parseAllPresentProducts();
		List<Float> allPrices = new ArrayList<Float>();
		
		for (ProductDto product : allPresentProducts) {
			allPrices.add(product.getPrice());
		}
		return allPrices;
	}
	
	// N�o h� produto cujo pre�o � o mesmo do que algum dos limites do range
	@Test
	public void teste_semPrecoNoLimite() {

		TesteRegra1.acessarListaSummerDresses();	
		
		Float v1 = 19.52f;
		Float v2 = 29.44f;
		PriceRange.rangeBetween(v1, v2);
		Delay.of(1500);
		
		List<Float> prices = productsPrices();
		
		
		assertThat(prices, everyItem(greaterThanOrEqualTo(v1)));
		assertThat(prices, everyItem(lessThanOrEqualTo(v2)));
	}
	
	// H� produtos cujo pre�o � o mesmo que o limite inferior do range
	@Test
	public void teste_precoNoLimiteInferior() {	
		
		TesteRegra1.acessarListaSummerDresses();	
		
		Float v1 = 16.40f;
		Float v2 = 29.44f;
		PriceRange.rangeBetween(v1, v2);
		Delay.of(1500);
		
		List<Float> prices = productsPrices();
		
		assertThat(prices, everyItem(greaterThanOrEqualTo(v1)));
		assertThat(prices, everyItem(lessThanOrEqualTo(v2)));
	}
	
	// H� produtos cujo pre�o � o mesmo que o limite superior do range	
	@Test
	public void teste_precoNoLimiteSuperior() {
		
		TesteRegra1.acessarListaSummerDresses();	
		
		Float v1 = 19.52f;
		Float v2 = 30.50f;
		PriceRange.rangeBetween(v1, v2);
		Delay.of(1500);
		
		List<Float> prices = productsPrices();
		
		assertThat(prices, everyItem(greaterThanOrEqualTo(v1)));
		assertThat(prices, everyItem(lessThanOrEqualTo(v2)));
	}
	
	// Um range em que n�o h� produtos dispon�veis
	@Test
	public void teste_nenhumProduto() {
		
		TesteRegra1.acessarListaSummerDresses();	
		
		Float v1 = 16.41f;
		Float v2 = 28.97f;
		PriceRange.rangeBetween(v1, v2);
		Delay.of(1500);
		
		List<Float> prices = productsPrices();
		
		assertEquals(0, prices.size());
	}
	
	// Um range inv�lido, em que o in�cio � ap�s o fim
	/*@Test
	public void teste_rangeInvalido() {
		
		TesteRegra1.acessarListaSummerDresses();	
		
		Float v1 = 30.50f;
		Float v2 = 19.52f;
		PriceRange.rangeBetween(v1, v2);
		Delay.of(1500);
		
		List<Float> prices = productsPrices();
		
		assertEquals(0, prices.size());
	}*/

}
