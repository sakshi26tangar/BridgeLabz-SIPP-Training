public class DeckOfCards {
    public static void main(String[] args) {
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
        String[] deck = new String[52];
        for (int i = 0; i < deck.length; i++) {
            deck[i] = ranks[i % 13] + " of " + suits[i / 13];
        }
        for (int i = 0; i < deck.length; i++) {
            int rand = i + (int)(Math.random() * (deck.length - i));
            String temp = deck[i];
            deck[i] = deck[rand];
            deck[rand] = temp;
        }
        int players = 4, cards = 5;
        if (players * cards <= deck.length) {
            for (int i = 0; i < players; i++) {
                System.out.print("Player " + (i + 1) + ": ");
                for (int j = 0; j < cards; j++) {
                    System.out.print(deck[i * cards + j] + " | ");
                }
                System.out.println();
            }
        }
    }
}
