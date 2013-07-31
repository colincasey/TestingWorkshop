package mocking;

import java.io.File;
import java.util.Collection;

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
        return new CommandExecutor(Runtime.getRuntime(), command);
    }

    private static OutputParser<? extends Collection<File>> createOutputParser() {
        return isWindows ? new DirCommandOutputParser() : new LsCommandOutputParser();
    }
}
