package quiz.chess;

import quiz.chess.pieces.Piece;
import quiz.chess.pieces.PieceFactory;
import quiz.chess.util.StringUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bollsal on 2016. 11. 15..
 */
public class Board {

    public final static int BOARD_ROW = 8;
    public final static int BOARD_COLUMN = 8;

    public final static int BLACK_PIECE_ROW = 0;
    public final static int BLACK_PAWN_ROW = 1;
    public final static int WHITE_PAWN_ROW = 6;
    public final static int WHITE_PIECE_ROW = 7;

    private static int pieceCount;
    private List<Piece> pieceList;

    public void create() {
        pieceList = new ArrayList<>();
    }

    public void addPawn(Piece piece) {
        pieceList.add(piece);
    }

    public int getTotalPawnCount() {
        for (Piece piece : pieceList) {
            if (!piece.getName().equals(Piece.EMPTY_PAWN)) {
                Board.pieceCount++;
            }
        }
        return Board.pieceCount;
    }

    public List<Piece> getPawnList() {
        return pieceList;
    }

    public void createPieces() {
        List<Piece> blackPieces = createBlackPiece();
        List<Piece> WhitePieces = createWhitePiece();
        for (int i = 0; i < BOARD_ROW; i++) {
            for (int j = 0; j < BOARD_COLUMN; j++) {
                switch (i) {
                    case BLACK_PIECE_ROW:
                        pieceList.add(blackPieces.get(j));
                        break;
                    case BLACK_PAWN_ROW:
                        pieceList.add(PieceFactory.createBlackPawn());
                        break;
                    case WHITE_PAWN_ROW:
                        pieceList.add(PieceFactory.createWhitePawn());
                        break;
                    case WHITE_PIECE_ROW:
                        pieceList.add(WhitePieces.get(j));
                        break;
                    default:
                        pieceList.add(PieceFactory.createEmptyPawn());
                        break;
                }
            }
        }
    }

    public List<Piece> createBlackPiece() {
        List<Piece> pieces = new ArrayList<>();
        pieces.add(PieceFactory.createBlackRook());
        pieces.add(PieceFactory.createBlackKnight());
        pieces.add(PieceFactory.createBlackBishop());
        pieces.add(PieceFactory.createBlackQueen());
        pieces.add(PieceFactory.createBlackKing());
        pieces.add(PieceFactory.createBlackBishop());
        pieces.add(PieceFactory.createBlackKnight());
        pieces.add(PieceFactory.createBlackRook());
        return pieces;
    }

    public List<Piece> createWhitePiece() {
        List<Piece> pieces = new ArrayList<>();
        pieces.add(PieceFactory.createWhiteRook());
        pieces.add(PieceFactory.createWhiteKnight());
        pieces.add(PieceFactory.createWhiteBishop());
        pieces.add(PieceFactory.createWhiteQueen());
        pieces.add(PieceFactory.createWhiteKing());
        pieces.add(PieceFactory.createWhiteBishop());
        pieces.add(PieceFactory.createWhiteKnight());
        pieces.add(PieceFactory.createWhiteRook());
        return pieces;
    }

    public String printBoardRow(int row) {
        StringBuilder builder = new StringBuilder();

//        for (int i = 0; i < BOARD_ROW; i++) {
//            for (int j = 0; j < BOARD_COLUMN; j++) {
//                if (i == row) {
//                    builder.append(pieceList.get((BOARD_ROW * i) + j).getMark());
//                }
//            }
//        }
        for (int j = 0; j < BOARD_COLUMN; j++) {
            builder.append(pieceList.get((BOARD_ROW * (BOARD_ROW - row)) + j).getName());
        }

        return builder.toString();
    }
    
    public String printBoard() {
        StringBuilder builder = new StringBuilder();
        for (int i = BOARD_ROW; i > 0; i--) {
            builder.append(printBoardRow(i));
            builder.append(StringUtil.NEW_LINE);
        }
//        for (int i = 0; i < BOARD_ROW; i++) {
//            builder.append(printBoardRow(i));
//            builder.append(StringUtil.NEW_LINE);
//        }
        return builder.toString();
    }

//    public static void main(String... args) {
//        pieceList = new ArrayList<>();
//        createBlackPieces();
//
//        System.out.println(printBoardRow(7));
//
//        System.out.println(printBoard());
//    }
}
