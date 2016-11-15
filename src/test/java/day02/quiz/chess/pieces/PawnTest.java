package day02.quiz.chess.pieces;

import org.junit.*;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by bollsal on 2016. 11. 15..
 */
public class PawnTest {

    Pawn pawn;
    Pawn pawnBlck;

    @BeforeClass
    public static void beforeClass() {

    }

    @Before
    public void setUp() {
        pawn = new Pawn();
        pawnBlck = new Pawn();
    }

    @Test
    public void getColor_white인지_체크() {
        pawn.create(Pawn.COLOR.WHITE);
        assertThat(pawn.getColor(), is(Pawn.COLOR.WHITE));
    }

    @Test
    public void getColor_black으로_할당하고_체크() {
        pawnBlck.create(Pawn.COLOR.BLACK);
        assertThat(pawnBlck.getColor(), is(Pawn.COLOR.BLACK));
    }

    @After
    public void tearDown() {

    }

    @AfterClass
    public static void afterClass() {

    }
}
