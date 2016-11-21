package quiz.chess;

import quiz.chess.pieces.Pawn;
import org.junit.*;

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
        Pawn whitePawn = new Pawn(Pawn.WHITE);
        whitePawn.create(Pawn.WHITE);
        board.addPawn(whitePawn);

        assertThat(board.getTotalPawnCount(), is(1));

        Pawn blackPawn = new Pawn(Pawn.BLACK);
        blackPawn.create(Pawn.BLACK);
        board.addPawn(blackPawn);

        assertThat(board.getTotalPawnCount(), is(2));


        assertThat(board.getPawnList(), hasItem(whitePawn));
        assertThat(board.getPawnList(), hasItem(blackPawn));

//        Pawn blackPawn1 = new Pawn();
//        blackPawn1.create(Pawn.COLOR.BLACK);
//        assertThat(board.getPawnList(), hasItem(blackPawn1));
    }

    @Test
    public void Create테스트() {
        board.initialize();

        String blackPawnRow = "PPPPPPPP";
        String whitePawnRow = "pppppppp";
        assertThat(board.printBoardRow(7), is(blackPawnRow));
        assertThat(board.printBoardRow(2), is(whitePawnRow));

        assertThat(board.getTotalPawnCount(), is(16));
    }

    @Test
    public void 콘솔에출력하기() {
        board.initialize();
        System.out.println(board.printBoard());
    }

    @After
    public void tearDown() {

    }

    @AfterClass
    public static void afterClass() {

    }
}
