package ru.reeson2003.Game.model;

import ru.reeson2003.Game.view.View;
import ru.reeson2003.map.Direction;
import ru.reeson2003.map.Map;
import ru.reeson2003.map.Map_gen_0_1;
import ru.reeson2003.npcs.Parameters;
import ru.reeson2003.player.Player;


/**
 * Created by Тоня on 16.10.2016.
 */
public class Game {
    private static Game game = null;
    private Player player;
    private Map map;

    private Game() {
        initialize();
    }
    public static Game getInstance() {
        if (game == null) {
            game = new Game();
        }
        return game;
    }

    private void initialize() {
        map = Map.getInstance(new Map_gen_0_1());
        player = new Player("Reeson", "player", map.getStart(), new Parameters(1000d,5,5,5,5,5));
        mainLoop();
    }

    public synchronized void mainLoop() {
        refreshObjects();
        refreshIcon();
        refreshPosition();
    }

    public void setDirection(Direction direction) {
        player.move(direction);
        refreshObjects();
        refreshIcon();
        refreshPosition();
    }

    public Player getPlayer() {
        return player;
    }

    public void refreshObjects() {
        View.getInstance().show(player.getPosition().getObjects());
    }
    public void refreshPosition() {
        View.getInstance().show(player.getPosition());
    }
    public void refreshIcon() {
        View.getInstance().show(player.getPosition().getLocation().getIcon());
    }

    public void showPlayerStats() {
        View.getInstance().show(player.getParameters());
    }

}