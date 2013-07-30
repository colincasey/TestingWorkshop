package mocking;

import java.io.File;
import java.util.Collection;

public class ListDirectoryCommand {
    private final CommandExecutor commandExecutor;
    private final OutputParser<? extends Collection<File>> outputParser;

    public ListDirectoryCommand(CommandExecutor commandExecutor, OutputParser<? extends Collection<File>> outputParser) {
        this.commandExecutor = commandExecutor;
        this.outputParser = outputParser;
    }

    public Collection<File> execute() throws Exception {
        String output = commandExecutor.exec();
        return outputParser.parse(output);
    }
}
