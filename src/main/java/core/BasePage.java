package core;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

import static core.DriverFactory.getDriver;
import static core.LocalProperties.WAIT_TIME_IN_SECONDS;
import static core.MessagesLog.RESULTS_FOUND;

/**
 * A classe BasePage encapsula atributos e métodos do framework Selenium, como campos e ações que
 * serão aplicadas em cada pagina (Page)
 */
public abstract class BasePage {

  /**
   * Define o tempo de espera para os métodos que utilizam a instancia do WebDriverWait.
   */
  private WebDriverWait wait = new WebDriverWait(getDriver(), WAIT_TIME_IN_SECONDS);

  /**
   * API de Logging log4j usado para registrar logs
   *
   */
  private static Logger logger = LogManager.getLogger(BasePage.class);

  public BasePage() throws MalformedURLException {
  }

  // region Wait

  /**
   * Aguarda um determinado tempo antes de prosseguir com a próxima instrução
   *
   * @param milliSeconds tempo em milisegundos
   */
  public void waitTime(Integer milliSeconds) {
    try {
      logger.info(MessagesLog.IMPLICIT_WAIT);
      TimeUnit.MILLISECONDS.sleep(milliSeconds);
    } catch (InterruptedException e) {
      logger.error(e);
    }
  }

  /**
   * Verificar se um elemento está presente na página localizado pela propriedade by do selenium.
   *
   * @param by elemento estático da classe WebElement
   */
  public void waitPresenceElement(By by) {
    logger.info(MessagesLog.EXPLICIT_WAIT);
    wait.until(ExpectedConditions.presenceOfElementLocated(by));
  }

  /**
   * Aguarda até que um elemento seja visível e clicável localizado pela propriedade by do selenium.
   *
   * @param by elemento estático da classe WebElement
   */
  public void waitElementClickable(By by) {
    logger.info(MessagesLog.EXPLICIT_WAIT);
    wait.until(ExpectedConditions.elementToBeClickable(by));
  }

  /**
   * Aguarda até que um elemento seja selecionável localizado pela propriedade by do selenium.
   *
   * @param by elemento estático da classe WebElement
   */
  public void waitElementToBeSelected(By by) {
    logger.info(MessagesLog.EXPLICIT_WAIT);
    wait.until(ExpectedConditions.elementToBeSelected(by));
  }

  /**
   * Aguarda até que o elemento surja na página localizado pela propriedade by do selenium.
   *
   * @param by elemento estático da classe WebElement
   */
  public void waitElement(By by) {
    logger.info(MessagesLog.EXPLICIT_WAIT);
    wait.until(ExpectedConditions.visibilityOfElementLocated(by));
  }

  /**
   * Aguarda até que todos os elementos estejam visíveis.
   */
  public void waitElementVisible() {
    logger.info(MessagesLog.EXPLICIT_WAIT);
    wait.until(ExpectedConditions.visibilityOfAllElements());
  }

