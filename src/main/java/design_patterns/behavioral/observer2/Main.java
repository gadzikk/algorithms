package design_patterns.behavioral.observer2;

/**
 * Created by gadzik on 29.07.20.
 */
public class Main {
    public static void main(String args[]) {
        AverageScoreDisplay averageScoreDisplay = new AverageScoreDisplay();
        CurrentScoreDisplay currentScoreDisplay = new CurrentScoreDisplay();

        CricketData cricketData = new CricketData();

        cricketData.registerObserver(averageScoreDisplay);
        cricketData.registerObserver(currentScoreDisplay);

        cricketData.dataChanged();

        cricketData.unregisterObserver(averageScoreDisplay);

        cricketData.dataChanged();
    }
}
