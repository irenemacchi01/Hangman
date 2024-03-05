import java.util.Scanner;

public class Hangman {
    private static final String[] WORDS = {"JAVA", "PROGRAMMAZIONE", "GIOCO", "SCHERMO", "COMPUTER"};
    private static final int MAX_TRIES = 6;

    public static void play() {
        Scanner input = new Scanner(System.in);
        String wordToGuess = getRandomWord();
        char[] guessedLetters = new char[wordToGuess.length()];
        int remainingTries = MAX_TRIES;

        // Inizializza l'array delle lettere indovinate con caratteri '_'
        for (int i = 0; i < guessedLetters.length; i++) {
            guessedLetters[i] = '_';
        }

        System.out.println("Benvenuto al gioco dell'impiccato!");
        System.out.println("La parola da indovinare ha " + wordToGuess.length() + " lettere.");

        while (remainingTries > 0 && containsUnderscore(guessedLetters)) {
            System.out.println("Tentativi rimanenti: " + remainingTries);
            System.out.println("Parola attuale: " + String.valueOf(guessedLetters));
            System.out.print("Inserisci una lettera: ");
            char guess = input.nextLine().toUpperCase().charAt(0);

            boolean found = false;
            for (int i = 0; i < wordToGuess.length(); i++) {
                if (wordToGuess.charAt(i) == guess) {
                    guessedLetters[i] = guess;
                    found = true;
                }
            }

            if (!found) {
                remainingTries--;
                System.out.println("La lettera inserita non è presente nella parola.");
            }

            System.out.println();
            input.close();
        }

        if (!containsUnderscore(guessedLetters)) {
            System.out.println("Complimenti! Hai indovinato la parola: " + wordToGuess);
        } else {
            System.out.println("Mi dispiace, hai esaurito tutti i tentativi. La parola da indovinare era: " + wordToGuess);
        }

    }

    private static String getRandomWord() {
        return WORDS[(int) (Math.random() * WORDS.length)];
    }

    private static boolean containsUnderscore(char[] array) {
        for (char c : array) {
            if (c == '_') {
                return true;
            }
        }
        return false;
    }
}
