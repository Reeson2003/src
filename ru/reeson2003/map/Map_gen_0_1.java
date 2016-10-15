package ru.reeson2003.map;

import ru.reeson2003.Game.iTimeActivator;
import ru.reeson2003.npcs.Rabbit;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * Created by Тоня on 06.10.2016.
 */
public class Map_gen_0_1 implements iMapGenerator{
    Position start;
    List<Location> locations;
    iTimeActivator timeActivator;

    public Map_gen_0_1(iTimeActivator timeActivator) {
        this.timeActivator = timeActivator;
        this.locations = new LinkedList<>();
        makeMap();
    }

    private void makeMap() {
        Location forest = new LocGen0_1("Forest","Лес", 4, 4).getLocation();
        Location field  = new LocGen0_1("Field","Поле", 5, 5).getLocation();
        Location dungeon = new LocGen0_1("Dungeon","Подземелье", 3, 2).getLocation();
        start = field.getPosition(2, 0);
        field.getPosition(0,1).setWest(forest.getPosition(3,3));
        forest.getPosition(3,3).setEast(field.getPosition(0,1));
        field.getPosition(4,3).setEast(dungeon.getPosition(0,1));
        dungeon.getPosition(0,1).setWest(field.getPosition(4,3));

        Rabbit roger = new Rabbit("Кролик", field.getPosition(2,1));
        Rabbit Bear = new Rabbit("Медведь", forest.getPosition(2,1));

        timeActivator.addTimeListener(roger);
        timeActivator.addTimeListener(Bear);
    }

    @Override
    public List<Location> getLocations() {
        return locations;
    }
    @Override
    public Position getStart() {
        return start;
    }
}