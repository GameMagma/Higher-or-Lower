public class Player {
    private DeckManager.Card currentCard;

    public DeckManager.Card getCurrentCard() { return currentCard; }

    public void giveCard(DeckManager.Card currentCard) { this.currentCard = currentCard; }
}
