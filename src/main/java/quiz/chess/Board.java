package quiz.chess;

import quiz.chess.pieces.Pawn;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Created by bollsal on 2016. 11. 15..
 */
public class Board {

    public final static int BOARD_ROW = 8;
    public final static int BOARD_COLUMN = 8;

    public final static int BLACK_ROW = 1;
    public final static int WHITE_ROW = 6;

    static List<Pawn> pawnList;

    public void create() {
        pawnList = new ArrayList<>();
    }

    public void addPawn(Pawn pawn) {
        pawnList.add(pawn);
    }

    public int getTotalPawnCount() {
        int count = 0;
        for (Pawn pawn : pawnList) {
            if (!pawn.getMark().equals(Pawn.EMPTY_PAWN)) {
                count++;
            }
        }
        return count;
    }

    public List<Pawn> getPawnList() {
        return pawnList;
    }

    public void initialize() {
        for (int i = 0; i < BOARD_ROW; i++) {
            for (int j = 0; j < BOARD_COLUMN; j++) {
                switch (i) {
                    case BLACK_ROW:
                        pawnList.add(new Pawn(Pawn.BLACK));
                        break;
                    case WHITE_ROW:
                        pawnList.add(new Pawn(Pawn.WHITE));
                        break;
                    default:
                        pawnList.add(new Pawn(Pawn.EMPTY));
                        break;
                }
            }
        }
    }

    public String printBoardRow(int row) {
        StringBuilder builder = new StringBuilder();

//        for (int i = 0; i < BOARD_ROW; i++) {
//            for (int j = 0; j < BOARD_COLUMN; j++) {
//                if (i == row) {
//                    builder.append(pawnList.get((BOARD_ROW * i) + j).getMark());
//                }
//            }
//        }
        for (int j = 0; j < BOARD_COLUMN; j++) {
            builder.append(pawnList.get((BOARD_ROW * (BOARD_ROW - row)) + j).getMark());
        }

        return builder.toString();
    }
    
    public String printBoard() {
        StringBuilder builder = new StringBuilder();
        for (int i = BOARD_ROW; i > 0; i--) {
            builder.append(printBoardRow(i));
            builder.append("\n");
        }
//        for (int i = 0; i < BOARD_ROW; i++) {
//            builder.append(printBoardRow(i));
//            builder.append("\n");
//        }
        return builder.toString();
    }

//    public static void main(String... args) {
//        pawnList = new ArrayList<>();
//        initialize();
//
//        System.out.println(printBoardRow(7));
//
//        System.out.println(printBoard());
//    }
}
