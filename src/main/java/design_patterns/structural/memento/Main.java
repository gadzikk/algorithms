package design_patterns.structural.memento;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gadzik on 30.07.20.
 */
public class Main {
    public static void main(String[] args) {
        List<Life.Memento> savedTimes = new ArrayList<Life.Memento>();
        Life life = new Life();
        life.set("1000 B.C.");
        savedTimes.add(life.saveToMemento());
        life.set("1000 A.D.");
        savedTimes.add(life.saveToMemento());
        life.set("2000 A.D.");
        savedTimes.add(life.saveToMemento());
        life.set("4000 A.D.");
        life.restoreFromMemento(savedTimes.get(0));
    }
}
