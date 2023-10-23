import java.lang.Math;
import java.util.Scanner;

public class CarGuesser {

  public static void main(String[] args) {
    String[] carsList = {"mazda", "bmw", "mercedes", "ford", "chevy"};
    Scanner sc = new Scanner(System.in);

    System.out.println("Guess a popular car make! Enter a single lowercase letter, and watch it become clearer and clearer what type of car it is.");
    String randWord = carsList[(int)(Math.random() * carsList.length)];
    String runningGuess = initialize(randWord);

    while (!runningGuess.equals(randWord)) {
      System.out.println(runningGuess);
      String input = sc.nextLine();
      runningGuess = game(input, randWord, runningGuess);
    }

    System.out.println("You win!");
  }

  public static String initialize(String word) {
    String current = "";
    for (int i = 0; i < word.length(); i++) {
      current += "_";
    }
    return current;
  }

  public static String game(String guess, String word, String current) {
    for (int i = 0; i < word.length(); i++) {
      if (guess.equals(String.valueOf(word.charAt(i)))) {
        current = current.substring(0, i) + guess + current.substring(i + 1);
      }
    }
    return current;
  }
}
