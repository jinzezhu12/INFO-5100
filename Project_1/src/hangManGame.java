import java.util.Random;
import java.util.Scanner;

public abstract class hangManGame {
    public static void playGame(){
        String[] wordList = Hangman(); //initialize the wordlist
        handleGuess(wordList);
    }

    private static void handleGuess(String[] wordList) {
        Scanner scanner = new Scanner(System.in); // initialize the scanner to take user's inputs
        boolean isPlaying = true;

        while(isPlaying){
            System.out.println("*********************** Welcome to the Game of Hangman ***********************");
            char[] randomWordGuess = chooseWord(wordList); //pick a random word from the word list
            int attemptsAllowed = 8; // set maximum attempts allowed for incorrect guess equal to 8 times
            char[] userGuess = new char[randomWordGuess.length]; // initialize the guesses made by user

            for(int i = 0; i < userGuess.length; i++){
                userGuess[i] = '-';
            }

            boolean wordIsGuessed = false; // set initial guess condition to false
            int attempts = 0; //init the attempts made by user so far

            while(!wordIsGuessed && attempts != attemptsAllowed){
                System.out.print("Current guess: ");
                displayWord(userGuess);
                System.out.printf("You currently have %d attempts.\n" , attemptsAllowed - attempts);
                System.out.println("Enter a single character");
                char input = scanner.next(".").toLowerCase().charAt(0);
                System.out.flush();
                scanner.nextLine(); //throw away the \n not consumed by next (".")
                attempts++;

                if(input == '-'){
                    isPlaying = false;
                    wordIsGuessed = true;
                } else {
                    int letterOccurence = 0;
                    for (int i = 0; i < userGuess.length; i++){
                        if (randomWordGuess[i] == input){
                            userGuess[i] = input;
                            letterOccurence++;
                            if(letterOccurence == 1 )
                                attempts--;
                        }
                    }

                    if(gameWon(userGuess)){
                        wordIsGuessed = true;
                        System.out.println("Congratulation! You won this game......");
                    }

                    printHangMan(attempts); //print part of the hangman whenever user make a incorrect guess
                }
            }
            if(!wordIsGuessed) System.out.println("You have ran out of guesses......");
            System.out.println("Do you want to play another game? (yes/no)");
            String anotherGame = scanner.nextLine().toLowerCase();
            if(gameOver(anotherGame))
                isPlaying = false;
        }
    }

    private static void printHangMan(int attempts) {
        switch (attempts) {
            case 1:
                System.out.println(" ----------\n" + "|          |\n" + "|          0\n" + "|\n" + "|\n" + "|\n" + "|\n" + "|\n" +"|________________\n");
                break;
            case 2:
                System.out.println(" ----------\n" + "|          |\n" + "|          0\n" + "|          |\n" + "|\n" + "|\n" + "|\n" +"|________________\n");
                break;
            case 3:
                System.out.println(" ----------\n" + "|          |\n" + "|          0\n" + "|          |\n" + "|       ---\n" + "|\n" + "|\n"  + "|\n" +"|________________\n");
                break;
            case 4:
                System.out.println(" ----------\n" + "|          |\n" + "|          0\n" + "|          |\n" + "|       --- ---\n" + "|\n" + "|\n" + "|\n" +"|________________\n");
                break;
            case 5:
                System.out.println(" ----------\n" + "|          |\n" + "|          0\n" + "|          |\n" + "|       --- ---\n" + "|         /\n" + "|        /\n" + "|\n" +"|________________\n");
                break;
            case 6:
                System.out.println(" ----------\n" + "|          |\n" + "|          0\n" + "|          |\n" + "|       --- ---\n" + "|         / \\\n" + "|        /   \\\n" + "|\n"  +"|________________\n");
                break;
            case 7:
                System.out.println(" ----------\n" + "|          |\n" + "|          0\n" + "|          |\n" + "|       --- ---\n" + "|         / \\\n" + "|        /   \\\n" + "|     --\n" +"|________________\n");
                break;
            case 8:
                System.out.println(" ----------\n" + "|          |\n" + "|          0\n" + "|          |\n" + "|       --- ---\n" + "|         / \\\n" + "|        /   \\\n" + "|      --     --\n" + "|________________\n");
                break;
        }

    }

    private static boolean gameOver(String anotherGame) {
        if(anotherGame.equals("no")) {
            System.out.println("*********************** GAME IS OVER!!! ***********************");
            return true;
        }
        return false;
    }

    private static boolean gameWon(char[] userGuess) {
        for(int i = 0; i < userGuess.length; i++){
            if(userGuess[i] == '-')
                return false;
        }
        return true;
    }

    private static void displayWord(char[] userGuess) {
        for (int i = 0; i < userGuess.length; i++){
            System.out.print(userGuess[i] + " ");
        }
        System.out.println();
    }

    private static char[] chooseWord(String[] wordList) {
        Random random = new Random();
        return wordList[random.nextInt(wordList.length)].toCharArray();
    }

    private static String[] Hangman() {
        return new String[] {"youtube", "facebook", "instagram", "twitter", "google"};
    }
} 
