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
}
