package quiz.blackjack;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.CoreMatchers.*;
import static org.mockito.Mockito.*;

/**
 * Created by bollsal on 2016. 12. 19..

 * Rule 정리
 * 1. 유저는 나 vs 딜러
 * 2. 카드 2장을 받고 시작
 * 3. 시작부터 블랙잭(21) : 나 - 배팅액의 2배 이득, 딜러 - 배팅인만큼 이득
 * 4. 나 vs 딜러 -> 21에 가까울 수록 승리.

 * # 21이 넘으면 패배 : Burst
 * # 추가 카드를 뽑음 : Hit
 * # 안뽑고 턴을 넘김 : Stand
 */
public class BlackJackTest {
    BlackJack blackJack;

    @Before
    public void setUp() throws Exception {
        blackJack = new BlackJack();
    }

    @Test
    public void 첫번째_턴에_카드2장_제대로받아지는지() {
        blackJack.firstHit();

        assertThat(blackJack.getTurnCount(), is(1));
        assertThat(blackJack.getUserCardCount(), is(2));
        assertThat(blackJack.getDealerCardCount(), is(2));
    }

    @Test
    public void blackjack_아닌상태에서_유저가_이기는경우() {
        blackJack.getUserCards().add(20);
        blackJack.getDealerCards().add(10);

        assertThat(blackJack.checkState(), is(BlackJack.STATE.USER_WIN));
    }

    @Test
    public void blackjack_아닌상태에서_딜러가_이기는경우() {
        blackJack.getUserCards().add(10);
        blackJack.getDealerCards().add(20);

        assertThat(blackJack.checkState(), is(BlackJack.STATE.DEALER_WIN));
    }

    @Test
    public void blackjack_테스트() {
        assertThat(blackJack.getUserCardCount(), is(0));

        blackJack.getUserCards().add(21);
        assertThat(blackJack.checkState(), is(BlackJack.STATE.USER_BLACK_JACK));
    }

    @Test
    public void burst_테스트() {
//        blackJack.getUserCards().add(22);
//        assertThat(blackJack.checkState(), is(BlackJack.STATE.USER_BURST));

        blackJack.getDealerCards().add(22);
        assertThat(blackJack.checkState(), is(BlackJack.STATE.DEALER_BURST));
    }

    @Test
    public void hit_테스트() {
        assertThat(blackJack.getUserCardCount(), is(0));

        blackJack.hit();
        assertThat(blackJack.getUserCardCount(), is(1));

        blackJack.hit();
        assertThat(blackJack.getUserCardCount(), is(2));
    }

    @Test
    public void stand_테스트() {
        assertThat(blackJack.getUserCardCount(), is(0));

        blackJack.stand();
        assertThat(blackJack.getUserCardCount(), is(0));
    }
}
