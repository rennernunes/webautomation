package utils;

import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class DataUtils {

  /**
   * Gera numero de celular.
   *
   * @return string numero de celular.
   */
  public static String generateMobileNumber() {
    String mobile = "";
    Integer number;
    for (int i = 0; i < 10; i++) {
      if (i == 2) {
        number = new Integer((int) ((Math.random() * 9) + 1));
        while (number >= 1 && number <= 5) {
          number = new Integer((int) ((Math.random() * 9) + 1));
        }
      } else {
        number = new Integer((int) (Math.random() * 10));
      }
      mobile += number.toString();
    }

    if ("0".equals(mobile.substring(0, 1))) {
      mobile = mobile.replaceFirst("0", "1");
    }

    String mobileSubString = mobile.substring(2, 4);

    if (("11").equals(mobile.substring(0, 2)) && !("79").equals(mobileSubString)
        && !("78").equals(mobileSubString) && !("77").equals(mobileSubString)
        && !("70").equals(mobileSubString)) {
      mobile = mobile.replaceFirst("11", "119");
    }

    return mobile;
  }

  /**
   * Gera telefone.
   *
   * @return string numero telefone
   */
  public static String generatePhoneNumber() {
    String phone = "";
    Integer number;
    for (int i = 0; i < 10; i++) {
      if (i == 2) {
        number = new Integer((int) ((Math.random() * 9) + 1));
        while (number == 1 || number >= 6 && number <= 9) {
          number = new Integer((int) ((Math.random() * 9) + 1));
        }
      } else {
        number = new Integer((int) (Math.random() * 10));
      }
      phone += number.toString();
    }

    if ("0".equals(phone.substring(0, 1))) {
      phone = phone.replaceFirst("0", "1");
    }

    return phone;
  }

  /**
   * Gera numero de agência.
   *
   * @return string agência.
   */
  public static String generateAgency() {
    String agency = "";
    Integer number;
    number = new Integer((int) (Math.random() * 10000));
    agency += number.toString();

    return agency;
  }

  /**
   * Gera conta corrente.
   *
   * @return string conta corrente.
   */
  public static String generateCurrentAccount() {
    String currentAccount = "";
    Integer number;
    number = new Integer((int) (Math.random() * 100000));
    currentAccount += number.toString();
    return currentAccount;
  }

  /**
   * Gera número de endereço.
   *
   * @return string número de endereço.
   */
  public static String addressNumber() {

    Random random = new Random();
    Integer randomInt = new Integer((int) (random.nextInt(3000) + 1));

    return randomInt.toString();
  }

  /**
   * Obtem o mes atual.
   *
   * @return mes atual
   */
  public static String getCurrentMonth() {
    return String.format("%02d", Calendar.getInstance().get(Calendar.MONTH));
  }

  /**
   * Obtem o dia atual.
   *
   * @return dia atual
   */
  public static String getCurrentDay() {

    return String.format("%02d", Calendar.getInstance().get(Calendar.DAY_OF_MONTH));
  }

  /**
   * Obtem o ano atual.
   *
   * @return ano atual
   */
  public static String getCurrentYear() {
    return String.format("%04d", Calendar.getInstance().get(Calendar.YEAR));
  }

  /**
   * Gera ano aleatório.
   *
   * @return ano aleatorio
   */
  public static String getRandomYear() {
    int min = 1930;
    int max = 2010;

    Random r = new Random();
    String randomYear = Integer.toString(r.nextInt((max - min) + 1) + min);

    return randomYear;
  }

  /**
   * Gera data com diferencial de dias.
   *
   * @return data com diferencial de dias.
   */
  public static Date dateWithDifferentialDays(int days) {
    Calendar calendar = Calendar.getInstance();
    calendar.add(Calendar.DAY_OF_MONTH, days);
    return calendar.getTime();
  }


  /* *********************************************** */
  /* Funcões auxiliares dos geradores de CPF e CNPJ */
  /* *********************************************** */

  /**
   * Gerar um CPF arbitrário. Código obtido de
   * http://www.javafree.org/artigo/851371/Validacao-de-CPF.html. Todos os direitos são do autor do
   * código.
   *
   * @return CPF gerado arbitrariamente.
   */
  public static String generateCpf() {
    StringBuilder initials = new StringBuilder();
    Integer number;
    number = Integer.valueOf((int) (Math.random() * 1000000000));
    initials.append(number.toString());

    return initials.toString() + digitCpfChecker(initials.toString());
  }

  /**
   * Método que calcula o dígito verificador, observando se está correto. Código obtido de
   * http://www.javafree.org/artigo/851371/Validacao-de-CPF.html. Todos os direitos são do autor do
   * código.
   *
   * @param num
   * @return Dígito verificador.
   */
  private static String digitCpfChecker(String num) {
    return getVerifyingDigit(num, false, 2);
  }

  /**
   * Calcular um dígito verificador com a quantidade de casas indicadas a partir de uma sequência de
   * números enviada.
   *
   * @param font Sequência de números para cálculo do Dígito verificador
   * @param tenPerX Indica se deve haver substituição de resultado 10 por X durante o cálculo -
   *        padrão usado em alguns lugares
   * @param digitsAmount Quantidade de dígitos a serem retornados
   * @return Dígito Verificador gerado.
   */
  private static String getVerifyingDigit(String font, boolean tenPerX, int digitsAmount) {
    if (digitsAmount > 1) {
      String partial = getVerifyingDigit(font, tenPerX);
      return partial + getVerifyingDigit(font + partial, tenPerX, --digitsAmount);
    } else {
      return getVerifyingDigit(font, tenPerX);
    }
  }

  /**
   * Calcular um dígito verificador a partir de uma sequência de números enviada.
   *
   * @param font Sequência de números para cálculo do Dígito verificador
   * @param tenPerX Indica se deve haver substituição de resultado 10 por X durante o cálculo -
   *        padrão usado em alguns lugares
   * @return Dígito Verificador gerado.
   */
  private static String getVerifyingDigit(String font, boolean tenPerX) {

    int weight = font.length() + 1;
    int verifyingDigit = 0;
    for (int i = 0; i < font.length(); i++) {
      verifyingDigit += Integer.parseInt(font.substring(i, i + 1)) * weight--;
    }
    verifyingDigit = verifyingDigit % 11;
    if (verifyingDigit > 1) {
      return String.valueOf(11 - verifyingDigit);
    } else if (verifyingDigit == 1 && tenPerX) {
      return "X";
    }
    return "0";

  }

  /**
   * Gerar um número de CNPJ válido.
   *
   * @return CNPJ gerado.
   */
  public static String generateCnpj() {
    StringBuilder initials = new StringBuilder();
    Long number;
    number = Long.valueOf((long) (Math.random() * 1000000000000l));
    initials.append(number.toString());
    return initials.toString() + digitCNPJChecker(initials.toString());
  }

  /**
   * Dado um conjunto de 12 números, gerar um dígito verificador.
   *
   * @param cnpj CNPJ com 12 números.
   * @return Dígito verificador.
   */
  private static String digitCNPJChecker(String cnpj) {
    return getVerifyingDigitBase10(cnpj, false, 2);
  }

  /**
   * Calcular um dígito verificador usando o módulo 11, base 10, com a quantidade de casas indicadas
   * a partir de uma sequência de números enviada.
   *
   * @param font Sequência de números para cálculo do Dígito verificador
   * @param tenPerX Indica se deve haver substituição de resultado 10 por X durante o cálculo -
   *        padrão usado em alguns lugares
   * @param digitsAmount Quantidade de dígitos a serem retornados
   * @return Dígito verificador gerado.
   */
  private static String getVerifyingDigitBase10(String font, boolean tenPerX, int digitsAmount) {
    char subOne = '0';
    if (tenPerX) {
      subOne = 'X';
    }
    return getVerifyingDigitBaseParameterized(font, 10, '0', subOne, digitsAmount);
  }

  /**
   * Calcular um dígito verificador usando o módulo 11, com a quantidade de casas indicadas a partir
   * de uma sequência de números enviada.
   *
   * @param font Sequência de números para cálculo do Dígito verificador
   * @param base Valor da base que se deseja usar para o cálculo do Dígito verificador
   * @param subZero Caracter que deve substituir o resultado quando o resto for 0
   * @param subOne Caracter que deve substituir o resultado quando o resto for 1
   * @param digitsAmount Quantidade de dígitos a serem retornados
   * @return Dígito verificador gerado.
   */
  private static String getVerifyingDigitBaseParameterized(String font, int base, char subZero,
      char subOne, int digitsAmount) {
    if (digitsAmount > 1) {
      String partial = getVerifyingDigitBaseParameterized(font, base, subZero, subOne);
      return partial + getVerifyingDigitBaseParameterized(font + partial, base, subZero, subOne,
          --digitsAmount);
    } else {
      return getVerifyingDigitBaseParameterized(font, base, subZero, subOne);
    }
  }

  /**
   * Calcular um dígito verificador a partir de uma sequência de números enviada. O maior weight
   * usado atinge a base, retorna a 2
   *
   * @param font Sequência de números para cálculo do Dígito verificador
   * @param base Valor da base que se deseja usar para o cálculo do Dígito verificador
   * @param subZero Caracter que deve substituir o resultado quando o resto for 0
   * @param subOne Caracter que deve substituir o resultado quando o resto for 1
   * @return Dígito verificador gerado.
   */
  private static String getVerifyingDigitBaseParameterized(String font, int base, char subZero,
      char subOne) {

    int weight = 2;
    int verifyingDigit = 0;
    for (int i = font.length() - 1; i >= 0; i--) {
      verifyingDigit += Integer.parseInt(font.substring(i, i + 1)) * weight;
      if (weight == base - 1) {
        weight = 2;
      } else {
        weight++;
      }
    }
    verifyingDigit = verifyingDigit % 11;
    if (verifyingDigit > 1) {
      return String.valueOf(11 - verifyingDigit);
    } else if (verifyingDigit == 1) {
      return String.valueOf(subOne);
    }
    return String.valueOf(subZero);

  }


}

