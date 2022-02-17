package com.uwu;

import java.util.Scanner;

public class Game {
    private static int score;
    private static Card currentCard;
    private static Card nextCard;
    private static Deck deck;
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        deck = new Deck();
        currentCard = deck.getNextCard();
        gameTurn();
    }

    public static void gameTurn() {
        nextCard = deck.getNextCard();
        System.out.println(currentCard);
        String answer = sc.nextLine();
        if (answer.equals("higher") && currentCard.isHigherOrEqual(nextCard)) {
            correct();
        } else if (answer.equals("lower") && !currentCard.isHigherOrEqual(nextCard)) {
            correct();
        } else {
            gameOver();
        }
    }

    public static void correct() {
        score++;
        currentCard = nextCard;
        System.out.println("{System} Correct. Score: " + score + ".Cards left: " + deck.getCards().size());
        gameTurn();
    }

    public static void gameOver() {
        System.out.println("{System} You lost. The next card was a " + nextCard + ". Score: " + score + ". Cards left: " + deck.getCards().size());
    }
}
