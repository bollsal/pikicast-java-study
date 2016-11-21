package quiz.chess.pieces;

import org.junit.*;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by bollsal on 2016. 11. 15..
 */
public class PawnTest {

    Pawn pawnWhite;
    Pawn pawnBlck;

    @BeforeClass
    public static void beforeClass() {

    }

    @Before
    public void setUp() {
        pawnWhite = new Pawn(Pawn.WHITE);
        pawnBlck = new Pawn(Pawn.BLACK);
    }

    @Test
    public void getColor_white인지_체크() {
        pawnWhite.create(Pawn.WHITE);
        assertThat(pawnWhite.getColor(), is(Pawn.WHITE));
    }

    @Test
    public void getColor_black으로_할당하고_체크() {
        pawnBlck.create(Pawn.BLACK);
        assertThat(pawnBlck.getColor(), is(Pawn.BLACK));
    }

    @After
    public void tearDown() {

    }

    @AfterClass
    public static void afterClass() {

    }
}
