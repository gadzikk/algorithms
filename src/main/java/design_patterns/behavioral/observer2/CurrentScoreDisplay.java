package design_patterns.behavioral.observer2;

/**
 * Created by gadzik on 29.07.20.
 */
public class CurrentScoreDisplay implements Observer {
    private int runs, wickets;
    private float overs;

    public void update(int runs, int wickets,
                       float overs) {
        this.runs = runs;
        this.wickets = wickets;
        this.overs = overs;
        display();
    }

    public void display() {
        System.out.println("\nCurrent Score Display:\n"
                + "Runs: " + runs +
                "\nWickets:" + wickets +
                "\nOvers: " + overs);
    }
}
