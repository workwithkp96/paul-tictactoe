package in.paul.tictactoe.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Cell {
    int row;
    int col;
    Symbol symbol;
    CellState sate;
}
