package blackjack;

import java.util.Random;
import java.util.Scanner;

public class Card {

	public static void main(String[] args) {
        String anotherCard, playAgain = "y", ctn = null;
        int nextCard, card1, card2, dCard1, dCard2;
        int cardTotal = 0, dTotal = 0;
 
        Scanner keyboard = new Scanner(System.in);
 
        Random random = new Random();
 
        // Commencez à distribuer les deux premières cartes aux joueurs
 
        while ("y".equals(playAgain)) {
            // les deux premières cartes aléatoires du croupier

            dCard1 = random.nextInt(10) + 1;
            dCard2 = random.nextInt(10) + 1;
 
            // les deux premières cartes aléatoires des joueurs et le total des cartes
            card1 = random.nextInt(10) + 1;
            card2 = random.nextInt(10) + 1;
            cardTotal = card1 + card2;
 
            
            dTotal = dCard1 + dCard2;
            System.out.println("Croupier montre: " + dCard1);
 
            // afficher les deux premières cartes des joueurs et le total des cartes
            System.out.println("Premiere Carte: " + card1 + ", " + card2);
            System.out.println("Totale: " + cardTotal);
 
            System.out.println("Deuxieme Carte (y/n)?: ");
            anotherCard = keyboard.nextLine();
 
            while ("y".equals(anotherCard)) {
                nextCard = random.nextInt(10) + 1;
                cardTotal += nextCard;
                System.out.println("Carte: " + nextCard);
                System.out.println("Totale: " + cardTotal);
 
                if (cardTotal > 21) {
                    System.out.println("Perdu, croupier a gagné");
                    System.out.println("Voulez vous jouer encore? (y/n):");
                    playAgain = keyboard.nextLine();
                }
 
                if (cardTotal < 21)
                    System.out.println("Deuxieme Carte (y/n)?: ");
                 
                anotherCard = keyboard.nextLine();
                 
                if ("n".equals(anotherCard))
                    System.out.println("croupier avait: " + dTotal);
                 
                System.out.println("Tu avais: " + cardTotal);
 
                while ("n".equals(anotherCard)) {
                    if (dTotal < cardTotal && cardTotal < 21) {
                        System.out.println("ouayy tu gagne!");
                        System.out.println("Joue encore? (y/n): ");
                        playAgain = keyboard.nextLine();
                         
                        if (playAgain.equalsIgnoreCase("y"))
                            playAgain = "y";
 
                        if (dTotal > cardTotal && dTotal < 21)
                            System.out.println("Tu Perds!");
                         
                        playAgain = keyboard.nextLine();
                    }
                }
            }
        }
    }
}
