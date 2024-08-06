package in.paul.tictactoe.strategies;

import in.paul.tictactoe.domain.Move;

public interface WinningStrategy{
    boolean checkWinner(Move move);
}
