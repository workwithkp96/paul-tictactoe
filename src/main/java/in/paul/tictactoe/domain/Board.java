package in.paul.tictactoe.domain;

import lombok.Data;

import java.util.List;

@Data
public class Board {
    List<List<Cell>> grid;
}
