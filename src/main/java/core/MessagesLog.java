package core;

/**
 * Classe contém as mensagens utilizadas pelo log
 */
public final class MessagesLog {

  /**
   * Construtor privado para que a classe não seja instanciada.
   */
  private MessagesLog() {}

  /**
   * Constante UNKNOWN_URL
   */
  public static final String UNKNOWN_URL = "URL desconhecida";

  /**
   * Constante UNKNOWN_BROWSER
   */
  public static final String UNKNOWN_BROWSER = "Browser desconhecido";

  /**
   * Constante INSTANTIATE_DRIVER
   */
  public static final String INSTANTIATE_DRIVER = "Instanciando o navegador com o driver específico";

  /**
   * Constante RESTART_BROWSER
   */
  public static final String RESTART_BROWSER = "Reiniciando Browser";

  /**
   * Constante CLOSE_BROWSER.
   */
  public static final String CLOSE_BROWSER = "Encerrando sessão do navegador";

  /**
   * Constante INSTANTIATING_WEB_ELEMENTS.
   */
  public static final String INSTANTIATING_WEB_ELEMENTS = "Instanciando elementos da Web";

  /**
   * Constante RESULTS_NOT_FOUND
   */
  public static final String RESULTS_NOT_FOUND = "Não foi retornado resultado na busca";

  /**
   * Constante RESULTS_RETURNED
   */
  public static final String RESULTS_FOUND = "Resultados encontrados na 1ª página : ";

  /**
   * Constante RESULTS_RETURNED
   */
  public static final String TOTAL_RESULTS_FOUND = "Total de resultados encontrados : ";

  /**
   * Constante URL
   */
  public static final String URL = "Iniciando sessão do navegador";

  /**
   * Constante CLICKING_ON_AN_ELEMENT
   */
  public static final String CLICKING_ON_AN_ELEMENT = "Clicando em um elemento";

  /**
   * Constante SEND_KEYS_ON_AN_ELEMENT
   */
  public static final String SEND_KEYS_ON_AN_ELEMENT = "Sequência de caracteres enviada ao elemento";

  /**
   * Constante ELEMENT_IS_DISPLAYED
   */
  public static final String ELEMENT_IS_DISPLAYED = "Verificando se o elemento é ou não exibido";

  /**
   * Constante ELEMENT_IS_CLICKABLE
   */
  public static final String ELEMENT_IS_CLICKABLE = "Verificando se o elemento é ou não clicável";

  /**
   * Constante GET_PAGE_TITLE
   */
  public static final String GET_PAGE_TITLE = "Obtendo o título da página";

  /**
   * Constante IMPLICIT_WAIT
   */
  public static final String IMPLICIT_WAIT = "Tempo de espera padrão";

  /**
   * Constante EXPLICIT_WAIT
   */
  public static final String EXPLICIT_WAIT = "Tempo de espera dinâmica";


}
