package in.paul.tictactoe.domain;

import in.paul.tictactoe.strategies.ColumnWinningStrategy;
import in.paul.tictactoe.strategies.RowWinningStrategy;
import in.paul.tictactoe.strategies.WinningStrategy;
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
    private final List<WinningStrategy> winningStrategies = List.of(new RowWinningStrategy(), new ColumnWinningStrategy());

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

        if(checkWinner(move)){
            setStatus(GameStatus.SUCCESS);
            setWinner(currentPlayer);
        }else if(moves.size() == 9){
            setStatus(GameStatus.DRAW);
            setWinner(null);
        }
    }

    private boolean checkWinner(Move move){
        for(WinningStrategy winningStrategy : winningStrategies){
            if(winningStrategy.checkWinner(move))
                return true;
        }
        return false;
    }
}

