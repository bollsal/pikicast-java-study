package day02.quiz.chess;

import day02.quiz.chess.pieces.Pawn;
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
    }

    @Test
    public void 말들이없어도_에러안남() {
        board.create();
    }

    @Test
    public void 체스판에말들을추가하고_갯수확인() {
        board.create();

        Pawn whitePawn = new Pawn();
        whitePawn.create(Pawn.COLOR.WHITE);
        board.addPawn(whitePawn);

        assertThat(board.getTotalPawnCount(), is(1));

        Pawn blackPawn = new Pawn();
        blackPawn.create(Pawn.COLOR.BLACK);
        board.addPawn(blackPawn);

        assertThat(board.getTotalPawnCount(), is(2));


        assertThat(board.getPawnList(), hasItem(whitePawn));
        assertThat(board.getPawnList(), hasItem(blackPawn));

//        Pawn blackPawn1 = new Pawn();
//        blackPawn1.create(Pawn.COLOR.BLACK);
//        assertThat(board.getPawnList(), hasItem(blackPawn1));
    }

    @After
    public void tearDown() {

    }

    @AfterClass
    public static void afterClass() {

    }
}
