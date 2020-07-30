package design_patterns.behavioral.command;

/**
 * Created by gadzik on 29.07.20.
 */
public class CloseFileCommand implements Command {
    private FileSystemReceiver fileSystem;

    public CloseFileCommand(FileSystemReceiver fs) {
        this.fileSystem = fs;
    }

    @Override
    public void execute() {
        this.fileSystem.closeFile();
    }
}
