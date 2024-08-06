package in.paul.tictactoe.strategies;

import in.paul.tictactoe.domain.Move;

import java.util.HashMap;
import java.util.Map;

public class ColumnWinningStrategy implements WinningStrategy{
    private final Map<Integer, Map<Character, Integer>> columnSymbolCounts = new HashMap<>();

    public ColumnWinningStrategy(){
        columnSymbolCounts.put(0,new HashMap<>());
        columnSymbolCounts.put(1,new HashMap<>());
        columnSymbolCounts.put(2,new HashMap<>());
    }
    @Override
    public boolean checkWinner(Move move) {

        int col = move.getCell().getCol();
        char sign = move.getCell().getSymbol().getSign();

        columnSymbolCounts.get(col).put(sign,columnSymbolCounts.get(col).getOrDefault(sign,0)+1);

        return columnSymbolCounts.get(col).get(sign) == 3;
    }
}
