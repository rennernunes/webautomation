package core;

/**
 * Classe contém as constantes e configurações utilizadas no projeto
 */
public final class LocalProperties {

  /**
   * Construtor privado para que a classe não seja instanciada.
   */
  private LocalProperties() {}

  /**
   * Informa se o browser irá fechar ou não depois da execução dos testes
   */
  public static boolean FECHAR_BROWSER = true;

  /**
   * Informa o SITE em que será realizado os testes
   */
  public static String SITE = System.getenv("URL_SITE");
//  public static String SITE = "https://www.magazineluiza.com.br/";

  /**
   * Informa o navegador em que será realizado os testes
   */

  public static final Browsers BROWSER = Browsers.valueOf(System.getenv("BROWSER"));
//  public static final Browsers BROWSER = Browsers.CHROME;

  /**
   * Constante WAIT_TIME_IN_SECONDS.
   */
  public static final int WAIT_TIME_IN_SECONDS = 15;

  /**
   * Constante WAIT_TIME_DRIVER_IN_SECONDS .
   */
  public static final int WAIT_TIME_DRIVER_IN_SECONDS = 10;

  /**
   * Constante URL hub
   */
  public static final String HUB_URL = "http://localhost:4444/wd/hub";

  /**
   * Enum Browsers.
   */
  public enum Browsers {
    CHROME,
    FIREFOX
  }

}
