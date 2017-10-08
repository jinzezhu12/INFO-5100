import java.util.Scanner;

public class projectSolution_1 {
    public static void main (String[] args){
        takeUserInput();
    }

    private static void takeUserInput() {
        Scanner scanner = new Scanner(System.in);
        int option = -1;
        while(option != 0){
            showMenu();
            option = scanner.nextInt();

            switch (option){
                case 0:
                    break;
                case 1:
                    hangManGame.playGame();
                case 2:
                    whatIsHangmanGame();
                default:
                    System.out.println("Please enter a valid option ( 0 - 2 )..........");
            }
        }
    }

    private static void whatIsHangmanGame() {
        System.out.println("The word to guess is represented by a row of dashes, representing each letter of the word. In most variants, proper nouns, such as names, places, and ");
        System.out.println("brands, are not allowed. Slang words, sometimes referred to as informal or shortened words, are also not allowed. If the guessing player suggests a letter ");
        System.out.println("which occurs in the word, the other player writes it in all its correct positions. If the suggested letter or number does not occur in the word, the other player ");
        System.out.println("draws one element of a hanged man stick figure as a tally mark.");
        System.out.println("he player guessing the word may, at any time, attempt to guess the whole word. If the word is correct, the game is over and the guesser wins. ");
        System.out.println("Otherwise, the other player may choose to penalize the guesser by adding an element to the diagram. On the other hand, if the other player makes ");
        System.out.println("enough incorrect guesses to allow his opponent to complete the diagram, the game is also over, this time with the guesser losing. However, the guesser");
        System.out.println("can also win by guessing all the letters or numbers that appears in the word, thereby completing the word, before the diagram is completed.\n");
    }

    private static void showMenu() {
            System.out.println("               My Solution For Project 1                 ");
            System.out.println("*********************************************************");
            System.out.println("        1. start the hangman game                        ");
            System.out.println("        2. what is hangman game                          ");
            System.out.println("*********************************************************");
            System.out.println("        Press 0 to exit the menu.........................");
        }

}
