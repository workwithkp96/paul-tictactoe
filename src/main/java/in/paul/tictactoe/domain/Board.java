package in.paul.tictactoe.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class Board {
    List<List<Cell>> grid;

    public Board(){
        createGrid();
    }

    public void displayBoard(){
        for(List<Cell> row : grid){
            for(Cell cell : row){
                System.out.print("| " + cell.getSymbol().sign + " |");
            }
            System.out.println();
        }
    }

    public void createGrid(){
        for(int i=0;i<3;i++){
            List<Cell> row = new ArrayList<>();
            for(int j=0;j<3;j++){
                row.add(new Cell(i,j,null,CellState.EMPTY));
            }
            grid.add(row);
        }
    }
}
