package design_patterns.behavioral.command;

/**
 * Created by gadzik on 29.07.20.
 */
public class Main {
    public static void main(String[] args) {
        //Creating the receiver object
        FileSystemReceiver fs = new UnixFileSystemReceiver();
        //creating command and associating with receiver
        OpenFileCommand openFileCommand = new OpenFileCommand(fs);
        //Creating invoker and associating with Command
        FileInvoker file = new FileInvoker(openFileCommand);
        //perform action on invoker object
        file.execute();
        WriteFileCommand writeFileCommand = new WriteFileCommand(fs);
        file = new FileInvoker(writeFileCommand);
        file.execute();

        CloseFileCommand closeFileCommand = new CloseFileCommand(fs);
        file = new FileInvoker(closeFileCommand);
        file.execute();
    }
}
