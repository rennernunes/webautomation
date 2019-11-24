package page;

import java.net.MalformedURLException;
import java.util.function.BooleanSupplier;

import org.openqa.selenium.By;

import core.BasePage;

public class ShoppingAutomationPage extends BasePage {
	public ShoppingAutomationPage() throws MalformedURLException {
	}

	String xpathMenuAllDepartments = "//span[contains(.,'Todos os departamentos')]";
	String xpathMenuSports = "//a[contains(.,'Esporte e Lazer')]";
	String xpathMenuBicycles = "//a[contains(.,'Bicicletas')]";
	String xpathZipCode = "//input[contains(@aria-label,'cep')]";
	String xpathButtonOk = "//button[contains(@aria-label,'calcular cep')]";
	String xpathButtonBuy = "(//button[contains(.,'Adicionar à sacola')])[1]";

	// region home page

	public void waitHeaderShopping() {
		waitPresenceElement(By.xpath("//h1[contains(@class,'sprite-top-footer header-logo')]"));
	}

	public boolean isBrowserAtShopping() throws MalformedURLException {
		waitTime(3000);
		return getCurrentUrl().contains("https://www.magazineluiza.com.br/");
	}

	public boolean menuAllDepartmentsIsDisplayed() throws MalformedURLException {
		return getIsDisplayed(By.xpath(xpathMenuAllDepartments));
	}

	public String getTextMenuAllDepartments() throws MalformedURLException {
		return getTextElement(By.xpath(xpathMenuAllDepartments));
	}

	public void clickMenuAllDepartments() throws MalformedURLException {
		clickItem(By.xpath(xpathMenuAllDepartments));
	}

	// endregion

	// region dropdown menu

	public void waitElementMenuSports() throws MalformedURLException {
		waitPresenceElement(By.xpath(xpathMenuSports));
	}

	public String getTextMenuSports() throws MalformedURLException {
		return getTextElement(By.xpath(xpathMenuSports));
	}

	public void clickMenuSports() throws MalformedURLException {
		clickItem(By.xpath(xpathMenuSports));
	}

	// endregion

	// region sports page

	public boolean isBrowserAtShoppingPageSports() throws MalformedURLException {
		waitTime(1000);
		return getCurrentUrl().contains("/esporte-e-lazer/l/es/");
	}

	public void waitHeaderSports() {
		waitPresenceElement(By.xpath("//h1[contains(.,'Esporte e Lazer')]"));
	}

	public String getHeaderPageSports() throws MalformedURLException {
		return getTextElement(By.xpath("//h1[contains(.,'Esporte e Lazer')]"));
	}

	public String getTextMenuBicycles() throws MalformedURLException {
		return getTextElement(By.xpath(xpathMenuBicycles));
	}

	public void clickMenuBicycles() throws MalformedURLException {
		clickItem(By.xpath(xpathMenuBicycles));
	}

	// endregion

	// region bicycles page

	public boolean isBrowserAtShoppingPageBicycles() throws MalformedURLException {
		waitTime(1000);
		return getCurrentUrl().contains("/esporte-e-lazer/s/es/bclt/");
	}

	public String getHeaderPageBicycles() throws MalformedURLException {
		return getTextElement(By.xpath("//h1[contains(.,'Bicicletas')]"));
	}

	public void waitHeaderBicycles() {
		waitPresenceElement(By.xpath("//h1[contains(.,'Bicicletas')]"));
	}

	public boolean selectOrderByIsDisplayed() throws MalformedURLException {
		return getIsDisplayed(By.id("sort"));
	}

	public void setOrderBy() throws MalformedURLException {
		clickItem(By.xpath("//select[@id='sort']"));
		waitTime(1000);
		clickSelectSearch(By.xpath("//select[@id='sort']//option[contains(.,'Maior Preço')]"));
	}

	public void clickItemShopping() throws MalformedURLException {
		waitTime(3000);
		clickItem(By.xpath(
				"(//h3[starts-with(.,'Bicicleta Colli GPD 220 Aro 26 Aero 21 Marchas F a Disco Diant. e Tras. e Dupla Suspensão - 220')])[1]"));
	}

	// endregion

	// region item page

	public String getTextLabelColor() throws MalformedURLException {
		return getTextElement(By.xpath("//label[contains(.,'Cor:')]"));
	}

	public boolean spanPriceIsDisplayed() throws MalformedURLException {
		return getIsDisplayed(By.xpath("//span[contains(@class,'price-template__text')]"));
	}

	public String getTextLabelFreight() throws MalformedURLException {
		return getTextElement(By.xpath("//span[contains(.,'Consultar prazo e valor do frete')]"));
	}

	public String getTextLinkLostZipCode() throws MalformedURLException {
		return getTextElement(By.xpath("//a[contains(.,'Não sei o CEP')]"));
	}

	public boolean inputZipCodeIsDisplayed() throws MalformedURLException {
		return getIsDisplayed(By.xpath(xpathZipCode));
	}

	public boolean buttonOkIsDisplayed() throws MalformedURLException {
		return getIsDisplayed(By.xpath(xpathButtonOk));
	}

