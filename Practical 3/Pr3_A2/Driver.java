public class Driver {
    public static void main(String[] args) {
        // Defining a sequence of cards to add
        Card[] cardsToAdd = {
            new Card("Ace", "Spades"),
            new Card("Queen", "Hearts"),
            new Card("Jack", "Diamonds"),
            new Card("Ace", "Spades"), // This is the duplicate card
            new Card("King", "Clubs"),
            new Card("Queen", "Hearts") // Another duplicate
        };

        // Create the destination array
        Card[] cards = new Card[cardsToAdd.length];
        int count = 0;
        boolean duplicateFound = false;

        // Add cards one at a time
        for (Card card : cardsToAdd) {
            boolean isDuplicate = false;

            // Before adding, check it against the earlier cards
            for (int i = 0; i < count; i++) {
                if (cards[i].equals(card)) {
                    isDuplicate = true;
                    if (!duplicateFound) {
                        System.out.println("Duplicate found: " + card);
                        duplicateFound = true;
                    }
                    break;
                }
            }

            // Add the card to our array of cards
            cards[count++] = card;
        }
    }
}
