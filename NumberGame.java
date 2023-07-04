import java.util.Scanner;
import java.util.Random;


//Time complexity is O(r*n) --r is rounds and n is number of attempts
public class NumberGame {


    int score = 0;
    int player1 = 0, player2 = 0;
    int rounds;
    int guess;
    int random_number;


    public void print_board_single_player() {


        System.out.println("\t\t Rules \n");
        System.out.println("\t\t 1)Guess a number between 1-100\n");
        System.out.println("\t\t 2)You will be given 3 attempts\n");
        System.out.println("\t\t 3)100 points will be rewarded for correct guess\n");
        System.out.println("\t\t 4)You can choose the number of rounds\n");
    }


    public void print_board_multiplayer() {


        System.out.println("\t\t Rules \n");
        System.out.println("\t\t 1)Both players will have to guess a number between 1-100\n");
        System.out.println("\t\t 2)Player that whose guess is closest to the number will be rewarded 100 points\n");
        System.out.println("\t\t 3)The player with maximum points will win the game\n");
        System.out.println("\t\t 4)You can choose the number of rounds\n");
    }

    public void start_game_single_player(int r) {

        int min = 1;
        int max = 100;
        Random random = new Random();


        Scanner sc = new Scanner(System.in);


        for (int j = 1; j <= r; j++) {

            System.out.println("\t\t **** Round " + j + " ***");

            random_number = random.nextInt(max - min + 1) + 1;

            for (int i = 0; i < 3; i++) {

                System.out.println("\nEnter your guess:");
                guess = sc.nextInt();


                if (guess > random_number) {
                    System.out.println("\n Your guess was too high");
                } else if (guess < random_number) {
                    System.out.println("\n Your guess was too low");
                } else {
                    System.out.println("\n Your guess was correct");
                    score = score + 100;

                    System.out.println("\n !! Your score is " + score + " !! ");

                    System.out.println("\n Congratulations!! Lets go to next round");

                    break;
                }


            }

            System.out.println("\n The number was " + random_number);
        }


        System.out.println("\n !! Your final score is :" + score + " !! ");


    }

    public void start_game_multiplayer(int r) {

        int min = 1;
        int max = 100;
        Random random = new Random();


        Scanner sc = new Scanner(System.in);


        for (int j = 1; j <= r; j++) {
            System.out.println("\t\t **** Round " + j + " ****");

            random_number = random.nextInt(max - min + 1) + 1;

            int guess1;
            int guess2;

            System.out.println("\n Player 1 enter your guess:");
            guess1 = sc.nextInt();

            System.out.println("\n Player 2 enter your guess:");
            guess2 = sc.nextInt();

            int diff1, diff2;

            diff1 = Math.abs(guess1 - random_number);
            diff2 = Math.abs(guess2 - random_number);

            System.out.println("\n The number was " + random_number);

            if (diff1 > diff2) {
                System.out.println("\n Player 2 is the winner");
                player2 = player2 + 100;
                System.out.println("\n Scores:");
                System.out.println("\n Player 1: " + player1 + " Player 2: " + player2);


            } else if (diff1 < diff2) {
                System.out.println("\n Player 1 is the winner");

                player1 = player1 + 100;
                System.out.println("\n Scores:");
                System.out.println("\n Player 1: " + player1 + " Player 2: " + player2);

            } else {
                System.out.println("We have a tie");
                player1 = player1 + 50;
                player2 = player2 + 50;
                System.out.println("\n Scores:");

                System.out.println("\n Player 1: " + player1 + " Player 2: " + player2);
            }


        }

        System.out.println("\n Final scores: ");
        System.out.println("\n Player 1:" + player1 + " Player 2: " + player2);

        if (player2 > player1) {
            System.out.println("\n Player 2 is winner ");
        } else if (player1 > player2) {
            System.out.println("\n Player 1 is winner ");
        } else {
            System.out.println("\n We have joint winners ");
        }
    }

    public static void main(String[] args) {

        int choice;
        NumberGame n = new NumberGame();
        Scanner sc = new Scanner(System.in);

        System.out.println("\t\t\t*** Number Guessing Game ***\t\t\t \n");

        System.out.println("\t\t 1) Choose 1 for single player mode\n");
        System.out.println("\t\t 2) Choose 2 for  multiplayer mode\n");


        System.out.println(" \nEnter your choice");
        choice = sc.nextInt();
      switch (choice)
        {
            case 1 : 
                n.print_board_single_player();
                System.out.println("Enter the number of rounds:");
                n.rounds = sc.nextInt();
                n.start_game_single_player(n.rounds);
                break;
            
            case 2 :
                n.print_board_multiplayer();
                System.out.println("Enter the number of rounds:");
                n.rounds = sc.nextInt();
                n.start_game_multiplayer(n.rounds);
                break;
            
            default :
                System.out.println("\n Enter the correct choice");
        }


    }
}
