package in.paul.tictactoe.domain;

import lombok.Data;
import java.util.List;

@Data
public class Game {
    Board board;
    List<Player> players;
    List<Move> moves;
    int currentPlayerIndex;
    GameStatus status;
    Player winner;

    public boolean validateMove(Move move){
        return move.getCell().getRow() >= 0 && move.getCell().getRow() < 3 && move.getCell().getCol() >= 0 && move.getCell().getCol() < 3;
    }

    public void makeMove(){
        Player currentPlayer = players.get(currentPlayerIndex++);
        System.out.println(currentPlayer.getName() + ".Please make your move !\n");

        Move move = currentPlayer.giveMove();

        if(!validateMove(move))
            return;

        int row = move.getCell().getRow();
        int col = move.getCell().getCol();
        Symbol symbol = move.getCell().getSymbol();

        board.getGrid().get(row).get(col).setSymbol(symbol);
        board.getGrid().get(row).get(col).setSate(CellState.OCCUPIED);
        Cell occupiedCell = board.getGrid().get(row).get(col);

        move.setCell(occupiedCell);
        moves.add(move);

        currentPlayerIndex %=2;
    }
}
