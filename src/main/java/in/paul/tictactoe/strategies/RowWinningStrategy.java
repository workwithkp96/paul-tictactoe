package in.paul.tictactoe.strategies;

import in.paul.tictactoe.domain.Move;

import java.util.HashMap;
import java.util.Map;

public class RowWinningStrategy implements WinningStrategy{
    private final Map<Integer, Map<Character, Integer>> rowSymbolCounts = new HashMap<>();

    public RowWinningStrategy(){
        rowSymbolCounts.put(0,new HashMap<>());
        rowSymbolCounts.put(1,new HashMap<>());
        rowSymbolCounts.put(2,new HashMap<>());
    }
    @Override
    public boolean checkWinner(Move move) {

        int row = move.getCell().getRow();
        char sign = move.getCell().getSymbol().getSign();

        rowSymbolCounts.get(row).put(sign,rowSymbolCounts.get(row).getOrDefault(sign,0)+1);

        return rowSymbolCounts.get(row).get(sign) == 3;
    }
}