  /**
   * Aguarda até que o elemento esteja visível localizado pela propriedade id do selenium.
   *
   * @param by elemento estático da classe WebElement
   */
  public void waitElement(String by) {
    logger.info(MessagesLog.EXPLICIT_WAIT);
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(by)));
  }

  /**
   * Verifica se um elemento é invisível ou não está presente localizado pela propriedade by do
   * selenium.
   *
   * @param by elemento estático da classe WebElement
   */
  public void waitInvisibleElement(By by) {
    logger.info(MessagesLog.EXPLICIT_WAIT);
    wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
  }

  /**
   * Verifica se um elemento é invisível ou não está presente localizado pela propriedade id do
   * selenium.
   *
   * @param by elemento estático da classe WebElement
   */
  public void waitInvisibleElement(String by) {
    logger.info(MessagesLog.EXPLICIT_WAIT);
    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id(by)));
  }

  // endregion

  /**
   * Pressiona o botão Enter(Return), em um campo de texto que aceite definir um valor localizado
   * pela propriedade by do selenium.
   *
   * @param by elemento estático da classe WebElement
   * @throws MalformedURLException quando a URL informada não é válida
   */
  public void pressReturnKey(By by) throws MalformedURLException {
    logger.info(MessagesLog.SEND_KEYS_ON_AN_ELEMENT);
    getDriver().findElement(by).sendKeys(Keys.RETURN);
  }

  // region TextField e TextArea

  /**
   * Digita em um elemento sem limpar previamente, que aceite definir um valor localizado pela
   * propriedade by do selenium.
   *
   * @param by elemento estático da classe WebElement
   * @param text texto a ser inserido no elemento input
   * @throws MalformedURLException quando a URL informada não é válida
   */
  public void setTextWithoutClear(By by, String text) throws MalformedURLException {
    logger.info(MessagesLog.SEND_KEYS_ON_AN_ELEMENT);
    getDriver().findElement(by).sendKeys(text);
  }

  /**
   * Digita em um elemento com mascara formatada movendo o ponteiro para o começo sem limpar
   * previamente, que aceite definir um valor localizado pela propriedade by do selenium.
   *
   * @param by elemento estático da classe WebElement
   * @param text texto a ser inserido no elemento input
   * @throws MalformedURLException quando a URL informada não é válida
   */

  public void setTextFieldKeyHome(By by, String text) throws MalformedURLException {
    logger.info(MessagesLog.SEND_KEYS_ON_AN_ELEMENT);
    getDriver().findElement(by).sendKeys(Keys.HOME + text);
  }

  /**
   * Digita em um elemento com mascara formatada pressionando enter sem limpar previamente, que
   * aceite definir um valor localizado pela propriedade by do selenium.
   *
   * @param by elemento estático da classe WebElement
   * @param text texto a ser inserido no elemento input
   * @throws MalformedURLException quando a URL informada não é válida
   */

  public void setTextFieldKeyReturn(By by, String text) throws MalformedURLException {
    logger.info(MessagesLog.SEND_KEYS_ON_AN_ELEMENT);
    getDriver().findElement(by).sendKeys(text + Keys.RETURN);
  }

  /**
   * Limpa e digita em um elemento, que aceite definir um valor localizado pela propriedade by do
   * selenium.
   *
   * @param by elemento estático da classe WebElement
   * @param text texto a ser inserido no elemento input
   * @throws MalformedURLException quando a URL informada não é válida
   */
  public void setText(By by, String text) throws MalformedURLException {
    logger.info(MessagesLog.SEND_KEYS_ON_AN_ELEMENT);
    getDriver().findElement(by).clear();
    getDriver().findElement(by).sendKeys(text);
  }

  /**
   * Limpa e digita em um elemento, que aceite definir um valor localizado pela propriedade Id do
   * selenium.
   *
   * @param by elemento estático da classe WebElement
   * @param text texto a ser inserido no elemento input
   * @throws MalformedURLException quando a URL informada não é válida
   */
  public void setText(String by, String text) throws MalformedURLException {
    logger.info(MessagesLog.SEND_KEYS_ON_AN_ELEMENT);
    getDriver().findElement(By.id(by)).clear();
    getDriver().findElement(By.id(by)).sendKeys(text);
  }

  /**
   * @param regex expressão regular que corresponde a uma determinada sequencia
   * @param replacement sequencia a ser substituída
   *
   * @return sequência de resultados após substituir toda a ocorrência de 'regex' correspondente por
   *         'substring'
   */
  public String replaceAll(String regex, String replacement) {
    return Pattern.compile(regex).matcher((CharSequence) this).replaceAll(replacement);
  }

  /**
   * Retorna valor do atributo do elemento localizado pela propriedade Id do selenium.
   *
   * @param by elemento estático da classe WebElement
   * @throws MalformedURLException quando a URL informada não é válida
   * @return o valor do atributo
   */
  public String getTextField(String by) throws MalformedURLException {
    return getTextField(By.id(by));
  }

  /**
   * Retorna valor do atributo do elemento localizado pela propriedade by do selenium.
   *
   * @param by elemento estático da classe WebElement
   * @throws MalformedURLException quando a URL informada não é válida
   * @return o valor do atributo
   */
  public String getTextField(By by) throws MalformedURLException {
    return getDriver().findElement(by).getAttribute("value");
  }

  // endregion

  // region getCurrentURL

  /**
   * Retorna a URL em que o navegador está no momento que a função é chamada
   *
   * @throws MalformedURLException quando a URL informada não é válida
   * @return URL atual
   */
  public String getCurrentUrl() throws MalformedURLException {
    return getDriver().getCurrentUrl();
  };

  // endregion

  // region TextElement

  /**
   * Retorna o texto visível do elemento localizado pela propriedade by do selenium.
   *
   * @param by elemento estático da classe WebElement
   * @throws MalformedURLException quando a URL informada não é válida
   * @return o valor do elemento
   */
  public String getTextElement(By by) throws MalformedURLException {
    return getDriver().findElement(by).getText();
  }

  /**
   * Retorna o texto visível do elemento localizado pela propriedade Id do selenium.
   *
   * @param by elemento estático da classe WebElement
   * @throws MalformedURLException quando a URL informada não é válida
   * @return o valor do elemento
   */
  public String getTextElement(String by) throws MalformedURLException {
    return getTextElement(By.id(by));
  }

  /**
   * Retorna o texto visível do elemento localizado pelo atributo value.
   *
   * @param by elemento estático da classe WebElement
   * @throws MalformedURLException quando a URL informada não é válida
   * @return o valor do atributo
   */
  public String getTextElementByValue(String by) throws MalformedURLException {
    return getDriver().findElement(By.id(by)).getAttribute("value");
  }

  /**
   * Retorna o titulo da página atual.
   *
   * @throws MalformedURLException quando a URL informada não é válida
   * @return o titulo da página
   */
  public String getTitlePage() throws MalformedURLException {
    logger.info(MessagesLog.GET_PAGE_TITLE);
    return getDriver().getTitle();
  }

  // endregion

  // region isDisplayed

  /**
   * Verifica se o elemento está visivel localizado pela propriedade Id do selenium.
   *
   * @param by elemento estático da classe WebElement
   * @throws MalformedURLException quando a URL informada não é válida
   * @return se o elemento é exibido ou não
   */
  public boolean getIsDisplayed(String by) throws MalformedURLException {
    return getIsDisplayed(By.id(by));
  }

  /**
   * Verifica se o elemento está visivel localizado pela propriedade by do selenium.
   *
   * @param by elemento estático da classe WebElement
   * @throws MalformedURLException quando a URL informada não é válida
   * @return se o elemento é exibido ou não
   */
  public boolean getIsDisplayed(By by) throws MalformedURLException {
    logger.info(MessagesLog.ELEMENT_IS_DISPLAYED);
    return getDriver().findElement(by).isDisplayed();
  }

  /**
   * Verifica se o elemento está visivel localizado pelo atributo texto.
   *
   * @param text valor do elemento
   * @throws MalformedURLException quando a URL informada não é válida
   * @return se o elemento é exibido ou não
   */
  public boolean getTextFieldIsDisplayed(String text) throws MalformedURLException {
    return getIsDisplayed(By.xpath("//div[input[contains(@name,'" + text + "')]]"));
  }

  /**
   * Verifica se o Botão está visivel localizado pelo elemento texto.
   *
   * @param text valor do elemento
   * @throws MalformedURLException quando a URL informada não é válida
   * @return se o elemento é exibido ou não
   */
  public boolean getButtonIsDisplayed(String text) throws MalformedURLException {
    return getIsDisplayed(By.xpath("//button[@type='button'][contains(.,'" + text + "')]"));
  }

  // endregion

  // region Link

  /**
   * Clica em um link localizado pelo atributo texto.
   *
   * @throws MalformedURLException quando a URL informada não é válida
   * @param text valor do elemento
   */
  public void clickLinkText(String text) throws MalformedURLException {
    logger.info(MessagesLog.CLICKING_ON_AN_ELEMENT);
    WebElement button = getDriver().findElement(By.linkText(text));
    button.click();
  }

  // endregion

  // region RadioButton e CheckBox

  /**
   * Clica em um radio button localizado pela propriedade Id do selenium.
   *
   * @throws MalformedURLException quando a URL informada não é válida
   * @param by elemento estático da classe WebElement
   */
  public void clickRadio(String by) throws MalformedURLException {
    logger.info(MessagesLog.CLICKING_ON_AN_ELEMENT);
    getDriver().findElement(By.id(by)).click();
  }

  /**
   * Verifica se radio button está selecionado localizado pela propriedade by do selenium.
   *
   * @param by elemento estático da classe WebElement
   * @throws MalformedURLException quando a URL informada não é válida
   * @return se o elemento está selecionado ou não
   */
  public boolean isRadioSelected(String by) throws MalformedURLException {
    return getDriver().findElement(By.id(by)).isSelected();
  }

  /**
   * Clica em um checkbox localizado pela propriedade Id do selenium.
   *
   * @throws MalformedURLException quando a URL informada não é válida
   * @param by elemento estático da classe WebElement
   */
  public void clickCheckBox(String by) throws MalformedURLException {
    clickCheckBox(By.id(by));
  }

  /**
   * Clica em um checkbox localizado pela propriedade by do selenium.
   *
   * @throws MalformedURLException quando a URL informada não é válida
   * @param by elemento estático da classe WebElement
   */
  public void clickCheckBox(By by) throws MalformedURLException {
    logger.info(MessagesLog.CLICKING_ON_AN_ELEMENT);
    getDriver().findElement(by).click();
  }

  /**
   * Verifica se check box está selecionado localizado pela propriedade Id do selenium.
   *
   * @param by elemento estático da classe WebElement
   * @throws MalformedURLException quando a URL informada não é válida
   * @return se o elemento está selecionado ou não
   */
  public boolean isCheckBoxSelected(String by) throws MalformedURLException {
    return getDriver().findElement(By.id(by)).isSelected();
  }

  /**
   * Verifica se check box está selecionado localizado pela propriedade by do selenium.
   *
   * @param by elemento estático da classe WebElement
   * @throws MalformedURLException quando a URL informada não é válida
   * @return se o elemento está selecionado ou não
   */
  public boolean isCheckBoxSelected(By by) throws MalformedURLException {
    return getDriver().findElement(by).isSelected();
  }

  // endregion

  // region Botao

  public boolean getButtonIsClickable(String text) {
    try {
      waitTime(2500);
      wait.until(ExpectedConditions.elementToBeClickable(
          By.xpath("//button[@type='button'][contains(text(),'" + text + "')]")));
      return true;
    } catch (TimeoutException e) {
      return false;
    }
  }

  /**
   * Clica em um botão localizado pela propriedade Id do selenium.
   *
   * @param by elemento estático da classe WebElement
   * @throws MalformedURLException quando a URL informada não é válida
   */
  public void clickButton(String by) throws MalformedURLException {
    logger.info(MessagesLog.CLICKING_ON_AN_ELEMENT);
    clickButton(By.id(by));
  }

  /**
   * Clica em um botão localizado pela propriedade by do selenium.
   *
   * @param by elemento estático da classe WebElement
   * @throws MalformedURLException quando a URL informada não é válida
   */
  public void clickButton(By by) throws MalformedURLException {
    logger.info(MessagesLog.CLICKING_ON_AN_ELEMENT);
    getDriver().findElement(by).click();

  }

  /**
   * Clica em um botão localizado pelo atributo texto.
   *
   * @param text valor do elemento
   * @throws MalformedURLException quando a URL informada não é válida
   */
  public void clickButtonByText(String text) throws MalformedURLException {
    clickButton(By.xpath("//button[contains(.,'" + text + "')]"));
  }

  // endregion

  // region Selecionar Busca

  /**
   * Clica em um elemento localizado pela propriedade by do selenium.
   *
   * @param by elemento estático da classe WebElement
   * @throws MalformedURLException quando a URL informada não é válida
   */
  public void clickItem(By by) throws MalformedURLException {
    logger.info(MessagesLog.CLICKING_ON_AN_ELEMENT);
    getDriver().findElement(by).click();
  }

  /**
   * Clica em um resultado da busca.
   *
   * @param by elemento estático da classe WebElement
   * @throws MalformedURLException quando a URL informada não é válida
   */
  public void clickSelectSearch(String by) throws MalformedURLException {
    logger.info(MessagesLog.CLICKING_ON_AN_ELEMENT);
    getDriver().findElement(By.id(by)).click();
  }

  /**
   * Clica em um resultado da busca especificado pela propriedade by do selenium.
   *
   * @param by elemento estático da classe WebElement
   * @throws MalformedURLException quando a URL informada não é válida
   */
  public void clickSelectSearch(By by) throws MalformedURLException {
    logger.info(MessagesLog.CLICKING_ON_AN_ELEMENT);
    WebElement element = getDriver().findElement(by);
    JavascriptExecutor je = (JavascriptExecutor) getDriver();
    je.executeScript("arguments[0].scrollIntoView(true);", element);
    element.click();
  }

  /**
   * Clica em um resultado da busca que contém scroll especificado pela propriedade by do selenium.
   *
   * @param by elemento estático da classe WebElement
   * @throws MalformedURLException quando a URL informada não é válida
   */
  public void clickSelectSearchScroll(By by) throws MalformedURLException {
    logger.info(MessagesLog.CLICKING_ON_AN_ELEMENT);
    WebElement element = getDriver().findElement(by);
    Actions act = new Actions(getDriver());
    act.moveToElement(element).click().perform();
  }

  // endregion

  // region Selecionar Grid

  /**
   * Clica em algum elemento ou resultado do grid especificado pela propriedade Id do selenium.
   *
   * @param by elemento estático da classe WebElement
   * @throws MalformedURLException quando a URL informada não é válida
   */
  public void clickGrid(String by) throws MalformedURLException {
    clickGrid(By.id(by));
  }

  /**
   * Clica em algum elemento ou resultado do grid especificado pela propriedade by do selenium.
   *
   * @param by elemento estático da classe WebElement
   * @throws MalformedURLException quando a URL informada não é válida
   */
  public void clickGrid(By by) throws MalformedURLException {
    logger.info(MessagesLog.CLICKING_ON_AN_ELEMENT);
    getDriver().findElement(by).click();
  }

  // endregion

  // region Alerts

  /**
   * Altera para o alert e captura o texto.
   *
   * @throws MalformedURLException quando a URL informada não é válida
   * @return valor do elemento
   */
  public String alertGetTextAlert() throws MalformedURLException {
    Alert alert = getDriver().switchTo().alert();
    return alert.getText();
  }

  /**
   * Altera o foco para o alert, captura o texto e clica em qualquer botão de confirmação.
   *
   * @throws MalformedURLException quando a URL informada não é válida
   * @return valor do elemento
   */
  public String alertGetTextAccept() throws MalformedURLException {
    Alert alert = getDriver().switchTo().alert();
    String text = alert.getText();
    alert.accept();
    return text;
  }

  /**
   * Altera o foco para o alert, captura o texto e clica em qualquer botão de recusar.
   *
   * @throws MalformedURLException quando a URL informada não é válida
   * @return valor do elemento
   */
  public String alertGetTextDismiss() throws MalformedURLException {
    Alert alert = getDriver().switchTo().alert();
    String text = alert.getText();
    alert.dismiss();
    return text;
  }

  /**
   * Altera o foco para o alert, digita em um elemento do alert e clica em qualquer botão de
   * recusar.
   *
   * @param text valor do elemento
   * @throws MalformedURLException quando a URL informada não é válida
   */
  public void alertSetTextoPromptAccept(String text) throws MalformedURLException {
    Alert alert = getDriver().switchTo().alert();
    alert.sendKeys(text);
    alert.accept();
  }

  // endregion

  // region Frames e Janelas

  /**
   * Altera o foco para o frame informado pelo atributo Id.
   *
   * @param by elemento estático da classe WebElement
   * @throws MalformedURLException quando a URL informada não é válida
   */
  public void switchToFrame(String by) throws MalformedURLException {
    getDriver().switchTo().frame(by);
  }

  /**
   * Fecha o frame com foco.
   * @throws MalformedURLException quando a URL informada não é válida
   */
  public void closeFrame() throws MalformedURLException {
    getDriver().switchTo().defaultContent();
  }

  /**
   * Altera o foco para a janela identificada pelo Id.
   *
   * @param by elemento estático da classe WebElement
   * @throws MalformedURLException quando a URL informada não é válida
   */
  public void switchToWindow(String by) throws MalformedURLException {
    getDriver().switchTo().window(by);
  }

  /**
   * Fecha a janela com foco.
   * @throws MalformedURLException quando a URL informada não é válida
   */
  public void closeWindow() throws MalformedURLException {
    getDriver().close();
  }

  // endregion

  // region List

  /**
   * Encontra os resultados no grid de busca
   * Computa quantos resultados foram encontrados
   * Verifica se todos os resultados da primeira página correspondem com o filtro selecionado
   *
   * @param by elemento estático da classe WebElement
   * @param text valor do elemento
   * @throws MalformedURLException quando a URL informada não é válida
   */
  public void inspectGridRows(By by, String text) throws MalformedURLException {

    List<WebElement> rows = getDriver().findElements(by);

    // retorna o numero de resultados da busca que foram encontrados
    int count = rows.size();
    logger.info(RESULTS_FOUND + count);

    // verifica se todos os elementos do grid são iguais de acordo com o filtro da busca
    for (WebElement e : rows) {
      Assert.assertEquals(text, e.getText());

    }
  }

  /**
   * Encontra os resultados no grid de busca Computa quantos resultados foram encontrados
   *
   * @param by elemento estático da classe WebElement
   * @throws MalformedURLException quando a URL informada não é válida
   */
  public void inspectGridResultsInRows(By by) throws MalformedURLException {

    List<WebElement> rows = getDriver().findElements(by);

    // retorna o numero de resultados da busca que foram encontrados
    int count = rows.size();

    if (count == 0) {
      logger.info(MessagesLog.RESULTS_NOT_FOUND);
    } else {
      // Ao criar um grid, criasse a linha "first" e a "last", mesmo que só tenha 1 resultado. Ou
      // seja, se tiver n elementos no grid (tal que n>=1), o xpath encontrará n+2 elementos da
      // forma que foi montado
      logger.info(RESULTS_FOUND + (count - 2));
    }

  }

  // endregion

  // region isClickable
  /**
   * Verifica se o elemento é clicável localizado pela propriedade by do selenium.
   *
   * @param by elemento estático da classe WebElement
   * @return se o elemento é clicável ou não
   */
  public boolean getIsClickable(By by) {
    try {
      logger.info(MessagesLog.ELEMENT_IS_CLICKABLE);
      waitTime(2500);
      wait.until(ExpectedConditions.elementToBeClickable(by));
      return true;
    } catch (TimeoutException e) {
      return false;
    }
  }
  // endregion

  // region isElementOnPage
  /**
   * Verificar se um elemento está presente na página localizado pela propriedade by do selenium.
   *
   * @param by elemento estático da classe WebElement
   * @throws MalformedURLException quando a URL informada não é válida
   */
  public boolean isElementOnPage(By by) throws MalformedURLException {
    try {
      logger.info(MessagesLog.ELEMENT_IS_DISPLAYED);
      getDriver().findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }
  // endregion

}
