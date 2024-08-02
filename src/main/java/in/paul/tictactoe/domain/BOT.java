package in.paul.tictactoe.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class BOT extends Player{
    String name;
    BotLevel botLevel;
    BotPlayingStrategy botPlayingStrategy;
}
