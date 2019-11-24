package steps;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.net.MalformedURLException;

import core.DriverFactory;
import io.cucumber.java8.Pt;
import page.ShoppingAutomationPage;

public class ShoppingAutomationSteps implements Pt {
	
	private ShoppingAutomationPage page = new ShoppingAutomationPage();
	
	String residentialAddressZipCode = "14056550";
	String invalidProduct = "%$#@!";

	public ShoppingAutomationSteps() throws MalformedURLException {

		Dado("que acesso a pagina de compras", () -> {
			DriverFactory.navigateToSite();
			page.waitHeaderShopping();
			assertTrue(page.isBrowserAtShopping());
		});

		Dado("seleciono um produto", () -> {
			assertTrue(page.menuAllDepartmentsIsDisplayed());
			assertEquals("Todos os departamentos", page.getTextMenuAllDepartments());
			page.clickMenuAllDepartments();

			page.waitElementMenuSports();
			assertEquals("Esporte e Lazer", page.getTextMenuSports());
			page.clickMenuSports();

			assertTrue(page.isBrowserAtShoppingPageSports());
			page.waitHeaderSports();
			assertEquals("Esporte e Lazer", page.getHeaderPageSports());

			assertEquals("Bicicletas", page.getTextMenuBicycles());
			page.clickMenuBicycles();

			page.waitHeaderBicycles();
			assertEquals("Bicicletas", page.getHeaderPageBicycles());
			assertTrue(page.isBrowserAtShoppingPageBicycles());
			assertTrue(page.selectOrderByIsDisplayed());
			page.setOrderBy();
			page.clickItemShopping();

			assertEquals("Cor:", page.getTextLabelColor());
			assertTrue(page.spanPriceIsDisplayed());

			assertEquals("Consultar prazo e valor do frete", page.getTextLabelFreight());
			assertEquals("Não sei o CEP", page.getTextLinkLostZipCode());
			assertTrue(page.inputZipCodeIsDisplayed());
			assertTrue(page.buttonOkIsDisplayed());
			page.setZipCode(residentialAddressZipCode);

			assertAll("Verifica se os dados da entrega são mostrados", 
					() -> assertTrue(page.getZipCodeIsDisplayed()),
					() -> assertTrue(page.getFreightAddressIsDisplayed()),
					() -> assertTrue(page.getDeliveryTypeIsDisplayed()),
					() -> assertTrue(page.getFreightDaysIsDisplayed()), 
					() -> assertTrue(page.getFreightIsDisplayed()));

			assertEquals(
					"* O prazo de entrega inicia-se no 1º dia útil após a confirmação do pagamento. "
							+ "Informações referentes apenas para 01 unidade deste item.",
					page.getTextDefaultFreight());

		});

		Quando("adiciono o produto na sacola", () -> {
			assertEquals("Adicionar à sacola", page.getTextAddToCart());
			assertTrue(page.buttonAddToCartIsDisplayed());
			page.clickBuyItem();
		});

		Entao("sou direcionado para o carrinho", () -> {
			assertTrue(page.isBrowserAtShoppingPageCart());
			page.waitHeaderCart();

			assertAll("Verifica se o item é mostrado no carrinho", 
					() -> assertTrue(page.getTextPriceIsDisplayed()),
					() -> assertTrue(page.getTextAmountIsDisplayed()),
					() -> assertTrue(page.getProductAmountIsDisplayed()),
					() -> assertTrue(page.imgItemCartIsDisplayed()),
					() -> assertTrue(page.getTextItemIsDisplayed()),
					() -> assertTrue(page.getTextProductCodeIsDisplayed()),
					() -> assertTrue(page.getTextSoldAndDeliveredByIsDisplayed()),
					() -> assertTrue(page.getTextItemProductDeliveryIsDisplayed()),
					() -> assertTrue(page.getTextProductPriceIsDisplayed()));
			
		});

		Quando("realizo a busca de um produto inválido", () -> {
			assertTrue(page.inputSearchIsDisplayed());
			assertTrue(page.iconSearchIsDisplayed());
			
			page.setSearchInvalidProduct(invalidProduct);
		});

		Entao("aparece uma mensagem de busca inválida", () -> {
			assertTrue(page.getMessageSearchInvalidProductIsDisplayed());
		});
	}
}
