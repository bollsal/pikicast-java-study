package day02.quiz.chess;

import day02.quiz.chess.pieces.Pawn;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bollsal on 2016. 11. 15..
 */
public class Board {

    List<Pawn> pawnList;

    public void create() {
        pawnList = new ArrayList<>();
    }

    public void addPawn(Pawn pawn) {
        pawnList.add(pawn);
    }

    public int getTotalPawnCount() {
        return pawnList.size();
    }

    public List<Pawn> getPawnList() {
        return pawnList;
    }
}
