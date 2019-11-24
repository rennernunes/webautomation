package utils;

import java.util.Random;

public class RandomUtils {

  private static Random rand = new Random();

  public static String generateRandomCaracterType(int sizeCharacters, caracterType type) {
    char[] array;

    switch (type){

      case upperCaseLetters:
        array = caracterType.upperCaseLetters.caracterArray;
        break;

      case lowerCaseLetters:
        array = caracterType.lowerCaseLetters.caracterArray;
        break;

      case specialCharacters:
        array = caracterType.specialCharacters.caracterArray;
        break;

      case numbers:
        array = caracterType.numbers.caracterArray;
        break;

        default:
          array = caracterType.upperCaseLetters.caracterArray;

    }

    StringBuffer sb = new StringBuffer();
    for (int i = 0; i < sizeCharacters; i++) {
      int ch = rand.nextInt(array.length);
      sb.append(array[ch]);
    }
    return sb.toString();
  }

  public enum caracterType{
    upperCaseLetters("ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray()),
    lowerCaseLetters("abcdefghijklmnopqrstuvwxyz".toCharArray()),
    specialCharacters("ABCDEFGHIJKLMNOPQRSTUVWXYZÁÉÍÓÚÃÕÂÊÎÔÛÀÈÌÒÙÇ".toCharArray()),
    numbers("0123456789".toCharArray());

    public char[] caracterArray;

    caracterType(char[] caracterArray){
      this.caracterArray = caracterArray;
    }

  }

}
