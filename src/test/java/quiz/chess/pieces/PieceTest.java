package quiz.chess.pieces;

import org.junit.*;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by bollsal on 2016. 11. 15..
 */
public class PieceTest {

    Piece pieceWhite;
    Piece pieceBlack;

    @BeforeClass
    public static void beforeClass() {

    }

    @Before
    public void setUp() {
        pieceWhite = PieceFactory.createWhitePawn();
        pieceBlack = PieceFactory.createBlackPawn();
    }

    @Test
    public void getColor_white인지_체크() {
        pieceWhite.create(Piece.Color.WHITE);
        assertThat(pieceWhite.getColor(), is(Piece.Color.WHITE));
    }

    @Test
    public void getColor_black으로_할당하고_체크() {
        pieceBlack.create(Piece.Color.BLACK);
        assertThat(pieceBlack.getColor(), is(Piece.Color.BLACK));
    }

    @After
    public void tearDown() {

    }

    @AfterClass
    public static void afterClass() {

    }
}
