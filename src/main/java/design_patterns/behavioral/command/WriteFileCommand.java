package design_patterns.behavioral.command;

/**
 * Created by gadzik on 29.07.20.
 */
public class WriteFileCommand implements Command {

    private FileSystemReceiver fileSystem;

    public WriteFileCommand(FileSystemReceiver fs) {
        this.fileSystem = fs;
    }

    @Override
    public void execute() {
        this.fileSystem.writeFile();
    }

}
