package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Dealer dealer = new Dealer();
        Player player = new Player();
        ArrayCardList arrayCardList = new ArrayCardList();


        int sumOfDealersCards = arrayCardList.arr[dealer.dealersArray[0]] + arrayCardList.arr[dealer.dealersArray[1]];
        int sumOfPlayersCards = arrayCardList.arr[player.playersArray[0]] + arrayCardList.arr[player.playersArray[1]];

        System.out.println("Welcome to Buco's blackjack program!");
        System.out.println("You get " + arrayCardList.arr[player.playersArray[0]] + " and a " + arrayCardList.arr[player.playersArray[1]] + ".");
        System.out.println("Your total is " + sumOfPlayersCards + ".");
        System.out.print("\n");
        System.out.println("The dealer has a " + arrayCardList.arr[dealer.dealersArray[0]] + " showing, and a hidden card.");
        System.out.println("His total is hidden, too.");
        System.out.print("Would you like to 'hit' or 'stay'? ");
        String playerInput = scanner.nextLine();
        System.out.println("\n");

        int i = 2;

        while (playerInput.equals("hit") || playerInput.equals("stay") || sumOfPlayersCards <= 21 && sumOfDealersCards <= 21) {

            if (playerInput.equals("hit")) {

                sumOfPlayersCards = sumOfPlayersCards + arrayCardList.arr[player.playersArray[i]];

                System.out.println("You drew a " + arrayCardList.arr[player.playersArray[i]] + ".");
                System.out.println("Your total is " + sumOfPlayersCards + ".");

                if (sumOfPlayersCards > 21) {

                    System.out.println("Your are busted, Dealer won");
                    break;

                }

                i++;

                playerInput = scanner.nextLine();

            }

            if (playerInput.equals("stay")) {

                System.out.println("Okay, dealer's turn.");
                System.out.println("His hidden card was " + arrayCardList.arr[dealer.dealersArray[1]] + ".");
                System.out.println("His total was " + sumOfDealersCards + ".");
                System.out.print("\n");

                if (sumOfDealersCards <= 16) {
                    sumOfDealersCards = sumOfDealersCards + arrayCardList.arr[dealer.dealersArray[i]];

                    System.out.println("Dealer choose to hit.");
                    System.out.println("He drew a " + arrayCardList.arr[dealer.dealersArray[i]] + ".");
                    System.out.println("His total is " + sumOfDealersCards + ".");
                    System.out.print("\n");

                    i++;
                }
                if(sumOfPlayersCards > 21){
                    System.out.println("You are busted");
                    System.out.println("You lost");
                    break;
                }

                if (sumOfDealersCards <= 21 && sumOfDealersCards > 16) {

                    if (sumOfDealersCards >= sumOfPlayersCards) {
                        System.out.println("Dealer won");
                        break;
                    }
                    if (sumOfPlayersCards > sumOfDealersCards) {
                        System.out.println("Player won");
                        break;
                    }

                }

            }

        }
    }

}
