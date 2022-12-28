import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        play();
    }

    static void play() {
        System.out.println(">>>>>>>>> Jocul Spanzuratoarea <<<<<<<<<<<<");

        ArrayList<String> words = new ArrayList<>(
                Arrays.asList("language", "paint", "tire", "hot", "plane", "plane", "test", "system", "object"
                        , "wheel", "multiply", "south", "vodka", "vortex", "puppy", "jawbreaker", "blitz", "gossip"
                        , "pixel", "transplant", "iphone", "galaxy", "blizzard", "fuchsia", "zombie", "schnapps"
                        , "kiwi", "jumbo", "puzzle", "lengths", "subway", "funny", "zip", "unzip", "jackpot", "voodoo"
                        , "pizza", "dyno", "zigzag", "spritz", "oxygen", "megaimage", "microwave"));

        Random rnd = new Random();
        int pozitie = rnd.nextInt(words.size());
        String hiddenWord = words.get(pozitie);
        hiddenWord = hiddenWord.toLowerCase();
        char[] stars = new char[hiddenWord.length()];

        Arrays.fill(stars, '*');
        int lives;

        if (hiddenWord.length() < 8) {
            lives = 6;
        } else {
            lives = 9;
        }
        System.out.println("The word played is: " + String.valueOf(stars));
        Scanner sc = new Scanner(System.in);
        while (true) {
            boolean theLetterIsCorrect = false;

            if (!String.valueOf(stars).contains("*")) {
                System.out.println("Well done, you won!");
                break;
            }

            if (lives == 0) {
                System.out.println("Sorry, you've been hanged..." + "\nThe word played was " + hiddenWord);
                break;
            }

            System.out.print("\nGuess a letter: ");
            char theGuessedLetter = sc.next().charAt(0);

            for (int i = 0; i < hiddenWord.length(); i++) {
                if (theGuessedLetter == hiddenWord.charAt(i)) {
                    stars[i] = theGuessedLetter;
                    theLetterIsCorrect = true;
                }
            }

            if (!theLetterIsCorrect) {
                System.out.println("You made a mistake, try again...");
                lives--;
            }

            System.out.println(stars);
        }
    }
}
