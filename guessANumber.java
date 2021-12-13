package guessANumber;

import java.util.Random;
import java.util.Scanner;

/**
 *  Написать программу, которая загадывает случайное число от 0 до 9 и пользователю дается 3 попытки угадать это число.
 *  При каждой попытке компьютер должен сообщить, больше ли указанное пользователем число, чем загаданное, или меньше.
 *  После победы или проигрыша выводится запрос – «Повторить игру еще раз? 1 – да / 0 – нет»(1 – повторить, 0 – нет).
 */
public class guessANumber {
    public static void main(String[] args) {
        guessNumber();
    }

    public static void guessNumber() {
        boolean gameIsOn = true;
        while (gameIsOn) {
            System.out.println("You have 3 attempts to guess a number");
            int generatedRandom = randomNumber();
            int usersChoice = askUser();
            int failedAttempts = 0;
            for (int i = 0; i < 3 ; i++) {
                System.out.printf("Wrong tries %d \n",failedAttempts + 1);
                if (failedAttempts >= 2){
                    System.out.println("You lost");
                    gameIsOn = askToPlayAgain();
                    guessNumber();
                } else if (usersChoice > generatedRandom) {
                    System.out.println("Your number is bigger");
                    failedAttempts++;
                    usersChoice = askUser();
                } else if (usersChoice < generatedRandom) {
                    System.out.println("Your number is lower");
                    failedAttempts++;
                    usersChoice = askUser();
                } else {
                    System.out.printf("Congratulation. You guessed a number. Number was %d! \n", generatedRandom);
                    break;
                }
            }
            gameIsOn = askToPlayAgain();
        }
    }

    public static boolean askToPlayAgain(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Do you wanna try again? ;)");
        int usersChoice = scanner.nextInt();
        return usersChoice == 1;
    }

    public static int randomNumber() {
        Random random = new Random();
        return random.nextInt(10);
    }

    public static int askUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please type your number:>");
        return scanner.nextInt();
    }

}
