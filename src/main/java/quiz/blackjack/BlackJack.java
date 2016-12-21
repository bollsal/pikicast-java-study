package quiz.blackjack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by bollsal on 2016. 12. 19..
 */
public class BlackJack {

    public static final int BLACK_JACK_VALUE = 21;

    interface STATE {
        String BLACK_JACK_FIRST_TURN = "Black jack first turn";

        String USER_BLACK_JACK = "user Black jack";
        String DEALER_BLACK_JACK = "dealer Black jack";

        String USER_BURST = "user Burst";
        String DEALER_BURST = "dealer Burst";

        String USER_WIN = "user win";
        String DEALER_WIN = "dealer win";
        String DRAW = "draw";
    }

    private List<Integer> cards = new ArrayList<>();

    private List<Integer> userCards = new ArrayList<>();
    private List<Integer> dealerCards = new ArrayList<>();

    private int turnCount = 0;

    public BlackJack() {
        initCards();
    }

    public void initCards() {
        for (int i = 2; i < 11; i++) {
            cards.add(i);
        }
        cards.add(10);  // J
        cards.add(10);  // Q
        cards.add(10);  // K
        cards.add(11);  // A
    }

    public int getTurnCount() {
        return turnCount;
    }

    public void firstHit() {
        hit(false);
        hit(false);

        turnCount++;
    }

    public void hit() {
        hit(false);
    }

    public void hit(boolean addTurnCount) {
        addUserCard();
        addDealerCard();

        if (addTurnCount)
            turnCount++;
    }

    public void stand() {
        // TODO : ??
        turnCount++;
    }

    private void addUserCard() {
        userCards.add(getCard());
    }

    private void addDealerCard() {
        dealerCards.add(getCard());
    }

    private int getCard() {
        Collections.shuffle(cards);
        return cards.get(0);
    }

    public List<Integer> getUserCards() {
        return userCards;
    }

    public List<Integer> getDealerCards() {
        return dealerCards;
    }

    public int getUserCardCount() {
        return userCards.size();
    }

    public int getDealerCardCount() {
        return dealerCards.size();
    }

    private int getUserValue() {
        int user = 0;
        for (int userCard : userCards) {
            user += userCard;
        }
        return user;
    }

    private int getDealerValue() {
        int dealer = 0;
        for (int dealerCard : dealerCards) {
            dealer += dealerCard;
        }
        return dealer;
    }

    public String checkState() {
        int user = getUserValue();
        int dealer = getDealerValue();

        if (turnCount == 1) {
            if (user == BLACK_JACK_VALUE || dealer == BLACK_JACK_VALUE) {
                return STATE.BLACK_JACK_FIRST_TURN;
            }
        } else {
            if (user == BLACK_JACK_VALUE) {
                return STATE.USER_BLACK_JACK;
            } else if (dealer == BLACK_JACK_VALUE) {
                return STATE.DEALER_BLACK_JACK;
            } else if (user > BLACK_JACK_VALUE) {
                return STATE.USER_BURST;
            } else if (dealer > BLACK_JACK_VALUE) {
                return STATE.DEALER_BURST;
            } else if (user > dealer) {
                return STATE.USER_WIN;
            } else if (user < dealer) {
                return STATE.DEALER_WIN;
            } else {
                return STATE.DRAW;
            }
        }

        return null;
    }
}
