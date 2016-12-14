package quiz.chess;

import quiz.chess.pieces.Piece;
import org.junit.*;
import quiz.chess.pieces.PieceFactory;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by bollsal on 2016. 11. 15..
 */
public class BoardTest {

    Board board;

    @BeforeClass
    public static void beforeClass() {

    }

    @Before
    public void setUp() {
        board = new Board();
        board.create();
    }

    @Test
    public void 말들이없어도_에러안남() {

    }

    @Test
    public void 체스판에말들을추가하고_갯수확인() {
        Piece whitePiece = PieceFactory.create(Piece.Color.WHITE, Piece.WHITE_PAWN);
        whitePiece.create(Piece.Color.WHITE);
        board.addPawn(whitePiece);

        assertThat(board.getTotalPawnCount(), is(1));

        Piece blackPiece = PieceFactory.create(Piece.Color.BLACK, Piece.BLACK_PAWN);
        blackPiece.create(Piece.Color.BLACK);
        board.addPawn(blackPiece);

        assertThat(board.getTotalPawnCount(), is(2));


        assertThat(board.getPawnList(), hasItem(whitePiece));
        assertThat(board.getPawnList(), hasItem(blackPiece));
    }

    @Test
    public void Create테스트() {
        board.createPieces();

        String blackPawnRow = "PPPPPPPP";
        String whitePawnRow = "pppppppp";
        assertThat(board.printBoardRow(7), is(blackPawnRow));
        assertThat(board.printBoardRow(2), is(whitePawnRow));

        assertThat(board.getTotalPawnCount(), is(32));
    }

    @Test
    public void 콘솔에출력하기() {
        board.createPieces();
        System.out.println(board.printBoard());
    }

    @After
    public void tearDown() {

    }

    @AfterClass
    public static void afterClass() {

    }
}
