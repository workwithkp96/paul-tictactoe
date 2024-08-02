package in.paul.tictactoe.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class HumanPlayer extends Player{
    String name;
}