	public void setZipCode(String residentialAddressZipCode) throws MalformedURLException {
		setTextFieldKeyHome(By.xpath(xpathZipCode), residentialAddressZipCode);
		clickButton(By.xpath(xpathButtonOk));
		waitTime(2000);
	}

	public boolean getZipCodeIsDisplayed() throws MalformedURLException {
		return getIsDisplayed(By.xpath("(//span[contains(@class,'freight-product__zipcode js-freight-zipcode')])[2]"));
	}

	public boolean getFreightAddressIsDisplayed() throws MalformedURLException {
		return getIsDisplayed(By.xpath("(//p[contains(@class,'freight-text-info js-freight-address')])[2]"));
	}

	public boolean getDeliveryTypeIsDisplayed() throws MalformedURLException {
		return getIsDisplayed(By.xpath("(//span[contains(.,'Entrega padrão')])[2]"));
	}

	public boolean getFreightDaysIsDisplayed() throws MalformedURLException {
		return getIsDisplayed(By.xpath("(//span[contains(@class,'box-item-delivery-days-text')])[2]"));
	}

	public boolean getFreightIsDisplayed() throws MalformedURLException {
		return getIsDisplayed(By.xpath("(//span[@class='js-freight-price'])[2]"));
	}

	public String getTextDefaultFreight() throws MalformedURLException {
		return getTextElement(By.xpath("(//p[contains(@class,'freight-product__freight-text-info')])[4]"));
	}

	public String getTextAddToCart() throws MalformedURLException {
		return getTextElement(By.xpath("(//span[contains(.,'Adicionar à sacola')])[1]"));
	}

	public boolean buttonAddToCartIsDisplayed() throws MalformedURLException {
		return getIsDisplayed(By.xpath(xpathButtonBuy));

	}

	public void clickBuyItem() throws MalformedURLException {
		clickItem(By.xpath(xpathButtonBuy));
	}

	// endregion

	// region item page

	public boolean isBrowserAtShoppingPageCart() throws MalformedURLException {
		waitTime(2000);
		return getCurrentUrl().contains("https://sacola.magazineluiza.com.br/#/");
	}

	public void waitHeaderCart() throws MalformedURLException {
		waitPresenceElement(By.xpath("//div[@class='BasketTable-header-product'][contains(.,'Sacola')]"));
	}

	public boolean getTextPriceIsDisplayed() throws MalformedURLException {
		return getIsDisplayed(By.xpath("//div[@class='BasketTable-header-price'][contains(.,'Preço')]"));
	}

	public boolean getTextAmountIsDisplayed() throws MalformedURLException {
		return getIsDisplayed(By.xpath("//div[@class='BasketTable-header-quantity'][contains(.,'Quantidade')]"));
	}

	public boolean getProductAmountIsDisplayed() throws MalformedURLException {
		return getIsDisplayed(By.xpath("//select[contains(@class,'BasketItem-product-quantity-dropdown')]"));
	}

	public boolean imgItemCartIsDisplayed() throws MalformedURLException {
		return getIsDisplayed(By.xpath(
				"//img[@src='https://a-static.mlcdn.com.br/102x76/bicicleta-colli-gpd-220-aro-26-aero-21-marchas-f-a-disco-diant-e-tras-e-dupla-suspensao-220/ciamobshop/220-14d/0c9d131838e48197eadce02143d0354f.jpg']"));
	}

	public boolean getTextItemIsDisplayed() throws MalformedURLException {
		return getIsDisplayed(By.xpath(
				"//span[contains(.,'Bicicleta Colli GPD 220 Aro 26 Aero 21 Marchas F a Disco Diant. e Tras. e Dupla Suspensão - 220 -   - Verde Militar')]"));
	}

	public boolean getTextProductCodeIsDisplayed() throws MalformedURLException {
		return getIsDisplayed(By.xpath("//span[contains(@class,'BasketItem-product-info-sku')]"));
	}

	public boolean getTextSoldAndDeliveredByIsDisplayed() throws MalformedURLException {
		return getIsDisplayed(By.xpath("//div[contains(@class,'SoldAndDeliveredBy')]"));
	}

	public boolean getTextItemProductDeliveryIsDisplayed() throws MalformedURLException {
		return getIsDisplayed(By.xpath("//span[contains(@class,'BasketItem-product-delivery-message')]"));
	}

	public boolean getTextProductPriceIsDisplayed() throws MalformedURLException {
		return getIsDisplayed(By.xpath("//div[contains(@class,'BasketItem-product-price')]"));
	}

	// endregion

	// region invalid serch

	public boolean inputSearchIsDisplayed() throws MalformedURLException {
		return getIsDisplayed(By.id("inpHeaderSearch"));
	}

	public boolean iconSearchIsDisplayed() throws MalformedURLException {
		return getIsDisplayed(By.xpath("//span[@id='btnHeaderSearch']"));
	}

	public void setSearchInvalidProduct(String invalidProduct) throws MalformedURLException {
		setText(By.id("inpHeaderSearch"), invalidProduct);
		clickItem(By.xpath("//span[@id='btnHeaderSearch']"));
	}

	public boolean getMessageSearchInvalidProductIsDisplayed() throws MalformedURLException {
		return getIsDisplayed(By.xpath("//div[contains(@class,'nm-not-found-message1')]"));
	}

	// endregion

}
