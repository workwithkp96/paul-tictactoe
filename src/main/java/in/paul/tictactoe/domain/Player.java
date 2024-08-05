package in.paul.tictactoe.domain;

import lombok.Data;

import java.util.Scanner;
import java.util.UUID;
@Data
public class Player {
    UUID id;
    Symbol symbol;
    String name;


    Move giveMove(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the row\n");
        int row = sc.nextInt();
        System.out.println("Please enter the column\n");
        int col = sc.nextInt();

        return new Move(new Cell(row,col,this.symbol,CellState.EMPTY),this);
    }
}
