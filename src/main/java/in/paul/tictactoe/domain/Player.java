package in.paul.tictactoe.domain;

import lombok.Data;

import java.util.UUID;
@Data
public class Player {
    UUID id;
    Symbol symbol;
}
