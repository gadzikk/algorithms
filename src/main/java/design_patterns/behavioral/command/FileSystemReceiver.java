package design_patterns.behavioral.command;

/**
 * Created by gadzik on 29.07.20.
 */
public interface FileSystemReceiver {
    void openFile();
    void writeFile();
    void closeFile();
}
