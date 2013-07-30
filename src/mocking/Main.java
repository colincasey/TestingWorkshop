package mocking;

import java.io.File;
import java.util.Collection;

/**
 * Created with IntelliJ IDEA.
 * User: ccasey
 * Date: 7/30/13
 * Time: 6:36 AM
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    private static final boolean isWindows = System.getProperty("os.name").contains("win");

    public static void main(String[] args) throws Exception {
        ListDirectoryCommand listDirectoryCommand = new ListDirectoryCommand(createProcessExecutor(), createOutputParser());
        Collection<File> files = listDirectoryCommand.execute();
        for(File file : files) {
            System.out.println(file.getAbsolutePath());
        }
    }

    private static CommandExecutor createProcessExecutor() {
        String command = isWindows ? "dir" : "ls";
        CommandExecutor commandExecutor = new CommandExecutor(Runtime.getRuntime(), command);
        return commandExecutor;
    }

    private static OutputParser<? extends Collection<File>> createOutputParser() {
        return isWindows ? new DirCommandOutputParser() : new LsCommandOutputParser();
    }
}
