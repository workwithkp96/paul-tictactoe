package in.paul.tictactoe.domain;

import lombok.Data;

@Data
public class Cell {
    int row;
    int col;
    Symbol symbol;
    CellState sate;
}
