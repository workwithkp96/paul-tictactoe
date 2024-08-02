package in.paul.tictactoe.domain;

import lombok.Data;

@Data
public class Move {
    Cell cell;
    Player player;
}
